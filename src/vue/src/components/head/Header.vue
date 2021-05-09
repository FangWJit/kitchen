<template>
    <div style="position: fixed;z-index: 9;width:100%;background-color:#ffffff;height: 60px">
        <div style="width: 1410px;margin: 0 auto;">
            <div id="top_logo">
                <img src="../../static/img/厨阁.png" style="width: 50px;height:50px;float: left">
                <span style="font-size: 30px;overflow: hidden;margin-left: 10px">厨阁</span>
            </div>
            <div style="display: inline-block;position: relative">
                <el-menu
                         :default-active="active"
                         class="el-menu-demo"
                         mode="horizontal"
                         active-text-color="coral">
                    <el-menu-item index="1" @click="$router.push({path:'/index'}),$store.commit('SET_PAGE','1')" >
                        <span>首页</span>
                    </el-menu-item>
                    <el-menu-item index="2" @click="$router.push({path:'/food_assort'}),$store.commit('SET_PAGE','2')">
                        <span >食谱分类</span>
                    </el-menu-item>
                    <el-menu-item index="3" @click="$router.push({path:'/health'}),$store.commit('SET_PAGE','3')">
                        <span >养身之道</span>
                    </el-menu-item>
                    <el-menu-item index="4" @click="$router.push({path:'/food_question'}),$store.commit('SET_PAGE','4')" >
                        <span >美食问答</span>
                    </el-menu-item>
                    <el-menu-item index="5" @click="$router.push({path:'/foodlist'}),$store.commit('SET_PAGE','5')">
                        <span>菜谱大全</span>
                    </el-menu-item>
                    <el-menu-item index="6" @click="$router.push({path:'/foodlist2'}),$store.commit('SET_PAGE','6')">
                        <span >家常菜谱</span>
                    </el-menu-item>
                    <el-menu-item index="7" @click="$router.push({path:'/user_assort'}),$store.commit('SET_PAGE','7')">
                        <span >厨友排行</span>
                    </el-menu-item>
                    <el-menu-item index="8" @click="$router.push({path:'/proclamation'}),$store.commit('SET_PAGE','8')">
                        <span >公告</span>
                    </el-menu-item>
                </el-menu>
            </div>
            <div id="top_list">
                <div style="margin-left: 35px; width: 85px; height: 21px; display: inline-block;float: left;margin-top: 25px">
                    <div class="upload">
                        <i class="el-icon-upload"/>发表
                        <ul>
                            <li >发表视频</li>
                            <li @click="goto('/UploadWord')">发表文章</li>
                            <li>发表菜谱</li>
                        </ul>
                    </div>
                </div>
                <div style="width: 85px; height: 21px; display: inline-block;float: left;margin-top: 25px">
                    <a @click="$router.push({path:'/food_question'})" >
                        <i class="el-icon-question"/>提问
                    </a>
                </div>
                <div style="width: 30px;height: 30px;display: inline-block;margin-top: 13px">
                    <el-dropdown size="medium" @command="handleCommand" >
                        <img class="img_photo" :src="userPhoto"/>
                        <el-dropdown-menu slot="dropdown" style="text-align: center;">
                            <el-dropdown-item disabled style="display: block;font-size: 18px;color: coral">{{userName.substr(0.3)}}</el-dropdown-item>
                            <el-dropdown-item command="a" divided style="display: block">修改头像</el-dropdown-item>
                            <el-dropdown-item command="b" disabled style="display: block">修改密码</el-dropdown-item>
                            <el-dropdown-item command="c" style="display: block">个人中心</el-dropdown-item>
                            <el-dropdown-item command="d" style="display: block">退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </div>

            <!--                弹框 -->
            <el-dialog title="修改头像" style="width:630px;margin: 10px auto" :visible.sync="outerVisible" :modal-append-to-body="false" :center="true" :close-on-click-modal="false" :show-close="false">

                <el-avatar class="look_photo" :size="120" fit="fit" :src="lookPhoto"></el-avatar>

                <div v-for="i in 10" @click="select(i)" style="display: inline-block">
                    <el-avatar class="select_photo" :size="60" fit="fit" :src="'http://39.99.240.33:8045/kitchen/static/image/'+i+'.png'" ></el-avatar>
                </div>

                <div slot="footer" class="dialog-footer">
                    <el-button @click="outerVisible = false;lookPhoto = userPhoto">取消</el-button>
                    <el-button type="primary" @click="send">确认</el-button>
                </div>
            </el-dialog>

            <div id="top_search">
                <form>
                    <div id="top_search_input">
                        <div id="FDJ"><img src="../../static/img/搜索.png"/></div>
                        <input v-model="searchValue" type="text" id="top_search_input_Text" placeholder="番茄炒鸡蛋"/>
                        <el-button type="primary"  style=" height: 34px;width: 70px;border: none;background: coral;
                                         margin-top: -1px;float: right;font-family: 隶书;border-top-left-radius: 0;border-bottom-left-radius: 0" @click="toSearch" >搜索</el-button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data() {
            return{
                selectId: '', // 选择头像的序列id
                lookPhoto: '',
                outerVisible: false,
                userName:'',
                userId:'',
                userPhoto: '',
                searchValue:'',
                active:localStorage.getItem("pageIndex")
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init() {
                let _this = this;
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
            },
            goto(url) {
                console.log(url)
                let u = this.$router.resolve(url);
                window.open(u.href,'_blank');
            }
        }
    }
</script>

<style scoped>
    .upload:hover {
        color: coral;
    }
    .upload ul {
        margin-top: 18px;
        background-color: white;
        padding: 5px 10px 5px 0;
        border-radius: 4px;
        display: none;
    }
    .upload li{
        width: 100%;
        height: 26px;
        font-size: 14px;
        list-style-type: none;
        text-align: center;
        line-height: 26px;
        color: black;
        margin: 5px;
    }
    .upload:hover ul {
        display: block;
    }
    .upload li:hover{
        background-color: #d4e4fa;
        color: #409eff;
        /*transition: all .3s ease-in-out;*/
    }

</style>