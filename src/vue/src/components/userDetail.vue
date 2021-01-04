<template>
	<div>
		<div id="top">
			<div id="top_logo">
				<img src="../static/image/厨阁.png" style="width: 50px;height:50px;float: left">
				<span style="font-size: 30px;">厨阁</span>
			</div>
			<div id="top_search">
				<form>
					<div id="top_search_input">
						<div id="FDJ"><img src="../static/image/搜索.png" /></div>
						<input type="text" id="top_search_input_Text" />
						<button style="margin-left:13px;height: 42px;width: 80px;position:absolute;border:0
		    ;background: coral;margin-top: -1px;border-radius: 3px;float: right;
		    font-family: 隶书;font-size: 20px">搜索</button>
					</div>
				</form>
			</div>
			<div id="top_list">
				<ul>
					<a href="#">
						<li>上传</li>
					</a>
					<a @click="$router.push({path:'/food_question'})" href="">
						<li>提问</li>
					</a>
					<a @click="$router.push({path:'/detail',query:{userId:$store.state.userInfo.id}})" v-if="username != null || username != ''" href="">
						<li style="font-size: 20px;color: coral">{{username}}</li>
					</a>
					<a href="" v-else-if="username == null || username == '' ">
						<li>请先登录</li>
					</a>
					<a href="" @click="loginout()">
						<li>退出</li>
					</a>
				</ul>
			</div>

		</div>

		<div id="Navigation">
			<div id="Navigation_body">
				<ul>
					<a class="Navigation" @click="$router.push({path:'/index'})" href=""><li class="na_li"> 首页</li></a>
					<a class="Navigation" @click="$router.push({path:'/foodlist'})"  href="" ><li class="na_li">菜谱大全</li></a>
					<a class="Navigation" @click="$router.push({path:'/foodlist2'})"  href=""><li class="na_li">家常菜谱</li></a>
					<a class="Navigation" @click="$router.push({path:'/food_question'})"  href=""><li class="na_li">美食问答</li></a>
					<a class="Navigation"  href=""><li class="na_li">食谱分类</li></a>
					<a class="Navigation"  href=""><li class="na_li">健康食疗</li></a>
					<a class="Navigation"  href=""><li class="na_li">厨友排行</li></a>
					<a class="Navigation" @click="$router.push({path:'/proclamation'})" href=""><li class="na_li">公告</li></a>
				</ul>

			</div>
		</div>
		<div class="bobo">
			<el-collapse v-model="activeNames" @change="handleChange">
				<el-collapse-item title="基本信息" name="1" >
					<div class="info">
						<table class="table_info" >
							<tr>
								<td>姓名：</td>
								<td>{{user.username}}</td>
							</tr>
							<tr>
								<td>电话：</td>
								<td>{{user.userphone}}</td>
							</tr>
							<tr>
								<td>年龄：</td>
								<td>{{user.userage}}</td>
							</tr>
						</table>
						<div class="pro_left">
							<img :src="user.userphoto" class="pro_photo" />
							<div style="text-align: center;">
								<span>粉丝：{{user.fans}}</span>
								|
								<span>关注：{{user.noricer}}</span>
							</div>
						</div>
					</div>
				</el-collapse-item>
				<el-collapse-item title="作品集" name="2">
					<div class="tag_css">
						<div class="el_tag">
							<el-tag >家常</el-tag>
						</div>
						<div class="el_tag">
							<el-tag type="success">爆炒</el-tag>
						</div>
						<div class="el_tag">
							<el-tag type="info">甜品</el-tag>
						</div>
						<div class="el_tag">
							<el-tag type="warning">饮品</el-tag>
						</div>
						<div class="el_tag">
							<el-tag type="danger">煲汤</el-tag>
						</div>
					</div>

					<div class="works">
						<el-row>
							<el-col :span="5" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0" class="oneCard">
								<el-card shadow="hover" :body-style="{ padding: '0px' }">
									<img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
									<div style="padding: 14px;">
										<span>好吃的汉堡</span>
										<div class="bottom clearfix">
											<time class="time">{{ currentDate }}</time>
											<el-button type="text" class="button">查看做法</el-button>
										</div>
									</div>
								</el-card>
							</el-col>
						</el-row>
					</div>
				</el-collapse-item>
				<el-collapse-item title="收藏夹" name="3" v-if="userId == $store.state.userInfo.id">
					<div class="works">
						<el-row>
							<el-col :span="5" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0" class="oneCard">
								<el-card shadow="hover" :body-style="{ padding: '0px' }">
									<img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
									<div style="padding: 14px;">
										<span>好吃的汉堡</span>
										<div class="bottom clearfix">
											<time class="time">{{ currentDate }}</time>
											<el-button type="text" class="button">查看做法</el-button>
										</div>
									</div>
								</el-card>
							</el-col>
						</el-row>
					</div>
				</el-collapse-item>
				<el-collapse-item title="历史查看" name="4" v-if="userId == $store.state.userInfo.id">
					<div class="works">
						<el-row>
							<el-col :span="5" v-for="(o, index) in 4" :key="o" :offset="index > 0 ? 1 : 0" class="oneCard">
								<el-card shadow="hover" :body-style="{ padding: '0px' }">
									<img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
									<div style="padding: 14px;">
										<span>好吃的汉堡</span>
										<div class="bottom clearfix">
											<time class="time">{{ currentDate }}</time>
											<el-button type="text" class="button">查看做法</el-button>
										</div>
									</div>
								</el-card>
							</el-col>
						</el-row>
					</div>
				</el-collapse-item>
			</el-collapse>
		</div>
	</div>
</template>

<script>
	export default {
		data (){
			return {
				currentDate: new Date(),
				activeNames: ['1','2','3','4'],
				username:'',
				user:{
					username:'',
					userphone:'',
					userphoto:'',
					userage:0,
					fans:0,
					noricer:0,
					notesnum:0,
					tucknum:0,
					sex:''
				},
				userId:''
			}
		},
		mounted() {
			this.init();
		},
		created() {
			this.userId = this.$route.query.userId;
		},
		methods:{
			handleChange(val) {
				console.log(val);
			},
			init(){
				this.username = this.$store.state.userInfo.userName;
				let _this = this;
				this.$request.get('/userDetail/getDetail?userId='+this.userId)
				.then( res => {
					let userInfo = res.data.data;
					_this.user.username = userInfo.userName;
					_this.user.userage = userInfo.age;
					_this.user.userphone = userInfo.userPhone;
					_this.user.userphoto = require('../static/image/'+userInfo.userPhoto);
					_this.user.fans = userInfo.fans;
					_this.user.noricer = userInfo.noricer;
					_this.user.tucknum = userInfo.tuckNum;
					_this.user.notesnum = userInfo.notesNum ;
					_this.user.sex = userInfo.sex;
				})
			},
			loginout(){
				localStorage.removeItem('Authorization');
				this.$store.state.userInfo = '';
				this.$router.push({path:'/login'})
			}
		}
	}
</script>

<style>
	@import url("../static/css/css_detail.css");
	.bobo{
		max-width: 900px;
		margin:10px auto;
	}
	.tag_css{
		margin: 25px auto;
		max-width:850px;
		height: 55px;
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
	}
	.el_tag{
        display: inline-block;
		margin: 10px 10px;
	}
	.works{
		max-width: 850px;
		height: auto;
		margin: 10px auto;
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
	}
	.time {
		font-size: 13px;
		color: #999;
	}

	.bottom {
		margin-top: 13px;
		line-height: 12px;
	}

	.button {
		padding: 0;
		float: right;
	}

	.image {
		width: 90%;
		display: block;
		margin: auto;
		margin-top: 10px;
		border-radius: 4px;
	}

	.clearfix:before,
	.clearfix:after {
		display: table;
		content: "";
	}

	.clearfix:after {
		clear: both
	}

	.oneCard{
		margin: 20px auto;
	}
	.el-col-offset-0{
		margin-left: 17px;
	}
</style>
