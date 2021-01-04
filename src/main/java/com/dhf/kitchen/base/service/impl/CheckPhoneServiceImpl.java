package com.dhf.kitchen.base.service.impl;

import cn.hutool.core.util.StrUtil;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.base.service.CheckPhoneService;
import com.dhf.kitchen.config.MyConstant;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.login.service.UserService;
import com.dhf.kitchen.utils.SmsCodeUtil;
import com.dhf.kitchen.utils.ValidateSmsCodeUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 14:11 2020/11/23
 * @Modified by
 */
@Service
public class CheckPhoneServiceImpl implements CheckPhoneService {

    @Autowired
    UserService userService;

    /**
    　* @Description 修改密码发送验证码
    　* @Author 方万军
    　* [strMobile]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/2 9:19
    */
    @Override
    public KitResult checkPhone(String strMobile) throws IOException {
        //手机号非空验证，以及正确性验证
        if(StrUtil.isBlank(strMobile)) {
            return KitResult.fail(MyConstant.STR_MOBILE_NULL);
        }else if(!Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,strMobile)) {
            return KitResult.fail(MyConstant.STR_MOBILE_ERROR);
        }
        User u = new User();
        u.setUserPhone(strMobile);
        KitResult kitResult = userService.queryByPhone(u);
        if (kitResult.getData() == null) {
            return kitResult;
        }
        String code = SmsCodeUtil.sendSmsCode(strMobile);
        if (!"200".equals(code)) {
            if (code.equals("416")) {
                return KitResult.fail("今日短信发送已达上限");
            } else {
                return KitResult.fail("系统错误");
            }
        }
        return KitResult.succ(null);
    }

    /**
    　* @Description 注册验证手机
    　* @Author 方万军
    　* [strMobile]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/2 10:30
    */
    @Override
    public KitResult checkPhoneRegister(String strMobile) throws IOException {
        //手机号非空验证，以及正确性验证
        if(StrUtil.isBlank(strMobile)) {
            return KitResult.fail(MyConstant.STR_MOBILE_NULL);
        }else if(!Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,strMobile)) {
            return KitResult.fail(MyConstant.STR_MOBILE_ERROR);
        }
        User u = new User();
        u.setUserPhone(strMobile);
        KitResult kitResult = userService.queryByPhone(u);
        if (StringUtils.equals(kitResult.getCode(),"200")) {
            return KitResult.fail("该手机号已经注册过了，无需再注册");
        }
        String code = SmsCodeUtil.sendSmsCode(strMobile);
        if (!"200".equals(code)) {
            if (code.equals("416")) {
                return KitResult.fail("今日短信发送已达上限");
            } else {
                return KitResult.fail("系统错误");
            }
        }
        return KitResult.succ(null);
    }

    /**
    　* @Description 验证 验证码
    　* @Author 方万军
    　* [phone, code]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2020/12/2 9:19
    */
    @Override
    public KitResult checkCode(String phone, String code) throws Exception {

        if(StrUtil.isBlank(phone)) {
            return KitResult.fail(MyConstant.STR_MOBILE_NULL);
        }else if(!Pattern.matches(MyConstant.REGEX_MOBILE_EXACT,phone)) {
            return KitResult.fail(MyConstant.STR_MOBILE_ERROR);
        }else if(!Pattern.matches("[0-9]{4}",code)) {
            return KitResult.fail("验证码格式不对");
        }
        String smsCode = ValidateSmsCodeUtil.sendValidateSmsCode(phone, code);
        if (StringUtils.equals("200",code)) {
            return KitResult.succ(null);
        }
        return KitResult.fail("验证失败");
    }
}
