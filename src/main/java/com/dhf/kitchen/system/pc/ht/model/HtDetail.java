package com.dhf.kitchen.system.pc.ht.model;

import com.dhf.kitchen.base.dto.BaseDto;
import lombok.Data;

import java.util.Date;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 14:07 2020/12/30
 * @Modified by
 */
@Data
public class HtDetail extends BaseDto {

    private String htId;

    private String userId;

    private String userName;

    private String userPhoto;

    private String htValue;

    private Date createTime;

    private Integer ansNum;


}
