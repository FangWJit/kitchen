package com.dhf.kitchen.system.pc.login.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.base.service.CheckPhoneService;
import com.dhf.kitchen.config.MyConstant;
import com.dhf.kitchen.config.SessionContext;
import com.dhf.kitchen.redis.RedisUtils;
import com.dhf.kitchen.shiro.JwtUtils;
import com.dhf.kitchen.system.pc.login.dto.AlterPassDto;
import com.dhf.kitchen.system.pc.login.dto.UserChangePassDto;
import com.dhf.kitchen.system.pc.login.dto.UserInfoDto;
import com.dhf.kitchen.system.pc.login.dto.UserRegisterDto;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.userdetail.service.UserDetailService;
import com.dhf.kitchen.system.pc.login.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user",tags = "人员接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private CheckPhoneService checkPhoneService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "登录用户",tags = "登录用户")
    @PostMapping(value = "/login")
    public KitResult login(@Valid @RequestBody UserInfoDto userInfoBo,
                                HttpServletResponse response ,
                                HttpServletRequest request) {

        boolean isPhone = Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,userInfoBo.getUserPhone());
        if (!isPhone) {
            return KitResult.fail("手机号格式不对");
        }
        User user = userInfoBo.convertTo(User.class);
        KitResult kitResult = userService.queryByLoginPhone(user);
        if (kitResult.getData() != null) {
            String token = jwtUtils.generateToken(user);
            redisUtils.set("token:"+token, JSON.toJSONString(kitResult.getData()),604800L);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");
            response.setHeader("Authorization", token);
        }
        return kitResult;
    }

    @ApiOperation(value = "忘记密码",tags = "忘记密码")
    @PostMapping(value = "/forGetPass")
    public KitResult forGetPass(@Valid @RequestBody AlterPassDto alterPassDto) {

        if(!Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,alterPassDto.getUserPhone())) {
            return KitResult.fail("输入手机号格式不对");
        }
        User user = alterPassDto.convertTo(User.class);
        log.info("user {}",user);
        KitResult kitResult = userService.queryByPhone(user);
        if (kitResult.getData() != null){
            userService.update(user, new QueryWrapper<User>().eq("user_phone", user.getUserPhone()));
            return new KitResult("200","修改成功");
        }
        return kitResult;
    }

    @Deprecated
    @ApiOperation(value = "用户注册时验证手机号", tags = "用户注册手机时验证手机号")
    @GetMapping(value = "/registerCheck")
    public KitResult registerCheck(String phone) throws IOException {
         return checkPhoneService.checkPhoneRegister(phone);
    }

    @ApiOperation(value = "用户注册", tags = "用户注册")
    @PostMapping(value = "/register")
    public KitResult register(@Valid @RequestBody UserRegisterDto userRegisterBo) {

        boolean isPhone = Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,userRegisterBo.getUserPhone());
        if (!isPhone) {
            return KitResult.fail("手机号格式不对,请重新注册");
        }
        User user = userRegisterBo.convertTo(User.class);
        return userService.insertUser(user);
    }
    
    @ApiOperation(value = "修改密码", tags = "修改密码")
    @PostMapping(value = "/changePass")
    @RequiresAuthentication
    public KitResult changePass(@Valid @RequestBody UserChangePassDto userChangePassDto,
                                HttpServletRequest request) {
        String oldPass = userChangePassDto.getUserPass();
        String newPass = userChangePassDto.getNewUserPass();
        return userService.changePass(oldPass, newPass);
    }

    @ApiOperation(value = "修改手机号码",tags = "修改绑定的手机号码")
    @GetMapping(value = "/alterPhone")
    @RequiresAuthentication
    public KitResult alterPhone(@Valid @NotBlank(message = "手机号不能为空") String userPhone) {
        return null;
    }
    
    /**
    　* @Description 发送短信验证 先决条件是否注册过，来修改密码
    　* @Author 方万军
    　* [phone]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/1 10:35
    */
    @ApiOperation(value = "发送验证短信",tags = "发送验证短信")
    @GetMapping(value = "/checkPhoneCode")
    public KitResult checkPhoneCode(String phone) throws IOException {
        return checkPhoneService.checkPhone(phone);
    }

    /**
    　* @Description 验证验证码
    　* @Author 方万军
    　* [phone, code]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/2 10:40
    */
    @ApiOperation(value = "验证验证码",tags = "验证验证码")
    @GetMapping(value = "/checkCode")
    public KitResult checkCode(String phone, String code) throws Exception {
        return checkPhoneService.checkCode(phone,code);
    }

    /**
    　* @Description 读自己的详细信息（可修改）  也可查看他人的信息（只可读）
    　* @Author 方万军
    　* [phone]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/1 10:33
    */
    @ApiOperation(value = "用户详情", tags = "用户详情")
    @RequiresAuthentication
    @GetMapping(value = "/detail")
    public KitResult showDetail(String phone) {
        return userDetailService.queryUserDetail(phone);
    }

    @ApiOperation(value = "退出登录", tags = "退出登录")
    @GetMapping(value = "/loginOut")
    public KitResult loginOut(HttpServletRequest request,
                                   HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        redisUtils.del(MyConstant.TOKEN+token);
        response.setHeader("Authorization",null);
        return KitResult.succ("退出成功");
    }

    @ApiOperation(value = "查询字典",tags = "查询字典")
    @GetMapping(value = "/index")
    public KitResult selectMenu() {
        User user = SessionContext.get();
        KitResult kitResult = userDetailService.queryUserDetail(user.getUserId());
        return kitResult;
    }


}

