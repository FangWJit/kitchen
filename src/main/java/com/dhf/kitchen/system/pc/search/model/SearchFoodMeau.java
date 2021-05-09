package com.dhf.kitchen.system.pc.search.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : 方万军
 * @Description 菜单菜单
 * @Date : created in 19:14 2021/1/2
 * @Modified by
 */
@Data
public class SearchFoodMeau implements Serializable {

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
    private String mainIngredient;
    /* 辅料 */
    private String accessories;
    /* 步骤 */
    private String measure;
    /* 技巧 */
    private String techniques;
    /* 创建时间 */
    private Date createTime;
    /* 阅读次数 */
    private Integer readcount;
    /* 点赞数*/
    private Integer likecount;

}
