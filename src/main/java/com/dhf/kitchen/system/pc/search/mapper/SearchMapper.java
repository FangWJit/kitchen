package com.dhf.kitchen.system.pc.search.mapper;

import com.dhf.kitchen.system.pc.search.model.SearchFoodMeau;
import com.dhf.kitchen.system.pc.search.model.SearchUserDetail;

import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 13:33 2021/3/23
 * @Modified by
 */
public interface SearchMapper {

    SearchUserDetail selectUser(String phone);

    List<SearchFoodMeau> selectFood(String value);

}
