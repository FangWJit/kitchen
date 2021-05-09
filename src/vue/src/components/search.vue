<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <div style="width: 1410px;margin: 0px auto;">
            <div  style="padding-top:100px;padding-bottom:80px;position: relative;width: 960px;margin: 0px auto;">
                <el-collapse v-model="activeName" style="padding:0 10px;background-color:white;border-radius: 4px" >
                    <el-collapse-item title="相关用户" name="1" :disabled="true">
                        <div v-if="user.userphone === '' ">
                            <el-card style="margin: 10px" >
                                未搜索到相关的用户,请检查搜索的电话格式是否正确。
                            </el-card>
                        </div>
                        <div v-else>
                            <el-card style="margin: 10px" >
                                <div slot="header" style="margin:-10px 0" @click="router(user.userId)">
                                    <img :src="user.userphoto" style="width: 25px;height: 25px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"></img>
                                    <span style="font-size: 13px">{{user.username}}</span>
                                </div>
                                <div style="margin-top: -10px;margin-bottom: -10px;font-size:13px">
                                    粉丝:{{user.fans}},性别:{{user.sex}}
                                </div>
                            </el-card>
                        </div>
                    </el-collapse-item>
                    <el-collapse-item title="相关菜谱" name="2" :disabled="true">
                        <div v-if="foodList[0].meauId === '' ">
                            <el-card style="margin: 10px" >
                                未搜索到相关的菜谱,请重新搜索关键字。
                            </el-card>
                        </div>
                        <div v-else>
                            <el-card style="margin: 10px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)" v-for="(item,index) in foodList" :key="index" v-show="index < maxnumber ">
                                <div style="margin:-10px 0" @click="info(item.meauId)">
                                    <img :src="item.img" style="width: 80px;height: 80px;margin-right: 10px;margin-bottom: -4px;"></img>
                                    <p style="color: red">{{item.likecount}}糖</p>
                                    <h2 style="font-size: 18px;display: block">{{item.name}}</h2>
                                    <p style="font-size: 13px;display: block">{{item.tags}}</p>
                                </div>
                            </el-card>
                            <div style="width:900px;line-height: 10px" >
                                <p class="more" @click="maxnumber += 10" v-show="maxnumber < foodList.length" style="margin: 5px;text-align: center;font-size: 10px;width: 900px">显示更多...
                                    <i class="el-icon-arrow-down" style="display: block;margin: 5px;"></i>
                                </p>
                            </div>
                            <div style="width:900px;line-height: 10px" >
                                <p class="more" @click="maxnumber = 10" v-show="maxnumber >= foodList.length" style="margin: 10px;text-align: center;font-size: 10px;width: 900px">
                                    <i class="el-icon-arrow-up" style="display: block;margin: 5px;"></i>
                                    收起更多...
                                </p>
                            </div>
                        </div>
                    </el-collapse-item>
                </el-collapse>
            </div>
        </div>

    </div>
</template>

<script>
    export default {
        name: "search",
        data() {
            return {
                selectId: this.$store.state.userInfo.userPhoto.substr(46,1), // 选择头像的序列id
                lookPhoto: '',
                outerVisible: false,
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                userId:'',
                userPhoto: this.$store.state.userInfo.userPhoto,
                searchValue: '',
                maxnumber:10,
                user:{
                    userId:'',
                    username:'',
                    userphone:'',
                    userphoto:'',
                    userage:0,
                    fans:0,
                    noricer:0,
                    notesnum:0,
                    tucknum:0,
                    sex:''
                },
                activeName:['1','2'],
                foodList:[
                    {
                        meauId:'',
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
        created() {
            this.searchValue = this.$route.query.values;
        },
        methods:{
            init() {
                let _this = this;
                // 匹配 电话
                let phoneRe =
                    /^0?(13[0-9]|14[579]|15[012356789]|16[6]|17[013678]|18[0-9]|19[89]|14[57])[0-9]{8}$/;
                if (phoneRe.test(_this.searchValue) && _this.searchValue != "") {
                    _this.$request.get('/search/selectUser?value='+this.searchValue)
                        .then( res => {
                            if (res.data.code === '200') {
                                let userInfo = res.data.data;
                                _this.user.userId = userInfo.id;
                                _this.user.username = userInfo.userName;
                                _this.user.userage = userInfo.age;
                                _this.user.userphone = userInfo.userPhone;
                                _this.user.userphoto = userInfo.userPhoto;
                                _this.user.fans = userInfo.fans;
                                _this.user.noricer = userInfo.noricer;
                                _this.user.tucknum = userInfo.tuckNum;
                                _this.user.notesnum = userInfo.notesNum ;
                                _this.user.sex = userInfo.sex;

                                _this.foodList = [
                                    {
                                        meauId:'',
                                        name:'',
                                        tags:'',
                                        img:'',
                                        likecount:''
                                    }
                                ]
                            } else {
                                _this.$message.error("搜索用户失败")
                            }
                        });
                } else {
                    _this.$request.get('/search/selectFood?value='+this.searchValue)
                    .then( res => {
                        if (res.data.code === '200') {
                            _this.foodList = res.data.data;
                            _this.user = {
                                userId:'',
                                    username:'',
                                    userphone:'',
                                    userphoto:'',
                                    userage:0,
                                    fans:0,
                                    noricer:0,
                                    notesnum:0,
                                    tucknum:0,
                                    sex:''
                            };
                        }
                    })
                }
                _this.searchValue = '';

                // 获取用户信息
                if (this.$store.state.userInfo === null ) {
                    //  获取  用户的详细信息
                    _this.$request.get("/user/index")
                        .then(res => {
                                console.log(res)
                                if (res.data.code == '200' ) {
                                    _this.$store.commit('SET_USERINFO',res.data.data);
                                    _this.userId = res.data.data.id;
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
                    this.userId = this.$store.state.userInfo.id;
                    this.userName = this.$store.state.userInfo.userName;
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
            // 搜索
            toSearch() {
                const values = this.searchValue;
                this.$router.push({path:'/search',query:{values}});
                this.init();
            },
            // 下拉菜单
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

<style scoped>

</style>