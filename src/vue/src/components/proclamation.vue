<template>
    <div>
        <div class="background">
            <img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
        </div>
        <div style="padding-top: 50px;width: 1410px">
            <div style="width: 960px;margin: 10px auto">
                <el-carousel :interval="4000" type="card" height="300px">
                    <el-carousel-item v-for="item in imgs" :key="item">
                        <img :src="item">
                    </el-carousel-item>
                </el-carousel>
            </div>

            <div class="block" style="width: 980px;margin: 50px auto;background-color: rgba(255, 255, 255, 0.5);padding: 40px">
                <el-timeline>
                    <el-timeline-item style="margin-left: 10px" v-for="item in node" :timestamp="item.time" placement="top" >
                        <el-card>
                            <h4>{{item.nodeContent}}</h4>
                            <p>{{'系统管理员 提交于'+item.createTime}}</p>
                        </el-card>
                    </el-timeline-item>
                </el-timeline>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "proclamation",
        data() {
            return {
                backgroudimage: require('../static/img/背景8.png'),
                imgs:[
                    require('../static/img/Charcoal Grill 木炭烧烤香肠.jpg'),
                    require('../static/img/东坡肉.jpg'),
                    require('../static/img/肉末茄子.jpg')
                ],
                node:[],
            }
        },
        mounted() {
            this.init();
        },
        methods:{
            init() {
                this.$request.get('/node/getNodes').then( res => {
                    if (res.data.code === '200') {
                        this.node = res.data.data;
                        this.node.forEach( item => {
                            item.createTime = this.$moment(item.createTime).format('yyyy-MM-DD HH:mm:ss');
                            item.time = this.$moment(item.createTime).format('yyyy-MM-DD')
                        })
                    } else {
                        this.$message.error(res.data.message);
                    }
                })
            },
        }
    }
</script>

<style>

</style>