import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

import Home from '../views/Home.vue';
import NavBar from '../views/NavBar.vue';
import Map_ from '../views/Map.vue';
import Login from '../views/Login.vue';
import Me from '../views/Me.vue';
import Join from '../views/Join.vue';
import Footer from '../views/Footer.vue';
import store from '../store';

Vue.use(VueRouter);

const requireAuth = () => (to, from, next) => {
    const nextRoute = to.path;

    if (store.getters.getAccessToken) {
        return next();
    } else next('/login' + nextRoute);
};

export default new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            components: {
                NavBar: NavBar,
                default: Home,
                Footer: Footer,
            },
        },
        {
            path: '/Home',
            components: {
                NavBar: NavBar,
                default: Home,
                Footer: Footer,
            },
        },
        {
            path: '/map',
            components: {
                NavBar: NavBar,
                default: Map_,
                Footer: Footer,
            },
        },
        {
            path: '/login',
            components: {
                NavBar: NavBar,
                default: Login,
            },
        },
        {
            path: '/login/:nextRoute',
            components: {
                NavBar: NavBar,
                default: Login,
            },
        },
        {
            path: '/me',
            components: {
                NavBar: NavBar,
                default: Me,
            },
            beforeEnter: requireAuth(),
        },
        {
            path: '/join',
            components: {
                NavBar: NavBar,
                default: Join,
            },
        },
        {
            path: '/map',
            components: {
                NavBar: NavBar,
                default: Map_,
                Footer: Footer,
            },
        },
    ],
});