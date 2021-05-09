package com.dhf.kitchen.system.pc.node.controller;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.node.model.Node;
import com.dhf.kitchen.system.pc.node.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:41 2021/5/5
 * @Modified by
 */
@RestController
@RequestMapping(value = "/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @GetMapping(value = "/getNodes")
    public KitResult getNodes() {
        return nodeService.queryNodes();
    }

    @PostMapping(value = "/insertNode")
    public KitResult insertNode (@RequestBody Node node) {
        return nodeService.insertNode(node);
    }

    @GetMapping(value = "/deleteNode")
    public KitResult deleteNode(String nodeId) {
        return nodeService.deleteNode(nodeId);
    }
}
