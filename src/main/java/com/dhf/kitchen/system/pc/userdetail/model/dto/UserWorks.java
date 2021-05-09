package com.dhf.kitchen.system.pc.userdetail.model.dto;

import lombok.Data;

/**
 * @Author : 方万军
 * @Description  用户作品
 * @Date : created in 17:10 2021/3/28
 * @Modified by
 */
@Data
public class UserWorks {

    // 食品的id
    private  String foodId;
    // 食品图片
    private String foodPhoto;
    // 食品名称
    private String foodName;
}
