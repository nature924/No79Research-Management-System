<template>
<div class="home-preview" :style='{"width":"1200px","margin":"0 auto","background":"none"}'>



<div class="recommend" :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px 0 0 0","overflow":"hidden","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","justifyContent":"space-between"}'>
	
    <div class="title" :style='{"width":"auto","padding":"0px","margin":"0px ","lineHeight":"54px","textAlign":"left","order":"0"}'>
		<span :style='{"padding":"10px","borderColor":"#55b44b","fontSize":"32px","color":"#000","borderStyle":"solid","borderWidth":" 0 0 5px 0"}'>队伍信息推荐</span>
	</div>
	
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","margin":"0 auto","flexWrap":"wrap-reverse","background":"none","display":"flex","width":"80%","justifyContent":"space-between","height":"300px"}'>
		<div class="box1" :style='{"width":"10%","background":"#cce199","height":"20%"}'></div>
		<div class="box2" :style='{"width":"10%","background":"#acd598","height":"40%"}'></div>
		<div class="box3" :style='{"width":"10%","background":"#8ac998","height":"60%"}'></div>
		<div class="box4" :style='{"width":"10%","background":"#85ccc9","height":"80%"}'></div>
		<div class="box5" :style='{"width":"10%","background":"#7fcef4","height":"100%"}'></div>
		<div class="box6" :style='{"width":"10%","background":"#89abda","height":"120%"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"padding":"0px","margin":"20px 0 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
		<div :style='{"border":"1px solid #bee4cc","padding":"4px","margin":"8px 0","borderRadius":"4px","flexWrap":"wrap","background":"none","display":"flex","width":"19%","position":"relative","height":"auto"}' v-for="(item,index) in duiwuxinxiRecommend" :key="index" @click="toDetail('duiwuxinxiDetail', item)" class="list-item animation-box">
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.duiwumingcheng}}</div>
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.zuzhangxingming}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('duiwuxinxi')" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","textAlign":"center","display":"block","float":"right","borderRadius":"30px","background":"#3db769","width":"auto","lineHeight":"40px","height":"40px","order":"0"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>
<div class="recommend" :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px 0 0 0","overflow":"hidden","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","justifyContent":"space-between"}'>
	
    <div class="title" :style='{"width":"auto","padding":"0px","margin":"0px ","lineHeight":"54px","textAlign":"left","order":"0"}'>
		<span :style='{"padding":"10px","borderColor":"#55b44b","fontSize":"32px","color":"#000","borderStyle":"solid","borderWidth":" 0 0 5px 0"}'>科研成果推荐</span>
	</div>
	
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","margin":"0 auto","flexWrap":"wrap-reverse","background":"none","display":"flex","width":"80%","justifyContent":"space-between","height":"300px"}'>
		<div class="box1" :style='{"width":"10%","background":"#cce199","height":"20%"}'></div>
		<div class="box2" :style='{"width":"10%","background":"#acd598","height":"40%"}'></div>
		<div class="box3" :style='{"width":"10%","background":"#8ac998","height":"60%"}'></div>
		<div class="box4" :style='{"width":"10%","background":"#85ccc9","height":"80%"}'></div>
		<div class="box5" :style='{"width":"10%","background":"#7fcef4","height":"100%"}'></div>
		<div class="box6" :style='{"width":"10%","background":"#89abda","height":"120%"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"padding":"0px","margin":"20px 0 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
		<div :style='{"border":"1px solid #bee4cc","padding":"4px","margin":"8px 0","borderRadius":"4px","flexWrap":"wrap","background":"none","display":"flex","width":"19%","position":"relative","height":"auto"}' v-for="(item,index) in keyanchengguoRecommend" :key="index" @click="toDetail('keyanchengguoDetail', item)" class="list-item animation-box">
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.chengguomingcheng}}</div>
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.duiwumingcheng}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('keyanchengguo')" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","textAlign":"center","display":"block","float":"right","borderRadius":"30px","background":"#3db769","width":"auto","lineHeight":"40px","height":"40px","order":"0"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>
<div class="recommend" :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px 0 0 0","overflow":"hidden","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","justifyContent":"space-between"}'>
	
    <div class="title" :style='{"width":"auto","padding":"0px","margin":"0px ","lineHeight":"54px","textAlign":"left","order":"0"}'>
		<span :style='{"padding":"10px","borderColor":"#55b44b","fontSize":"32px","color":"#000","borderStyle":"solid","borderWidth":" 0 0 5px 0"}'>公告信息推荐</span>
	</div>
	
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","margin":"0 auto","flexWrap":"wrap-reverse","background":"none","display":"flex","width":"80%","justifyContent":"space-between","height":"300px"}'>
		<div class="box1" :style='{"width":"10%","background":"#cce199","height":"20%"}'></div>
		<div class="box2" :style='{"width":"10%","background":"#acd598","height":"40%"}'></div>
		<div class="box3" :style='{"width":"10%","background":"#8ac998","height":"60%"}'></div>
		<div class="box4" :style='{"width":"10%","background":"#85ccc9","height":"80%"}'></div>
		<div class="box5" :style='{"width":"10%","background":"#7fcef4","height":"100%"}'></div>
		<div class="box6" :style='{"width":"10%","background":"#89abda","height":"120%"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"padding":"0px","margin":"20px 0 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
		<div :style='{"border":"1px solid #bee4cc","padding":"4px","margin":"8px 0","borderRadius":"4px","flexWrap":"wrap","background":"none","display":"flex","width":"19%","position":"relative","height":"auto"}' v-for="(item,index) in gonggaoxinxiRecommend" :key="index" @click="toDetail('gonggaoxinxiDetail', item)" class="list-item animation-box">
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.biaoti}}</div>
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.faburen}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('gonggaoxinxi')" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","textAlign":"center","display":"block","float":"right","borderRadius":"30px","background":"#3db769","width":"auto","lineHeight":"40px","height":"40px","order":"0"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>
<div class="recommend" :style='{"border":"2px solid #a4d9b7","padding":"20px","margin":"20px 0 0 0","overflow":"hidden","borderRadius":"8px","flexWrap":"wrap","background":"rgba(255,255,255,1)","display":"flex","justifyContent":"space-between"}'>
	
    <div class="title" :style='{"width":"auto","padding":"0px","margin":"0px ","lineHeight":"54px","textAlign":"left","order":"0"}'>
		<span :style='{"padding":"10px","borderColor":"#55b44b","fontSize":"32px","color":"#000","borderStyle":"solid","borderWidth":" 0 0 5px 0"}'>资源文件推荐</span>
	</div>
	
	<div v-if="false" class="idea recommendIdea" :style='{"padding":"20px","margin":"0 auto","flexWrap":"wrap-reverse","background":"none","display":"flex","width":"80%","justifyContent":"space-between","height":"300px"}'>
		<div class="box1" :style='{"width":"10%","background":"#cce199","height":"20%"}'></div>
		<div class="box2" :style='{"width":"10%","background":"#acd598","height":"40%"}'></div>
		<div class="box3" :style='{"width":"10%","background":"#8ac998","height":"60%"}'></div>
		<div class="box4" :style='{"width":"10%","background":"#85ccc9","height":"80%"}'></div>
		<div class="box5" :style='{"width":"10%","background":"#7fcef4","height":"100%"}'></div>
		<div class="box6" :style='{"width":"10%","background":"#89abda","height":"120%"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	<!-- 样式一 -->
	<div class="list list1 index-pv1" :style='{"padding":"0px","margin":"20px 0 0 0","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
		<div :style='{"border":"1px solid #bee4cc","padding":"4px","margin":"8px 0","borderRadius":"4px","flexWrap":"wrap","background":"none","display":"flex","width":"19%","position":"relative","height":"auto"}' v-for="(item,index) in ziyuanwenjianRecommend" :key="index" @click="toDetail('ziyuanwenjianDetail', item)" class="list-item animation-box">
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-if="preHttp(item.fengmian)" :src="item.fengmian.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","borderRadius":"0","display":"block","height":"220px"}' v-else :src="baseUrl + (item.fengmian?item.fengmian.split(',')[0]:'')" alt="" />
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.ziyuanmingcheng}}</div>
			<div class="name line1" :style='{"padding":"0 10px","margin":"0 auto","borderColor":"#e1f6e9","color":"#333","background":"#f1fdf5","borderWidth":"0 0 1px 0","display":"block","width":"100%","lineHeight":"30px","fontSize":"14px","borderStyle":"solid"}'>{{item.ziyuanleixing}}</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	<div @click="moreBtn('ziyuanwenjian')" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","textAlign":"center","display":"block","float":"right","borderRadius":"30px","background":"#3db769","width":"auto","lineHeight":"40px","height":"40px","order":"0"}'>
		<span :style='{"color":"#f5f5f5","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#f5f5f5","fontSize":"16px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

	




</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],
        duiwuxinxiRecommend: [],
        keyanchengguoRecommend: [],
        gonggaoxinxiRecommend: [],
        ziyuanwenjianRecommend: [],

      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getList() {
          let autoSortUrl = "";
          autoSortUrl = "duiwuxinxi/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.duiwuxinxiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "keyanchengguo/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.keyanchengguoRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "gonggaoxinxi/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.gonggaoxinxiRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
          autoSortUrl = "ziyuanwenjian/autoSort";
			this.$http.get(autoSortUrl, {params: {
				page: 1,
				limit: 10,
			}}).then(res => {
				if (res.data.code == 0) {
					this.ziyuanwenjianRecommend = res.data.data.list;
					
					
					// 商品列表样式五
					
				}
			});
			
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(165, 195, 180);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(165, 195, 180);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0) scale(0.98) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(-2px, -2px, 20px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: 0;
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: #3db769;
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: #3db769;
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: rotate(0) scale(0.98) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				transform: 0;
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
