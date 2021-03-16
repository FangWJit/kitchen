package com.dhf.kitchen.system.pc.food.model.dto;

import com.dhf.kitchen.system.pc.food.model.dto.accessorie.FoodAccessorie;
import com.dhf.kitchen.system.pc.food.model.dto.mainingredient.MainFeed;
import com.dhf.kitchen.system.pc.food.model.dto.step.FoodStep;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 11:29 2021/3/1
 * @Modified by
 */
@Data
public class FoodMeauTO {

    /* 菜品的id*/
    private int meauId;
    /* 创建用户id */
    private String userId;
    /* 创建用户姓名 */
    private String userName;
    /* 菜名 */
    private String name;
    /* 功能 */
    private String tags;
    /* 类型*/
    private String method;
    /*  图片 */
    private String img;
    /* 操作等级 */
    private String level;
    /* 适合人数量 */
    private String peopleNum;
    /* 口味 */
    private String taste;
    /* 准备时间 */
    private String prepareTime;
    /* 烹饪时间 */
    private String cookTime;
    /* 主料 */
    private List<MainFeed> mainIngredient;
    /* 辅料 */
    private List<FoodAccessorie> accessories;
    /* 步骤 */
    private List<FoodStep> measure;
    /* 技巧 */
    private String techniques;
    /* 创建时间 */
    private Date createTime;
    /* 阅读次数 */
    private Integer readcount;
    /* 点赞数*/
    private Integer likecount;

}
