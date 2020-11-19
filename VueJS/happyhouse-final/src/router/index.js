import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module


import Home from "../views/Home.vue";
import NavBar from '../views/NavBar.vue';
import Map_ from '../views/Map.vue';
import Footer from '../views/Footer.vue';


Vue.use(VueRouter)

export default new VueRouter({
    routes: [{
            path: '/',
            components: {
                NavBar: NavBar,
                default: Home,
                Footer: Footer
            }
        },
        {
            path: '/Home',
            components: {
                NavBar: NavBar,
                default: Home,
                Footer: Footer
            }
        },
        {
            path: '/map',
            components: {
                NavBar: NavBar,
                default: Map_,
                Footer: Footer
            }
        },
    ],
});