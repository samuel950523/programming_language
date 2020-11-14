import Login from './components/Login.js';
import Main from './components/Main.js';
import MainChild1 from './components/MainChild1.js';
import MainChild2 from './components/MainChild2.js';

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
            children: [
                {
                    path: '/main/child1',
                    component: MainChild1,
                },
                {
                    path: '/main/child2',
                    component: MainChild2,
                },
            ],
        },
    ],
});
