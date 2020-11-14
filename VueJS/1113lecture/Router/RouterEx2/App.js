import Login from './components/Login.js';
import Main from './components/Main.js';

export default new VueRouter({
    routes: [
        {
            path: '/',
            component: Main,
        },
        {
            path: '/login',
            component: Login,
        },
        {
            path: '/main',
            component: Main,
        },
    ],
})