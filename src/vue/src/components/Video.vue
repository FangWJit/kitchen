<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <div class="video_body">
            <div class="video_card">
                <div class="video_info">
                    <div class="dynami">
                        <div style="float: left;padding: 0 0 5px 5px">
                            腊肠别总蒸着吃，学会这3种做法，家里的囤货几天就能吃光了
                        </div>
                    </div>
                </div>
                <video class="video" autoplay="autoplay" :src="require('../static/video/腊肠别总蒸着吃，学会这3种做法，家里的囤货几天就能吃光了.mp4')" controls="controls"></video>
                <div class="video_info">
                    <div class="dynami">
                        <div style="float: left;padding: 0 0 5px 5px">
                            腊肠别总蒸着吃，学会这3种做法，家里的...
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img v-if="shoucang == false" src="../static/img/foodDetails/收藏1.png" class="dy" />
                            <img v-if="shoucang == true" src="../static/img/foodDetails/收藏2.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img v-if="dianzan == false" src="../static/img/foodDetails/点赞1.png" class="dy" />
                            <img v-if="dianzan == true" src="../static/img/foodDetails/点赞2.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img src="../static/img/foodDetails/评论1.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img src="../static/img/foodDetails/查看.png" class="dy" />
                        </div>
                    </div>
                </div>

                <div class="recommend">
                    <p>相关推荐</p>
                    <el-divider/>
                    <div class="more_video" v-for="item in 3">
                        <img class="more_img" :src="require('../static/img/feng/腊肠.png')"/>
                        <p>用户</p>
                    </div>
                </div>

                <div class="comment">
                    <p>评论</p>
                    <i class="el-icon-chat-line-square" style="margin-left: 10px;"/>
                    <el-divider />
                    <div style="width: 750px;height: auto;margin: 20px auto">
                        <el-input v-model="value" placeholder="发表你的评论吧！" style="width: 670px"/>
                        <el-button type="primary" style="margin-left: 5px">发表</el-button>
                    </div>
                    <el-divider style="background-color: #999999;width: 700px;margin: 10px auto" />
                    <div class="more_comment">
                        <div style="width: 700px;height: 30px;margin-top: 10px" v-for="item in lunyan">
                            <p style="float: left;width: 400px;height: auto;margin-left: 30px;right: 0">{{item.name+'  :  '+item.value}}</p>
                            <p style="width: 150px;float: right;margin-right: 10px;margin-left: 0">{{item.time}}</p>
                            <p style="width: 40px;float: right;margin-left: 0">点赞</p>
                            <p style="width: 40px;float: right;margin-left: 0">评论</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Video",
        data(){
            return{
                backgroudimage: require('../static/img/背景8.png'),
                shoucang:true,
                dianzan:true,
                show:false,
                value:'',   // 评论的内容
                lunyan:[
                    {
                        name:'小白',
                        value:'健康生活每一Tina',
                        time:'2021-05-02 10:24:10'
                    },
                    {
                        name:'派大星',
                        value:'健康生活每一Tina',
                        time:'2021-05-02 15:58:12'
                    },
                    {
                        name:'海绵',
                        value:'健康生活每一Tina',
                        time:'2021-05-02 17:25:34'
                    },
                    {
                        name:'小白',
                        value:'健康生活每一Tina',
                        time:'2021-05-03 15:24:10'
                    }
                ]
            }
        },
        methods:{
            sendPingLun() {
                this.lunyan.push({
                    name:this.$store.state.userInfo.userName,
                    value: this.value,
                    time:this.$moment(new Date()).format('yyyy-MM-DD HH:mm:ss')
                });
            }
        }
    }
</script>

<style scoped>
    /* 最大活动区域 */
    .video_body{
        width: 1410px;
        height: auto;
        margin: 60px auto 0;
        padding-bottom: 40px;
    }
    /* 活动区域 */
    .video_card {
        width: 1000px;
        height: auto;
        background-color: rgba(255,255,255,0.5);
        margin: 0 auto;
        padding: 40px 0;
    }
    /* 视频播放区域 */
    .video_card .video {
        width: 800px;
        height: 380px;
        margin: 0 auto;
        display: block;
        background-color: black;
    }
    /* 点赞等信息 */
    .video_card .video_info {
        width: 800px;
        height: 40px;
        margin: 0 auto;
        background-color: white;
    }
    .video_info .dynami {
        width: 100%;
        height: 20px;
        padding: 10px 0 5px 0;
    }
    .number {
        background-color: #e7e3e3;
    }
    .numbers {
        font-size: 8px;
    }
    .dy,.numbers,.number {
        float: right;
        width: 50px;
        height: 20px;
    }
    .dy {
        width: 20px;
    }
    /* 推荐 */
    .recommend {
        width: 800px;
        height: auto;
        background-color: rgba(255,255,255,0.7);
        margin: 40px auto 0;
    }
    .recommend p {
        margin: 10px 0 0 10px;
        font-size: 14px;
        color: coral;
    }
    /* 分隔符 */
    .el-divider--horizontal {
        margin: 11px 0;
        background-color: #acada8;
    }
    .more_video{
        width: 200px;
        height: 200px;
        margin-left: 50px;
        display: inline-block;
    }
    .more_img {
        width: 200px;
        height: 150px;
    }
    .more_video p{
        color: black;
    }
    /* 评论 */
    .comment {
        width: 800px;
        height: auto;
        background-color: rgba(255,255,255,0.7);
        margin: 40px auto;
        padding: 40px 0;
    }
    .comment p {
        margin: 10px 0 0 10px;
        font-size: 14px;
        color: coral;
    }
    /* 更多评论 */
    .more_comment {
        width: 780px;
        height: auto;
        background-color: rgba(255,255,255,1);
        margin: 0 auto;
        padding: 0 0 40px 0;
    }

</style>