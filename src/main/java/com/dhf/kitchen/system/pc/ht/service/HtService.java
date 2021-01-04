package com.dhf.kitchen.system.pc.ht.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.ht.model.dt.HtDetailDt;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 14:58 2020/12/30
 * @Modified by
 */
public interface HtService {

    KitResult selectHtList();

    KitResult insertHt(HtDetailDt htDetailDt);

    KitResult insertAnsHt(HtDetailDt htDetailDt);

    KitResult deleteHt(String htId);

    KitResult deleteAnsHt(String htId,String ansHt);
}
