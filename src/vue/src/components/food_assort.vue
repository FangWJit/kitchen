<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <!--        主体部分 -->
        <div style="padding-top: 100px;height: auto;width: 100%">
            <div style="width: 1410px;height: 300px;margin: 0 auto">
                <div style="width:960px;height: 40px;border-top: 2px solid coral;border-bottom: 2px solid coral;margin: 30px auto 10px;">
                    <ul class="nav_ul">
                        <li class="nav_li" v-for="(item,index) in assort" :key="index" @click="change(index)">{{item.value}}</li>
                    </ul>
                    <div class="act" style="display: inline-block;position: relative;width: 102px;vertical-align: middle;">
                        <p class="nav_more">浏览全部菜谱<i class="el-icon-arrow-down" style="margin: 5px;"></i></p>
                        <div id="navlist_sub"  >
                            <div>
                                <h5>主食/小吃/饮品</h5>
                                <ul>
                                    <li><a title="米饭" href="https://home.meishichina.com/recipe/mifan/" target="_blank">米饭</a></li>
                                    <li><a title="炒饭" href="https://home.meishichina.com/recipe/chaofan/" target="_blank">炒饭</a></li>
                                    <li><a title="包子" href="https://home.meishichina.com/recipe/baozi/" target="_blank">包子</a></li>
                                    <li><a title="饺子" href="https://home.meishichina.com/recipe/jiaozi/" target="_blank">饺子</a></li>
                                    <li><a title="馒头花卷" href="https://home.meishichina.com/recipe/mantou/" target="_blank">馒头花卷</a></li>
                                    <li><a title="面条" href="https://home.meishichina.com/recipe/miantiao/" target="_blank">面条</a></li>
                                    <li><a title="饼" href="https://home.meishichina.com/recipe/bing/" target="_blank">饼</a></li>
                                    <li><a title="粥" href="https://home.meishichina.com/recipe/zhou/" target="_blank">粥</a></li>
                                    <li><a title="冰品" href="https://home.meishichina.com/recipe/bingpin/" target="_blank">冰品</a></li>
                                </ul>
                            </div>
                            <div>
                                <h5>场景/饮食方式</h5>
                                <ul>
                                    <li><a title="早餐" href="https://home.meishichina.com/recipe/zaocan/" target="_blank">早餐</a></li>
                                    <li><a title="快手菜" href="https://home.meishichina.com/recipe/kuaishoucai/" target="_blank">快手菜</a></li>
                                    <li><a title="下午茶" href="https://home.meishichina.com/recipe/xiawucha/" target="_blank">下午茶</a></li>
                                    <li><a title="中式宴请" href="https://home.meishichina.com/recipe/zhongshiyanqing/" target="_blank">中式宴请</a></li>
                                    <li><a title="西式宴请" href="https://home.meishichina.com/recipe/xishiyanqing/" target="_blank">西式宴请</a></li>
                                    <li><a title="夏季食谱" href="https://home.meishichina.com/recipe/xiaji/" target="_blank">夏季食谱</a></li>
                                    <li><a title="高颜值" href="https://home.meishichina.com/recipe/gaoyanzhi/" target="_blank">高颜值</a></li>
                                    <li><a title="宿舍时代" href="https://home.meishichina.com/recipe/susheshidai/" target="_blank">宿舍时代</a></li>
                                    <li><a title="二人世界" href="https://home.meishichina.com/recipe/erren/" target="_blank">二人世界</a></li>
                                    <li><a title="儿童" href="https://home.meishichina.com/recipe/ertong/" target="_blank">儿童</a></li>
                                    <li><a title="孕妇" href="https://home.meishichina.com/recipe/yunfu/" target="_blank">孕妇</a></li>
                                    <li><a title="产妇" href="https://home.meishichina.com/recipe/chanfu/" target="_blank">产妇</a></li>
                                </ul>
                            </div>
                            <div>
                                <h5>中西菜系</h5>
                                <ul><li><a title="川菜" href="https://home.meishichina.com/recipe/chuancai/" target="_blank">川菜</a></li>
                                    <li><a title="鲁菜" href="https://home.meishichina.com/recipe/lucai/" target="_blank">鲁菜</a></li>
                                    <li><a title="闽菜" href="https://home.meishichina.com/recipe/mincai/" target="_blank">闽菜</a></li>
                                    <li><a title="粤菜" href="https://home.meishichina.com/recipe/yuecai/" target="_blank">粤菜</a></li>
                                    <li><a title="湘菜" href="https://home.meishichina.com/recipe/xiangcai/" target="_blank">湘菜</a></li>
                                    <li><a title="日料" href="https://home.meishichina.com/recipe/ribencai/" target="_blank">日料</a></li>
                                    <li><a title="韩餐" href="https://home.meishichina.com/recipe/hanguocai/" target="_blank">韩餐</a></li>
                                    <li><a title="泰国菜" href="https://home.meishichina.com/recipe/taiguocai/" target="_blank">泰国菜</a></li>
                                    <li><a title="法国菜" href="https://home.meishichina.com/recipe/faguocai/" target="_blank">法国菜</a></li>
                                </ul>
                            </div>
                            <div>
                                <h5>烘焙</h5>
                                <ul>
                                    <li><a title="面包" href="https://home.meishichina.com/recipe/mianbao/" target="_blank">面包</a></li>
                                    <li><a title="蛋糕" href="https://home.meishichina.com/recipe/dangao/" target="_blank">蛋糕</a></li>
                                    <li><a title="派塔" href="https://home.meishichina.com/recipe/paita/" target="_blank">派塔</a></li>
                                    <li><a title="吐司" href="https://home.meishichina.com/recipe/tusi/" target="_blank">吐司</a></li>
                                    <li><a title="批萨" href="https://home.meishichina.com/recipe/pisa/" target="_blank">批萨</a></li>
                                    <li><a title="慕斯" href="https://home.meishichina.com/recipe/musi/" target="_blank">慕斯</a></li>
                                    <li><a title="饼干" href="https://home.meishichina.com/recipe/binggan/" target="_blank">饼干</a></li>
                                    <li><a title="曲奇" href="https://home.meishichina.com/recipe/quqi/" target="_blank">曲奇</a></li>
                                    <li><a title="布丁" href="https://home.meishichina.com/recipe/buding/" target="_blank">布丁</a></li>
                                </ul>
                            </div>
                            <div>
                                <h5>常见菜式</h5>
                                <ul>
                                    <li><a title="热菜" href="https://home.meishichina.com/recipe/recai/" target="_blank">热菜</a></li>
                                    <li><a title="凉菜" href="https://home.meishichina.com/recipe/liangcai/" target="_blank">凉菜</a></li>
                                    <li><a title="主食" href="https://home.meishichina.com/recipe/zhushi/" target="_blank">主食</a></li>
                                    <li><a title="小吃" href="https://home.meishichina.com/recipe/xiaochi/" target="_blank">小吃</a></li>
                                    <li><a title="汤羹" href="https://home.meishichina.com/recipe/tanggeng/" target="_blank">汤羹</a></li>
                                    <li><a title="烘焙" href="https://home.meishichina.com/recipe/hongbei/" target="_blank">烘焙</a></li>
                                    <li><a title="饮品" href="https://home.meishichina.com/recipe/yinpin/" target="_blank">饮品</a></li>
                                    <li><a title="家常菜" href="https://home.meishichina.com/recipe/jiachang/" target="_blank">家常菜</a></li>
                                    <li><a title="开胃菜" href="https://home.meishichina.com/recipe/kaiweicai/" target="_blank">开胃菜</a></li>
                                </ul>
                            </div>
                            <div>
                                <h5>所有菜谱</h5>
                                <ul>
                                    <li><a title="最新发布" href="https://home.meishichina.com/recipe-list.html" target="_blank">最新发布</a></li>
                                    <li><a title="最新推荐" href="https://home.meishichina.com/recipe-list-view-elite.html" target="_blank">最新推荐</a></li>
                                    <li><a title="最热菜谱" href="https://home.meishichina.com/recipe-list-view-collection.html" target="_blank">最热菜谱</a></li>
                                    <li><a title="家常菜谱" href="https://home.meishichina.com/recipe-menu.html" target="_blank" style="color:#ff6767;">家常菜谱</a></li>
                                </ul>
                                <h5>食疗食补</h5>
                                <ul>
                                    <li><a title="补钙" href="https://www.meishichina.com/YuanLiao/gongxiao/bugai/" target="_blank">补钙</a></li>
                                    <li><a title="贫血" href="https://www.meishichina.com/YuanLiao/gongxiao/pinxue/" target="_blank">贫血</a></li>
                                    <li><a title="免疫力" href="https://www.meishichina.com/YuanLiao/gongxiao/tigaomianyili/" target="_blank">免疫力</a></li>
                                    <li><a title="养胃" href="https://www.meishichina.com/YuanLiao/gongxiao/yangwei/" target="_blank">养胃</a></li>
                                    <li><a title="对抗雾霾" href="https://www.meishichina.com/YuanLiao/gongxiao/duikangwumai/" target="_blank">对抗雾霾</a></li>
                                    <li><a title="润肺止咳" href="https://www.meishichina.com/YuanLiao/gongxiao/runfeizhike/" target="_blank">润肺止咳</a></li>
                                    <li><a title="滋阴" href="https://www.meishichina.com/YuanLiao/gongxiao/ziyin/" target="_blank">滋阴</a></li>
                                    <li><a title="壮阳" href="https://www.meishichina.com/YuanLiao/gongxiao/zhuangyang/" target="_blank">壮阳</a></li>
                                    <li><a title="失眠" href="https://www.meishichina.com/YuanLiao/gongxiao/shimian/" target="_blank">失眠</a></li>
                                    <li><a title="养颜" href="https://www.meishichina.com/YuanLiao/gongxiao/yangyan/" target="_blank">养颜</a></li>
                                    <li><a title="排毒" href="https://www.meishichina.com/YuanLiao/gongxiao/paidu/" target="_blank">排毒</a></li>
                                    <li><a title="便秘" href="https://www.meishichina.com/YuanLiao/gongxiao/bianmi/" target="_blank">便秘</a></li>
                                    <li><a title="瘦身" href="https://www.meishichina.com/YuanLiao/gongxiao/shoushen/" target="_blank">瘦身</a></li>
                                    <li><a title="丰胸" href="https://www.meishichina.com/YuanLiao/gongxiao/fengxiong/" target="_blank">丰胸</a></li>
                                    <li><a title="痛经" href="https://www.meishichina.com/YuanLiao/gongxiao/tongjing/" target="_blank">痛经</a></li>
                                    <li><a title="月经不调" href="https://www.meishichina.com/YuanLiao/gongxiao/yuejingbutiao/" target="_blank">月经不调</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="image_card" >
                    <img :src="images[imgIndex].aimage" />
                </div>
                <div class="zhicheng">
                    <div class="food_card" >
                        <p style="margin-top: 10px;color: coral;font-size: 20px">- {{assort[assortIndex].value}} -</p>
                        <el-card style="margin: 10px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)" v-for="(item,index) in foodList" :key="index" v-show="index < maxnumber ">
                            <div style="margin:-10px 0" @click="info(item.meauId)">
                                <img :src="item.img" style="width: 80px;height: 80px;margin-right: 10px;margin-bottom: -4px;"></img>
                                <h2 style="font-size: 20px;display: inline;position: absolute;">{{item.name}}</h2>
                                <p style="color: red;font-size: 18px;">{{item.likecount}}糖</p>
                                <p style="font-size: 13px;display: block">{{item.tags}}</p>
                            </div>
                        </el-card>
                        <div style="width:900px;line-height: 10px" >
                            <p class="more" @click="maxnumber += 10" v-show="maxnumber < foodList.length" style="margin: 5px;text-align: center;font-size: 10px;width: 900px">显示更多...
                                <i class="el-icon-arrow-down" style="display: block;margin: 5px;"></i>
                            </p>
                        </div>
                        <div style="width:900px;line-height: 10px" >
                            <p class="more" @click="maxnumber = 10" v-show="maxnumber >= foodList.length && foodList.length!=0" style="margin: 10px;text-align: center;font-size: 10px;width: 900px">
                                <i class="el-icon-arrow-up" style="display: block;margin: 5px;"></i>
                                收起更多...
                            </p>
                        </div>
                    </div>
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
                backgroudimage: require('../static/img/背景8.png'),
                userName:'',
                assort:[
                    {value:'热菜'},
                    {value:'凉菜'},
                    {value:'汤羹'},
                    {value:'主食'},
                    {value:'小吃'},
                    {value:'西餐'},
                    {value:'烘焙'},
                    {value:'饮品'},
                    {value:'零食'},
                    {value:'炮酱腌菜'},
                    {value:'自制食材'},
                ],
                images:[
                    {aimage:'https://static.meishichina.com/img/banner/1.jpg'},
                    {aimage:'https://static.meishichina.com/img/banner/2.jpg'},
                    {aimage:'https://static.meishichina.com/img/banner/3.jpg'},
                    {aimage:'https://static.meishichina.com/img/banner/4.jpg'},
                ],
                assortIndex:0,
                imgIndex:0,
                foodList:[],
                maxnumber:10,
            }
        },
        mounted() {
            this.init();
            console.log(this.$store.state.pageIndex);
        },
        methods:{
            init(){
                let _this = this;
                this.userName=this.$store.state.userInfo.userName;
                // 默认第一个为选中状态
                let li = document.getElementsByClassName('nav_li');
                li[0].className += ' c';
                // 发起请求
                _this.$request.get('/search/selectFood?value='+this.assort[0].value)
                    .then( res => {
                        if (res.data.code === '200') {
                            _this.foodList = res.data.data;
                        } else {
                            _this.$message.error(res.data.msg);
                        }
                    });
            },
            // 改变选中状态的 li 样式 及  下面内容
            change(index){
                this.assortIndex = index;
                let _this = this;
                let li = document.getElementsByClassName('nav_li');
                let className = li[index].className;
                if (className.indexOf('c') == -1 ){
                    for(let i=0;i<li.length;i++){
                        if (i == index) {
                            li[i].className += ' c';
                        } else {
                            li[i].className = className;
                        }
                    }
                }
                // 获取随机数 随机获取导航栏下面的图片地址
                this.imgIndex = parseInt(Math.random()*(4),10);
                // 发起请求
                _this.$request.get('/search/selectFood?value='+this.assort[index].value)
                    .then( res => {
                        if (res.data.code === '200') {
                            // 改变数据
                            _this.foodList = [];
                            _this.foodList = res.data.data;
                        } else {
                            _this.$message.error(res.data.msg);
                        }
                    });
            },
            info(meauId) {
                let url = this.$router.resolve({path:'/foodDetails',query:{meauId}});
                window.open(url.href,'_blank');
            },
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
    /* 图片效果*/
    .image_card{
        width: 960px;
        height: 100px;
        margin: 0 auto;
    }
    .zhicheng {
        width: 960px;
        height: 500px;
        margin: 0 auto;
    }
    /* 食谱卡片 */
    .food_card {
        width: 960px;
        height: auto;
        margin: 0 auto;
    }
    .act:hover #navlist_sub {
        display: block;
    }
    .act:hover .nav_more {
        color: coral;
    }
    /* 更多分类 */
    .nav_more {
        float: right;
        font-size: 13px;
        line-height: 40px;
    }
    /* 更多分类详情 */
    #navlist_sub {
        background: #fff;
        width: 960px;
        position: absolute;
        z-index: 99;
        box-shadow: 0 2px 3px #ddd;
        overflow: hidden;
        margin-top: 42px;
        margin-left: -850px;
        font-size: 10px;
        display: none;
    }
    #navlist_sub div {
        float: left;
        width: 15%;
        margin: 0 .8%;
        padding: 0 0 10px;
    }
    #navlist_sub h5 {
        padding: 15px 3px 0;
        width: 100%;
        font-weight: 700;
        clear: both;
    }
    #navlist_sub ul {
        float: left;
        width: 100%;
        margin: 0 0 10px;
        display: inline-block;
    }
    #navlist_sub li {
        line-height: 160%;
        width: 47%;
        /*display: inline;*/
        list-style-type: none;
        padding: 0;
    }

</style>