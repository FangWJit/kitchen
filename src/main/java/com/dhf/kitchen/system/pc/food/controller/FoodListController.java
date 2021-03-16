package com.dhf.kitchen.system.pc.food.controller;


import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.food.service.FoodListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api
@RequiresAuthentication  // 请求验证
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
    @ApiOperation(value = "获取菜单列表" , tags = "获取菜单列表")
    @GetMapping(value = "/getList/{pageSize}")
    public KitResult getList(@PathVariable("pageSize") Integer pageSize){
       return  foodListService.getList(pageSize);
    }

    @ApiOperation(value = "获取总条目",tags = "获取总条目")
    @GetMapping(value = "/getCount")
    public KitResult getCount() {
        return foodListService.getCount();
    }

    @ApiOperation(value = "获取最热菜品排行" , tags = "获取最热菜品排行")
    @GetMapping(value = "/getRank")
    public KitResult getRank() {
        return foodListService.getRank();
    }

    @ApiOperation(value = "获取最新菜品排行" , tags = "获取最新菜品排行")
    @GetMapping(value = "/getLastRank")
    public KitResult getLastRank() {
        return foodListService.getLastRank();
    }

    @ApiOperation(value = "获取菜品详情" , tags = "获取菜品详情")
    @GetMapping(value = "/getFoodDetail/{id}")
    public KitResult getFoodDetail(@PathVariable("id") int id ) {
        if( id < 0) {
            return KitResult.fail("请求参数有误");
        }
        return foodListService.getFoodMeau(id);
    }
}

