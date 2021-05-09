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
                <el-menu default-active="2"
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
        <!--主体部分-->
        <div id="food_list" >
            <div style=" margin-top: 10px; width: 970px;height: auto">

                <div style="margin: 20px 10px 0 10px;width:220px;height:200px;display: inline-block " v-for="(item,index) in foodList" :key="index">
                    <el-card shadow="hover" :body-style="{ padding: '10px' }" >
                    <div style=" height: 110px; width: 200px;background-color: white;">
                        <img :src="item.img">
                    </div>
                    <div style=" height: 90px;width: 200px;background-color: white;">
                        <a href="" class="a" style="padding:5px;font-size: 14px;display:block;color: lightskyblue" @click="info(item.meauId)"> {{item.name.substr(0,13)}}</a>
                        <p style="padding:5px;font-size: 14px;display: block"> {{item.tags.substr(0,14)}}...</p>
                        <p style="padding:5px;font-size: 14px"> {{item.userName}}</p>
                        <p style="padding:5px;float: right; font-size: 14px;color: red"> {{item.likecount}}.糖</p>
                    </div>
                    </el-card>
                </div>
                <div class="block">
                    <el-pagination
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page.sync="currentPage"
                            :page-size="pageSize"
                            layout=" prev, pager, next,total"
                            :total="count">
                    </el-pagination>
                </div>
            </div>
        </div>

        <div style="float:left;height: 20px;width: 100%"></div>
        <div style="float:left;width: 100%;height:30px; background-color: #acada8;position: relative;text-align: center">
            国际警督  18290514177
        </div>
    </div>
</template>

<script>
    export default {
        name: "foodlist",
        data(){
            return{
                backgroudimage: require('../static/image/背景8.png'),
                userName:'',
                currentPage:this.$store.state.currentPage,
                count:0,
                pageSize:20,
                foodList:[
                    {
                        meauId:'',
                        userId:'',
                        userName:'',
                        name:'',
                        tags:'',
                        img:'',
                        likecount:''
                    }
                ]
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init(){
                this.userName=this.$store.state.userInfo.userName;
                console.log("其他"+this.$store.state.currentPage);
                this.currentPage = this.$store.state.currentPage;
                let _this = this;
                _this.$request.get('/foodList/getCount')
                    .then(res => {
                        _this.count = res.data.data;
                        // _this.$store.commit('SET_FOODLIST',res.data.data);
                    });
                this.getList(this.currentPage);
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
            handleSizeChange(val) {
                console.log("当前页大小"+val);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.$store.commit("SET_CURRENTPAGR",val);
                console.log(this.$store.state.currentPage);
                this.getList(this.currentPage);
            },
            getList(data){
                let _this = this;
                _this.$request.get('/foodList/getList/'+data)
                    .then(res => {
                        _this.foodList = res.data.data;
                        // _this.$store.commit('SET_FOODLIST',res.data.data);
                    });
            }

        }
    }
</script>

<style scoped>
    @import "../static/css/css_foodlist.css";

    .block {
        text-align: left;
        margin: 20px;
    }
</style>