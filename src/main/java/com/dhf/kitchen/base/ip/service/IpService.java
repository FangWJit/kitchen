package com.dhf.kitchen.base.ip.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.base.ip.model.Ip;

/**
 * @Author : 方万军
 * @Description  处理ip地址
 * @Date : created in 9:41 2021/3/26
 * @Modified by
 */
public interface IpService {

    KitResult getIp(String userPhone,String ip);

    KitResult insertIp(Ip ip);

    KitResult updateIpCount(String userPhone,String ip);

}
