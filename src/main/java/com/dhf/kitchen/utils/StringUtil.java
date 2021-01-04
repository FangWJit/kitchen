package com.dhf.kitchen.utils;


import com.dhf.kitchen.config.MyConstant;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @Date: 2020/4/17
 * @Author: zk
 */
public class StringUtil {
    private StringUtil() {
    }

    /**
     * 将字符串按照分隔成list
     *
     * @param str
     * @return
     */
    public static List<String> toList(String str, String splitChar) {
        if (Strings.isNullOrEmpty(str)) {
            return Collections.<String>emptyList();
        }

        if (splitChar == null) {
            return Collections.<String>emptyList();
        }

        String[] array = str.split(splitChar);

        List<String> list = new ArrayList<>(array.length);
        for (String s : array) {
            list.add(s.trim());
        }
        return list;
    }

    /**
     * 字符串转list 默认分隔符版本
     *
     * @param str
     * @return
     */
    public static List<String> toList(String str) {
        return toList(str, MyConstant.SPLIT);
    }

    public static List<String> toList(String str, int start) {
        return toList(str, MyConstant.SPLIT, start);
    }

    public static List<String> toList(String str, String splitChar, int start) {
        if (Strings.isNullOrEmpty(str)) {
            return Collections.<String>emptyList();
        }

        if (splitChar == null) {
            return Collections.<String>emptyList();
        }

        String[] array = str.split(splitChar);

        List<String> list = new ArrayList<>(array.length);

        for (int i = 0; i < array.length; i++) {
            if (i >= start) {
                list.add(array[i].trim());
            }
        }

        return list;
    }


    /**
     * 将字符串按照分隔成list
     *
     * @param str
     * @return
     */
        public static Set<String> toSet(String str, String splitChar) {
        if (Strings.isNullOrEmpty(str)) {
            return Collections.<String>emptySet();
        }

        if (splitChar == null) {
            return Collections.<String>emptySet();
        }

        String[] array = str.split(splitChar);

        Set<String> list = new HashSet<>(array.length);
        for (String s : array) {
            list.add(s.trim());
        }
        return list;
    }

    public static Set<String> toSet(String str) {
        return toSet(str, MyConstant.SPLIT);
    }

    /**
     * 是否匹配正则
     *
     * @param pattern
     * @param input
     * @return
     */
    public static boolean isMatch(Pattern pattern, CharSequence input) {
        return StringUtils.isNotEmpty(input) && pattern.matcher(input).matches();
    }

    public static char[] toCharArray(String value) {
        int len = value.length();
        char[] charArray = new char[len];
        for (int i = 0; i < len; i++) {
            charArray[i] = value.charAt(i);
        }
        return charArray;
    }
}
