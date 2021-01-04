package com.dhf.kitchen.system.pc.food.mapper;

import com.dhf.kitchen.system.pc.food.model.FoodList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhf.kitchen.system.pc.food.model.FoodMeau;
import com.dhf.kitchen.system.pc.food.model.dto.FoodRankDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
public interface FoodListMapper {

    /* 查询所有的 */
    List<FoodMeau> getList();

    /* 查询 喜欢度 最高的*/
    List<FoodRankDto> getLastList();

    /* 查询出喜欢度 第二 -第七 */
    List<FoodRankDto> getLikeList();
}
