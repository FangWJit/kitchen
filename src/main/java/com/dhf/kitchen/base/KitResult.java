package com.dhf.kitchen.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : FangWanJun
 * @Date : created in 14:34 2020/11/13
 */
@Setter
@Getter
public class KitResult {

    private String code;
    private String message;
    private Object data;

    public KitResult() {
    }

    public KitResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public KitResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /***
    　* 操作成功返回data
    　* @param [data]
    　* @return com.dhf.esint_demo.base.KitResult
    　* @date 2020/11/13 14:37
    */
    public static KitResult succ(Object data){
        KitResult kitResult = new KitResult();
        kitResult.setData(data);
        kitResult.setCode("200");
        kitResult.setMessage("成功");
        return kitResult;
    }

    public static KitResult fail(String message) {
        KitResult kitResult = new KitResult();
        kitResult.setData(null);
        kitResult.setCode("400");
        kitResult.setMessage(message);
        return kitResult;
    }

    @Override
    public String toString() {
        return "KitResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
