package com.dhf.kitchen.system.pc.food.service.impl;

import com.alibaba.fastjson.JSON;
import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.food.mapper.FoodListMapper;
import com.dhf.kitchen.system.pc.food.model.FoodMeau;
import com.dhf.kitchen.system.pc.food.model.dto.FoodMeauTO;
import com.dhf.kitchen.system.pc.food.model.dto.FoodRankDto;
import com.dhf.kitchen.system.pc.food.model.dto.accessorie.AccessoriesList;
import com.dhf.kitchen.system.pc.food.model.dto.mainingredient.MainList;
import com.dhf.kitchen.system.pc.food.model.dto.step.MeaSure;
import com.dhf.kitchen.system.pc.food.service.FoodListService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

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
    public KitResult getList(Integer pageSize) {
        Page<Object> page = PageHelper.startPage(pageSize, 20);
        List<FoodMeau> list = foodListMapper.getList();
        Integer count = foodListMapper.getCount();
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
    @Transactional
    public KitResult getFoodMeau(int id) {
        if (id < 0) {
            return KitResult.fail("请求参数有误");
        }
        foodListMapper.updateRead(id);
        FoodMeau foodMeau = foodListMapper.getFoodMeau(id);

        FoodMeauTO foodMeauTO = this.convertTo(foodMeau);

        if (foodMeau == null )  return KitResult.fail("资源不存在");
        return KitResult.succ(foodMeauTO);
    }

    @Override
    public KitResult getCount() {
        return KitResult.succ(foodListMapper.getCount());
    }


    /**
     * 转化数据库中的食品详情 格式为 具体的实体类
     * @param foodMeau
     * @return
     */
    public FoodMeauTO convertTo(FoodMeau foodMeau) {

        FoodMeauTO foodMeauTO = new FoodMeauTO();

        // 获取步骤
        String measure = foodMeau.getMeasure();
        MeaSure meaSure = JSON.parseObject(measure, MeaSure.class);
        // 获取主料
        String mainIngredient = foodMeau.getMainIngredient();
        MainList mainList = JSON.parseObject(mainIngredient, MainList.class);
        // 获取辅料
        String accessories = foodMeau.getAccessories();
        AccessoriesList accessoriesList = JSON.parseObject(accessories, AccessoriesList.class);
        // 辅料
        foodMeauTO.setAccessories(accessoriesList.getAccessoriesList());
        foodMeauTO.setCookTime(foodMeau.getCookTime());
        foodMeauTO.setCreateTime(foodMeau.getCreateTime());
        foodMeauTO.setImg(foodMeau.getImg());
        foodMeauTO.setLevel(foodMeau.getLevel());
        foodMeauTO.setLikecount(foodMeau.getLikecount());
        // 主料
        foodMeauTO.setMainIngredient(mainList.getMainIngredientList());
        // 步骤
        foodMeauTO.setMeasure(meaSure.getMeaSureList());
        foodMeauTO.setMeauId(foodMeau.getMeauId());
        foodMeauTO.setMethod(foodMeau.getMethod());
        foodMeauTO.setName(foodMeau.getName());
        foodMeauTO.setPeopleNum(foodMeau.getPeopleNum());
        foodMeauTO.setPrepareTime(foodMeau.getPrepareTime());
        foodMeauTO.setReadcount(foodMeau.getReadcount());
        foodMeauTO.setTags(foodMeau.getTags());
        foodMeauTO.setTaste(foodMeau.getTaste());
        foodMeauTO.setTechniques(foodMeau.getTechniques());
        foodMeauTO.setUserId(foodMeau.getUserId());
        foodMeauTO.setUserName(foodMeau.getUserName());

        return foodMeauTO;
    }


}
