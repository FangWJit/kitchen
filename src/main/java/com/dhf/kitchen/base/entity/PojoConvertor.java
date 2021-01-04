package com.dhf.kitchen.base.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @Author : FangWanJun
 * @Date : created in 14:58 2020/11/13
 */
public interface PojoConvertor {


    /***
    　* 转化格式  fastjson 实现序列化和反序列化
    　* @param [cla]
    　* @return T
    　* @date 2020/11/13 15:03
    */
    default <T> T convertTo(Class<T> cla) {
        return JSON.parseObject(JSON.toJSONBytes(this, SerializerFeature.DisableCircularReferenceDetect),cla);
    }

}
