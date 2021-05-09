package com.dhf.kitchen.utils;

import java.util.*;

/**
 * @Author : 方万军
 * @Description   搜索 算法 设计
 * @Date : created in 12:49 2021/3/23
 * @Modified by
 */
public class SearchUtil {
    public static void main(String[] args) {
        getSearchList("番茄炒鸡蛋");
    }
    /*
    *  将搜索字符串拆分成 多个碎片   格式 %str%
    * */
    public static List<String> getSearchList(String s) {

        Set<String> set = new TreeSet<>();
        int left = 0;
        int right = s.length();
        while(left < right) {
            set.add("%"+s.substring(left, right)+"%");
            left++;
        }
        left = 0;
        while(left < right) {
            set.add("%"+s.substring(left, right)+"%");
            right--;
        }
        left = 0;
        right = s.length();
        while(left < right) {
            set.add("%"+s.substring(left, right)+"%");
            left++;
            right--;
        }
        return new ArrayList<>(set);
    }

}
