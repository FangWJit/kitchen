package com.dhf.kitchen.system.pc.ht.mapper;

import com.dhf.kitchen.system.pc.ht.model.HtDetail;
import com.dhf.kitchen.system.pc.ht.model.dt.HtDetailDt;

import java.util.List;

/**
 * @Author : 方万军
 * @Description 话题
 * @Date : created in 14:53 2020/12/30
 * @Modified by
 */
public interface HtMapper {

    List<HtDetail> selectHtList() ;

    List<HtDetail> getHt(String queId) ;

    int insertHt(HtDetailDt htDetailDt);

    int insertAnsHt(HtDetailDt htDetailDt);

    int deleteHt(String htId);

    int deleteAllAns(String htId);

    int deleteAnsHt(String htId,String ansHt);
}
