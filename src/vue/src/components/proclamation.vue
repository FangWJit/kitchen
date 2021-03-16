<template>
    <div>


        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>

        <div style="position: fixed;z-index: 9;width: 1520px;background-color:#ffffff;border-bottom: 1px #dcdfe6 solid ;height: 60px">
            <div id="top_logo">
                <img src="../static/image/厨阁.png" style="width: 50px;height:50px;float: left">
                <span style="font-size: 30px;">厨阁</span>
            </div>
            <div style="display: inline-block">
                <el-menu default-active="8"
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
                    <a @click="router($store.state.userInfo.id)" v-if="userName != null || userName != ''" href="">
                        <li style="font-size: 20px;color: coral">{{userName}}</li>
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
                        <div id="FDJ"><img src="../static/image/搜索.png" /></div>
                        <input type="text" id="top_search_input_Text" placeholder="番茄炒鸡蛋"/>
                        <el-button type="primary"  style=" height: 34px;width: 70px;border: none;background: coral;
                                          margin-top: -1px;float: right;font-family: 隶书;border-top-left-radius: 0;border-bottom-left-radius: 0">搜索</el-button>
                    </div>
                </form>
            </div>
        </div>
        <div style="padding-top: 50px;">
            <div style="width: 960px;margin: 10px auto">
                <el-carousel :interval="4000" type="card" height="300px">
                    <el-carousel-item v-for="item in imgs" :key="item">
                        <img :src="item">
                    </el-carousel-item>
                </el-carousel>
            </div>

            <div class="block" style="width: 980px;margin: 50px auto;background-color: rgba(255, 255, 255, 0.5);">
                <el-timeline>
                    <el-timeline-item style="margin-left: 10px" timestamp="2018/4/12" placement="top" >
                        <el-card>
                            <h4>发布新的版本2.0</h4>
                            <p>王小虎 提交于 2018/4/12 20:46</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item style="margin-left: 10px" timestamp="2018/4/3" placement="top">
                        <el-card>
                            <h4>更新了不能评论的错误</h4>
                            <p>王小虎 提交于 2018/4/3 20:46</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item style="margin-left: 10px" timestamp="2018/4/2" placement="top">
                        <el-card>
                            <h4>第一届网上厨神大赛将于2019年10月24日举办</h4>
                            <p>王小虎 提交于 2018/4/2 20:46</p>
                        </el-card>
                    </el-timeline-item>
                </el-timeline>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "proclamation",
        data() {
            return {
                backgroudimage: require('../static/image/背景8.png'),
                userName:'',
                imgs:[
                    require('../static/image/Charcoal Grill 木炭烧烤香肠.jpg'),
                    require('../static/image/东坡肉.jpg'),
                    require('../static/image/肉末茄子.jpg')
                ]
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init() {
                this.userName = this.$store.state.userInfo.userName;
            },
            // 退出
            loginout() {
                localStorage.removeItem('Authorization');
                sessionStorage.removeItem('userInfo');
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

<style>

</style>