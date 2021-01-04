package com.dhf.kitchen.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dhf.kitchen.config.RedisConfig;
import com.dhf.kitchen.redis.RedisUtils;
import com.google.common.collect.Lists;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: auth
 * @description: 短信验证码
 **/
public final class SmsCodeUtil {


	public SmsCodeUtil(){
		throw new AssertionError();
	}
	
	//发送验证码的请求路径URL
    private static final String serverUrl="https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号
    private static final String appKey="f6acab89c0e0cad99b5a70c2f0002166";
    //网易云信分配的密钥
    private static final String appSecret="f57ab484373e";
    //随机数
    private static final String nonce="123456";
    //短信模板ID
    private static final String templateid="3913242";
    //验证码长度，范围4～10，默认为4
    private static final String codelen="4";
    
    public static String sendSmsCode(String phone) throws ClientProtocolException, IOException{
    	
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
         /*
          * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
          * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
          * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
          */
         nvps.add(new BasicNameValuePair("templateid", templateid));
         nvps.add(new BasicNameValuePair("mobile", phone));
         nvps.add(new BasicNameValuePair("codeLen", codelen));

         httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

         // 执行请求
         HttpResponse response = httpClient.execute(httpPost);
         /*
          * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
          * 2.具体的code有问题的可以参考官网的Code状态表
          */
         //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
         String responseEntity= EntityUtils.toString(response.getEntity(),"utf-8");

         //获取发送状态码
         String code= JSON.parseObject(responseEntity).getString("code");
//         if (code.equals("200")){
//             System.out.println("发送成功！");
//             //return;
//         }
//         System.out.println("发送失败！");
         return code;
     
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


    /**
     * @param strPhoneNum
     * @return String
     * @description 联通get请求 发送短信方法
     * SpCode		企业编号
     * LoginName	用户名称
     * Password		用户密码
     * MessageContent		短信内容, 最大402个字或字符（短信内容要求的编码为gb2312或gbk），短信发送必须按照短信模板 例如：你有一项编号为{xxxxxxxxx}的事务需要处理{x} 你有一项编号为123456789的事务需要处理。
     * UserNumber		手机号码(多个号码用”,”分隔)，最多1000个号码
     * SerialNumber		流水号，20位数字，唯一 （规则自定义,建议时间格式精确到毫秒）必填参数，与回执接口中的流水号一一对应，不传后面回执接口无法查询数据。
     * ScheduleTime		预约发送时间，格式:yyyyMMddHHmmss,如‘20090901010101’，立即发送请填空（预约时间要写当前时间5分钟之后的时间，若预约时间少于5分钟，则为立即发送。）
     * f		提交时检测方式
     * 1 --- 提交号码中有效的号码仍正常发出短信，无效的号码在返回参数faillist中列出
     * 不为1 或该参数不存在 --- 提交号码中只要有无效的号码，那么所有的号码都不发出短信，所有的号码在返回参数faillist中列出
     *
     * 返回值信息
     * 0	发送短信成功
     * 1	提交参数不能为空
     * 2	账号无效或权限不足
     * 3	账号密码错误,
     * 4	预约发送时间格式不正确，应为yyyyMMddHHmmss
     * 5	IP不合法,
     * 6	号码中含有无效号码或不在规定的号段或为免打扰号码（包含系统黑名单号码）
     * 7	非法关键字
     * 8	内容长度超过上限，最大402字或字符
     * 9	接受号码过多，最大1000
     * 12	您尚未订购[普通短信业务]，暂不能发送该类信息
     * 13	您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息
     * 14	流水号格式不正确
     * 15	流水号重复
     * 16	超出发送上限（操作员帐户当日发送上限）
     * 17	余额不足
     * 18	扣费不成功
     * 20	系统错误
     * 21	密码错误次数达到5次
     * 24	帐户状态不正常
     * 25	账户权限不足
     * 26	需要人工审核
     * 28	发送内容与模板不符
     * 29	扩展号太长或不是数字&accnum=
     * 32	同一号码相同内容发送次数太多（默认24小时内，验证码类发送5次或相同内容3次以上会报此错误。）
     * 33	同一号码验证码提交过快
     * @throws IOException
     */
    public static JSONObject sendMsgGet(String strPhoneNum, String type) throws IOException {
        Map<String,String> value = getPropertiesValue("properties/param.properties","SpCode,LoginName,Password");
        String SpCode = value.get("SpCode");
        String LoginName = value.get("LoginName");
        String Password = value.get("Password");
        JSONObject result = new JSONObject();
        String MessageContent = "";
        String checkCode = "";
        String SerialNumber = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        if("check".equals(type)){
            Random random = new Random();
            checkCode = String.valueOf(random.nextInt(9999));
            MessageContent = "您的厨阁账号验证码为："+checkCode;
        }else {
            MessageContent = "您的审核已通过！";
        }
        //联通get 请求地址
        String url = "https://api.ums86.com:9600/sms/Api/Send.do?SpCode="+SpCode+"&LoginName="+LoginName+"&Password="+Password+"&MessageContent="+ URLEncoder.encode(MessageContent,"GBK")+"&UserNumber="+strPhoneNum+"&SerialNumber="+SerialNumber+"&ScheduleTime=&f=1";
        String str = "";
        BufferedReader in = null ;
        URL sendUrl = new URL(url);
        URLConnection connect = sendUrl.openConnection();
        //固定消息头
        connect.setRequestProperty("content-Type", "application/x-www-form-urlencoded;charset=GBK");
        connect.setRequestProperty("accept", "*/*");
        connect.setRequestProperty("connection", "Keep-Alive");
        connect.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connect.connect();
        //Map<String, List<String>> resultMap = connection.getHeaderFields();
        in = new BufferedReader(new InputStreamReader(connect.getInputStream(),"GBK"));
        String lines;
        while ((lines = in.readLine())!=null){
            str += lines;
        }
        System.out.println(str);
        // str = result=2&description=账号无效或权限不足
        String code = str.substring(str.indexOf("=")+1,str.indexOf("=")+2);
        //成功返回 并且 是验证码操作
        if("0".equals(code)&&"check".equals(type)){
            //redis 存储 电话号和验证码
            saveCheckCodeToRedis(strPhoneNum,checkCode);
        }
        String message = str.substring(str.lastIndexOf("=")+1);
        result.put("code",code);
        result.put("message",message);
        return result;
    }

    /**
     * @param strPhoneNum 手机号码(多个号码用”,”分隔)，最多1000个号码
     * @param type check 为验证码 notice 为短信提示
     * @return
     * @throws IOException
     */
    public static JSONObject sendMsgPost(String strPhoneNum, String type) throws IOException {
        JSONObject result = new JSONObject();
        Map<String,String> value = getPropertiesValue("properties/param.properties","SpCode,LoginName,Password");
        String SpCode = value.get("SpCode");
        String LoginName = value.get("LoginName");
        String Password = value.get("Password");
        HttpClient httpClient = null;
        HttpResponse response = null;
        String verifyUrl = "https://api.ums86.com:9600/sms/Api/Send.do";
        String MessageContent = "";
        String checkCode = "";
        String SerialNumber = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        if("check".equals(type)){
            Random random = new Random();
            checkCode = String.valueOf(random.nextInt(9999));
            MessageContent = "您的验证码为："+checkCode;
        }else {
            MessageContent = "您的审核已通过！";
        }

        try {
            httpClient = HttpClients.createDefault();
            // 准备参数
            List<NameValuePair> params = Lists.newArrayList();
            params.add(new BasicNameValuePair("SpCode",SpCode));
            params.add(new BasicNameValuePair("LoginName",LoginName));
            params.add(new BasicNameValuePair("Password",Password));
            params.add(new BasicNameValuePair("MessageContent", MessageContent));
            params.add(new BasicNameValuePair("UserNumber", strPhoneNum));
            params.add(new BasicNameValuePair("SerialNumber", SerialNumber));
            params.add(new BasicNameValuePair("ScheduleTime", ""));
            params.add(new BasicNameValuePair("ExtendAccessNum", ""));
            params.add(new BasicNameValuePair("f", "1"));
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"GBK");
            //通过post方式访问
            HttpPost post = new HttpPost(verifyUrl);
            formEntity.setContentType("application/x-www-form-urlencoded");
            post.setEntity(formEntity);
            response = httpClient.execute(post);
            BufferedReader in = null ;
            String str = "";
            String lines;
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"GBK"));
            while ((lines = in.readLine())!=null){
                str += lines;
            }
            // str = result=2&description=账号无效或权限不足
            String code = str.substring(str.indexOf("=")+1,str.indexOf("=")+2);
            String message = str.substring(str.lastIndexOf("=")+1);
            result.put("code",code);
            if("0".equals(code)&&"check".equals(type)){
                //redis 存储 电话号和验证码
                saveCheckCodeToRedis(strPhoneNum,checkCode);
            }
            result.put("message",message);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void saveCheckCodeToRedis(String strPhoneNum,String checkCode){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("jedisTemplate");
        redisTemplate.opsForValue().set(strPhoneNum,checkCode,120, TimeUnit.SECONDS);
    }
    public static Map<String, String> getPropertiesValue(String path, String keys) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = com.dhf.kitchen.utils.SmsCodeUtil.class.getClassLoader().getResourceAsStream(path);
        properties.load(inputStream);
        String [] arrkey = keys.split(",");
        Map<String,String>map = new HashMap<>();
        for(String key:arrkey){
            map.put(key,properties.getProperty(key));
        }
        return map;
    }
}
