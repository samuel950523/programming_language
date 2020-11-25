<template>
    <div id="app">
        <table class="table table-hover mt-2">
            <ul style="list-style: none">
                <li>
                    비밀번호 변경
                    <input
                        type="text"
                        v-model="userPassword"
                        id="userPassword"
                        name="userPassword"
                        class="form-control"
                        required
                        minlength="1"
                        maxlength="20"
                        size="20"
                    />
                </li>
                <li>
                    이메일 변경
                    <input
                        type="text"
                        v-model="userEmail"
                        id="userEmail"
                        name="userEmail"
                        class="form-control"
                        required
                        minlength="1"
                        maxlength="20"
                        size="20"
                    />
                </li>
                <li>
                    <b-button
                        type="button"
                        variant="success"
                        v-on:click="loginEdit"
                        >수정하기</b-button
                    >
                </li>
            </ul>
        </table>
    </div>
</template>

<script>
import { editLogin } from "@/api";
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
    // components: {
    //     editLogin,
    // },
    data() {
        return {
            user: null,
            userPassword: "",
            userEmail: "",
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
        loginEdit: async function () {
            var userSeq = this.user.userSeq;
            var userPassword = this.userPassword;
            var userEmail = this.userEmail;

            console.log(userSeq);
            console.log(userPassword);
            console.log(userEmail);

            const get = await editLogin(userSeq, userPassword, userEmail);

            console.log(get);

            var router = this.$router;

            router.push({ path: "/Home" }); // 해당하는 라우터 이름으로 이동
        },
    },
};
</script>

<style scoped>
li {
    margin: 20px;
}
.form-control {
    width: 20%;
    margin-top: 10px;
}
</style>