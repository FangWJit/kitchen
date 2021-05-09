package com.dhf.kitchen.system.pc.word.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.word.mapper.WordMapper;
import com.dhf.kitchen.system.pc.word.model.Word;
import com.dhf.kitchen.system.pc.word.model.dto.WordDto;
import com.dhf.kitchen.system.pc.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 12:48 2021/5/4
 * @Modified by
 */

@Service("wordService")
public class WordServiceImpl implements WordService {

    @Autowired
    WordMapper wordMapper;

    /* 查询文章 */
    @Override
    public KitResult getWordList(String wordType) {
        List<WordDto> wordList = wordMapper.getWordList(wordType);
        if (wordList == null || wordList.size() == 0) return KitResult.fail("没有文章");
        return KitResult.succ(wordList);
    }

    /* 查询某一个文章 */
    @Override
    @Transactional
    public KitResult getWord(String wordId) {
        WordDto wordDto = wordMapper.getWord(wordId);
        if (wordDto == null) return KitResult.fail("参数错误");
        Word word = wordDto.convertTo(Word.class);
        // 阅读量 +1
        word.setReadCount(word.getReadCount()+1);
        int i = wordMapper.updateWord(word);
        if (i == -1) return KitResult.fail("更新阅读量失败");
        wordDto.setReadCount(word.getReadCount());
        return KitResult.succ(wordDto);
    }

    /* 插入文章 */
    @Override
    public KitResult insertWord(Word word) {
        int i = wordMapper.inertWord(word);
        if (i == -1) return KitResult.fail("上传失败");
        return KitResult.succ(null);
    }

    /* 更新文章 */
    @Override
    public KitResult updateWord(Word word) {
        int i = wordMapper.updateWord(word);
        if (i == -1) return KitResult.fail("更新失败");
        return KitResult.succ(null);
    }

    @Override
    public KitResult deleteWord(String wordId) {
        int i = wordMapper.deleteWord(wordId);
        if (i == -1) return KitResult.fail("删除失败");
        return KitResult.succ(null);
    }
}
