<template>
	<div class="main-containers">
		<div class="top-container" :style='{"margin":"0 auto","overflow":"hidden","alignItems":"center","background":"none","display":"flex","width":"1200px","position":"relative","justifyContent":"space-between","height":"64px","zIndex":"1002"}'>
			<img v-if='false' :style='{"width":"15%","boxShadow":"10px  0  rgba(245, 245, 245,.5)","objectFit":"cover","borderRadius":"0","display":"block","height":"100%"}' src='http://codegen.caihongy.cn/20221021/5f27920058a1472eb34bcc63283b3a97.png'>
			<div v-if="true" :style='{"color":"rgba(82, 181, 72, 1)","margin":"0","fontSize":"30px"}'>科研管理系统</div>
			<div>
				<div v-if="false" :style='{"fontSize":"16px","color":"#666","background":"none","display":"inline-block"}'></div>
				<div v-if="Token" :style='{"fontSize":"16px","color":"#666","background":"none","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"border":"none","padding":"0 20px","margin":"0 20px","color":"#f4f4f5","borderRadius":"20px","background":"#4fa946","display":"inline-block","fontSize":"18px","lineHeight":"36px","height":"36px"}'>登录/注册</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 20px","margin":"0 0 0 0","color":"#666","borderRadius":"20px","background":"#f4f4f5","display":"inline-block","fontSize":"18px","lineHeight":"36px","height":"36px"}'>退出</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"#fff","display":"block"} : {"minHeight":"100vh","padding":"0","position":"relative","backgroundImage":"url(http://codegen.caihongy.cn/20221024/3dac00c9fc144901a781afb3b54ec6b8.jpg)"}'>
			<div class="menu-preview" :style='{"width":"100%","background":"none","height":"auto"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":"0","listStyle":"none","margin":"0 auto","background":"linear-gradient(90deg, rgba(19,154,68,1) 0%, rgba(61,183,105,1) 36%, rgba(12,125,53,1) 100%),rgb(19,154,68)","display":"flex","width":"100%","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>后台管理</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>个人中心</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","margin":"0 0 20px","height":"100%"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto","height":"100%"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="400px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"padding":"40px 0","margin":"20px 0 0 0","alignItems":"center","background":"#282828","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"objectFit":"cover","borderRadius":"100%","display":"none"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","用户人数"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","队长人数"],"menu":"科研队伍","menuJump":"列表","tableName":"keyanduiwu"}],"menu":"科研队伍管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"队伍信息","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"队伍申请","menuJump":"列表","tableName":"duiwushenqing"}],"menu":"队伍申请管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","成果类型","查看评论","导出"],"menu":"科研成果","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["导出","查看","删除","审核"],"menu":"项目成果申报","menuJump":"列表","tableName":"xiangmuchengguoshenbao"}],"menu":"项目成果申报管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","查看评论","导出"],"menu":"资源文件","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"信息交流","tableName":"forum"}],"menu":"信息交流"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"队伍申请","menuJump":"列表","tableName":"duiwushenqing"}],"menu":"队伍申请管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"队伍信息","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除","审核"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论","导出"],"menu":"科研成果","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除","导出"],"menu":"项目成果申报","menuJump":"列表","tableName":"xiangmuchengguoshenbao"}],"menu":"项目成果申报管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除","查看评论","导出"],"menu":"资源文件","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"科研队伍","tableName":"keyanduiwu"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: '登出成功',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		margin: 0px 2px 0 2px;
		color: #fff;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		line-height: 60px;
		box-shadow: none;
		background: none;
		align-items: center;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		padding: 0 10px;
		margin: 5px 2px 0 2px;
		color: #fff;
		white-space: nowrap;
		font-size: 14px;
		border-color: #6bd591;
		line-height: 50px;
		border-radius: 8px;
		box-shadow: inset 0px 0px 2px 0px #b0e8c4;
		background: #4bc276;
		border-width: 0;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 50px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		padding: 0 10px;
		margin: 5px 2px 0 2px;
		color: #fff;
		white-space: nowrap;
		font-size: 14px;
		border-color: #6bd591;
		line-height: 50px;
		border-radius: 8px;
		box-shadow: inset 0px 0px 2px 0px #b0e8c4;
		background: #4bc276;
		border-width: 0;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 50px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: rgba(168, 168, 168,.4);
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: rgba(168, 168, 168,.4);
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		margin: 0 0 8px;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 50%;
		padding: 0;
		margin: 0 5px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		border-radius: 50%;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		border-radius: 50%;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
