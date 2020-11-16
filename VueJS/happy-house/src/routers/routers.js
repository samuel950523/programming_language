import Vue from 'vue'; // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter)

import NavBar from '@/components/NavBar.vue';
import Map_ from '@/components/Map.vue';
import Main from '@/components/Main.vue';
import TellMe from '@/components/TellMe.vue';
import Board from '@/components/Board.vue';
import Footer from '@/components/Footer.vue';


export default new VueRouter({
    routes: [{
            path: '/',
            components: {
                NavBar: NavBar,
                default: Main,
                Footer: Footer
            }
        },
        {
            path: '/Main',
            components: {
                NavBar: NavBar,
                default: Main,
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
        {
            path: '/Board',
            components: {
                NavBar: NavBar,
                default: Board,
                Footer: Footer
            }
        },
        {
            path: '/tellme',
            components: {
                NavBar: NavBar,
                default: TellMe,
                Footer: Footer
            }
        }
    ],
});