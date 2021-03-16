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
                    <el-menu default-active="6"
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
                            <div id="FDJ"><img src="../static/image/搜索.png"/></div>
                            <input type="text" id="top_search_input_Text" placeholder="番茄炒鸡蛋"/>
                            <el-button type="primary"  style=" height: 34px;width: 70px;border: none;background: coral;
                                          margin-top: -1px;float: right;font-family: 隶书;border-top-left-radius: 0;border-bottom-left-radius: 0">搜索</el-button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
<!--        主体部分 -->
        <div style="padding-top: 60px;height: auto;width: 100%">
            <div style="width: 960px;height: 300px;margin: 0 auto">
<!--                <img :src="img" style="opacity:0.5;width: 960px;height: 300px;">-->
                敬请期待！！！
            </div>
<!--            <div class="block" style="margin: 10px auto;width: 960px;height: 50px">-->
<!--                <el-pagination-->
<!--                        @size-change="handleSizeChange"-->
<!--                        @current-change="handleCurrentChange"-->
<!--                        :current-page.sync="currentPage2"-->
<!--                        :page-sizes="[10,20,40]"-->
<!--                        :page-size="10"-->
<!--                        layout="sizes, prev, pager, next"-->
<!--                        :total="1000">-->
<!--                </el-pagination>-->


<!--            </div>-->



        </div>
    </div>
</template>

<script>
    export default {
        name: "health",
        data (){
            return {
                backgroudimage: require('../static/image/背景8.png'),
                userName:'',
                img:require('../static/image/health/太极卡通.jpg'),
                currentPage2: 1,
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init(){
                this.userName=this.$store.state.userInfo.userName;

            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                console.log(`当前页: ${val}`);
            }
        }
    }
</script>

<style scoped>

</style>