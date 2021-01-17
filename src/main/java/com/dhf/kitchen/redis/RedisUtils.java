package com.dhf.kitchen.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author : 方万军
 * @Description redis的工具类  包含 String和Hash表的存取操作
 * @Date : created in 13:52 2020/12/1
 * @Modified by
 */
@Component
public class RedisUtils {

    @Qualifier("myRedisTemplate")
    @Autowired
    RedisTemplate redisTemplate;

    /**
    　* @Description 通过key取 value值
    　* @Author 方万军
    　* [key]
    　* @return java.lang.Object
    　* @date 2020/12/1 14:02
    */
    public Object get(String key) {
        return key == null?null:redisTemplate.opsForValue().get(key);
    }

    /**
    　* @Description 存入String类型的值
    　* @Author 方万军
    　* [key, value]
    　* @return boolean
    　* @date 2020/12/1 14:04
    */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
    　* @Description 存入String值并设置过期时间  单位秒
    　* @Author 方万军
    　* [key, value, time]
    　* @return boolean
    　* @date 2020/12/1 14:05
    */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 
    /**
    　* @Description 删除key对应的键和值
    　* @Author 方万军
    　* [key]
    　* @return void
    　* @date 2020/12/1 14:07
    */
    @SuppressWarnings("unchecked")
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
    　* @Description 判断key是否存在
    　* @Author 方万军
    　* [key]
    　* @return boolean
    　* @date 2020/12/1 14:08
    */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
    　* @Description 向一张hash表中放入数据,如果不存在将创建
    　* @Author 方万军
    　* [key, item, value]
    　* @return boolean
    　* @date 2020/12/1 14:09
    */
    public boolean hset(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
    　* @Description 存入一个hash表
    　* @Author 方万军
    　* [key, map]
    　* @return boolean
    　* @date 2020/12/1 14:10
    */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
    　* @Description 存入hash值并设定过期时间
    　* @Author 方万军
    　* [key, map, time]
    　* @return boolean
    　* @date 2020/12/1 14:11
    */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
    　* @Description  取值
    　* @Author 方万军
    　* [key, item]
    　* @return java.lang.Object
    　* @date 2020/12/1 14:12
    */
    public Object hget(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
    　* @Description 判断hash表中是否有该项的值
    　* @Author 方万军
    　* [key, item]
    　* @return boolean
    　* @date 2020/12/1 14:12
    */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**
    　* @Description 删除hash表中的值
    　* @Author 方万军
    　* [key, item]
    　* @return void
    　* @date 2020/12/1 14:12
    */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
    　* @Description 指定缓存失效时间
    　* @Author 方万军
    　* [key, time]
    　* @return boolean
    　* @date 2020/12/1 14:13
    */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
