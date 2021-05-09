<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>

        <div class="body">
            <div class="info_user">
                <p style="font-size: 10px;margin-left:5px">厨友名片</p>
                <img :src="url" class="own_photo" />
                <div class="own_name">
                    {{foodDetails.userName}}
                </div>
                <div  style="float: right;margin-top: 5px;margin-right: 5px">
                    <el-button  type="text"  >+ 关注</el-button>
    <!--                <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="ans.attention == 1" @click="trans(ans.userId,ans.attention)">√ 已关注</el-button>-->
    <!--                <el-button style="float: right; padding: 3px 0;color:coral" type="text" v-if="ans.attention == 2" @click="trans(ans.userId,ans.attention)">⇄ 互相关注</el-button>-->
                </div>
            </div>
    <!--    导航 -->
            <div class="navigation">
                <h2 style="color: coral;margin:10px">菜单导航</h2>
                <div class="button_war">
                    <button class="button_aaa"  @click="goto('#food_qu')">基本信息<i class="el-icon-arrow-right el-icon--right"></i></button>
                    <button class="button_aaa"  @click="goto('#zhu_liao')">主料<i class="el-icon-arrow-right el-icon--right"></i></button>
                    <button class="button_aaa"  @click="goto('#pei_liao')">配料<i class="el-icon-arrow-right el-icon--right"></i></button>
                    <button class="button_aaa"  @click="goto('#step')">步骤<i class="el-icon-arrow-right el-icon--right"></i></button>
                    <button class="button_aaa"  @click="goto('')">评论<i class="el-icon-arrow-right el-icon--right"></i></button>
                </div>
            </div>
    <!--    菜品基本信息   -->
            <div class="food_qu" id="food_qu">
                <el-image
                        style="width: 170px; height: 260px;float: left;border-radius: 4px;"
                        :src="foodDetails.img"
                        :preview-src-list="srcList">
                    <div slot="placeholder" class="image-slot">
                        加载中<span class="dot">...</span>
                    </div>
                </el-image>
                <!-- 基本信息  -->
                <div class="top_card">
                    <div class="food_name">
                        {{foodDetails.name}}
                    </div>

                    <div class="food_tags">
                        功效：{{foodDetails.tags}}
                    </div>

                    <div class="food_method">
                        烹饪方式：{{foodDetails.method}}
                    </div>

                    <div class="food_level">
                        等级：{{foodDetails.level}}
                    </div>

                    <div class="food_peopleNum">
                        份量：{{foodDetails.peopleNum}}
                    </div>

                    <div class="food_taste">
                        口味：{{foodDetails.taste}}
                    </div>

                    <div class="food_prepareTime">
                        准备时间：{{foodDetails.prepareTime}}
                    </div>

                    <div class="food_cookTime">
                        烹饪时间：{{foodDetails.cookTime}}
                    </div>

                </div>
    <!-- 动态信息 -->
                <div class="dynamic">
                    <div class="create_time">
                        {{foodDetails.createTime}}
                    </div>
                    <div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img v-if="shoucang == false" src="../static/image/foodDetails/收藏1.png" class="dy" />
                            <img v-if="shoucang == true" src="../static/image/foodDetails/收藏2.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                {{foodDetails.likecount}}
                            </div>
                            <img v-if="dianzan == false" src="../static/image/foodDetails/点赞1.png" class="dy" />
                            <img v-if="dianzan == true" src="../static/image/foodDetails/点赞2.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                9999W
                            </div>
                            <img src="../static/image/foodDetails/评论1.png" class="dy" />
                        </div>
                        <div>
                            <div v-if="show" class="number" />
                            <div v-else class="numbers" >
                                {{foodDetails.readcount}}
                            </div>
                            <img src="../static/image/foodDetails/查看.png" class="dy" />
                        </div>
                    </div>
                </div>

            </div>
    <!--        主料   -->
            <div class="pei_liao" id="zhu_liao">
                <p>主料</p>
                <img class="icon_img" src="../static/image/foodDetails/配料.png">
                <el-divider />
                <el-tag class="pei" v-for="(item,index) in foodDetails.mainIngredient" type="success">{{item.name+" - "+item.weight}}</el-tag>
            </div>
    <!--        配料   -->
            <div class="pei_liao" id="pei_liao">
                <p>配料</p>
                <img class="icon_img" src="../static/image/foodDetails/配料.png">
                <el-divider />
                <el-tag class="pei" v-for="(item,index) in foodDetails.accessories" type="success">{{item.name+item.weight}}</el-tag>
            </div>
    <!-- 步骤 -->
            <div class="step" id="step">
                <p>步骤</p>
                <img class="icon_img" src="../static/image/foodDetails/步骤.png">
                <el-divider />
                <div style="width: 750px;height: auto;margin: 0 auto">
                    <div v-for="(item,index) in foodDetails.measure">
                        <div v-for="(item1,index) in item.picture" style="width: 600px;height: 300px;margin: 0 auto">
                            <img :src="item1" />
                        </div>
                        <div style="width: 600px;height: 50px;margin: 10px auto">
                            {{item.step+item.des}}
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "foodDetails",
        data (){
            return{
                backgroudimage: require('../static/image/背景8.png'),
                eunm:'食品详情页',
                userName:'',
                url: require("../static/image/肉末茄子.jpg"),
                srcList: [
                    require("../static/image/肉末茄子.jpg"),
                    'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
                ],
                message:'这是一段很长很长很长的描述性文字11111',
                shoucang:true,
                dianzan:true,
                show:false,
                foodDetails:{
                    meauId:'',
                    userId:'',
                    userName:'',
                    name:'',
                    tags:'',
                    method:'',
                    img:'',
                    level:'',
                    peopleNum:'',
                    taste:'',
                    prepareTime:'',
                    cookTime:'',
                    mainIngredient:[
                        {
                            name:'',
                            imgUrl:'',
                            weight:''
                        }
                    ],
                    accessories:[{
                        name:'',
                        weight:''
                    }],
                    measure:[
                        {
                            picture: [],
                            step: '',
                            des: ''
                        }
                    ],
                    techniques:'',
                    createTime:'',
                    readcount:'',
                    likecount:''
                }

            }
        },
        mounted() {
            this.init();
        },
        created() {
            this.foodDetails.meauId = this.$route.query.meauId;
        },
        methods:{
            init(){
                let _this = this;
                this.$request.get('/foodList/getFoodDetail/'+_this.foodDetails.meauId).then(
                    res => {
                        if (res.data.code == '200') {
                            _this.foodDetails = res.data.data;
                            console.log(_this.foodDetails);
                        }
                    }
                );
            },
            goto(id) {
                document.querySelector(id).scrollIntoView(true);
            }
        }
    }
</script>

<style>


</style>