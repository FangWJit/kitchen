package com.dhf.kitchen.base.ip.mapper;

import com.dhf.kitchen.base.ip.model.Ip;
import org.apache.ibatis.annotations.Param;

/**
 * @Author : 方万军
 * @Description  ip地址的 持久类
 * @Date : created in 9:55 2021/3/26
 * @Modified by
 */
public interface IpMapper {
    // 数据库中获取ip
    Ip getIp(@Param("userPhone") String userPhone,@Param("ip") String ip);
    // 插入新的ip
    int insertIp(Ip ip);
    // 更新ip的访问次数
    int updateIpCount(@Param("userPhone") String userPhone,@Param("ip")String ip);
}
