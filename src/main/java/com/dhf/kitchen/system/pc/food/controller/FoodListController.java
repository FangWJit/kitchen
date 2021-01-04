package com.dhf.kitchen.system.pc.food.controller;


import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.food.service.FoodListService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fangwanjun
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/foodList")
public class FoodListController {


    @Autowired
    private FoodListService foodListService;

    /**
    　* @Description 查询列表  并且需要权限查询
    　* @Author 方万军
    　*
    　* @return
    　* @date 2021/1/2 16:25
    */
    @GetMapping(value = "/getList")
    @RequiresAuthentication
    public KitResult getList(){
       return  foodListService.getList();
    }

    @GetMapping(value = "/getRank")
    public KitResult getRank() {
        return foodListService.getRank();
    }

    @GetMapping(value = "/getLastRank")
    public KitResult getLastRank() {
        return foodListService.getLastRank();
    }
}

