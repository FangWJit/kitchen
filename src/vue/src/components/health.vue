<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
<!--        主体部分 -->
        <div style="padding-top: 100px;height: auto;width: 1410px;margin: 0 auto">
            <div style="width: 1410px;height: 50px;margin: 0 auto">
                <div style="width:960px;height: 40px;border-top: 2px solid coral;border-bottom: 2px solid coral;margin: 30px auto 10px;">
                    <ul class="nav_ul">
                        <li class="nav_li" v-for="(item,index) in assort" :key="index" @click="change(index)">{{item.value}}</li>
                    </ul>
                </div>
            </div>

            <div class="video_card">
                <p class="title">视频</p>
                <el-divider/>

                <div class="video" >
                    <div class="cover" @click="$router.push('/video')">
                        <img :src="require('../static/img/feng/腊肠.png')" >
                    </div>
                    <p class="desc">腊肠别总蒸着吃，学会这3种做法，家里的囤货几天就能吃光了</p>
                </div>

                <div class="video" >
                    <div class="cover" @click="$router.push('/video')">
                        <img :src="require('../static/img/feng/腊肠.png')">
                    </div>
                    <p class="desc">腊肠别总蒸着吃，学会这3种做法，家里的囤货几天就能吃光了</p>
                </div>

                <div class="video" >
                    <div class="cover" @click="$router.push('/video')">
                        <img :src="require('../static/img/feng/腊肠.png')">
                    </div>
                    <p class="desc">腊肠别总蒸着吃，学会这3种做法，家里的囤货几天就能吃光了</p>
                </div>
            </div>

            <div class="word_card">
                <p class="title">文章</p>
                <el-divider/>
                <div class="word" v-for="item in words">
                    <div class="title" @click="lookWord(item.wordId)">{{item.wordTitle}}</div>
                    <div class="create_time">{{item.createTime}}</div>
                    <div class="read_count"><i class="el-icon-view" style="margin-right: 5px"/>{{item.readCount}}</div>
                    <div v-html="item.wordContent" class="desc"></div>
                    <el-divider/>
                </div>
                <div style="width: 100%;text-align: center;line-height: 50px;color: #999999">没有更多了</div>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "health",
        data (){
            return {
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                assort:[
                    {value:'饮食常识'},
                    {value:'瘦身美容'},
                    {value:'母婴饮食'},
                    {value:'食疗食补'},
                    {value:'营养手册'},
                    {value:'健康专栏'}
                ],
                words:[]
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init(){
                this.userName=this.$store.state.userInfo.userName;

                // 默认第一个为选中状态
                let li = document.getElementsByClassName('nav_li');
                li[0].className += ' c';
                // 通过分类 获取文章
                this.getWord(this.assort[0].value);
            },
            router(userId){
                let url = this.$router.resolve({path:'/detail',query:{userId}});
                window.open(url.href,'_blank');
            },
            // 通过分类 获取文章
            getWord(wordType) {
                let _this = this;
                console.log(wordType,"wordType")
                _this.$request.get('/word/getList?wordType='+wordType)
                    .then( res => {
                        if (res.data.code === '200') {
                            _this.words = res.data.data;
                            _this.words.forEach( item => {
                                item.createTime = this.$moment(item.createTime).format("yyyy-MM-DD HH:mm:ss");
                            })
                        } else {
                            _this.$message.error(res.data.message);
                        }
                    });
            },
            // 改变选中状态的 li 样式 及  下面内容
            change(index) {
                this.assortIndex = index;
                let _this = this;
                let li = document.getElementsByClassName('nav_li');
                let className = li[index].className;
                if (className.indexOf('c') == -1) {
                    for (let i = 0; i < li.length; i++) {
                        if (i == index) {
                            li[i].className += ' c';
                            // 通过分类 获取文章
                            this.getWord(this.assort[i].value);
                        } else {
                            li[i].className = className;
                        }
                    }
                }
            },
            lookWord(wordId){
                this.$router.push({path:'/word',query:{wordId}});
            }
        }
    }
</script>

<style scoped>

    /* 导航 */
    .nav_ul {
        width: 850px;
        text-align: center;
        display: inline-block;
        vertical-align: middle;
    }
    .nav_ul .nav_li{
        display: inline;
        padding: 10px;
        line-height: 40px;
    }
    .nav_ul .nav_li:hover{
        color: coral;
    }
    /* 点击之后*/
    .c{
        color: coral;
    }
    /* 视频 */
    .video_card{
        width: 960px;
        height: 300px;
        margin: 20px auto 0;
    }
    /* 标题 */
    .title {
        margin: 10px 10px 0 10px;
        width: 100%;
        line-height: 30px;
    }
    /* 分隔符 */
    .el-divider--horizontal {
       margin: 11px 0;
        background-color: #acada8;
     }
    /* 视频块 */
    .video {
        width: 320px;
        height: 220px;
        margin-top: 10px;
        display: inline-block;
    }
    .cover {
        width: 250px;
        height: 150px;
        margin: 0 auto;
    }
    .cover img {
        width: 250px;
        height: 150px;
    }
    .cover:hover img{
        width: 255px;
        height: 155px;
        transition: all .5s ease-in-out;
    }
    .desc{
        width: 250px;
        height: 50px;
        display: block;
        font-size: 12px;
        margin: 0 auto;
    }
    .word_card{
        width: 960px;
        height: auto;
        margin: 20px auto;
    }
    .word {
        width: 940px;
        height: 130px;
        margin: 0 auto;
        padding: 20px 0 0 20px;
        background-color: rgba(255,255,255,0.7);
    }
    .word .title {
        width: 700px;
        height: 40px;
        line-height: 40px;
        margin-left: 10px;
        font-size: 24px;
        color: #605f5f;
    }
    .word .title:hover {
        color: coral;
    }
    .word .create_time {
        width: 150px;
        line-height: 10px;
        font-size: 8px;
        height: 10px;
        margin-left: 10px;
        color: #acada8;
        display: inline-block;
    }
    .word .read_count {
        width: 150px;
        line-height: 10px;
        font-size: 8px;
        height: 10px;
        margin-left: 10px;
        color: #acada8;
        display: inline-block;
    }
    .word .desc{
        width: 360px;
        height: 30px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        margin-left: 20px;
        display: block;
        font-size: 10px;
        margin-top: 10px;
        color: #999999;
    }


</style>