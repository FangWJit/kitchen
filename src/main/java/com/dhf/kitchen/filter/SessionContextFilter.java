package com.dhf.kitchen.filter;

import com.alibaba.fastjson.JSON;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.base.ip.model.Ip;
import com.dhf.kitchen.base.ip.service.IpService;
import com.dhf.kitchen.config.MyConstant;
import com.dhf.kitchen.config.SessionContext;
import com.dhf.kitchen.redis.RedisUtils;
import com.dhf.kitchen.shiro.JwtUtils;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.utils.IPAddress;
import com.dhf.kitchen.utils.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 11:26 2020/12/1
 * @Modified by
 */
@Configuration
@Slf4j
public class SessionContextFilter implements Filter {

    @Autowired
    private IpService ipService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    IPAddress ipAddress;

    private String annoUrl = "/user/login,/user/forGetPass,/user/register,/user/checkPhoneCode,/user/registerCheck,/user/checkCode,/swagger-ui.html,/static/image/";

    private Set<String> annoUrls;

    @Override
    public void init(FilterConfig filterConfig) {
        annoUrls = StringUtil.toSet(annoUrl);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = getAuthFailResponse(servletResponse);

        if (!needAuth(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String token = request.getHeader("Authorization");
        if (!StringUtils.isEmpty(token)) {
//            JwtToken jwt = new JwtToken(token);
//            String subject = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
            String userJson = (String) redisUtils.get(MyConstant.TOKEN + token);
            User user = JSON.parseObject(userJson,User.class);
            if (user !=null) {
                // 访问 index 时 获取ip地址
                if (request.getRequestURI().contains("/index")) {
                    try {
                        String ipAddr = ipAddress.getIpAddr(request);
                        Ip addresses = ipAddress.getAddresses(ipAddr, "?ip=" + ipAddr, "utf-8");
                        addresses.setUserPhone(user.getUserPhone());
                        if (addresses != null) {
                            KitResult ip = ipService.getIp(addresses.getUserPhone(),addresses.getIp());
                            // 不存在  第一次访问
                            if (ip.getData() == null) {
                                // 插入数据库
                                KitResult kitResult = ipService.insertIp(addresses);
                                if (kitResult.getCode().equals("200")) {
                                    log.info(ipAddr+"访问厨阁成功");
                                } else {
                                    log.error(ipAddr+"访问失败");
                                }
                            } else {
                                // 更新访问次数 以及最后登录的账号
                                KitResult kitResult = ipService.updateIpCount(addresses.getUserPhone(),addresses.getIp());
                                if (kitResult.getCode().equals("200")) {
                                    log.info(ipAddr+"访问厨阁成功");
                                } else {
                                    log.error(ipAddr+"访问失败");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 设置 线程局部变量
                SessionContext.THREAD_LOCAL.set(user);
                filterChain.doFilter(servletRequest, servletResponse);
                SessionContext.THREAD_LOCAL.remove();
            } else {
                // token失效
                response.getWriter().write(
                        new ObjectMapper().writeValueAsString(
                                KitResult.fail("token已失效，重新登录")
                        )
                );
            }
        } else {
            // 无 token
            response.getWriter().write(
                    new ObjectMapper().writeValueAsString(
                            KitResult.fail("登录失效，请先登录")
                    ));
            return;
        }
    }

    @Override
    public void destroy() {
    }

    public HttpServletResponse getAuthFailResponse(ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        return httpResponse;
    }

    /**
     * url是否需要认证
     *
     * @param request
     * @return
     */
    public boolean needAuth(HttpServletRequest request) {

        boolean needAuth = true;
        String requestURI = request.getRequestURI();

        /**
         * 当前访问uri在匿名列表中则无需认证
         */
        for (String url : annoUrls) {
            if (requestURI.endsWith(url) || requestURI.contains(url)) {
                needAuth = false;
                break;
            }
        }

        return needAuth;
    }
}
