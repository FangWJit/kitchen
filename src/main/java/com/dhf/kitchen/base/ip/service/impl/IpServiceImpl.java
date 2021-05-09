package com.dhf.kitchen.base.ip.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.base.ip.mapper.IpMapper;
import com.dhf.kitchen.base.ip.model.Ip;
import com.dhf.kitchen.base.ip.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 9:54 2021/3/26
 * @Modified by
 */
@Service
public class IpServiceImpl implements IpService {

    @Autowired
    private IpMapper ipMapper;

    @Override
    public KitResult getIp(String userPhone,String ip) {
        Ip ip1 = ipMapper.getIp(userPhone,ip);
        if (ip1 == null) return KitResult.succ(null);
        return KitResult.succ(ip1);
    }

    @Override
    @Transactional
    public KitResult insertIp(Ip ip) {
        int i = ipMapper.insertIp(ip);
        if (i<0) return KitResult.fail("存入数据库失败");
        return KitResult.succ(null);
    }

    @Override
    @Transactional
    public KitResult updateIpCount(String userPhone,String ip) {
        int i = ipMapper.updateIpCount(userPhone,ip);
        if (i <0) return KitResult.fail("更新失败");
        Ip ip1 = ipMapper.getIp(userPhone,ip);
        return KitResult.succ(ip1);
    }
}
