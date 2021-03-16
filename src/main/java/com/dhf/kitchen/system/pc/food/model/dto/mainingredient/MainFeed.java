package com.dhf.kitchen.system.pc.food.model.dto.mainingredient;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : 方万军
 * @Description 主料细节
 * @Date : created in 13:07 2021/3/1
 * @Modified by
 */
@Getter
@Setter
public class MainFeed {

    // 名字
    private String name;

    // 图片地址
    private String imgUrl;
    
    //分量
    private String weight;
}
