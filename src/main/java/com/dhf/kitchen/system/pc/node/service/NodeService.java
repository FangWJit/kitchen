package com.dhf.kitchen.system.pc.node.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.node.model.Node;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:36 2021/5/5
 * @Modified by
 */
public interface NodeService {

    KitResult queryNodes();

    KitResult insertNode(Node node);

    KitResult deleteNode(String nodeId);
}
