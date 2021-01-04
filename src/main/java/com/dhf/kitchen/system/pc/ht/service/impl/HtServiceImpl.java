package com.dhf.kitchen.system.pc.ht.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.config.SessionContext;
import com.dhf.kitchen.system.pc.ht.dto.HtDetailDto;
import com.dhf.kitchen.system.pc.ht.mapper.HtMapper;
import com.dhf.kitchen.system.pc.ht.model.HtDetail;
import com.dhf.kitchen.system.pc.login.model.User;
import com.dhf.kitchen.system.pc.userrelation.model.UserRelation;
import com.dhf.kitchen.system.pc.ht.model.dt.HtDetailDt;
import com.dhf.kitchen.system.pc.ht.service.HtService;
import com.dhf.kitchen.system.pc.userrelation.service.UserRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:00 2020/12/30
 * @Modified by
 */
@Service
public class HtServiceImpl implements HtService {

    @Autowired
    private HtMapper htMapper;

    @Autowired
    private UserRelationService userRelationService;

    /**
    　* @Description 查询话题的列表  包括  评论的列表  以及  话题者和评论者与当前用户的关系
    　* @Author 方万军
    　* []
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/1 20:43
    */
    @Override
    public KitResult selectHtList() {

        List<HtDetailDto> htDetailDtos = new ArrayList<>();

        // 获取话题列表
        List<HtDetail> htDetails = htMapper.selectHtList();
        if (htDetails.isEmpty()) {
            return KitResult.fail("暂无话题");
        }
        // 遍历话题列表
        for (HtDetail h :htDetails) {
            // 用户和话题发布者的关系
            User user = SessionContext.get();
            UserRelation userRelation = new UserRelation();
            userRelation.setUserId(user.getUserId());
            userRelation.setNoricorId(h.getUserId());
            KitResult relation = userRelationService.getRelation(userRelation);
            // 获取话题的评论
            List<HtDetail> ans = htMapper.getHt(h.getHtId());
            if (htDetails.isEmpty()) {
                return KitResult.fail("暂无评论");
            }
            List<HtDetailDto> htDetailDtoAns = new ArrayList<>();
            // 遍历评论
            for (HtDetail de:ans) {
                // 获取用户和评论者的关系 存入链表中
                userRelation.setNoricorId(de.getUserId());
                KitResult relation1 = userRelationService.getRelation(userRelation);
                HtDetailDto htDetailDto = de.convertTo(HtDetailDto.class);
                htDetailDto.setAttention((Integer) relation1.getData());
                htDetailDtoAns.add(htDetailDto);
            }
            // 转化 话题为可传输对象，设置关系 和评论链表
            HtDetailDto htDetailDto = h.convertTo(HtDetailDto.class);
            htDetailDto.setAttention((Integer) relation.getData());
            htDetailDto.setAns(htDetailDtoAns);
            htDetailDtos.add(htDetailDto);
        }
        // 返回整个链表
        return KitResult.succ(htDetailDtos);
    }

    /**
    　* @Description 当前用户添加话题
    　* @Author 方万军
    　* [htDetailDt]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/1 20:44
    */
    @Override
    public KitResult insertHt(HtDetailDt htDetailDt) {
        // 随机生成话题id
        htDetailDt.setHtId(htDetailDt.getHtId()+ UUID.randomUUID());
        int i = htMapper.insertHt(htDetailDt);
        if (i ==0) return KitResult.fail("发布失败");
        return KitResult.succ(1);
    }

    /**
    　* @Description 用户评论话题
    　* @Author 方万军
    　* [htDetailDt]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/1 20:45
    */
    @Override
    @Transactional
    public KitResult insertAnsHt(HtDetailDt htDetailDt) {
        // 随机生成话题id
        htDetailDt.setHtId(htDetailDt.getHtId()+ UUID.randomUUID());
        int i = htMapper.insertHt(htDetailDt);
        if (i ==0) return KitResult.fail("发布失败");
        int i1 = htMapper.insertAnsHt(htDetailDt);
        if (i1 == 0) new Throwable("评论失败");
        return KitResult.succ(1);
    }

    /**
    　* @Description  删除话题
    　* @Author 方万军
    　* [htId]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/1 20:46
    */
    @Override
    public KitResult deleteHt(String htId) {
        int i = htMapper.deleteHt(htId);
        if (i == 0) return KitResult.fail("删除失败");
        htMapper.deleteAllAns(htId);
        return KitResult.succ("删除成功");
    }

    /**
    　* @Description 删除评论
    　* @Author 方万军
    　* [htId, ansHt]
    　* @return com.dhf.kitchen.base.KitResult
    　* @date 2021/1/1 20:46
    */
    @Override
    public KitResult deleteAnsHt(String htId, String ansHt) {
        int i1 = htMapper.deleteHt(ansHt);
        if (i1 == 0) return KitResult.fail("删除评论失败");
        int i = htMapper.deleteAnsHt(htId, ansHt);
        if (i == 0) return KitResult.fail("删除评论关系失败");
        return KitResult.succ("删除评论成功");
    }


}
