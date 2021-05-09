package com.dhf.kitchen.system.pc.node.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.node.mapper.NodeMapper;
import com.dhf.kitchen.system.pc.node.model.Node;
import com.dhf.kitchen.system.pc.node.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:38 2021/5/5
 * @Modified by
 */

@Service("nodeService")
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;


    @Override
    public KitResult queryNodes() {
        List<Node> nodes = nodeMapper.queryNode();
        if (nodes == null || nodes.size() == 0) return KitResult.fail("查询公告错误");
        return KitResult.succ(nodes);
    }

    @Override
    public KitResult insertNode(Node node) {
        node.setNodeId(UUID.randomUUID().toString());
        int i = nodeMapper.insertNode(node);
        if (i == -1) return KitResult.fail("插入失败");
        return KitResult.succ(null);
    }

    @Override
    public KitResult deleteNode(String nodeId) {
        int i = nodeMapper.deleteNode(nodeId);
        if (i == -1) return KitResult.fail("删除失败");
        return KitResult.succ(null);
    }
}
