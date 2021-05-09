package com.dhf.kitchen.system.pc.search.service;

import com.dhf.kitchen.base.KitResult;

/**
 * @Author : 方万军
 * @Description  搜索
 * @Date : created in 13:30 2021/3/23
 * @Modified by
 */
public interface SearchService {

    KitResult searchUser(String phone);

    KitResult searchFood(String value);
}
