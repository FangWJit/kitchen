<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <!--主体部分-->
        <div id="food_list" >
            <div style="width: 970px;height: auto;margin: 0 auto">
                <div style="margin: 20px 10px 0 10px;width:220px;height:200px;display: inline-block " v-for="(item,index) in foodList" :key="index">
                    <el-card shadow="hover" :body-style="{ padding: '10px' }"  >
                        <div @click="info(item.meauId)">
                            <div style=" height: 110px; width: 200px;background-color: white;">
                                <img :src="item.img">
                            </div>
                            <div style=" height: 90px;width: 200px;background-color: white;" >
                                <a href="" class="a" style="padding:5px;font-size: 14px;display:block;color: lightskyblue" > {{item.name.substr(0,13)}}</a>
                                <p style="padding:5px;font-size: 14px;display: block"> {{item.tags.substr(0,14)}}...</p>
                                <p style="padding:5px;font-size: 14px"> {{item.userName}}</p>
                                <p style="padding:5px;float: right; font-size: 14px;color: red"> {{item.likecount}}.糖</p>
                            </div>
                        </div>

                    </el-card>
                </div>
                <div class="pageHandler">
                    <el-pagination
                            background
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
                outerVisible: false,
                userPhoto: this.$store.state.userInfo.userPhoto,
                selectId: this.$store.state.userInfo.userPhoto.substr(43,1), // 选择头像的序列id
                lookPhoto: '',
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                currentPage:this.$store.state.currentPage,
                count:0,
                pageSize:20,
                searchValue:'',
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
                    this.router(this.$store.state.userInfo.id);
                }

            },
            // 修改头像
            handleAvatarSuccess(res, file) {
                this.imageUrl = file.name;
                this.photo = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;
                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
            // 选择头像
            select(id) {
                this.selectId = id;
                this.lookPhoto = 'http://39.99.240.33:8045/kitchen/static/image/'+id+'.png';
            },
            send() {
                let url = 'http://39.99.240.33:8045/kitchen/static/image/'+this.selectId+'.png';
                let _this = this;
                _this.$request.get('/userDetail/setPhoto?photo='+url+'&id='+this.$store.state.userInfo.id)
                    .then(res => {
                        if (res.data.code === '200') {
                            _this.userPhoto = url;
                            _this.outerVisible = false;
                            _this.$store.state.userInfo.userPhoto = url;
                            window.sessionStorage.setItem('userInfo',JSON.stringify(_this.$store.state.userInfo));
                        } else {
                            _this.$message.error(res.data.message);
                        }
                    })
                // this.$request.post('/userDetail/static',file);
            }

        }
    }
</script>

<style scoped>
    @import "../static/css/css_foodlist.css";

    .pageHandler {
        /*text-align: left;*/
        margin: 20px;
    }
</style>