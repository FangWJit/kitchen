package com.dhf.kitchen.base.service;

import com.dhf.kitchen.base.KitResult;

import java.io.IOException;

/**
 * @Author : 方万军
 * @Description  验证短信验证码
 * @Date : created in 14:09 2020/11/23
 * @Modified by
 */
public interface CheckPhoneService {

    KitResult checkPhone(String phone) throws IOException;

    KitResult checkPhoneRegister(String phone) throws IOException;

    KitResult checkCode(String phone,String code) throws Exception;
}
