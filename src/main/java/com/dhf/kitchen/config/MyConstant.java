package com.dhf.kitchen.config;

/**
 * @Author : FangWanJun
 * @Date : created in 10:42 2020/11/14
 */
public class MyConstant {

    private MyConstant() {
    }

    /**
     * 手机号为空
     */
    public static String STR_MOBILE_NULL = "手机号为空";
    /**
     * 手机号格式错误
     */
    public static String STR_MOBILE_ERROR = "手机号格式错误";
    public static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9])|(147))\\d{8}$";



    public static final String DATE_FORMAT0 = "yyyy-MM";
    public static final String DATE_FORMAT1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT2 = "yyyy-MM-dd HH";
    public static final String DATE_FORMAT3 = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT4 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT5 = "HH:mm";


    public static final String SPLIT = ",";
    public static final String SPLIT1 = "/";
    public static final String SPLIT2 = ":";


    /**
     * token
     */
    public static final String TOKEN = "token:";


}
