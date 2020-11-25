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
import Board_ from '../views/Board.vue';
import BoardCreate_ from '../views/BoardCreate.vue';
import BoardEdit_ from '../views/BoardEdit.vue';
import LoginEdit_ from '../views/LoginEdit.vue';

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
        {
            path: '/board',
            components: {
                NavBar: NavBar,
                default: Board_,
                Footer: Footer
            }
        },
        {
            path: '/boardCreate',
            components: {
                NavBar: NavBar,
                default: BoardCreate_,
                Footer: Footer
            },
        },
        {
            path: '/boardEdit',
            name: 'BoardEdit_',
            components: {
                NavBar: NavBar,
                default: BoardEdit_,
                Footer: Footer
            },
        },
        {
            path: '/loginEdit',
            name: 'LoginEdit_',
            components: {
                NavBar: NavBar,
                default: LoginEdit_,
                Footer: Footer
            },
        },
    ],
});