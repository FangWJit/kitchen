package com.dhf.kitchen.system.pc.food.model.dto.step;

import lombok.Data;

import java.util.List;

/**
 * @Author : 方万军
 * @Description   食品步骤
 * @Date : created in 10:51 2021/3/1
 * @Modified by
 */
@Data
public class FoodStep {

    // 图片列表
    public List<String> picture;

    // 步骤 几
    public String step;

    // 描述
    public String des;

}
