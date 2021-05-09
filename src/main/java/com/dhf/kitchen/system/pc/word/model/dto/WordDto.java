package com.dhf.kitchen.system.pc.word.model.dto;

import com.dhf.kitchen.base.entity.PojoConvertor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 15:55 2021/5/4
 * @Modified by
 */
@Data
public class WordDto implements PojoConvertor, Serializable {

    private String wordId;

    private String userId;

    private String userName;

    private String userPhoto;

    private String wordTitle;

    private String wordType;

    private String wordContent;

    private Date createTime;

    private int readCount;

    private int likeCount;

    private int scCount;

    private int state;
}
