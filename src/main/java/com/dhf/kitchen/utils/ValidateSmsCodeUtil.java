package com.dhf.kitchen.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: auth
 * @description: 验证短信验证码
 * @author: jiangshan
 * @create: 2018-06-30 10:19
 **/
public final class ValidateSmsCodeUtil {

	public ValidateSmsCodeUtil(){
		throw new AssertionError();
	}
	
	  //发送验证码的请求路径URL
	 private static final String serverUrl="https://api.netease.im/sms/verifycode.action";
	 //网易云信分配的账号
	 private static final String appKey="f6acab89c0e0cad99b5a70c2f0002166";
	 //网易云信分配的密钥
	 private static final String appSecret="f57ab484373e";
	 //随机数
	 private static final String nonce="123456";
	 
	 public static String sendValidateSmsCode(String phone,String code) throws Exception{

    	 DefaultHttpClient httpClient = new DefaultHttpClient();
         HttpPost httpPost = new HttpPost(serverUrl);
         String curTime = String.valueOf((new Date()).getTime() / 1000L);
         
         String checkSum = getCheckSum(appSecret, nonce, curTime);

         // 设置请求的header
         httpPost.addHeader("AppKey", appKey);
         httpPost.addHeader("Nonce", nonce);
         httpPost.addHeader("CurTime", curTime);
         httpPost.addHeader("CheckSum", checkSum);
         httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

         // 设置请求的的参数，requestBody参数
         List<NameValuePair> nvps = new ArrayList<NameValuePair>();
    
         nvps.add(new BasicNameValuePair("mobile", phone));
         nvps.add(new BasicNameValuePair("code", code));

         httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

         // 执行请求
         HttpResponse response = httpClient.execute(httpPost);
         /*
          * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
          * 2.具体的code有问题的可以参考官网的Code状态表
          */
         String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

         //获取发送状态码
         String codes= JSON.parseObject(responseEntity).getString("code");
         String msg= JSON.parseObject(responseEntity).getString("msg");
        /* if (codes.equals("200")){
             System.out.println("发送成功！");
             //return;
         }else if(codes.equals("404") && !msg.equals("template id not exist")){
        	 throw new Exception("超时错误！");
         }else if(codes.equals("413")){
        	 throw new Exception("验证码错误！");
         }else{
        	 throw new Exception(codes+"请根据codes查询code状态表！");
         }*/
         return codes;
         
	 }
	 
	 // 计算并获取CheckSum
	 private static String getCheckSum(String appSecret, String nonce, String curTime) {
	     return encode("sha1", appSecret + nonce + curTime);
	 }
	    
	 private static String encode(String algorithm, String value) {
	     if (value == null) {
	         return null;
	     }
	     try {
	         MessageDigest messageDigest
                  = MessageDigest.getInstance(algorithm);
	         messageDigest.update(value.getBytes());
	         return getFormattedText(messageDigest.digest());
	     } catch (Exception e) {
	         throw new RuntimeException(e);
	     }
	 }
     private static String getFormattedText(byte[] bytes) {
	     int len = bytes.length;
	     StringBuilder buf = new StringBuilder(len * 2);
	     for (int j = 0; j < len; j++) {
	         buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
	         buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
	     }
	     return buf.toString();
	 }
	 private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
	         '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	    
	 
	//public static void main(String[] args) throws Exception {
	//	sendValidateSmsCode("13262592207","6434");
	//}

}
