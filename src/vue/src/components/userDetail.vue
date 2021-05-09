<template>
	<div>
		<div class="background">
			<img :src="backgroudimage" width="100%" height="100%" alt="厨阁" />
		</div>
		<div class="bobo">
			<el-collapse v-model="activeNames" @change="handleChange" style="padding:0 20px;background-color:white;border-radius: 4px">
				<el-collapse-item title="基本信息" name="1" >
					<div class="info">

						<table class="table_info" >
							<tr>
								<td>姓名：</td>
								<td v-show="!xiugai" style="color:coral;" v-if="user.userName != null">{{user.userName}}</td>
								<td v-show="!xiugai" style="color:#c0c4cc;" v-else>待完善</td>
								<td v-show="xiugai"><el-input v-model="tempUser.userName"/></td>
								<td v-show="!xiugai" v-if="userId == $store.state.userInfo.id"><i class="el-icon-edit" @click="changeInfo"></i></td>
							</tr>
							<tr>
								<td>电话：</td>
								<td v-show="!xiugai" style="color:coral;" v-if="user.userPhone != null">{{user.userPhone}}</td>
								<td v-show="!xiugai" style="color:#c0c4cc;" v-else>待完善</td>
								<td v-show="xiugai"><el-input v-model="tempUser.userPhone"  readonly/></td>
								<td v-show="!xiugai" v-if="userId == $store.state.userInfo.id"><i class="el-icon-edit" @click="changeInfo"></i></td>
							</tr>
							<tr>
								<td>年龄：</td>
								<td v-show="!xiugai" style="color:coral;" v-if="user.age != null">{{user.age}}</td>
								<td v-show="!xiugai" style="color:#c0c4cc;" v-else>待完善</td>
								<td v-show="xiugai"><el-input v-model="tempUser.age"/></td>
								<td v-show="!xiugai" v-if="userId == $store.state.userInfo.id"><i class="el-icon-edit" @click="changeInfo"></i></td>
							</tr>
							<tr>
								<td>性别：</td>
								<td v-show="!xiugai" style="color:coral;" v-if="user.sex != null">{{user.sex}}</td>
								<td v-show="!xiugai" style="color:#c0c4cc;" v-else>待完善</td>
								<td v-show="xiugai"><el-input v-model="tempUser.sex"/></td>
								<td v-show="!xiugai" v-if="userId == $store.state.userInfo.id"><i class="el-icon-edit" @click="changeInfo"></i></td>
							</tr>
							<tr v-show="xiugai">
								<td><el-button style="height: 30px;line-height: 5px;font-size: 12px" @click="cancelChange">取消</el-button></td>
								<td><el-button style="height: 30px;line-height: 5px;font-size: 12px" type="primary" @click="sendChange">确认</el-button></td>
							</tr>
						</table>
						<div class="pro_left">
							<img :src="user.userPhoto" class="pro_photo" />
							<div style="text-align: center;">
								<span style="color:coral;">粉丝：{{user.fans}}</span>
								|
								<span style="color:coral;">关注：{{user.noricer}}</span>
							</div>
						</div>
					</div>
				</el-collapse-item>
				<el-collapse-item title="作品集" name="2">
					<div class="works">
						<el-row>
							<div v-if="userWorks[0].foodId != '' ">
								<div style="width: 100%;font-size: 18px;margin-left: 20px;margin-top:10px">文章</div>
								<el-divider />
								<div class="tag_css">
									<div class="word" v-for="(item,index) in userWords" :key="index" v-show="index<list0">
										<div class="title" @click="lookWord(item.wordId)">{{item.wordTitle}}</div>
										<div  class="delete" @click="deleteWord(item.wordId,index)">删除</div>
										<div class="create_time">{{item.createTime}}</div>
										<div class="read_count"><i class="el-icon-view" style="margin-right: 5px"/>{{item.readCount}}</div>
									</div>
									<div style="width:900px;line-height: 10px" >
										<p class="more" @click="list0 += 4" v-show="list0 < userWords.length" style="margin: 15px;text-align: right;font-size: 10px;width: 400px;">
											显示更多...
											<i class="el-icon-arrow-down" style="display: inline-block;margin: 5px;"></i>
										</p>
										<p v-show="list0 >= userWords.length" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;color: #c0c4cc;">
											没有更多了
										</p>
										<p class="more" @click="list0 = 4" v-show="list0 > 4" style="margin: 15px;text-align: left;font-size: 10px;width: 400px;">
											收起更多...
											<i class="el-icon-arrow-up" style="display: inline-block;margin: 5px;"></i>
										</p>
									</div>
								</div>
								<div style="width: 100%;font-size: 18px;margin-left: 20px;margin-top:10px">菜谱</div>
								<el-divider />
								<el-col :span="5" v-for="(o, index) in userWorks" :key="index" :offset="index > 0 ? 1 : 0" class="oneCard" v-show="index < list1">
									<el-card class="foodname"  shadow="hover" :body-style="{ padding: '0px' }">
										<img :src="o.foodPhoto" class="image">
										<div  style="padding: 10px;font-size: 16px" @click="info(o.foodId)">
											<span>{{o.foodName.substr(0,8)}}</span>
											<span v-if="o.foodName.length > 8">...</span>
										</div>
									</el-card>
								</el-col>
								<div style="width:900px;line-height: 10px" >
									<p class="more" @click="list1 += 4" v-show="list1 < userWorks.length" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;">
										显示更多...
										<i class="el-icon-arrow-down" style="display: inline-block;margin: 5px;"></i>
									</p>
									<p v-show="list1 >= userWorks.length" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;color: #c0c4cc;">
										没有更多了
									</p>
									<p class="more" @click="list1 = 4" v-show="list1 > 4" style="margin: 10px;text-align: left;font-size: 10px;width: 400px;">
										收起更多...
										<i class="el-icon-arrow-up" style="display: inline-block;margin: 5px;"></i>
									</p>
								</div>
							</div>
							<div v-else style="padding: 50px 0 50px 0;width:900px;text-align: center;font-size: 16px;color: #c0c4cc">
								还没有发布任何作品!!!
							</div>
						</el-row>
					</div>
				</el-collapse-item>
				<el-collapse-item title="收藏夹" name="3" v-if="userId == $store.state.userInfo.id">
					<div class="works">
						<el-row>
							<el-col :span="5" v-for="(o, index) in 10" :key="o" :offset="index > 0 ? 1 : 0" class="oneCard" v-show="index < list2">
								<el-card shadow="hover" :body-style="{ padding: '0px' }">
									<img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
									<div style="padding: 14px;">
										<span>好吃的汉堡</span>
									</div>
								</el-card>
							</el-col>
							<div style="width:900px;line-height: 10px" >
								<p class="more" @click="list2 += 4" v-show="list2 < 10" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;">
									显示更多...
									<i class="el-icon-arrow-down" style="display: inline-block;margin: 5px;"></i>
								</p>
								<p v-show="list2 >= 10" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;color: #c0c4cc;">
									没有更多了
								</p>
								<p class="more" @click="list2 = 4" v-show="list2 > 4" style="margin: 10px;text-align: left;font-size: 10px;width: 400px;">
									收起更多...
									<i class="el-icon-arrow-up" style="display: inline-block;margin: 5px;"></i>
								</p>
							</div>
						</el-row>
					</div>
				</el-collapse-item>
				<el-collapse-item title="历史查看" name="4" v-if="userId == $store.state.userInfo.id">
					<div class="works">
						<el-row>
							<el-col :span="5" v-for="(o, index) in 18" :key="o" :offset="index > 0 ? 1 : 0" class="oneCard" v-show="index < list3">
								<el-card shadow="hover" :body-style="{ padding: '0px' }">
									<img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
									<div style="padding: 14px;">
										<span>好吃的汉堡</span>
										<div class="bottom clearfix">
											<el-button type="text" class="button">查看做法</el-button>
										</div>
									</div>
								</el-card>
							</el-col>
							<div style="width:900px;line-height: 10px" >
								<p class="more" @click="list3 += 4" v-show="list3 < 10" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;">
									显示更多...
									<i class="el-icon-arrow-down" style="display: inline-block;margin: 5px;"></i>
								</p>
								<p v-show="list3 >= 10" style="margin: 5px;text-align: right;font-size: 10px;width: 400px;color: #c0c4cc;">
									没有更多了
								</p>
								<p class="more" @click="list3 = 4" v-show="list3 > 4" style="margin: 10px;text-align: left;font-size: 10px;width: 400px;">
									收起更多...
									<i class="el-icon-arrow-up" style="display: inline-block;margin: 5px;"></i>
								</p>
							</div>
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
				selectId: this.$store.state.userInfo.userPhoto.substr(46,1), // 选择头像的序列id
				lookPhoto: '',
				outerVisible: false,
				userName:'',
				userPhoto: this.$store.state.userInfo.userPhoto,
				searchValue: '',
				backgroudimage: require('../static/img/背景8.png'),
				list0:4,
				list1:4,
				list2:4,
				list3:4,
				activeNames: ['1','2'],
				user:{
					userName:'',
					userPhone:'',
					userPhoto:'',
					age:0,
					fans:0,
					noricer:0,
					notesNum:0,
					tuckNum:0,
					sex:''
				},
				tempUser:{
					userName:'',
					userPhone:'',
					userPhoto:'',
					age:0,
					fans:0,
					noricer:0,
					notesNum:0,
					tuckNum:0,
					sex:''
				},
				userWorks:[
					{
						foodId:'',
						foodPhoto:'',
						foodName:''
					}
				],
				userWords:[],
				userId:'',
				xiugai:false
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
				let _this = this;
				this.userName = this.$store.state.userInfo.userName;
				this.$request.get('/userDetail/getWorks?userId='+ this.userId)
						.then( res => {
							if (res.data.code === '200') {
								_this.userWorks = res.data.data.FoodList;
								_this.userWords = res.data.data.userWordList;
								_this.userWords.forEach( item => {
									item.createTime = this.$moment(item.createTime).format("yyyy-MM-DD HH:mm:ss");
								})
							}
						});
				this.$request.get('/userDetail/getDetail?userId=' + this.userId)
						.then(res => {
									if (res.data.code == '200') {
										_this.user = res.data.data;
									} else {
										localStorage.removeItem('Authorization');
										_this.$router.push({path: 'login'});
									}
								},
								fail => {
									localStorage.removeItem('Authorization');
									_this.$router.push({path: 'login'});
								});
			},
			// 查看菜谱
			info(meauId) {
				console.log(meauId);
				let url = this.$router.resolve({path:'/foodDetails',query:{meauId}});
				window.open(url.href,'_blank');
			},
			changeInfo() {
				this.tempUser = this.user;
				this.xiugai = true;
			},
			// 取消修改
			cancelChange() {
				let userInfo = this.$store.state.userInfo;
				this.user.userName = userInfo.userName;
				this.user.age = userInfo.age;
				this.user.userPhone = userInfo.userPhone;
				this.user.userPhoto = userInfo.userPhoto;
				this.user.fans = userInfo.fans;
				this.user.noricer = userInfo.noricer;
				this.user.tuckNum = userInfo.tuckNum;
				this.user.notesNum = userInfo.notesNum ;
				this.user.sex = userInfo.sex;
				this.xiugai = false;
				this.$message.warning("取消修改");
			},
			// 确认修改
			sendChange() {
				this.user = this.tempUser;
				this.xiugai = false;
				let _this = this;
				let userDetail = this.user;
				this.$request.post('/userDetail/updateUser',userDetail).then( res => {
					if (res.data.code === '200') {
						_this.$message.success("修改成功");
					}else {
						_this.$message.error(res.data.message);
						_this.user.userName = userInfo.userName;
						_this.user.age = userInfo.age;
						_this.user.userPhone = userInfo.userPhone;
						_this.user.userPhoto = userInfo.userPhoto;
						_this.user.fans = userInfo.fans;
						_this.user.noricer = userInfo.noricer;
						_this.user.tuckNum = userInfo.tuckNum;
						_this.user.notesNum = userInfo.notesNum ;
						_this.user.sex = userInfo.sex;
					}
				})

			},
			// 查看文章
			lookWord(wordId){
				this.$router.push({path:'/word',query:{wordId}});
			},
			// 删除文章
			deleteWord(wordId,index) {
				let _this = this;
				this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning',
					beforeClose:function(action, instance, done) {
						if (action === 'confirm') {
							_this.$request.get('/word/deleteWord?wordId='+wordId).then(res => {
								if (res.data.code === '200') {
									_this.userWords.splice(index,1);
								} else {
									_this.$message.error(res.data.message);
								}
							});
							done();
						}
					}
				}).then(() => {
					this.$message({
						type: 'success',
						message: '删除成功!'
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			}
		}
	}
</script>

<style>
	@import url("../static/css/css_detail.css");
	.bobo{
		max-width: 900px;
		margin:0 auto;
		height: auto;
		padding:80px 10px 10px 10px;

	}
	.tag_css{
		margin: 25px auto;
		max-width:800px;
		height: auto;
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
	}
	.el_tag{
        display: inline-block;
		margin: 10px 10px;
	}
	.works{
		max-width: 900px;
		height: auto;
		margin: 10px auto;
		box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
	}
	.time {
		font-size: 13px;
		color: #999;
	}

	.bottom {
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
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
	}
	.oneCard:hover{
		animation: shake 0.7s cubic-bezier(.36, .07, .19, .97) both;
		transform: translate3d(0, 0, 0);
		backface-visibility: hidden;
		perspective: 1000px;
	}


	.el-col-offset-0,.oneCard.el-col.el-col-5.el-col-offset-1 {
		margin-left: 3.16667%;
	}

	.word {
		width: 600px;
		height: 60px;
		margin: 0 auto;
		padding: 20px 0 0 20px;
		background-color: rgba(255,255,255,0.7);
	}
	.word .title {
		width: 400px;
		height: 40px;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
		line-height: 40px;
		margin-left: 10px;
		font-size: 20px;
		display: inline-block;
		color: #605f5f;
		vertical-align: middle;
	}
	.word .title:hover {
		color: coral;
	}
	.delete {
		display: inline-block;
		color: #f57676;
		font-size: 16px;
		width: 50px;
		float: right;
		vertical-align: middle;
	}
	.delete:hover {
		color: red;
	}
	.update {
		display: inline-block;
		color: #5656ec;
		font-size: 16px;
		width: 50px;
		float: right;
		vertical-align: middle;
	}
	.update:hover {
		color: blue;
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

	.more:hover {
		color: #c0c4cc;
	}

	.foodname:hover {
		color: coral;
	}


</style>
