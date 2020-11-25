<template>
    <b-container class="mt-4" v-if="user">
        <b-row>
            <b-col></b-col>
            <b-col cols="8">
                <b-jumbotron>
                    <template #header>My Page</template>

                    <template #lead> 내 정보 확인페이지입니다. </template>

                    <hr class="my-4" />

                    <b-container class="mt-4">
                        <b-row>
                            <b-col cols="2"></b-col>
                            <b-col cols="2" align-self="end">아이디</b-col
                            ><b-col cols="4" align-self="start">{{
                                user.userName
                            }}</b-col>
                            <b-col cols="2"></b-col>
                        </b-row>
                        <b-row>
                            <b-col cols="2"></b-col>
                            <b-col cols="2" align-self="end">비밀번호</b-col
                            ><b-col cols="4" align-self="start">{{
                                user.userPassword
                            }}</b-col>
                            <b-col cols="2"></b-col>
                        </b-row>
                        <b-row>
                            <b-col cols="2"></b-col>
                            <b-col cols="2" align-self="end">이메일</b-col
                            ><b-col cols="4" align-self="start">{{
                                user.userEmail
                            }}</b-col>
                            <b-col cols="2"></b-col>
                        </b-row>

                        <b-row>
                            <b-col cols="2"></b-col>
                            <b-col cols="2" align-self="end">가입일</b-col
                            ><b-col cols="4" align-self="start">{{
                                user.userRegisterDate.year +
                                "." +
                                user.userRegisterDate.monthValue +
                                "." +
                                user.userRegisterDate.dayOfMonth
                            }}</b-col>
                            <b-col cols="2"></b-col>
                        </b-row>
                    </b-container>
                    <hr class="my-4" />

                    <b-button variant="primary" href="#" class="mr-1" v-on:click="loginEdit()"
                        >정보수정</b-button
                    >
                    <b-button variant="danger" href="#" v-on:click="loginDelete()">회원탈퇴</b-button>
                </b-jumbotron>
            </b-col>
            <b-col></b-col>
        </b-row>
    </b-container>
    <!-- <h2>내정보보기</h2>
    이름 : {{ user.username }}<br />
    아이디 : {{ user.userid }}<br />
    이메일 : {{ user.email }}<br />
    주소 : {{ user.address }}<br />
    가입일 : {{ user.joindate }}<br />
  </div> -->
</template>

<script>
import axios from "axios";
import { deleteLogin } from "@/api";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
    components: {
        deleteLogin,
    },
    name: "me",
    data() {
        return {
            user: null,
        };
    },
    created() {
        axios
            .get(`${SERVER_URL}/user/info`)
            .then((response) => {
                this.user = response.data.user;
            })
            .catch(() => {
                this.$store
                    .dispatch("LOGOUT")
                    .then(() => this.$router.replace("/"));
            });
    },
    methods: {
        loginEdit: function () {

            var router = this.$router;

            router.push({ path: '/loginEdit' }) // 해당하는 라우터 이름으로 이동
        },
        loginDelete: async function () {

            var userSeq = this.user.userSeq;

            console.log(userSeq);

            const test = await deleteLogin(userSeq);

            console.log(test);

            this.$store
                .dispatch("LOGOUT")
                // .then(() => this.$router.replace("/").catch(() => {}));

            var router = this.$router;

            router.push({ path: '/Home' }) // 해당하는 라우터 이름으로 이동
        },
    },
};
</script>

<style></style>
