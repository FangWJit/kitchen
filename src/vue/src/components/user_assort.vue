<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <!--        主体部分 -->
        <div style="padding-top: 60px;height: auto;width: 100%">
            <div style="width: 1410px;height: auto;margin: 0 auto;background-color: rgba(255,255,255,0.8)">
                <div style="width: 150px;height: 100px;margin: 50px auto;padding-top: 20px">
                    <el-avatar style="width: 100px;height: 100px"  :src="require('../static/img/读书.jpg')"></el-avatar>
                </div>
                <div style="margin-left: 20px">
                    <el-avatar v-for="(item,index) in 12" style="width: 70px;height: 70px;margin: 25px 40px 25px 40px"  src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "health",
        data (){
            return {
                outerVisible: false,
                userPhoto: this.$store.state.userInfo.userPhoto,
                selectId: this.$store.state.userInfo.userPhoto.substr(43,1), // 选择头像的序列id
                lookPhoto: '',
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                searchValue:'',
                img:require('../static/img/health/太极卡通.jpg'),
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init(){
                this.userName=this.$store.state.userInfo.userName;
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
                    this.router(this.$store.state.userInfo.id);
                }

            },
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
            // 搜索
            toSearch() {
                const values = this.searchValue;
                this.$router.push({path:'/search',query:{values}});
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

</style>