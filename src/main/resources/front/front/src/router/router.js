import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import keyanduiwuList from '../pages/keyanduiwu/list'
import keyanduiwuDetail from '../pages/keyanduiwu/detail'
import keyanduiwuAdd from '../pages/keyanduiwu/add'
import duiwuxinxiList from '../pages/duiwuxinxi/list'
import duiwuxinxiDetail from '../pages/duiwuxinxi/detail'
import duiwuxinxiAdd from '../pages/duiwuxinxi/add'
import jiaruduiwuList from '../pages/jiaruduiwu/list'
import jiaruduiwuDetail from '../pages/jiaruduiwu/detail'
import jiaruduiwuAdd from '../pages/jiaruduiwu/add'
import duiwushenqingList from '../pages/duiwushenqing/list'
import duiwushenqingDetail from '../pages/duiwushenqing/detail'
import duiwushenqingAdd from '../pages/duiwushenqing/add'
import keyanchengguoList from '../pages/keyanchengguo/list'
import keyanchengguoDetail from '../pages/keyanchengguo/detail'
import keyanchengguoAdd from '../pages/keyanchengguo/add'
import xiangmuchengguoshenbaoList from '../pages/xiangmuchengguoshenbao/list'
import xiangmuchengguoshenbaoDetail from '../pages/xiangmuchengguoshenbao/detail'
import xiangmuchengguoshenbaoAdd from '../pages/xiangmuchengguoshenbao/add'
import gonggaoxinxiList from '../pages/gonggaoxinxi/list'
import gonggaoxinxiDetail from '../pages/gonggaoxinxi/detail'
import gonggaoxinxiAdd from '../pages/gonggaoxinxi/add'
import ziyuanwenjianList from '../pages/ziyuanwenjian/list'
import ziyuanwenjianDetail from '../pages/ziyuanwenjian/detail'
import ziyuanwenjianAdd from '../pages/ziyuanwenjian/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'keyanduiwu',
					component: keyanduiwuList
				},
				{
					path: 'keyanduiwuDetail',
					component: keyanduiwuDetail
				},
				{
					path: 'keyanduiwuAdd',
					component: keyanduiwuAdd
				},
				{
					path: 'duiwuxinxi',
					component: duiwuxinxiList
				},
				{
					path: 'duiwuxinxiDetail',
					component: duiwuxinxiDetail
				},
				{
					path: 'duiwuxinxiAdd',
					component: duiwuxinxiAdd
				},
				{
					path: 'jiaruduiwu',
					component: jiaruduiwuList
				},
				{
					path: 'jiaruduiwuDetail',
					component: jiaruduiwuDetail
				},
				{
					path: 'jiaruduiwuAdd',
					component: jiaruduiwuAdd
				},
				{
					path: 'duiwushenqing',
					component: duiwushenqingList
				},
				{
					path: 'duiwushenqingDetail',
					component: duiwushenqingDetail
				},
				{
					path: 'duiwushenqingAdd',
					component: duiwushenqingAdd
				},
				{
					path: 'keyanchengguo',
					component: keyanchengguoList
				},
				{
					path: 'keyanchengguoDetail',
					component: keyanchengguoDetail
				},
				{
					path: 'keyanchengguoAdd',
					component: keyanchengguoAdd
				},
				{
					path: 'xiangmuchengguoshenbao',
					component: xiangmuchengguoshenbaoList
				},
				{
					path: 'xiangmuchengguoshenbaoDetail',
					component: xiangmuchengguoshenbaoDetail
				},
				{
					path: 'xiangmuchengguoshenbaoAdd',
					component: xiangmuchengguoshenbaoAdd
				},
				{
					path: 'gonggaoxinxi',
					component: gonggaoxinxiList
				},
				{
					path: 'gonggaoxinxiDetail',
					component: gonggaoxinxiDetail
				},
				{
					path: 'gonggaoxinxiAdd',
					component: gonggaoxinxiAdd
				},
				{
					path: 'ziyuanwenjian',
					component: ziyuanwenjianList
				},
				{
					path: 'ziyuanwenjianDetail',
					component: ziyuanwenjianDetail
				},
				{
					path: 'ziyuanwenjianAdd',
					component: ziyuanwenjianAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
