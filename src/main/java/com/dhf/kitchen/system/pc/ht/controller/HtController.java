package com.dhf.kitchen.system.pc.ht.controller;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.ht.model.dt.HtDetailDt;
import com.dhf.kitchen.system.pc.ht.service.HtService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:03 2020/12/30
 * @Modified by
 */
@RestController
@RequiresAuthentication
@RequestMapping(value = "/ht")
public class HtController {

    @Autowired
    private HtService htService;

    @GetMapping(value = "/getHt")
    public KitResult selectHt() {
        return htService.selectHtList();
    }

    @PostMapping(value = "/putHt")
    public KitResult putHt(@RequestBody HtDetailDt htDetailDt) {
        return htService.insertHt(htDetailDt);
    }

    @PostMapping(value = "/ansHt")
    public KitResult ansHt(@RequestBody HtDetailDt htDetailDt) {

        return htService.insertAnsHt(htDetailDt);
    }

    @GetMapping(value = "/delHt")
    public KitResult delHt(String htId) {
        if (StringUtils.isEmpty(htId)) {
            KitResult.fail("缺少参数");
        }
        return htService.deleteHt(htId);
    }

    @GetMapping(value = "/delAnsHt")
    public KitResult delAnsHt(String htId,String ansHt) {
        if (StringUtils.isEmpty(htId) || StringUtils.isEmpty(ansHt)) {
            return KitResult.fail("缺少参数");
        }
        return htService.deleteAnsHt(htId,ansHt);
    }

}
