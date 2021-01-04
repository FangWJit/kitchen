package com.dhf.kitchen.system.pc.food.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.food.model.FoodList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dhf.kitchen.system.pc.food.model.FoodMeau;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface FoodListService {

    KitResult getList() ;

    KitResult getRank();

    KitResult getLastRank();
}
