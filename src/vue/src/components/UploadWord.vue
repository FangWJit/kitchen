<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <div class="upload_word">
            <div class="word">
                <h2 style="text-align: center;margin-bottom: 10px">发表文章</h2>
                <div style="width: 900px;margin: 0 auto;padding: 30px 0">
                    <el-form ref="form" :model="form" label-width="80px" >
                        <el-form-item label="文章标题" >
                            <el-input v-model="form.name" placeholder="请输入文章标题" ></el-input>
                        </el-form-item>
                        <el-form-item label="文章分类">
                            <el-select v-model="form.region" placeholder="请选择活动区域">
                                <el-option label="饮食常识" value="饮食常识"></el-option>
                                <el-option label="瘦身美容" value="瘦身美容"></el-option>
                                <el-option label="母婴饮食" value="母婴饮食"></el-option>
                                <el-option label="食疗食补" value="食疗食补"></el-option>
                                <el-option label="营养手册" value="营养手册"></el-option>
                                <el-option label="健康专栏" value="健康专栏"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="文章内容">
                            <tinymac @inc="getValue"/>
                        </el-form-item>
                        <el-form-item >
                            <el-button type="primary" style="width: 100px" @click="sendWord">发表</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import tinymac from '../components/Tinymce'
    export default {
        name: "UploadWord",
        components:{
            tinymac
        },
        data(){
            return {
                backgroudimage: require('../static/img/背景8.png'),
                form: {
                    name: '',
                    region: '饮食常识',
                    value:''
                }
            }
        },
        methods:{
            getValue(value){
                this.form.value=value;
            },
            sendWord() {
                let word = {
                    userId:this.$store.state.userInfo.id,
                    wordTitle:this.form.name,
                    wordType:this.form.region,
                    wordContent:this.form.value
                }
                let _this = this;
                if (this.form.name != '') {
                    this.$request.post('/word/insertWord',word).then( res => {
                        if (res.data.code === '200') {
                            _this.$message.success("发表成功");
                            _this.$store.commit('SET_PAGE','1');
                            _this.$router.push('/'); // 找 上一级
                        }
                    })
                } else{
                    this.$message.error('标题不能为空');
                }
            }
        }

    }
</script>

<style scoped>
    .upload_word {
        width: 960px;
        height: auto;
        background-color: rgba(255,255,255,0.7);
        margin: 0 auto;
    }

    .upload_word .word {
        width: 960px;
        height: auto;
        padding-top: 100px;
    }

</style>