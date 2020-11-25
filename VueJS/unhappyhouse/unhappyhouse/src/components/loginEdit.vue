<template>
    <div id="app">
        <table class="table table-hover mt-2">
            <ul>
                <li>비밀번호 변경 : <input type="text" v-model="userPassword" id="userPassword" name="userPassword" required minlength="1" maxlength="20" size="20"></li>
                <li>이메일 변경 : <input type="text" v-model="userEmail" id="userEmail" name="userEmail" required minlength="1" maxlength="20" size="20"></li>
            </ul>
        </table>

        <button v-on:click="loginEdit">수정완료</button>

    </div>
</template>

<script>
import { editLogin } from "@/api";
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {

    components: {
        editLogin,
    },
    data() {
     return {
         user: null,
         userPassword: "",
         userEmail: "",
     }
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
     methods:{
        loginEdit: async function (){
            var userSeq = this.user.userSeq;
            var userPassword = this.userPassword;
            var userEmail = this.userEmail;

            console.log(userSeq);
                        console.log(userPassword);
                                    console.log(userEmail);

            const get = await editLogin(userSeq, userPassword, userEmail);

            console.log(get)

             var router = this.$router;

            router.push({ path: '/Home' }) // 해당하는 라우터 이름으로 이동
        }
    },
}
</script>

<style scoped>

</style>