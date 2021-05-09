package com.dhf.kitchen.utils;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dhf.kitchen.base.ip.model.Ip;
import org.springframework.stereotype.Component;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
/**
 * @Author : 方万军
 * @Description
 * @Date : created in 17:26 2021/3/24
 * @Modified by
 */

/**
 *  根据IP地址获取详细的地域信息
 *第一个方法是传入ip获取真实地址
 *最后一个方法是获取访问者真实ip 即使通过Nginx多层代理也可以获取
 */
@Component
public class IPAddress {

    // {"resultcode":"200",
    // "reason":"查询成功",
    // "result":{"Country":"中国","Province":"天津","City":"天津市","Isp":"联通"},"error_code":0}
    public Ip getAddresses(String ip,String content, String encodingString)
            throws IOException {


        String keys = "&key=4e0a7531f9c183874dbef8461b1d7473";

        // 这里调用聚合数据的接口
        String urlStr = "http://apis.juhe.cn/ip/ipNew"+content+keys;
        // 建立连接
        URL url = new URL(urlStr);
        URLConnection urlConnection = url.openConnection();
        // 拉取  输入流
        InputStream returnStr = urlConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                returnStr, encodingString));// 往对端写完数据对端服务器返回数据
        // ,以BufferedReader流来读取
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        // 转化成对象
        if (JSON.parseObject(buffer.toString()).get("resultcode").equals("200")) {
            Ip result = JSON.parseObject(buffer.toString()).getObject("result", Ip.class);
            result.setIp(ip);
            return result;
        }
        return null;
    }

//    // 测试
//    public static void main(String[] args) {
//        IPAddress addressUtils = new IPAddress();
//        // 测试ip 111.121.72.101 中国贵州省贵阳市 电信
//        String ip = "60.28.145.226";
//        Ip address = null;
//        try {
//            address = addressUtils.getAddresses(ip,"?ip="+ip, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(address.toString());
//        // 输出结果为：中国贵州省贵阳市 电信
//    }


    /**
     * 获取访问用户的客户端IP（适用于公网与局域网）.
     */
    public String getIpAddr(final HttpServletRequest request)
            throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }

        return ipString;
    }
}
