package com.dhf.kitchen.system.pc.word.controller;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.word.model.Word;
import com.dhf.kitchen.system.pc.word.model.dto.WordDto;
import com.dhf.kitchen.system.pc.word.service.WordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @Author : 方万军
 * @Description 文章控制类
 * @Date : created in 13:04 2021/5/4
 * @Modified by
 */
@RestController
@RequestMapping(value = "/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @PostMapping(value = "/insertWord")
    public KitResult insertWord(@RequestBody Word word) {
        if (word == null) return KitResult.fail("参数不完整");
        word.setWordId(UUID.randomUUID().toString());
        return wordService.insertWord(word);
    }

    @GetMapping(value = "/getList")
    public KitResult getList(String wordType) {
        return wordService.getWordList(wordType);
    }

    @GetMapping(value = "/getWord")
    public KitResult getWord(String wordId) {
        return wordService.getWord(wordId);
    }

    /* 更新文章 */
    @GetMapping(value = "/updateWord")
    public KitResult updateWord(WordDto wordDto) {
        Word word = wordDto.convertTo(Word.class);
        return wordService.updateWord(word);
    }

    /* 更新文章 */
    @GetMapping(value = "/deleteWord")
    public KitResult deleteWord(String wordId) {
        return wordService.deleteWord(wordId);
    }
}
