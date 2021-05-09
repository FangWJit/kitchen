package com.dhf.kitchen.system.pc.node.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author : 方万军
 * @Description  公告类
 * @Date : created in 14:47 2021/5/5
 * @Modified by
 */
@Data
public class Node {

    private String nodeId;

    private String nodeContent;

    private Date createTime;
}
