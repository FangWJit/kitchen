package com.dhf.kitchen.system.pc.word.mapper;

import com.dhf.kitchen.system.pc.word.model.Word;
import com.dhf.kitchen.system.pc.word.model.dto.WordDto;

import java.util.List;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 12:42 2021/5/4
 * @Modified by
 */
public interface WordMapper {
    // 查询所有的文章
    List<WordDto> getWordList(String wordType);
    // 查询某一个用户的所有文章
    List<WordDto> getUserWordList(String userId);
    // 查询 某一个 文章
    WordDto getWord(String wordId);
    // 添加文章
    int inertWord(Word word);
    // 更改文章
    int updateWord(Word word);
    // 删除文章
    int deleteWord(String wordId);

}
