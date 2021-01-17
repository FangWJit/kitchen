<template>
    <div>
        <div id="top">
            <div id="top_logo">
                <img src="../static/image/厨阁.png" style="width: 50px;height:50px;float: left">
                <span style="font-size: 30px;">厨阁</span>
            </div>
            <div id="top_search">
                <form>
                    <div id="top_search_input">
                        <div id="FDJ"><img src="../static/image/搜索.png" /></div>
                        <input type="text" id="top_search_input_Text" />
                        <button style="margin-left:13px;height: 42px;width: 80px;position:absolute;border:0
            ;background: coral;margin-top: -1px;border-radius: 3px;float: right;
            font-family: 隶书;font-size: 20px" >搜索</button></div>
                </form>
            </div>
            <div id="top_list">
                <ul>
                    <a href="#"><li>上传</li></a>
                    <a href="#"><li>提问</li></a>
                    <a href="" @click="$router.push({path:'login'})"> <li>登录</li></a>
                    <a href=""><li>注册</li></a>
                </ul>
            </div>

        </div>
        <!--导航栏-->
        <div id="Navigation">
            <div id="Navigation_body">
                <ul>
                    <a class="Navigation" @click="$router.push({path:'/index'})" href=""><li class="na_li"> 首页</li></a>
                    <a class="Navigation" @click="$router.push({path:'/foodlist'})"  href="" style=" background-color: aliceblue;color: coral;"><li class="na_li">菜谱大全</li></a>
                    <a class="Navigation" @click="$router.push({path:'/foodlist2'})"  href=""><li class="na_li">家常菜谱</li></a>
                    <a class="Navigation" @click="$router.push({path:'/food_question'})"  href=""><li class="na_li">美食问答</li></a>
                    <a class="Navigation"  href=""><li class="na_li">食谱分类</li></a>
                    <a class="Navigation"  href=""><li class="na_li">健康食疗</li></a>
                    <a class="Navigation"  href=""><li class="na_li">厨友排行</li></a>
                    <a class="Navigation" @click="$router.push({path:'/proclamation'})"  href=""><li class="na_li">公告</li></a>
                </ul>

            </div>
        </div>
        <!--主体部分-->
        <div id="food_list" >
            <div style=" margin-top: 10px; width: 970px;height: auto">

                <div style="float: left;border: 1px solid #e8e6e6;margin-right: 15px;margin-top: 20px"  v-for="(item,index) in foodList" :key="index">
                    <el-card shadow="hover" :body-style="{ padding: '0px' }">
                    <div style=" height: 110px; width: 200px;background-color: white;">
                        <img :src="item.img">
                    </div>
                    <div style=" height: 90px;width: 200px;background-color: white;">
                        <a href="#" style="padding:5px;font-size: 14px;display:block;color: lightskyblue"> {{item.name.substr(0,13)}}</a>
                        <p style="padding:5px;font-size: 14px;"> {{item.tags.substr(0,14)}}...</p>
                        <p style="padding:5px;font-size: 14px;display: inline-block"> {{item.userName}}</p>
                        <p style="padding:5px;float: right; font-size: 14px;display: inline-block;color: red"> {{item.likecount}}.糖</p>
                    </div>
                    </el-card>
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
                foodList:[
                    {
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
                let _this = this;
                if (this.$store.state.foodList == null ) {
                    _this.$request.get('/foodList/getList')
                        .then(res => {
                            _this.foodList = res.data.data;
                            _this.$store.commit('SET_FOODLIST',res.data.data);
                        });
                } else {
                    this.foodList = this.$store.state.foodList;
                    console.log(this.foodList);
                }
            }
        }
    }
</script>

<style scoped>
    @import "../static/css/css_foodlist.css";
</style>