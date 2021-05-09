package com.dhf.kitchen.base.ip.model;

import lombok.Data;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 9:42 2021/3/26
 * @Modified by
 */
@Data
public class Ip {

    // IP地址
    private String ip;
    // 登录的账号
    private String UserPhone;
    // 国家
    private String Country;
    // 省会
    private String Province;
    // 城市
    private String City;
    // 运营商
    private String Isp;

}
