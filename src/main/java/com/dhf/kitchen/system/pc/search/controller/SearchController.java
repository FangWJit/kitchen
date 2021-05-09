package com.dhf.kitchen.system.pc.search.controller;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.system.pc.search.service.SearchService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 13:23 2021/3/23
 * @Modified by
 */
@RestController
@Api(value = "搜索",tags = "搜索")
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/selectUser")
    public KitResult searchUser(@RequestParam("value") String phone) {
        return searchService.searchUser(phone);
    }

    @GetMapping(value = "/selectFood")
    public KitResult searchFood(@RequestParam("value") String value) {
        return searchService.searchFood(value);
    }
}
