package com.dhf.kitchen.system.pc.node.mapper;

import com.dhf.kitchen.system.pc.node.model.Node;

import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:13 2021/5/5
 * @Modified by
 */
public interface NodeMapper {
    // 查询
    List<Node> queryNode();
    // 添加
    int insertNode(Node node);
    // 删除
    int deleteNode(String nodeId);
}
