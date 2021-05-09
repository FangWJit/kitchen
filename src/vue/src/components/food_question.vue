<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <div style="padding-top: 50px;width: 1410px;margin: 0 auto">
            <div class="body_qu">
                <p style="font-size:20px ;line-height: 1.7;font-family:'Microsoft YaHei';color: coral;margin:0 0 10px 20px ">今日您想提问</p>
                <el-input
                        type="textarea"
                        :rows="5"
                        placeholder="请输入内容"
                        v-model="textarea">
                </el-input>
                <div class="dynamic_publication">
                    <el-popover
                            width="500"
                            placement="left-end"
                            trigger="hover">
                        <div style="float: left;margin-left: 10px">
                            <div class="el_tag">
                                <el-tag
                                        :key="tag"
                                        v-for="tag in dynamicTags"
                                        closable
                                        :disable-transitions="false"
                                        @close="handleClose(tag)" @click="add(tag)">
                                    {{tag}}
                                </el-tag>
                            </div>
                            <el-input
                                    class="input-new-tag"
                                    v-if="inputVisible"
                                    v-model="inputValue"
                                    ref="saveTagInput"
                                    size="small"
                                    @keyup.enter.native="handleInputConfirm"
                                    @blur="handleInputConfirm">
                            </el-input>
                            <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
                        </div>
                        <el-button slot="reference" ><img src="../static/img/话题.png" class="el-image" /></el-button>
                    </el-popover>
                    <el-button type="primary" style="float: right;margin-right: 10px" @click="send">发表</el-button>
                </div>
            </div>

            <div class="body_qu">
                <p style="font-size:20px ;line-height: 1.7;font-family:'Microsoft YaHei';color: coral;margin:0 0 20px 20px ">我的提问</p>
                <div v-if="myhtnum == 0" style="margin:0 auto;width: 310px;color: #acada8;font-size: 17px">您还没有提问呢，快去提问考考大家吧</div>
                <el-card style="width: 940px;margin-bottom: 30px;background-color: #fbfbfb" shadow="hover" v-for="(item,index) in ht" :key="index" v-if="item.myque == true">
                    <div slot="header" class="clearfix">
                        <a @click="router(item.userId)" href="">
                            <img :src="item.userPhoto" style="width: 30px;height: 30px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"></img>
                            <span style="font-size: 18px">{{item.userName}}</span>
                        </a>
                        <div v-if="item.userId == $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px">
                            <el-button style="float: right; padding: 3px 0" type="text" @click="delHt(item.htId)" >删除</el-button>
                        </div>
                    </div>
                    <div class="text item" style="padding-bottom: 5px">
                        {{item.htValue}}
                        <el-badge  style="margin:0 10px 10px 10px;float: right;color: #acada8">
                            {{$moment(item.createTime).format('YYYY-MM-DD HH:mm')}}
                        </el-badge>
                    </div>
<!--                    <p class="qu_comment" v-if="!ht[index].showAns" @click="look(index)">查看回复 {{item.ans.length}}</p>-->
<!--                    <p class="qu_comment" v-if="ht[index].showAns" @click="look(index)">收起回复 {{item.ans.length}}</p>-->
                    <div style="float: left;margin-top: 10px" >
                        <div  style="width: 900px;" v-for="(answ,indexx) in item.ans" :key="indexx">
                            <el-card style="margin-bottom: 10px">
                                <div slot="header" style="margin:-10px 0">
                                    <a @click="router(answ.userId)" href="">
                                        <img :src="answ.userPhoto" style="width: 25px;height: 25px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"></img>
                                        <span style="font-size:13px" >{{answ.userName}}</span>
                                    </a>
                                    <div  style="display: inline-block;float: right;margin-top: 5px;margin-left: 5px">
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="delAnsHt(item.htId,answ.htId)" > 删除回复</el-button>
                                    </div>
                                    <div v-if="answ.userId != $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px;margin-right: 5px">
                                        <el-button style="float: right; padding: 3px 0" type="text" v-if="answ.attention == 0" @click="trans(answ.userId,answ.attention)" >+ 关注</el-button>
                                        <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="answ.attention == 1" @click="trans(answ.userId,answ.attention)">√ 已关注</el-button>
                                        <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="answ.attention == 2" @click="trans(answ.userId,answ.attention)">⇄ 互相关注</el-button>
                                    </div>
                                </div>
                                <div style="margin-top: -10px;margin-bottom: -10px;font-size:13px">
                                    {{answ.htValue}}
                                    <el-badge  style="margin:0 10px 10px 10px;float: right;color: #d6d3d1">
                                        {{$moment(answ.createTime).format('YYYY-MM-DD HH:mm')}}
                                    </el-badge>
                                </div>
                            </el-card>
                        </div>
                    </div>
                </el-card>
            </div>

            <div class="body_qu">
                <p style="font-size:20px ;line-height: 1.7;font-family:'Microsoft YaHei';color: coral;margin:0 0 20px 20px ">精选提问</p>
                <el-card style="width: 940px;margin-bottom: 30px;background-color: #fbfbfb" shadow="hover" v-for="(item,index) in ht" :key="index" v-if="haveht">
                    <div slot="header" class="clearfix">
                        <a @click="router(item.userId)" href="">
                            <img :src="item.userPhoto" style="width: 30px;height: 30px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"></img>
                            <span style="font-size:18px;">{{item.userName}}</span>
                        </a>
                        <div v-if="item.userId != $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px">
                            <el-button style="float: right; padding: 3px 0" type="text" v-if="item.attention == 0" @click="trans(item.userId,item.attention)" >+ 关注</el-button>
                            <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="item.attention == 1" @click="trans(item.userId,item.attention)">√ 已关注</el-button>
                            <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="item.attention == 2" @click="trans(item.userId,item.attention)">⇄ 互相关注</el-button>
                        </div>
                        <div v-if="item.userId == $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px">
                            <el-button style="float: right; padding: 3px 0" type="text" @click="delHt(item.htId)" >删除</el-button>
                        </div>
                    </div>
                    <div class="text item" style="padding-bottom: 5px;font-size:15px">
                        {{item.htValue}}
                        <el-badge  style="margin:0 10px 10px 10px;float: right;color: #acada8">
                            {{$moment(item.createTime).format('YYYY-MM-DD HH:mm')}}
                        </el-badge>
                    </div>
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="我来参与回答"
                            v-model="item.textarea" >
                    </el-input>
                    <div style="float: left;margin-top: 10px">
                        <el-badge  style="margin:0px 5px 10px 5px">
                            <el-button type="primary" plain @click="answer(item.textarea,item.htId)">回答</el-button>

                        </el-badge>
                        <div  style="width: 900px" v-for="(ans,index) in item.ans" :key="index">
                            <el-card style="margin-bottom: 5px">
                                <div slot="header" style="margin:-10px 0">
                                    <a @click="router(ans.userId)" href="">
                                        <img :src="ans.userPhoto" style="width: 25px;height: 25px;border-radius: 50%;margin-right: 10px;margin-bottom: -4px;"></img>
                                        <span style="font-size: 13px">{{ans.userName}}</span>
                                    </a>
                                    <div  style="display: inline-block;float: right;margin-top: 5px;margin-left: 5px;" v-if="item.userId == $store.state.userInfo.id">
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="delAnsHt(item.htId,ans.htId)" >删除回复</el-button>
                                    </div>
                                    <div v-if="ans.userId != $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px;margin-right: 5px">
                                        <el-button style="float: right; padding: 3px 0" type="text" v-if="ans.attention == 0" @click="trans(ans.userId,ans.attention)" >+ 关注</el-button>
                                        <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="ans.attention == 1" @click="trans(ans.userId,ans.attention)">√ 已关注</el-button>
                                        <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="ans.attention == 2" @click="trans(ans.userId,ans.attention)">⇄ 互相关注</el-button>
                                    </div>
                                    <div v-if="item.userId != $store.state.userInfo.id && ans.userId == $store.state.userInfo.id" style="display: inline-block;float: right;margin-top: 5px">
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="delAnsHt(item.htId,ans.htId)" >删除回复</el-button>
                                    </div>
                                </div>
                                <div style="margin-top: -10px;margin-bottom: -10px;font-size:13px">
                                    {{ans.htValue}}
                                    <el-badge  style="margin:0 10px 10px 10px;float: right;color: #acada8">
                                        {{$moment(ans.createTime).format('YYYY-MM-DD HH:mm')}}
                                    </el-badge>
                                </div>
                            </el-card>
                        </div>
                    </div>
                </el-card>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "food_question",
        data() {
            return {
                outerVisible: false,
                userPhoto: this.$store.state.userInfo.userPhoto,
                selectId: this.$store.state.userInfo.userPhoto.substr(43,1), // 选择头像的序列id
                lookPhoto: '',
                backgroudimage: require('../static/img/背景8.png'),
                textarea: '',
                myhtnum:0,
                errorMessage:'',
                dynamicTags: ['爆炒', '家常', '清蒸', '炝炒'],
                inputVisible: false,
                inputValue: '',
                click_count:1,
                userName:'',
                searchValue:'',
                haveht:false,
                ht:[
                    {
                        htId:'',
                        userId:'',
                        userName:'',
                        userPhoto:'',
                        htValue:'',
                        createTime:'',
                        myque:false,
                        quecount:0,
                        ans:[
                            {
                                htId:'',
                                userId:'',
                                userName:'',
                                userPhoto:'',
                                htValue:'',
                                attention:0,
                                createTime:''
                            }
                        ],
                        attention:0,
                        // show_note:false,
                        textarea:''
                    }
                ]
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            // 添加标签 到 多行输入框
            add(tag){
                this.textarea += ' #'+tag+' ';
            },
            // 关闭标签
            handleClose(tag) {
                this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1);
            },
            // 添加标签
            showInput() {
                this.inputVisible = true;
                this.$nextTick(_ => {
                    this.$refs.saveTagInput.$refs.input.focus();
                });
            },
            // 输入要添加的标签
            handleInputConfirm() {
                let inputValue = this.inputValue;
                if (inputValue) {
                    this.dynamicTags.push(inputValue);
                }
                this.inputVisible = false;
                this.inputValue = '';
            },
            look(index) {
                this.ht[index].showAns = !this.ht[index].showAns;
                console.log(this.ht[index]);
            },
            // 初始化 数据
            init(){
                this.userName=this.$store.state.userInfo.userName;
                let userId = this.$store.state.userInfo.id;
                let _this = this;
                this.$request.get("/ht/getHt")
                    .then(res => {
                        this.haveht = true;
                        let data = res.data.data ;
                        _this.ht = data;
                        _this.ht.forEach((item,index) => {
                            if (item.userId === _this.$store.state.userInfo.id) {
                                _this.ht[index].userName = item.userName + "  (我)";
                                _this.ht[index].myque = true;
                                _this.myhtnum++;
                            } else {
                                _this.ht[index].userName = item.userName;
                            }
                            _this.ht[index].createTime = item.createTime.toString();
                            _this.ht[index].userPhoto = item.userPhoto;
                            _this.ht[index].quecount = item.ansNum;
                            _this.ht[index].ans.forEach(item =>{
                                if (item.userId === _this.$store.state.userInfo.id) {
                                    item.userName = item.userName + "  (我)";
                                }
                                item.userPhoto = item.userPhoto;
                            });
                            // _this.ht[index].show_note = true;
                        })
                    });
            },
            // 带参 跳转 到 用户详情页
            router(userId){
                let url = this.$router.resolve({path:'/detail',query:{userId}});
                window.open(url.href,'_blank');
            },
            // 搜索
            toSearch() {
                const values = this.searchValue;
                this.$router.push({path:'/search',query:{values}});
            },
            // 发表话题
            send() {
                if (this.textarea == '' || this.textarea == null) {
                    this.errorMessage = "发表的信息不能为空";
                    this.error();
                } else {
                    let HtDetailDt = {
                        'htId': this.$store.state.userInfo.id,
                        'userId': this.$store.state.userInfo.id,
                        'userName': this.userName,
                        'userPhoto': this.$store.state.userInfo.userPhoto,
                        'htValue': this.textarea,
                        'isHt': 1
                    }
                    let _this = this;
                    this.$request.post('/ht/putHt', HtDetailDt)
                        .then(res => {
                            if (res.data.code == '200') {
                                _this.textarea = '';
                                _this.init();
                            }
                        })
                }
            },
            // 回答话题
            answer(result,queId) {
                if (result == '' || result == null) {
                    this.errorMessage = "回答的信息不能为空";
                    this.error();
                } else {
                    let HtDetailDt = {
                        'htId': this.$store.state.userInfo.id,
                        'userId': this.$store.state.userInfo.id,
                        'userName': this.userName,
                        'userPhoto': this.$store.state.userInfo.userPhoto,
                        'htValue': result,
                        'isHt': 0,
                        'queId': queId
                    }
                    let _this = this;
                    this.$request.post('/ht/ansHt', HtDetailDt)
                        .then(res => {
                            if (res.data.code == '200') {
                                _this.textarea = '';
                                _this.init();
                            }
                        })

                }
            },
            // 关注和取关
            trans(userid,code) {
                let userRelation = {
                    'userId':this.$store.state.userInfo.id,
                    'noricorId':userid
                };
                let _this = this;
                if (code == 0) {
                    this.$request.post('/attention/pop',userRelation)
                    .then( res => {
                        if (res.data.code == "200") {
                            _this.init();
                        } else {
                            _this.errorMessage="关注失败";
                            _this.error();
                        }
                    })
                } else {
                    this.$request.post('/attention/push',userRelation)
                        .then( res => {
                            if (res.data.code == "200") {
                                _this.init();
                            } else {
                                _this.errorMessage="取关失败";
                                _this.error();
                            }
                        })
                }
            },
            // 删除话题
            delHt(htId) {
                let _this = this;
                this.$request.get('/ht/delHt?htId='+htId)
                .then(res => {
                    console.log(res.data)
                    if (res.data.code == "200") {
                        _this.init();
                    } else {
                        _this.errorMessage="删除话题失败";
                        _this.error();
                    }
                })
            },
            // 删除评论(用户的评论 或者用户话题下的评论)
            delAnsHt(htId,ansHt) {
                let _this = this;
                this.$request.get('/ht/delAnsHt?htId='+htId+'&ansHt='+ansHt)
                    .then(res => {
                        if (res.data.code == "200") {
                            _this.init();
                        } else {
                            _this.errorMessage="删除回复失败";
                            _this.error();
                        }
                    })
            },
            // 错误信息输出
            error() {
                this.$message({
                    showClose: true,
                    message: this.errorMessage,
                    type: 'error'
                });
            }
        }
    }
</script>

<style >
    .body_qu {
        width: 940px;
        height:auto;
        margin: 50px auto;
        padding: 20px;
        border-radius: 6px;
        background-color: rgba(255, 255, 255, 0.5);
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
    }

    .dynamic_publication {
        margin-top: 10px;
    }

    .el-image {
        width: 20px;
        height: 20px;
        float: left;
    }

    .button-new-tag {
        margin-left: 10px;
        height: 32px;
        line-height: 30px;
        padding-top: 0;
        padding-bottom: 0;
    }
    .input-new-tag {
        width: 90px;
        margin-left: 10px;
        vertical-align: bottom;
        background-color: #fbfbfb;
    }

    .qu_comment {
        font-size: 14px;
        line-height: 10px;
        color: #a0cfff;
    }
    .qu_comment:hover {
        color: coral;
    }



</style>