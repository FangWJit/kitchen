<template>
    <div>

        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>

        <div >
            <div style="position: fixed;z-index: 9;width: 1520px;background-color:#ffffff;border-bottom: 1px #dcdfe6 solid ;height: 60px">
                <div id="top_logo">
                    <img src="../static/image/厨阁.png" style="width: 50px;height:50px;float: left">
                    <span style="font-size: 30px;">厨阁</span>
                </div>
                <div style="display: inline-block;position: relative">
                    <el-menu default-active="1"
                             class="el-menu-demo"
                             mode="horizontal"
                             active-text-color="coral">
                        <el-menu-item index="1" @click="$router.push({path:'/index'})" >
                            <span>首页</span>
                        </el-menu-item>
                        <el-menu-item index="2" @click="$router.push({path:'/foodlist'})">
                            <span>菜谱大全</span>
                        </el-menu-item>
                        <el-menu-item index="3" @click="$router.push({path:'/foodlist2'})">
                            <span >家常菜谱</span>
                        </el-menu-item>
                        <el-menu-item index="4" @click="$router.push({path:'/food_question'})" >
                            <span >美食问答</span>
                        </el-menu-item>
                        <el-menu-item index="5" @click="$router.push({path:'/food_assort'})">
                            <span >食谱分类</span>
                        </el-menu-item>
                        <el-menu-item index="6" @click="$router.push({path:'/health'})">
                            <span >养身之道</span>
                        </el-menu-item>
                        <el-menu-item index="7" @click="$router.push({path:'/user_assort'})">
                            <span >厨友排行</span>
                        </el-menu-item>
                        <el-menu-item index="8" @click="$router.push({path:'/proclamation'})">
                            <span >公告</span>
                        </el-menu-item>
                    </el-menu>
                </div>
                <div id="top_list">
                    <ul>
                        <a href="#">
                            <li>上传</li>
                        </a>
                        <a @click="$router.push({path:'/food_question'})" href="">
                            <li>提问</li>
                        </a>
                        <a @click="router($store.state.userInfo.id)" v-if="userName != null || userName != '' " href="">
                            <li style="font-size: 20px;color: coral" >{{userName}}</li>
                        </a>
                        <a href="" v-if="userName === null || userName === '' ">
                            <li style="margin-left: -15px">登录</li>
                        </a>
                        <a href="" @click="loginout()">
                            <li>退出</li>
                        </a>
                    </ul>
                </div>
                <div id="top_search">
                    <form>
                        <div id="top_search_input">
                            <div id="FDJ"><img src="../static/image/搜索.png"/></div>
                            <input type="text" id="top_search_input_Text" placeholder="番茄炒鸡蛋"/>
                            <el-button type="primary"  style=" height: 34px;width: 70px;border: none;background: coral;
                                          margin-top: -1px;float: right;font-family: 隶书;border-top-left-radius: 0;border-bottom-left-radius: 0">搜索</el-button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="fixed">
            <div id="top">


            </div>
        </div>
        <div id="body_div">
            <div style="float: left;width: 660px">
                <div id="body_div_left_top">
                    <p style="color: coral;font-size: 20px">时令热搜</p>
                    <div id="body_div_left_top_down">
                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">番茄炒鸡蛋</a></div>
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


<!--            登录验证-->
            <div style="float: right;width: 280px;height:auto">
                <div v-if="userName === '' || userName === null" id="body_div_right_top">
                    <div style="padding-top: 10px;width: 250px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="padding-top: 5px;width: 200px;margin: 0 auto">
                        <hr style="border: 1.2px solid;color: gainsboro;margin-top: 5px">
                    </div>
                    <div style="margin-top: -20px;margin-left: 110px;width:60px;background-color:#ffffff;padding-left: 10px;font-size: 18px;color: darkgray">Login</div>
                    <div>
                        <form action="#" method="post">
                            <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:25px;border-radius: 3px;opacity: 0.5">
                                <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/image/小人.png" /></div>
                                <input type="text" placeholder="QQ/微信/微博/手机号/厨号" class="login" style="width: 160px;height: 40px;margin-left:1px;border: none" />
                            </div>

                            <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:25px;border-radius: 3px;opacity: 0.5">
                                <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/image/锁.png" /></div>
                                <input type="password" placeholder="密码" class="login" style="width: 160px;height: 40px;margin-left:1px;border:none" />
                            </div>
                        </form>
                        <a href="#" style="float: left;font-size: 13px;margin-left: 25px;margin-top: 5px;margin-bottom: 15px;opacity: 0.5">忘记密码</a>
                        <a href="register.html" style="float: right;font-size: 13px;margin-right: 20px;margin-top: 5px;margin-bottom: 15px;opacity: 0.5">免费注册</a>
                        <button @click="$router.push({path: 'login'})" style="outline: none;margin-left: 20px;width: 235px;height: 40px;border: 1px solid white;background-color: coral;color: white;border-radius: 3px ">
                           去登录
                        </button>
                        <div style="margin-top: 30px;text-align: center;opacity: 0.5">
                            <div style="width: 280px"> 其他登录方式&gt;&gt;</div>
                            <div style="width: 50px;height: 50px;margin-left: 45px;margin-top:20px;float:left;border-radius: 5px">
                                <a href="#"> <img src="../static/image/QQ.png"></a>
                            </div>
                            <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                <a href="#"> <img src="../static/image/微信.png"></a>
                            </div>
                            <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                <a href="#"> <img src="../static/image/微博.png"></a>
                            </div>
                        </div>
                    </div>
                </div>
<!--    用户在搜  -->
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
<!--   用户分类-->
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

<!--                最佳厨友-->
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
                backgroudimage: require('../static/image/背景8.png'),
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
                //  食品最热排行
                _this.$request.get('/foodList/getRank')
                    .then(res =>{
                        _this.likefood = res.data.data;
                    });
                //   食品最新排行
                _this.$request.get('/foodList/getLastRank')
                    .then(res =>{
                        _this.lastfood = res.data.data;
                    });
                //   用户排行
                _this.$request.get('/userDetail/getUserRank')
                    .then(res => {
                        _this.userRank = res.data.data;
                        _this.userRank.forEach(item => {
                            item.userPhoto = require('../static/image/'+item.userPhoto);
                        })
                    });

                // 获取用户信息
                if (this.$store.state.userInfo.userId === null || this.$store.state.userInfo.userName === null) {
                    //  获取  用户的详细信息
                    _this.$request.get("/user/index")
                        .then(res => {
                                console.log(res)
                                if (res.data.code == '200' ) {
                                    _this.$store.commit('SET_USERINFO',res.data.data);
                                    _this.userId = res.data.data.userId;
                                    _this.userName = res.data.data.userName;
                                } else {
                                    localStorage.removeItem('Authorization');
                                    _this.$router.push({path: 'login'});
                                }
                            },
                            fail => {
                                localStorage.removeItem('Authorization');
                                _this.$router.push({path: 'login'});
                            });
                }else {
                    this.userId = this.$store.state.userInfo.userId;
                    this.userName = this.$store.state.userInfo.userName;
                }
            },
            // 退出
            loginout() {
                this.$store.commit("REMOVE_INFO");
                this.$router.push({path:'login'});
            },
            // 带参 跳转 到 用户详情页
            router(userId){
                let url = this.$router.resolve({path:'/detail',query:{userId}});
                window.open(url.href,'_blank');
            }
        }
    }
</script>

<style >

    .background{
        width:100%;
        /*height:100%;  !**宽高100%是为了图片铺满屏幕 *!*/
        z-index:-1;
        position: fixed;
        opacity:0.9;
    }

</style>