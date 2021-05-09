package com.dhf.kitchen.system.pc.search.service.impl;

import com.dhf.kitchen.base.KitResult;
import com.dhf.kitchen.config.MyConstant;
import com.dhf.kitchen.system.pc.search.mapper.SearchMapper;
import com.dhf.kitchen.system.pc.search.model.SearchFoodMeau;
import com.dhf.kitchen.system.pc.search.model.SearchUserDetail;
import com.dhf.kitchen.system.pc.search.service.SearchService;
import com.dhf.kitchen.utils.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author : 方万军
 * @Description
 * @Date : created in 13:32 2021/3/23
 * @Modified by
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public KitResult searchUser(String phone) {
        boolean matches = Pattern.matches(MyConstant.REGEX_MOBILE_EXACT, phone);
        if (!matches) {
            return KitResult.succ(null);
        }
        SearchUserDetail userDetail = searchMapper.selectUser(phone);
        return KitResult.succ(userDetail);
    }

    @Override
    public KitResult searchFood(String value) {
        List<SearchFoodMeau> rest = new ArrayList<>();
        List<String> searchList = SearchUtil.getSearchList(value);
        searchList.forEach( res -> {
            List<SearchFoodMeau> searchFoodMeaus = searchMapper.selectFood(res);
            rest.addAll(searchFoodMeaus);
        });
        if (rest == null) return KitResult.fail("没有数据");
        return KitResult.succ(rest);
    }
}
