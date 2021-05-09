<template>
    <div >
        <div class="background">
            <el-carousel :height="imgMaxHeight+'px'" :interval="15000" indicator-position="none">
                <el-carousel-item v-for="item in imgSrc" :key="item">
                    <img :src="item" width="100%" height="100%" alt="厨阁" />
                </el-carousel-item>
            </el-carousel>
        </div>

        <div style="width: 1100px;height: auto;margin: 0 auto">

            <div id="login_body">
                <el-tabs :value="action" :stretch="true">
                    <el-tab-pane label="LOGIN" name="first">
                        <div id="login_body_left" >
                            <div style="width: 450px;height: 20px;text-align: center;margin-top: 50px;font-size: 28px"><p>LOGIN</p></div>
                            <el-form :model="user" ref="user" :rules="rules" >
                                <div style="height: 40px;width: 40px;margin-left:110px;float:left;position:relative">  <img src="../static/img/小人.png" />   </div>
                                <el-form-item  style="height: 40px;width: 230px;margin-top:50px;margin-left:150px;position: relative" prop="phone">
                                    <el-input type="text"  v-model="user.phone" autofocus placeholder="手机号" style="width: 190px;height: 40px;margin-left:1px;border: none;position: absolute;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)" ></el-input>
                                </el-form-item>
                                <div style="height: 40px;width: 40px;float: left;position: relative;margin-left:110px"> <img src="../static/img/锁.png" />  </div>
                                <el-form-item style="height: 40px;width: 230px;margin-top:20px;margin-left:150px" prop="pass">
                                    <el-input type="password" v-model="user.pass"  placeholder="密码" style="width: 190px;height: 40px;margin-left:1px;position: absolute;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)" ></el-input>
                                </el-form-item>
                                <a @click="$router.push({path:'/index'})" href="" style="float: left;font-size: 13px;margin-left: 120px;margin-top: 5px;">游客登录</a>
                                <el-button type="text"  @click="centerDialogVisible = true" style="float: right;font-size: 13px;margin-right: 120px;margin-top: -5px">忘记密码?</el-button>
                                <el-dialog
                                        title="忘记密码"
                                        :visible.sync="centerDialogVisible"
                                        width="50%"
                                        center
                                        :modal-append-to-body="false" :close-on-click-modal="false" :show-close="false">
                                    <el-steps :active="active" finish-status="success">
                                        <el-step title="步骤 1" description="填写注册过的手机号"></el-step>
                                        <el-step title="步骤 2" description="验证验证码"></el-step>
                                        <el-step title="步骤 3" description="修改密码"></el-step>
                                    </el-steps>

                                    <el-form style="margin-top: 60px;" v-if="active == 0" :model="numberValidateForm" ref="numberValidateForm" label-width="100px" class="demo-ruleForm">
                                        <el-form-item
                                                label="手机号">
                                            <el-input type="text" v-model="numberValidateForm.phone" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item>
                                            <el-button type="primary" @click="submitFormUpdate1">提交</el-button>
                                            <el-button type="danger" @click="resetFormUpdate('numberValidateForm')">取消</el-button>
                                        </el-form-item>
                                    </el-form>
                                    <el-form style="margin-top: 60px;" v-if="active == 1" :model="numberValidateForm" ref="numberValidateForm" label-width="100px" class="demo-ruleForm">
                                        <p style="align-content: center">已向{{numberValidateForm.phone}}发送了验证码,十分钟内有效</p>
                                        <el-form-item label="验证码">
                                            <el-input type="age" v-model="numberValidateForm.phone_vaild" ></el-input>
                                        </el-form-item>
                                        <el-form-item>
                                            <el-button type="primary" @click="submitFormUpdate2">提交</el-button>
                                            <el-button type="danger" @click="resetFormUpdate('numberValidateForm')">取消</el-button>
                                            <el-button type="primary" plain @click="getCheckAgain()">重新获取验证码</el-button>
                                        </el-form-item>
                                    </el-form>

                                    <el-form style="margin-top: 60px;" v-if="active == 2" :rules="forgetPass" :model="numberValidateForm" ref="numberValidateForm" label-width="100px" class="demo-ruleForm">
                                        <el-form-item label="新密码" :label-width="formLabelWidth" prop="pass">
                                            <el-input v-model="numberValidateForm.pass" type="password" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="确认密码" :label-width="formLabelWidth" prop="checkPass">
                                            <el-input v-model="numberValidateForm.check_pass" type="password" ></el-input>
                                        </el-form-item>
                                        <el-button type="primary" style="margin-top: 12px;" @click="submitFormUpdate3">提交新密码</el-button>
                                    </el-form>
                                </el-dialog>
                                <el-form-item style="height: 40px;width: 80px;margin-top:30px;margin-left:110px;border-radius: 3px;float: left" >
                                    <el-button style="width: 230px;height: 40px;border: none;background-color: coral;color: white;border-radius: 3px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)" v-loading="loading" element-loading-background="rgba(125,125,125, 0.8)" @click="login()" >登录</el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                    </el-tab-pane>
                    <el-tab-pane label="OTHER" name="second">
                        <div id="login_body_right" >
                            <div style="width:450px;height: 20px;text-align: center;margin-top: 50px;font-size: 28px"><p>OTHER</p></div>
                            <div style="margin-top: 40px;text-align: center;float: left;margin-left: 110px">
                                <div class="otherlogin" style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px" >
                                    <a href="#"> <img src="../static/img/QQ.png"></a>
                                </div>
                                <div class="otherlogin" style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                    <a href="#"> <img src="../static/img/微信.png"></a>
                                </div>
                                <div class="otherlogin" style="width: 50px;height: 50px;margin-left: 20px;margin-top:20px;float:left;border-radius: 5px">
                                    <a href="#"> <img src="../static/img/微博.png"></a>
                                </div>
                            </div>
                            <p style="float: right; font-size: 13px;margin-right: 120px;margin-top: 50px">还没有账号?</p>
                            <div style="height: 40px;width: 80px;margin-top:117px;margin-left:110px;border-radius: 3px;float:left">
                                <el-button type="text" @click="dialogFormVisible = true" style="width: 230px;height: 40px;border: none;background-color: coral;color: white;border-radius: 3px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04) ">注册</el-button>

                                <el-dialog title="REGISTER" :visible.sync="dialogFormVisible" :modal-append-to-body="false" :center="true" :close-on-click-modal="false" :show-close="false">
                                    <el-form :model="user" :rules="rules"  ref="user">
                                        <el-form-item label="昵称" :label-width="formLabelWidth" prop="name">
                                            <el-input v-model="user.name" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="手机号" :label-width="formLabelWidth" prop="phone">
                                            <el-input v-model="user.phone" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="密码" :label-width="formLabelWidth" prop="pass">
                                            <el-input v-model="user.pass" type="password" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="确认密码" :label-width="formLabelWidth" prop="checkPass">
                                            <el-input v-model="user.checkPass" type="password" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="密保问题1" :label-width="formLabelWidth" >
                                            <el-input v-model="user.mibao1" placeholder="我的母校" ></el-input>
                                        </el-form-item>
                                        <el-form-item label="密保问题2" :label-width="formLabelWidth" >
                                            <el-input v-model="user.mibao2" placeholder="我的行业"></el-input>
                                        </el-form-item>
                                        <el-form-item label="密保问题3" :label-width="formLabelWidth" >
                                            <el-input v-model="user.mibao3" placeholder="我的爱人"></el-input>
                                        </el-form-item>
                                        <el-form-item >
                                            <el-button type="primary" @click="submitForm('user')">提交</el-button>
                                            <el-button type="danger" @click="resetForm('user')">取消</el-button>
                                        </el-form-item>
                                    </el-form>
                                </el-dialog>
                            </div>
                        </div>
                    </el-tab-pane>
                </el-tabs>
            </div>
        </div>
    </div>
</template>

<script>

    export default {
        name: "login",
        data (){
            // 注册用户的验证
            let validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.user.checkPass != '') {
                        this.$refs.user.validateField('checkPass');
                    }
                    callback();
                }
            };
            let validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.user.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };

            // 忘记密码的验证
            let forgetPass1 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.numberValidateForm.check_pass != '') {
                        this.$refs.numberValidateForm.validateField('check_pass');
                    }
                    callback();
                }
            };
            let forgetPass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.numberValidateForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return{
                imgSrc:[
                    require('../static/img/背景1.jpg'),
                    require('../static/img/背景2.jpg'),
                    require('../static/img/背景3.jpg'),
                    require('../static/img/背景4.jpg'),
                    require('../static/img/背景5.jpg')
                ],
                dialogFormVisible: false,
                action:'first', // 开始显示登陆框
                errorMessage:'',
                formLabelWidth: '100px',
                user: {
                    name:'',
                    pass:'',
                    checkPass:'',
                    phone:'',
                    mibao1:'',
                    mibao2:'',
                    mibao3:''
                },
                centerDialogVisible: false,
                // 注册表单验证
                rules: {
                    pass: [
                        {min: 8, message: '长度至少8个字符', trigger: 'blur'},
                        {required: true, validator: validatePass, trigger: 'blur'}
                    ],
                    checkPass: [
                        {required: true, validator: validatePass2, trigger: 'blur'},
                        {min: 8, message: '长度至少8个字符', trigger: 'blur'}
                    ],
                    phone: [
                        {max: 11, min:11, message: '长度为11个字符', trigger: 'blur'}
                    ]
                },
                // 忘记密码的验证
                forgetPass: {
                    pass: [
                        {min: 8, message: '长度至少8个字符', trigger: 'blur'},
                        {required: true, validator: forgetPass1, trigger: 'blur'}
                    ],
                    checkPass: [
                        {required: true, validator: forgetPass2, trigger: 'blur'},
                        {min: 8, message: '长度至少8个字符', trigger: 'blur'}
                    ],
                },
                active:0,
                numberValidateForm: {
                    phone:'',
                    phone_vaild:'',
                    pass:'',
                    check_pass:''
                },
                loading:false,
                imgMaxHeight:100
            }
        },
        mounted() {
            this.changeTableMaxHeight()
        },
        methods:{
            // 清空注册的消息
            clear() {
                this.user.name=''
                this.user.pass=''
                this.user.checkPass=''
                this.user.phone=''
                this.user.mibao1=''
                this.user.mibao2=''
                this.user.mibao3=''
            },
            // 提交注册信息
            submitForm(user) {
                let _this = this;
                let UserRegisterDto = {
                    'userName':_this.user.name,
                    'userPass':_this.user.pass,
                    'userPhone':_this.user.phone,
                    'mibao_1':_this.user.mibao1,
                    'mibao_2':_this.user.mibao2,
                    'mibao_3':_this.user.mibao3
                }
                this.$refs[user].validate((valid) => {
                    if (valid) {
                        _this.$request.post('/user/register',UserRegisterDto)
                            .then(res =>{
                                if (res.data.code === '200') {
                                    _this.user.pass = '';
                                    _this.user.checkPass = '';
                                    _this.user.name = '';
                                    _this.user.phone = '';
                                    _this.dialogFormVisible = false;
                                    // 消息通知
                                    _this.$message({
                                        showClose:true,
                                        message:'注册成功，去登录吧！',
                                        type:"success"
                                    });
                                } else {
                                    _this.errorMessage = res.data.message;
                                    _this.error();
                                }
                            });
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(user) {
                this.$refs[user].resetFields();
                this.dialogFormVisible=false;
            },
            // 验证验证码
            checkNext(va) {
                let _this = this;
                this.$refs[va].validate((valid) => {
                    if (valid) {
                        _this.$request.get('/user/checkCode?phone='+_this.numberValidateForm.phone+'&code='+_this.numberValidateForm.phone_vaild)
                        .then(res => {
                            if (res.data.code == '200') {
                                _this.regis = 1;
                            } else {
                                _this.errorMessage = res.data.message;
                                _this.error();
                            }
                        })
                    }
                })
            },
            // 发送手机验证码
            sendPhone(va) {
                let _this = this;
                this.$refs[va].validate((valid) => {
                    if (valid) {
                        _this.$request.get('/user/registerCheck?phone='+_this.numberValidateForm.phone)
                            .then(res => {
                                _this.errorMessage = res.data.message;
                                _this.error();
                            })
                    }
                })
            },
            //  1、忘记密码
            submitFormUpdate1() {
                let _this = this;
                this.$refs.numberValidateForm.validate((valid) => {
                    if (valid) {
                        _this.$request.get('/user/checkPhoneCode?phone='+_this.numberValidateForm.phone)
                         .then(res => {
                             if (res.data.code === '200'){
                                 _this.next();
                             } else {
                                 _this.errorMessage = res.data.message;
                                 _this.error();
                             }
                         })

                        // _this.next();
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            ///2、提交验证码
            submitFormUpdate2() {
                let _this = this;
                this.$refs.numberValidateForm.validate((valid) => {
                    if (valid) {
                        _this.$request.get('/user/checkCode?phone='+_this.numberValidateForm.phone+'&code='+_this.numberValidateForm.phone_vaild)
                        .then(res => {
                            if (res.data.code === '200'){
                                _this.next();
                                _this.$message({
                                    showClose:true,
                                    message:'验证成功',
                                    type:"success"
                                });
                            } else {
                                _this.errorMessage = res.data.message;
                                _this.error();
                            }
                        })
                        // _this.next();
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            // 2.1、再次获取验证码
            getCheckAgain(){
                this.active--;
            },
            ///3、修改密码
            submitFormUpdate3() {
                let _this = this;
                let AlterPassDto = {
                    'userPhone':_this.numberValidateForm.phone,
                    'userPass':_this.numberValidateForm.pass,
                };
                _this.$request.post('/user/forGetPass',AlterPassDto)
                .then( res => {
                    if (res.data.code === '200'){
                        _this.next();

                        _this.$message({
                            showClose:true,
                            message:'修改成功',
                            type:"success"
                        });
                    } else {
                        _this.errorMessage = res.data.message;
                        _this.error();
                    }
                });
            },
            // 取消浮窗
            resetFormUpdate(formName) {
                this.$refs[formName].resetFields();
                this.centerDialogVisible=false;
            },
            // 登录
            login(){
                let _this = this;
                let UserInfoDto = {
                    'userPhone':_this.user.phone,
                    'userPass':_this.user.pass,
                };
                this.loading=true;
                _this.$request.post('/user/login', UserInfoDto)
                    .then(res => {
                        console.log(res);
                        if (res.data.code === '200' || res.status === '200') {
                            _this.$store.commit('SET_TOKEN', res.headers.authorization);
                            //  获取  用户的详细信息
                            _this.$request.get("/user/index")
                                .then(res => {
                                        console.log(res)
                                        if (res.data.code == '200' ) {
                                            _this.$store.commit('SET_USERINFO',res.data.data);
                                            _this.$router.push({path: 'index'});
                                        } else {
                                            localStorage.removeItem('Authorization');
                                            _this.errorMessage = res.data.message;
                                            _this.loading = false;
                                            _this.error();
                                        }
                                    },
                                    fail => {
                                        localStorage.removeItem('Authorization');
                                        _this.errorMessage = res.data.message;
                                        _this.loading = false;
                                        _this.error();
                                    });
                        } else {
                            _this.errorMessage = res.data.message;
                            _this.loading = false;
                            _this.error();
                        }
                    }).catch(res => {
                        _this.errorMessage = '用户不存在或者密码错误';
                        _this.loading = false;
                        _this.error();
                    });
            },
            next() {
                if (this.active++ === 2) {
                    this.active =0;
                    this.numberValidateForm.pass='';
                    this.numberValidateForm.phone='';
                    this.numberValidateForm.phone_vaild='';
                    this.centerDialogVisible = false;
                }
            },
            error() {
                this.$message({
                    showClose: true,
                    message: this.errorMessage,
                    type: 'error'
                });
            },
            changeTableMaxHeight () {
                this.imgMaxHeight = document.body.offsetHeight // 网页可视区域高度;
            }
        }
    }
</script>

<style >
    @import "../static/css/css_login.css";

    .background{
        width:100%;
        /*height:100%;  !**宽高100%是为了图片铺满屏幕 *!*/
        z-index:-1;
        position: absolute;
    }
    .otherlogin:hover {
        background-color: rgba(66, 162, 70, 0.5);
    }

</style>