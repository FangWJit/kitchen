package com.dhf.kitchen.system.pc.word.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author : 方万军
 * @Description   文章管理
 * @Date : created in 12:37 2021/5/4
 * @Modified by
 */
@Data
public class Word implements Serializable {

    private String wordId;

    private String userId;

    private String wordTitle;

    private String wordType;

    private String wordContent;

    private Date createTime;

    private int readCount;

    private int likeCount;

    private int scCount;

}
