import NavBar from './components/NavBar.js';
import Blog from './components/Blog.js';
import Cafe from './components/Cafe.js';
import Mail from './components/Mail.js';
import TellMe from './components/TellMe.js';
import Footer from './components/Footer.js';

export default new VueRouter({
    routes: [
        {
            path: '/',
            components: {
                NavBar: NavBar,
                default: Cafe,
                Footer: Footer,
            },
        },
        {
            path: '/cafe',
            components: {
                NavBar: NavBar,
                default: Cafe,
                Footer: Footer,
            },
        },
        {
            path: '/mail',
            components: {
                NavBar: NavBar,
                default: Mail,
                Footer: Footer,
            },
        },
        {
            path: '/blog',
            components: {
                NavBar: NavBar,
                default: Blog,
                Footer: Footer,
            },
        },
        {
            path: '/tellme',
            components: {
                NavBar: NavBar,
                default: TellMe,
                Footer: Footer,
            },
        },
    ],
});
