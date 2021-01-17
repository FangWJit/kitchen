package com.dhf.kitchen.system.pc.food.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.food.mapper.FoodListMapper;
import com.dhf.kitchen.system.pc.food.model.FoodMeau;
import com.dhf.kitchen.system.pc.food.model.dto.FoodRankDto;
import com.dhf.kitchen.system.pc.food.service.FoodListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@Service
public class FoodListServiceImpl implements FoodListService {

    @Autowired
    private FoodListMapper foodListMapper;

    @Override
    public KitResult getList() {

        Page<Object> page = PageHelper.startPage(2, 20);
        List<FoodMeau> list = foodListMapper.getList();
        return KitResult.succ(list);
    }

    @Override
    public KitResult getRank() {
        List<FoodRankDto> secondList = foodListMapper.getLikeList();
        if (secondList.size() == 0 ) return KitResult.fail("操作失败");
        return KitResult.succ(secondList);
    }

    @Override
    public KitResult getLastRank() {
        List<FoodRankDto> lastList = foodListMapper.getLastList();
        if (lastList.size() == 0) return KitResult.fail("操作失败");
        return KitResult.succ(lastList);
    }

    @Override
    public KitResult getFoodMeau(int id) {
        if (id < 0) {
            return KitResult.fail("请求参数有误");
        }
        FoodMeau foodMeau = foodListMapper.getFoodMeau(id);
        if (foodMeau == null )  return KitResult.fail("资源不存在");
        return KitResult.succ(foodMeau);
    }


}
