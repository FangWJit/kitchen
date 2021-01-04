<template>
    <div>
        <div id="register_body">
            <div id="register_body_left">
                <div style="width: 480px;height: 20px;text-align: center;margin-top: 30px;font-size: 28px;margin-left: 20px"><p>REGISTER</p></div>
                <form action="Login.html" method="post">
                    <div style="height: 40px;width: 230px;margin-top:50px;border: 1px solid #d6d3d1;margin-left:150px;border-radius: 3px">
                        <div style="height: 40px;width: 40px;float: left;position: relative">  <img src="image/小人.png" />   </div>
                        <input type="text" class="login" placeholder="昵称" style="width: 160px;height: 40px;margin-left:1px;border: none;position: absolute" /></div>
                    <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:150px;border-radius: 3px">
                        <div style="height: 40px;width: 40px;float: left;position: relative">  <img src="image/小人.png" />   </div>
                        <input type="text" class="login" placeholder="手机号" style="width: 160px;height: 40px;margin-left:1px;border: none;position: absolute" /></div>
                    <div style="float: left; height: 40px;width: 100px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:150px;border-radius: 3px">
                        <div style="height: 40px;width: 20px;float: left;position: relative">   </div>
                        <input type="text" class="login" placeholder="验证码" maxlength="6" pattern="[0-9]" style="float: left; width: 60px;height: 40px;margin-left:1px;border: none;position: absolute" /></div>
                    <div style="float: right; height: 40px;width: 120px;margin-top:20px;border: 1px solid #d6d3d1;margin-right:100px;border-radius: 3px">
                        <input type="button" class="login" value="向手机发送验证码"  style=" width:120px;height: 40px;border-radius:3px;border:none; background-color: deepskyblue;color: #fbfbfb " /></div>
                    <div style="float: left; height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:150px;border-radius: 3px">
                        <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="image/锁.png" />  </div>
                        <input type="password" class="login" placeholder="密码" style="width: 160px;height: 40px;margin-left:1px;border:none;position: absolute "/></div>
                    <div style="float: left; height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:150px;border-radius: 3px">
                        <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="image/锁.png" />  </div>
                        <input type="password" class="login" placeholder="确认密码" style="width: 160px;height: 40px;margin-left:1px;border:none;position: absolute "/></div>
                    <div style="float: left; height: 40px;width: 80px;margin-top:30px;margin-left:150px;border-radius: 3px;float: left">
                        <input type="submit"  class="login" value="提交" style="width: 230px;height: 40px;border: none;background-color: coral;color: white;border-radius: 3px "/>
                    </div>
                </form>
            </div>

            <div id="register_body_right">
                <div style="margin-top: 80px;text-align: center;float: left;margin-left: 80px">
                    <div style="width: 280px"> 其他登录方式&gt;&gt;</div>
                    <br>
                    <div style="width: 50px;height: 50px;margin-left: 45px;margin-top:20px;float:left;border-radius: 5px">
                        <a href="#"> <img src="image/QQ.png"></a>
                    </div>
                    <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                        <a href="#"> <img src="image/微信.png"></a>
                    </div>
                    <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                        <a href="#"> <img src="image/微博.png"></a>
                    </div>
                </div>
                <p style="float: right; font-size: 13px;margin-right: 150px;margin-top: 50px">已经有账号?</p>
                <div style="height: 40px;width: 80px;margin-top:90px;margin-left:100px;border-radius: 3px;float:left">
                    <a href="Login.html"><button  style="width: 230px;height: 40px;border: none;background-color: coral;color: white;border-radius: 3px ">去登录</button></a>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "register"
    }
</script>

<style >
    @import "../static/css/css_register.css";
</style>