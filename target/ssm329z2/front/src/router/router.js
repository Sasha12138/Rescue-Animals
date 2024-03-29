import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import dongwuzhongleiList from '../pages/dongwuzhonglei/list'
import dongwuzhongleiDetail from '../pages/dongwuzhonglei/detail'
import dongwuzhongleiAdd from '../pages/dongwuzhonglei/add'
import leixingList from '../pages/leixing/list'
import leixingDetail from '../pages/leixing/detail'
import leixingAdd from '../pages/leixing/add'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import dongwuzhaojiaList from '../pages/dongwuzhaojia/list'
import dongwuzhaojiaDetail from '../pages/dongwuzhaojia/detail'
import dongwuzhaojiaAdd from '../pages/dongwuzhaojia/add'
import dongwulingyangList from '../pages/dongwulingyang/list'
import dongwulingyangDetail from '../pages/dongwulingyang/detail'
import dongwulingyangAdd from '../pages/dongwulingyang/add'
import dongwubaikeList from '../pages/dongwubaike/list'
import dongwubaikeDetail from '../pages/dongwubaike/detail'
import dongwubaikeAdd from '../pages/dongwubaike/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

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
					path: 'messages',
					component: Messages
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'dongwuzhonglei',
					component: dongwuzhongleiList
				},
				{
					path: 'dongwuzhongleiDetail',
					component: dongwuzhongleiDetail
				},
				{
					path: 'dongwuzhongleiAdd',
					component: dongwuzhongleiAdd
				},
				{
					path: 'leixing',
					component: leixingList
				},
				{
					path: 'leixingDetail',
					component: leixingDetail
				},
				{
					path: 'leixingAdd',
					component: leixingAdd
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
					path: 'dongwuzhaojia',
					component: dongwuzhaojiaList
				},
				{
					path: 'dongwuzhaojiaDetail',
					component: dongwuzhaojiaDetail
				},
				{
					path: 'dongwuzhaojiaAdd',
					component: dongwuzhaojiaAdd
				},
				{
					path: 'dongwulingyang',
					component: dongwulingyangList
				},
				{
					path: 'dongwulingyangDetail',
					component: dongwulingyangDetail
				},
				{
					path: 'dongwulingyangAdd',
					component: dongwulingyangAdd
				},
				{
					path: 'dongwubaike',
					component: dongwubaikeList
				},
				{
					path: 'dongwubaikeDetail',
					component: dongwubaikeDetail
				},
				{
					path: 'dongwubaikeAdd',
					component: dongwubaikeAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
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
