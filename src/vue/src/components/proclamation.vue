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
                        <a @click="$router.push({path:'/food_question'})" href="" >
                            <li>提问</li>
                        </a>
                        <a @click="$router.push({path:'/detail',query:{userId:$store.state.userInfo.id}})" v-if="userName != null || userName != ''" href="">
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
                        <a class="Navigation" @click="$router.push({path:'/index'})" href="">
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
                        <a class="Navigation" @click="$router.push({path:'/proclamation'})" href="" style="
                        background-color: aliceblue;color: coral;">
                            <li class="na_li">公告</li>
                        </a>
                    </ul>

                </div>
            </div>
        </div>

        <div style="width: 960px;margin: 10px auto">
            <el-carousel :interval="4000" type="card" height="300px">
                <el-carousel-item v-for="item in imgs" :key="item">
                    <img :src="item">
                </el-carousel-item>
            </el-carousel>
        </div>

        <div class="block" style="width: 960px;margin: 50px auto;">
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
</template>

<script>
    export default {
        name: "proclamation",
        data() {
            return {
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
            }
        }
    }
</script>

<style>

</style>