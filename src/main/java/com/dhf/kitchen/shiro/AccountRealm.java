package com.dhf.kitchen.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.dhf.kitchen.redis.RedisUtils;
import com.dhf.kitchen.system.pc.login.mapper.UserMapper;
import com.dhf.kitchen.system.pc.login.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author : FangWanJun
 * @Date : created in 10:20 2020/11/18
 */
@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwt = (JwtToken) token;
        String userJson = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
        User user = new User();
        user.setUserPhone(userJson.substring(1,12));
        User userLogin =  userMapper.queryByPhone(user);
        if (userLogin == null ){
            throw new UnknownAccountException("该用户未登录,请先登录");
        }
        AccountProfile accountProfile = new AccountProfile();
        BeanUtil.copyProperties(userLogin,accountProfile);
        return new SimpleAuthenticationInfo(accountProfile,jwt.getCredentials(),getName());
    }
}
