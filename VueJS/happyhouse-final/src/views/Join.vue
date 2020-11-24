<template>
    <b-container class="bv-example-row">
        <b-row>
            <b-col></b-col>
            <b-col cols="8">
                <b-card
                    class="mt-3"
                    header="회원가입"
                    style="max-width: 40rem"
                    align="left"
                >
                    <b-form>
                        <b-form-group label="아이디:" label-for="userName">
                            <b-form-input
                                id="userName"
                                v-model="user.userName"
                                required
                                placeholder="아이디 입력...."
                            ></b-form-input>
                        </b-form-group>
                        <b-form-group
                            label="비밀번호:"
                            label-for="userPassword"
                        >
                            <b-form-input
                                type="password"
                                id="userPassword"
                                v-model="user.userPassword"
                                required
                                placeholder="비밀번호 입력...."
                            ></b-form-input>
                        </b-form-group>
                        <b-form-group
                            label="비밀번호 확인:"
                            label-for="userPassword2"
                        >
                            <b-form-input
                                type="password"
                                id="userPassword2"
                            ></b-form-input>
                        </b-form-group>
                        <b-form-group label="이메일:" label-for="userEmail">
                            <b-form-input
                                id="userEmail"
                                v-model="user.userEmail"
                                required
                                placeholder="비밀번호 입력...."
                            ></b-form-input>
                        </b-form-group>

                        <b-button
                            type="button"
                            variant="success"
                            class="m-1"
                            @click="join"
                            >회원가입</b-button
                        >
                    </b-form>
                </b-card>
            </b-col>
            <b-col></b-col>
        </b-row>
    </b-container>
</template>

<script>
import Vue from "vue";
import VueRouter from "vue-router";
import axios from "axios";

Vue.use(VueRouter);

export default {
    name: "Join",
    data: function () {
        return {
            user: {
                userName: "",
                userPassword: "",
                userPassword2: "",
                userEmail: "",
            },
            message: "",
        };
    },
    computed: {},
    methods: {
        join: async function () {
            const Join = (user) => {
                return new Promise((resolve) => {
                    try {
                        const result = axios.post(
                            `http://127.0.0.1:8080/join`,
                            {
                                user:user
                            }
                        );
                        console.log(1111);
                        resolve(result);
                    } catch (error) {
                        resolve(false);
                    }
                });
            };

            console.log(this.user.userName);
            console.log(this.user.userPassword);
            console.log(this.user.userEmail);
            console.log(this.user);
            const time = await Join(this.user);
            console.log(time);
        },
    },
};
</script>

<style scope>
#login-div {
    text-align: center;
}
</style>
