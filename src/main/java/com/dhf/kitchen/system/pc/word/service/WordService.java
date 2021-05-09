package com.dhf.kitchen.system.pc.word.service;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.word.model.Word;

/**
 * @Author : 方万军
 * @Description  文章管理
 * @Date : created in 12:45 2021/5/4
 * @Modified by
 */
public interface WordService {

    KitResult getWordList(String wordType);

    KitResult getWord(String wordId);

    KitResult insertWord(Word word);

    KitResult updateWord(Word word);

    KitResult deleteWord(String wordId);
}
