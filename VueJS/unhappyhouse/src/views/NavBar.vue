<template>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <router-link to="/" class="navbar-brand"
            ><img src="../assets/ssafyicon.jpg" alt=""
        /></router-link>
        <!--
    <a class="navbar-brand" href="#">Navbar</a>
    -->
        <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <router-link to="/Home" class="nav-link">Home</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/map" class="nav-link"
                        >주택 실거래 검색</router-link
                    >
                </li>
                <li class="nav-item">
                    <router-link to="/board" class="nav-link"
                        >공지사항</router-link
                    >
                </li>
            </ul>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav class="ml-auto" v-if="getAccessToken">
                    <b-nav-item
                        ><b-avatar
                            variant="primary"
                            v-text="getUserName.charAt(0).toUpperCase()"
                        ></b-avatar>
                        {{ getUserName }}님 환영합니다.</b-nav-item
                    >
                    <b-nav-item
                        ><router-link to="/me"
                            >내정보보기</router-link
                        ></b-nav-item
                    >
                    <b-nav-item @click.prevent="onClickLogout"
                        >로그아웃</b-nav-item
                    >
                </b-navbar-nav>
                <b-navbar-nav class="ml-auto" v-else>
                    <b-nav-item>
                        <router-link to="/login"
                            >로그인</router-link
                        ></b-nav-item
                    >
                    <b-nav-item
                        ><router-link to="/join"
                            >회원가입</router-link
                        ></b-nav-item
                    >
                </b-navbar-nav>
            </b-collapse>
        </div>
    </nav>
</template>

<script>
import Vue from "vue";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

//mapGetters 등록
import { mapGetters } from "vuex";
export default {
    name: "NavBar",
    data() {
        //  data: function () {
        return {
            searchWord: "",
            isLogin: false,
        };
    },
    computed: {
        ...mapGetters(["getAccessToken", "getUserId", "getUserName"]),
    },
    methods: {
        search() {
            alert(this.searchWord);
        },
        onClickLogout() {
            this.$store
                .dispatch("LOGOUT")
                .then(() => this.$router.replace("/").catch(() => {}));
        },
    },
};
</script>

<style>
</style>