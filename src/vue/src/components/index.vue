<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>

        <div id="body_div">
            <div style="width: 700px;height:100%;padding: 10px;float: left;margin-left: 140px">
                <div id="body_div_left_top">
                    <p style="color: coral;font-size: 20px">时令热搜</p>
                    <div id="body_div_left_top_down">
                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#ffffff;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">番茄炒鸡蛋</a></div>

                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#ffffff;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">油焖大虾</a></div>

                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#ffffff;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">鸡蛋羹</a></div>

                        <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#ffffff;float: left;border-radius: 3px;text-align: center;">
                            <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px">麻辣鱼</a></div>
                    </div>
                </div>

                <div id="body_div_left_center">
                    <p style="color: coral;font-size: 20px">最新食谱</p>
                    <a href="#" style="float: right;margin-top: 5px">更多&gt&gt</a>
                    <div v-for="(item,index) in lastfood" :key="index">
                        <div id="NOone" v-if="index == 0" @click="info(item.meauId)">
                            <div id="image">
                                <a href="#"> <img :src="item.img"></a>
                            </div>
                            <div id="writer">
                                <p style="font-family:楷体;font-size: 25px;margin-top: 15px;margin-left: 5px">{{item.name.substr(0,8)}}</p>
                                <p style="font-family:楷体;font-size: 10px;margin-top: 15px;margin-left: 5px">{{item.tags.substr(0,40)}}...</p>
                                <p style="font-size: 18px;font-family: 楷体;margin-top: 5px;margin-left: 35px;display: inline-block">{{item.userName}}</p>
                                <h1 style="font-size: 30px;font-family: 新細明體-ExtB;margin-top: 5px;margin-left: 50px;display: inline-block;color: red">{{item.likecount}}.糖</h1>
                                <div style="width: 100px;height: 100px;right: 0px;bottom: 0px;position: absolute"><img src="../static/img/赞.png"></div>
                            </div>
                        </div>

                        <div style=" margin-top: 10px; width: 660px;height: auto" v-if="index != 0" @click="info(item.meauId)">
                            <div style="float: left;border: 1px solid #e8e6e6;margin-right: 17px;margin-top: 10px;padding: 10px;background-color: white;">
                                <div style=" height: 90px; width: 180px;background-color: white;">
                                    <img :src="item.img">
                                </div>
                                <div style=" height: 70px;width: 180px;background-color: white;">
                                    <a href="#" style="padding:5px;font-size: 14px;display:block"> {{item.name.substr(0,10)}}</a>
                                    <p style="padding:5px;font-size: 14px;display:block"> {{item.tags.substr(0,10)}}...</p>
                                    <p style="padding:5px;font-size: 14px;display: inline-block"> {{item.userName}}</p>
                                    <p style="padding:5px;float: right; font-size: 14px;display: inline-block;color: red"> {{item.likecount}}.糖</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="body_div_left_bottom">
                    <p style="color: coral;font-size: 20px">本周最热</p>
                    <a href="#" style="float: right;margin-top: 5px">更多&gt&gt</a>
                    <div v-for="(item,index) in likefood" :key="index">
                        <div id="NOone1" v-if="index == 0" @click="info(item.meauId)">
                            <div id="image1">
                                <a href="#"> <img :src="item.img"></a>
                            </div>
                            <div id="writer1">
                                <p style="font-family:楷体;font-size: 25px;margin-top: 15px;margin-left: 5px">{{item.name.substr(0,8)}}</p>
                                <p style="font-family:楷体;font-size: 10px;margin-top: 15px;margin-left: 5px">{{item.tags.substr(0,40)}}...</p>
                                <p style="font-size: 18px;font-family: 楷体;margin-top: 5px;margin-left: 35px;display: inline-block">{{item.userName}}</p>
                                <h1 style="font-size: 30px;font-family: 新細明體-ExtB;margin-top: 5px;margin-left: 50px;display: inline-block;color: red">{{item.likecount}}.糖</h1>
                                <div style="width: 100px;height: 100px;right: 0px;bottom: 0px;position: absolute"><img src="../static/img/赞.png"></div>
                            </div>
                        </div>

                        <div style=" margin-top: 10px; width: 660px;height: auto" v-if="index != 0" @click="info(item.meauId)">
                            <div style="float: left;border: 1px solid #e8e6e6;margin-right: 17px;margin-top: 10px;padding: 10px;background-color: white;">
                                <div style=" height: 90px; width: 180px;background-color: white">
                                    <img :src="item.img">
                                </div>
                                <div style=" height: 70px;width: 180px;background-color: white">
                                    <a href="#" style="padding:5px;font-size: 14px;display:block"> {{item.name.substr(0,10)}}</a>
                                    <p style="padding:5px;font-size: 14px;display: block"> {{item.tags.substr(0,10)}}...</p>
                                    <p style="padding:5px;font-size: 14px;display: inline-block"> {{item.userName}}</p>
                                    <p style="padding:5px;float: right; font-size: 14px;display: inline-block;color: red"> {{item.likecount}}.糖</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div id="body_div_left_bottom2">
                    <p style="color: coral;font-size: 20px">厨友排行</p>
                    <a href="#" style="float: right;margin-top: 5px">更多&gt&gt</a>

                    <div style=" margin-top: 10px; width: 660px;height: 200px">
                        <div style=" float: left; width: 70px;height: 70px;margin: 10px;text-align: center" v-for="(item,index) in userRank" :key="index">
                            <a href="#" @click="router(item.id)">
                                <img :src="item.userPhoto" style="width: 40px;height: 40px;border-radius: 50%;margin: 0 auto;"/>
                                <p style="width: 60px;font-size: 8px">{{item.userName.substr(0,3)}}</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

                <!--            登录验证-->
                <div style="float: right;width: 280px;height:auto;margin-right: 140px">
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
                                    <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/img/小人.png" /></div>
                                    <input type="text" placeholder="QQ/微信/微博/手机号/厨号" class="login" style="width: 160px;height: 40px;margin-left:1px;border: none" />
                                </div>

                                <div style="height: 40px;width: 230px;margin-top:20px;border: 1px solid #d6d3d1;margin-left:25px;border-radius: 3px;opacity: 0.5">
                                    <div style="height: 40px;width: 40px;float: left;position: relative"> <img src="../static/img/锁.png" /></div>
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
                                    <a href="#"> <img src="../static/img/QQ.png"></a>
                                </div>
                                <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                    <a href="#"> <img src="../static/img/微信.png"></a>
                                </div>
                                <div style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                    <a href="#"> <img src="../static/img/微博.png"></a>
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
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">番茄炒鸡蛋</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">虎皮贵庚</a></td>
                            </tr>
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">柴火鸡</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">八仙过海</a></td>
                            </tr>
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">鱼香肉丝</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">麻辣鳝段</a></td>
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
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">热菜</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">凉菜</a></td>
                            </tr>
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">主食</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">小吃</a></td>
                            </tr>
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">汤羹</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">烘焙</a></td>
                            </tr>
                            <tr>
                                <td style="width:120px;height: 40px;border-right: 1px solid #e8e6e6;border-bottom: 1px solid #e8e6e6;"><a href="#">饮品</a></td>
                                <td style="width:120px;height: 40px;border-bottom: 1px solid #e8e6e6;"><a href="#">家常菜</a></td>
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
                        <div style="float: left; width:100px;height: 100px;margin: 20px;"> <img src="../static/img/第一名.png"></div>
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
                selectId: '', // 选择头像的序列id
                lookPhoto: '',
                outerVisible: false,
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                userId:'',
                userPhoto: '',
                searchValue:'',
                likefood:[
                    {
                        meauId:'',
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
                        meauId:'',
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
                        userName:'',
                        id:''
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
                    .then(res => {
                            if (res.data.code == '200') {
                                _this.likefood = res.data.data;
                            } else {
                                localStorage.removeItem('Authorization');
                                _this.$router.push({path: 'login'});
                            }
                        },
                        fail => {
                            localStorage.removeItem('Authorization');
                            _this.$router.push({path: 'login'});
                        });
                //   食品最新排行
                _this.$request.get('/foodList/getLastRank')
                    .then(res => {
                            if (res.data.code == '200') {
                                _this.lastfood = res.data.data;
                            } else {
                                localStorage.removeItem('Authorization');
                                _this.$router.push({path: 'login'});
                            }
                        },
                        fail => {
                            localStorage.removeItem('Authorization');
                            _this.$router.push({path: 'login'});
                        });
                //   用户排行
                _this.$request.get('/userDetail/getUserRank')
                    .then(res => {
                            if (res.data.code == '200') {
                                _this.userRank = res.data.data;
                            } else {
                                localStorage.removeItem('Authorization');
                                _this.$router.push({path: 'login'});
                            }
                        },
                        fail => {
                            localStorage.removeItem('Authorization');
                            _this.$router.push({path: 'login'});
                        });
                // 获取用户信息
                if (this.$store.state.userInfo === null ) {
                    //  获取  用户的详细信息
                    _this.$request.get("/user/index")
                        .then(res => {
                                if (res.data.code == '200' ) {
                                    _this.$store.commit('SET_USERINFO',res.data.data);
                                    _this.userId = res.data.data.id;
                                    _this.userName = res.data.data.userName;
                                    _this.userPhoto = res.data.data.userPhoto;
                                    _this.selectId = res.data.data.userPhoto.substr(46,1);
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
                    this.userId = this.$store.state.userInfo.id;
                    this.userName = this.$store.state.userInfo.userName;
                    this.userPhoto = this.$store.state.userInfo.userPhoto;
                    this.selectId = this.$store.state.userInfo.userPhoto.substr(46,1);
                }
            },
            // 带参 跳转 到 用户详情页
            router(userId){
                let url = this.$router.resolve({path:'/detail',query:{userId}});
                window.open(url.href,'_blank');
            },
            info(meauId) {
                let url = this.$router.resolve({path:'/foodDetails',query:{meauId}});
                window.open(url.href,'_blank');
            },
            handleCommand(command){
                if (command === 'a'){
                    // 修改头像
                    this.lookPhoto = this.userPhoto;
                    this.outerVisible = true;
                }else if (command === 'b') {

                } else if (command === 'd') {
                    // 退出
                    this.$store.commit("REMOVE_INFO");
                    this.$router.push({path:'login'});
                } else {
                    // 查看个人详情
                    this.router(this.$store.state.userInfo.id);
                }

            },
            // 搜索
            toSearch() {
                const values = this.searchValue;
                this.$router.push({path:'/search',query:{values}});
            },
            // 选择头像
            select(id) {
                this.selectId = id;
                this.lookPhoto = 'http://39.99.240.33:8045/kitchen/static/image/'+id+'.png';
            },
            send() {
                let url = 'http://39.99.240.33:8045/kitchen/static/image/'+this.selectId+'.png';
                let _this = this;
                _this.$request.get('/userDetail/setPhoto?photo='+url+'&id='+_this.userId)
                .then(res => {
                    if (res.data.code === '200') {
                        _this.userPhoto = url;
                        _this.outerVisible = false;
                        _this.$store.state.userInfo.userPhoto = url;
                        window.sessionStorage.setItem('userInfo',JSON.stringify(_this.$store.state.userInfo));
                        //   更新用户排行
                        _this.$request.get('/userDetail/getUserRank')
                            .then(res => {
                                _this.userRank = res.data.data;
                            });
                    } else {
                        _this.$message.error(res.data.message);
                    }
                })
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