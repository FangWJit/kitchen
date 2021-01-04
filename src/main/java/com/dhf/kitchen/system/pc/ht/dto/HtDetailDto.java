package com.dhf.kitchen.system.pc.ht.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 21:41 2020/12/30
 * @Modified by
 */
@Data
public class HtDetailDto {

    private String htId;

    private String userId;

    private String userName;

    private String userPhoto;

    private String htValue;

    private Date createTime;

    private Integer ansNum;

    private Integer attention;

    private List<HtDetailDto> ans;
}
