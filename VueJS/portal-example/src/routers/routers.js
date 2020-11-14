import Vue from 'vue';  // defalut module
import VueRouter from 'vue-router'; // installed module

Vue.use(VueRouter)

import NavBar from '@/components/NavBar.vue';
import Blog from '@/components/Blog.vue';
import Cafe from '@/components/Cafe.vue';
import TellMe from '@/components/TellMe.vue';
import Footer from '@/components/Footer.vue';


export default new VueRouter({
  routes: [
    {
      path: '/',
      components: {
        NavBar: NavBar,
        default: Cafe,
        Footer: Footer
      }
    },
    {
      path: '/blog',
      components: {
        NavBar: NavBar,
        default: Blog,
        Footer: Footer
      }
    },
    {
      path: '/cafe',
      components: {
        NavBar: NavBar,
        default: Cafe,
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
