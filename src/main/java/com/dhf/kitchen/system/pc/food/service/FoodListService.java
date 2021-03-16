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

    /* 获取所有的菜品列表 */
    KitResult getList(Integer page) ;

    /* 获取最受欢迎的排行 */
    KitResult getRank();

    /* 获取最新发布的 排行 */
    KitResult getLastRank();

    /* 通过id获取 当前菜品的详细信息 */
    KitResult getFoodMeau(int id);

    /* 获取整个菜单的条目 */
    KitResult getCount();
}
