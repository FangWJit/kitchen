import Vue from 'vue'
import VueRouter from 'vue-router'
import detail from '../components/userDetail'
import login from "../components/login";
import index from "../components/index";
import foodlist from "../components/foodlist";
import register from "../components/register";
import food_question from "../components/food_question";
import proclamation from "../components/proclamation";
import foodlist2 from "../components/foodlist2";
import foodDetails from "../components/foodDetails";
import health from "../components/health";
import food_assort from "../components/food_assort";
import user_assort from "../components/user_assort";

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'First',
        redirect: { name: 'index' }
    },
    {
        path: '/index',
        name: 'index',
        component: index,
        meta:{ keepAlive: true }
    },
    {
        path: '/detail',
        name: 'detail',
        component:detail
    },
    {
        path: '/foodDetails',
        name: 'foodDetails',
        component:foodDetails
    },
    {
        path: '/login',
        name: 'login',
        component:login
    },
    {
        path: '/foodlist',
        name:'foodlist',
        component: foodlist
    },
    {
        path: '/foodlist2',
        name:'foodlist2',
        component: foodlist2
    },
    {
        path: '/register',
        name:'register',
        component: register
    },
    {
        path: '/food_question',
        name:'food_question',
        component: food_question,
    },
    {
        path: '/proclamation',
        name: 'proclamation',
        component: proclamation
    },
    {
        path: '/health',
        name: 'health',
        component: health
    },
    {
        path: '/food_assort',
        name: 'food_assort',
        component: food_assort
    },
    {
        path: '/user_assort',
        name: 'user_assort',
        component: user_assort
    }

]

const router = new VueRouter({
    mode: 'history',
    // mode: 'hash',
    base: process.env.BASE_URL,
    routes
})


// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
router.beforeEach((to, from, next) => {
    if (to.path === '/login') {
        next();
    } else {
        let token = localStorage.getItem('Authorization');
        if (token == null || token == '') {
            next('/login');
        } else {
            next();
        }
    }
});

export default router
