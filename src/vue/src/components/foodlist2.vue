<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <!--主体部分-->
        <div id="food_list">
            <br>
            <h3>菜谱大全</h3>
            <div id="body_div_left_top_down1">
                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_pork" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >猪肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_left_beef" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >牛肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_right_mutton" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >羊肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_left_other" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >其他肉类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_right_milk" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >奶制品</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_left_chicken" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >鸡肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_right_duck" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >鸭肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >蛋类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >其他禽类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >贝类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >其他海鲜水产</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >根茎蔬菜</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >米、面食、粉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >茎叶蔬菜</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >腌咸蔬菜</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >瓜果蔬菜</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >豆制品</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >干果豆类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >菜系</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >口味</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >蟹类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >水果</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#food_list_fish" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >鱼肉</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >虾类</a></div>

                <div class="XZ" style="margin:5px;width: 100px;height: 35px;background-color:#e7e3e3;float: left;border-radius: 3px;text-align: center;">
                    <a href="#" style="display: inline-block;width: 100px;height: 30px;border-radius: 3px;padding-top: 5px" >菌类</a></div>

            </div>

            <div id="food_list_pork">
                <div id="food_list_pork_class_th">
                    <p style="padding-top: 5px;font-size: 18px;padding-left: 30px">猪肉</p>
                </div>
                <div id="food_list_pork_class">
                    <table style="width: 960px;margin: 10px">
                        <tr >
                            <td >猪肉</td>
                            <td >排骨</td>
                            <td >猪蹄</td>
                            <td >猪肚</td>
                            <td >猪排</td>
                            <td >猪肝</td>
                            <td >猪骨</td>
                            <td >猪腰</td>
                            <td >猪脑</td>
                            <td >里脊</td>
                        </tr>
                        <tr>
                            <td >猪头</td>
                            <td >猪血</td>
                            <td >大排</td>
                            <td >猪心</td>
                            <td >猪皮</td>
                            <td >肘子</td>
                            <td >肉松</td>
                            <td >肥肠</td>
                            <td >腰花</td>
                            <td >肉皮</td>
                        </tr>
                        <tr>
                            <td >猪大肠</td>
                            <td >火腿</td>
                            <td >培根</td>
                            <td >猪耳朵</td>
                            <td >腊肉</td>
                            <td >香肠</td>
                            <td >猪尾巴</td>
                            <td >猪油</td>
                            <td >瘦肉</td>
                            <td >五花肉</td>
                        </tr>
                        <tr>
                            <td >猪肺</td>
                            <td >叉烧</td>
                            <td >火腿肠</td>
                            <td >肉末</td>
                            <td >肥肠</td>
                            <td >午餐肉</td>
                            <td >熏肉</td>
                            <td >肉丸</td>
                            <td >咸肉</td>
                            <td ></td>
                        </tr>

                    </table>
                </div>
            </div>

            <!--    左边的菜谱-->
            <div id="left" style="width: 460px;height: auto;float:left;">
                <div id="food_list_left_beef">
                    <div id="food_list_left_beef_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-left: 30px">牛肉</p>
                    </div>
                    <div id="food_list_left_beef_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >牛肉</td>
                                <td >牛排</td>
                                <td >牛仔骨</td>
                                <td >牛筋</td>
                                <td >牛骨</td>
                            </tr>
                            <tr>
                                <td >牛百叶</td>
                                <td >牛杂</td>
                                <td >肥牛</td>
                                <td >牛腩</td>
                                <td >牛肚</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div id="food_list_left_other">
                    <div id="food_list_left_other_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-left: 30px">其他肉类</p>
                    </div>
                    <div id="food_list_left_other_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >兔肉</td>
                                <td >驴肉</td>
                                <td >鹿肉</td>
                                <td >鹅肉</td>
                                <td >鹅肝</td>
                            </tr>
                            <tr>
                                <td >鹅肠</td>
                                <td >鹅掌</td>

                            </tr>
                        </table>
                    </div>
                </div>

                <div id="food_list_left_chicken">
                    <div id="food_list_left_chicken_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-left: 30px">鸡肉</p>
                    </div>
                    <div id="food_list_left_chicken_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >鸡翅</td>
                                <td >鸡胸</td>
                                <td >鸡腿</td>
                                <td >鸡爪</td>
                                <td >鸡胗</td>
                            </tr>
                            <tr>
                                <td >鸡肝</td>
                                <td >鸡心</td>
                                <td >鸡肠</td>
                                <td >鸡杂</td>
                                <td >公鸡</td>
                            </tr>
                            <tr>
                                <td >小鸡</td>
                                <td >仔鸡</td>
                                <td >乌鸡</td>
                                <td >野鸡</td>
                                <td >火鸡</td>
                            </tr>
                            <tr>
                                <td >鸡肉</td>
                                <td >土鸡</td>
                                <td >柴鸡</td>
                                <td >三黄鸡</td>
                                <td >童子鸡</td>
                            </tr>
                            <tr>
                                <td >老母鸡</td>
                            </tr>
                        </table>
                    </div>
                </div>

            </div>
            <!--    右边的菜谱-->
            <div id="right" style="width: 460px;height: auto;float: right">
                <div id="food_list_right_mutton">
                    <div id="food_list_right_mutton_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-right: 30px">羊肉</p>
                    </div>
                    <div id="food_list_right_mutton_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >羊肉</td>
                                <td >羊排</td>
                                <td >牛蝎子</td>
                                <td >羊腿</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div id="food_list_right_milk">
                    <div id="food_list_right_milk_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-right: 30px">奶制品</p>
                    </div>
                    <div id="food_list_right_milk_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >牛奶</td>
                                <td >奶油</td>
                                <td >奶酪</td>
                                <td >芝士</td>
                                <td >酸奶</td>
                            </tr>
                            <tr >
                                <td >黄油</td>
                                <td >奶粉</td>
                                <td >炼乳</td>
                                <td >酥油</td>
                                <td >淡奶油</td>
                            </tr>
                            <tr >
                                <td >奶油奶酪</td>
                            </tr>
                        </table>
                    </div>
                </div>

                <div id="food_list_right_duck">
                    <div id="food_list_right_duck_th">
                        <p style="padding-top: 5px;font-size: 18px;padding-right: 30px">鸭肉</p>
                    </div>
                    <div id="food_list_right_duck_class">
                        <table style="width: 460px;margin: 10px">
                            <tr >
                                <td >鸭肝</td>
                                <td >鸭肉</td>
                                <td >鸭头</td>
                                <td >鸭脖</td>
                                <td >鸭掌</td>
                            </tr>
                            <tr >
                                <td >鸭腿</td>
                                <td >鸭肠</td>
                                <td >鸭翅</td>
                                <td >野鸭</td>
                                <td >老鸭</td>
                            </tr>
                            <tr >
                                <td >鸭血</td>
                                <td >鸭胗</td>
                                <td >鸭舌</td>
                            </tr>
                        </table>
                    </div>
                </div>

            </div>

            <div id="food_list_fish">
                <div id="food_list_fish_class_th">
                    <p style="padding-top: 5px;font-size: 18px;padding-left: 30px">鱼肉</p>
                </div>
                <div id="food_list_fish_class">
                    <table style="width: 960px;margin: 10px">
                        <tr >
                            <td >鲤鱼</td>
                            <td >草鱼</td>
                            <td >武昌鱼</td>
                            <td >鲫鱼</td>
                            <td >鲈鱼</td>
                            <td >胖头鱼</td>
                            <td >鲶鱼</td>
                            <td >黑鱼</td>
                            <td >罗非鱼</td>
                            <td >鳗鱼</td>
                        </tr>
                        <tr>
                            <td >鲢鱼</td>
                            <td >青鱼</td>
                            <td >桂鱼</td>
                            <td >银鱼</td>
                            <td >鲮鱼</td>
                            <td >鲟鱼</td>
                            <td >鳟鱼</td>
                            <td >乌鱼</td>
                            <td >柴鱼</td>
                            <td >带鱼</td>
                        </tr>
                        <tr>
                            <td >三文鱼</td>
                            <td >海鱼</td>
                            <td >鳕鱼</td>
                            <td >刀鱼</td>
                            <td >鲨鱼</td>
                            <td >小黄鱼</td>
                            <td >秋刀鱼</td>
                            <td >龙利鱼</td>
                            <td >鱼排</td>
                            <td >鱼片</td>
                        </tr>
                        <tr>
                            <td >鱼骨</td>
                            <td >鱼丸</td>
                            <td >鱼皮</td>
                            <td >咸鱼</td>
                            <td >鱼头</td>
                            <td >鱼子</td>
                            <td >木鱼花</td>
                            <td >鱼肉</td>
                            <td >鱼干</td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
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
                userName:this.$store.state.userInfo.userName,
                searchValue:'',
            }
        },
        methods:{
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
                            window.sessionStorage.setItem('userInfo', JSON.stringify(_this.$store.state.userInfo));
                        } else {
                            _this.$message.error(res.data.message);
                        }
                    });
                // this.$request.post('/userDetail/static',file);
            }
        }
    }
</script>

<style scoped>
    @import "../static/css/css_foodlist.css";
</style>