package com.dhf.kitchen.system.pc.food.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 23:03 2021/1/2
 * @Modified by
 */
@Data
public class FoodRankDto implements Serializable {

    /* 菜名 */
    private String name;
    /* 创建用户id */
    private String userId;
    /* 创建用户姓名 */
    private String userName;
    /* 功能 */
    private String tags;
    /*  图片 */
    private String img;
    /* 点赞数*/
    private Integer likecount;
}
