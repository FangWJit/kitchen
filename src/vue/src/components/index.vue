<template>
    <div>
        <div id="fixed">
            <div id="top">
                <div id="top_logo">
                    <img src="../static/image/厨阁.png" style="width: 50px;height:50px;float: left">
                    <span style="font-size: 30px;">厨阁</span>
                </div>
                <div id="top_search">
                    <form>
                        <div id="top_search_input">
                            <div id="FDJ"><img src="../static/image/搜索.png"/></div>
                            <input type="text" id="top_search_input_Text"/>
                            <button style="margin-left:13px;height: 42px;width: 80px;position:absolute;border:0
		    ;background: coral;margin-top: -1px;border-radius: 3px;float: right;
		    font-family: 隶书;font-size: 20px">搜索
                            </button>
                        </div>
                    </form>
                </div>
                <div id="top_list">
                    <ul>
                        <a href="#">
                            <li>上传</li>
                        </a>
                        <a @click="$router.push({path:'/food_question'})" href="">
                            <li>提问</li>
                        </a>
                        <a @click="$router.push({path:'/detail',query:{userId}})" v-if="userName != null || userName != ''" href="">
                            <li style="font-size: 20px;color: coral">{{userName}}</li>
                        </a>
                        <a href="" v-else-if="userName == null || userName == '' ">
                            <li>请先登录</li>
                        </a>
                        <a href="" @click="loginout()">
                            <li>退出</li>
                        </a>
                    </ul>
                </div>

            </div>
            <div id="Navigation">
                <div id="Navigation_body">
                    <ul>
                        <a class="Navigation" @click="$router.push({path:'/index'})" href=""
                           style=" background-color: aliceblue;color: coral;">
                            <li class="na_li"> 首页</li>
                        </a>
                        <a class="Navigation" @click="$router.push({path:'/foodlist'})" href="">
                            <li class="na_li">菜谱大全</li>
                        </a>
                        <a class="Navigation" @click="$router.push({path:'/foodlist2'})" href="">
                            <li class="na_li">家常菜谱</li>
                        </a>
                        <a class="Navigation" @click="$router.push({path:'/food_question'})" href="">
                            <li class="na_li">美食问答</li>
                        </a>
                        <a class="Navigation" href="">
                            <li class="na_li">食谱分类</li>
                        </a>
                        <a class="Navigation" href="">
                            <li class="na_li">健康食疗</li>
                        </a>
                        <a class="Navigation" href="">
                            <li class="na_li">厨友排行</li>
                        </a>
                        <a class="Navigation" @click="$router.push({path:'/proclamation'})" href="">
                            <li class="na_li">公告</li>
                        </a>
                    </ul>

                </div>
            </div>
        </div>
        <div id="body_div">
            <div style="float: left;width: 660px">
                <div id="body_div_left_top">
                    <p style="color: coral;font-size: 20px">时令热搜</p>
                    <div id="body_div_left_top_down">
                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">东坡肉</a></div>
                    </div>
                </div>

                <div id="body_div_left_center">
                    <p style="color: coral;font-size: 20px">最新食谱</p>
                    <a href="#" style="float: right;margin-top: -20px">更多&gt&gt</a>
                    <hr style="border: 1px solid;color: coral;margin-top: 5px">
                    <div v-for="(item,index) in lastfood" :key="index">
                        <div id="NOone" v-if="index == 0">
                            <div id="image">
                                <a href="#"> <img :src="item.img"></a>
                            </div>
                            <div id="writer">
                                <p style="font-family:楷体;font-size: 25px;margin-top: 15px;margin-left: 5px">{{item.name}}</p>
                                <p style="font-family:楷体;font-size: 10px;margin-top: 15px;margin-left: 5px">{{item.tags}}</p>
                                <p style="font-size: 18px;font-family: 楷体;margin-top: 5px;margin-left: 35px;display: inline-block">{{item.userName}}</p>
                                <h1 style="font-size: 30px;font-family: 新細明體-ExtB;margin-top: 5px;margin-left: 50px;display: inline-block;color: red">{{item.likecount}}.糖</h1>
                                <div style="width: 100px;height: 100px;right: 0px;bottom: 0px;position: absolute"><img src="../static/image/赞.png"></div>
                            </div>
                        </div>

                        <div style=" margin-top: 10px; width: 660px;height: auto" v-if="index != 0">

                            <div style="float: left;border: 1px solid #e8e6e6;margin-right: 15px;margin-top: 10px">
                                <div style=" height: 110px; width: 200px;background-color: white;">
                                    <img :src="item.img">
                                </div>
                                <div style=" height: 90px;width: 200px;background-color: white;">
                                    <a href="#" style="padding:5px;font-size: 14px;display:block"> {{item.name}}</a>
                                    <p style="padding:5px;font-size: 14px;"> {{item.tags.substr(0,14)}}...</p>
                                    <p style="padding:5px;font-size: 14px;display: inline-block"> {{item.userName}}</p>
                                    <p style="padding:5px;float: right; font-size: 14px;display: inline-block;color: red"> {{item.likecount}}.糖</p>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div id="body_div_left_bottom">
                    <p style="color: coral;font-size: 20px">本周最热</p>
                    <a href="#" style="float: right;margin-top: -20px">更多&gt&gt</a>
                    <hr style="border: 1px solid;color: coral;margin-top: 5px">
                    <div v-for="(item,index) in likefood" :key="index">
                        <div id="NOone1" v-if="index == 0">
                            <div id="image1">
                                <a href="#"> <img :src="item.img"></a>
                            </div>
                            <div id="writer1">
                                <p style="font-family:楷体;font-size: 25px;margin-top: 15px;margin-left: 5px">{{item.name}}</p>
                                <p style="font-family:楷体;font-size: 10px;margin-top: 15px;margin-left: 5px">{{item.tags}}</p>
                                <p style="font-size: 18px;font-family: 楷体;margin-top: 5px;margin-left: 35px;display: inline-block">{{item.userName}}</p>
                                <h1 style="font-size: 30px;font-family: 新細明體-ExtB;margin-top: 5px;margin-left: 50px;display: inline-block;color: red">{{item.likecount}}.糖</h1>
                                <div style="width: 100px;height: 100px;right: 0px;bottom: 0px;position: absolute"><img src="../static/image/赞.png"></div>
                            </div>
                        </div>

                        <div style=" margin-top: 10px; width: 660px;height: auto" v-if="index != 0">

                            <div style="float: left;border: 1px solid #e8e6e6;margin-right: 15px;margin-top: 10px">
                                <div style=" height: 110px; width: 200px;background-color: white;">
                                    <img :src="item.img">
                                </div>
                                <div style=" height: 90px;width: 200px;background-color: white;">
                                    <a href="#" style="padding:5px;font-size: 14px;display:block"> {{item.name}}</a>
                                    <p style="padding:5px;font-size: 14px;"> {{item.tags.substr(0,14)}}...</p>
                                    <p style="padding:5px;font-size: 14px;display: inline-block"> {{item.userName}}</p>
                                    <p style="padding:5px;float: right; font-size: 14px;display: inline-block;color: red"> {{item.likecount}}.糖</p>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

                <div id="body_div_left_bottom2">
                    <p style="color: coral;font-size: 20px">厨友排行</p>
                    <a href="#" style="float: right;margin-top: -20px">更多&gt&gt</a>
                    <hr style="border: 1px solid;color: coral;margin-top: 5px">

                    <div style=" margin-top: 10px; width: 660px;height: 200px">
                        <div style=" float: left; width: 50px;height: 50px;border-radius: 50%;background-color: #fbfbfb;margin: 20px;text-align: center;margin-bottom: 30px" v-for="(item,index) in userRank" :key="index">
                            <a href="#">
                                <img :src="item.userPhoto" style="width: 60px;height: 60px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"/>
                                <p style="width: 60px">{{item.userName.substr(0,3)}}</p>
                            </a>
                        </div>
                    </div>

                </div>

            </div>

            <div style="float: right;width: 280px;height:auto">
<!--                <div v-if="userName === '' || userName === null" id="body_div_right_top">-->
<!--                    <div style="padding-top: 10px;width: 250px;margin: 0 auto">-->
<!--                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">-->
<!--                    </div>-->
<!--                    <div style="padding-top: 5px;width: 200px;margin: 0 auto">-->
<!--                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">-->
<!--                    </div>-->
<!--                    <div style="margin-top: -20px;margin-left: 110px;width:60px;background-color:#ffffff;padding-left: 10px;font-size: 18px;color: darkgray">Login</div>-->
<!--                    <div>-->

<!--                        <form action="#" method="post">-->
<!--                            <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:25px;border-radius: 3px">-->
<!--                                <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/image/小人.png" /></div>-->

<!--                                <input type="text" placeholder="QQ/微信/微博/手机号/厨号" class="login" style="width: 160px;height: 40px;margin-left:1px;border: none;position: absolute" />-->
<!--                            </div>-->

<!--                            <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:25px;border-radius: 3px">-->
<!--                                <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/image/锁.png" /></div>-->

<!--                                <input type="password" placeholder="密码" class="login" style="width: 160px;height: 40px;margin-left:1px;border:none;position: absolute " />-->
<!--                            </div>-->
<!--                            <a href="#" style="float: left;font-size: 13px;margin-left: 25px;margin-top: 5px;margin-bottom: 15px">忘记密码</a>-->
<!--                            <a href="register.html" style="float: right;font-size: 13px;margin-right: 20px;margin-top: 5px;margin-bottom: 15px">免费注册</a>-->
<!--                            <div style="height: 40px;width: 230px;margin-top:20px;margin-left:24px;border-radius: 3px">-->

<!--                                <input type="submit" value="登录" style="width: 235px;height: 40px;border: none;background-color: coral;color: white;border-radius: 3px " />-->

<!--                            </div>-->
<!--                            <div style="margin-top: 30px;text-align: center">-->
<!--                                <div style="width: 280px"> 其他登录方式&gt;&gt;</div>-->
<!--                                <div style="width: 50px;height: 50px;margin-left: 45px;margin-top:20px;float:left;border-radius: 5px">-->
<!--                                    <a href="#"> <img src="../static/image/QQ.png"></a>-->
<!--                                </div>-->
<!--                                <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">-->
<!--                                    <a href="#"> <img src="../static/image/微信.png"></a>-->
<!--                                </div>-->
<!--                                <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">-->
<!--                                    <a href="#"> <img src="../static/image/微博.png"></a>-->
<!--                                </div>-->
<!--                            </div>-->
<!--                        </form>-->

<!--                    </div>-->
<!--                </div>-->

                <div id="body_div_right_center">
                    <div style="padding-top: 10px;width: 250px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="padding-top: 5px;width: 200px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="margin-top: -18px;margin-left: 110px;width:65px;background-color:#ffffff;padding-left: 5px;font-size: 15px;color: darkgray">用户在搜</div>
                    <table style="margin: 0 auto;margin-top: 10px;width: 240px;text-align: center;margin-bottom: 10px">
                        <tr>
                            <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">拌肉皮丝</a></td>
                            <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">春季养生汤</a></td>
                        </tr>

                    </table>

                </div>

                <div id="body_div_right_bottom">
                    <div style="padding-top: 10px;width: 250px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="padding-top: 5px;width: 200px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="margin-top: -18px;margin-left: 110px;width:65px;background-color:#ffffff;padding-left: 5px;font-size: 15px;color: darkgray">用户分类</div>
                    <table style="margin: 0 auto;margin-top: 10px;width: 240px;text-align: center;margin-bottom: 10px">
                        <tr>
                            <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">豆腐花生</a></td>
                            <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">麻婆豆腐</a></td>
                        </tr>

                    </table>

                </div>

                <div id="body_div_right_last">
                    <div style="padding-top: 10px;width: 250px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="padding-top: 5px;width: 200px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="margin-top: -18px;margin-left: 110px;width:65px;background-color:#ffffff;padding-left: 5px;font-size: 15px;color: darkgray">最佳厨友</div>
                    <div style="float: left; width:100px;height: 100px;margin: 20px;"> <img src="../static/image/第一名.png"></div>
                    <div style=" float: right; width: 60px;height:60px;border-radius: 50%;background-color: #fbfbfb;margin: 40px;text-align: center" >
                        <a href="#"><img :src="userRank[0].userPhoto" style="width: 60px;height: 60px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"/>
                            <p>{{userRank[0].userName}}</p>
                        </a></div>

                </div>
            </div>
        </div>

        <div style="float:left;width: 100%;height:30px; background-color: #acada8;position: relative;text-align: center">
            国际警督 18290514177
        </div>
    </div>
</template>

<script>

    export default {
        name: "index",
        data() {
            return{
                userName:'',
                userId:'',
                likefood:[
                    {
                        userId:'',
                        userName:'',
                        name:'',
                        tags:'',
                        img:'',
                        likecount:''
                    }
                ],
                lastfood:[
                    {
                        userId:'',
                        userName:'',
                        name:'',
                        tags:'',
                        img:'',
                        likecount:''
                    }
                ],
                userRank:[
                    {
                        userPhoto:'',
                        userName:''
                    }
                ]
            }
        },
        mounted:function () {
            this.init();
        },
        methods:{
            ToIndex(){
                this.$router.push({
                    path:'/index'
                })
            },
            // 初始化方法
            init() {
                let _this=this;
                _this.$request.get("/user/index")
                    .then(res => {
                        console.log(res)
                        if (res.data.code == '200' ) {
                            _this.userName = res.data.data.userName;
                            _this.userId = res.data.data.id;
                            _this.$store.commit('SET_USERINFO',res.data.data);
                        } else {
                            localStorage.removeItem('Authorization');
                            _this.$router.push('/login');
                        }
                    },
                    fail => {
                        localStorage.removeItem('Authorization');
                        _this.$router.push('/login');
                    });

                _this.$request.get('/foodList/getRank')
                .then(res =>{
                    _this.likefood = res.data.data;
                });

                _this.$request.get('/foodList/getLastRank')
                    .then(res =>{
                        _this.lastfood = res.data.data;
                });

                _this.$request.get('/userDetail/getUserRank')
                .then(res => {
                    _this.userRank = res.data.data;
                    _this.userRank.forEach(item => {
                        item.userPhoto = require('../static/image/'+item.userPhoto);
                    })
                })
            },
            // 退出
            loginout() {
                this.$store.commit("REMOVE_INFO");
                this.$router.push({path:'login'});
            }
        }
    }
</script>

<style >

</style>