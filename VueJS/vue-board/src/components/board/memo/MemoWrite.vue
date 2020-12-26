<template>
    <b-row class="mb-3 mt-2">
        <b-form @submit="onSubmit">
            <b-col cols="11">
                <b-form-textarea
                    id="comment"
                    v-model="form.comment"
                    placeholder="댓글 입력..."
                    rows="2"
                ></b-form-textarea>
            </b-col>
            <b-col
                ><b-button type="submit" variant="dark">댓글등록</b-button>
            </b-col>
        </b-form>
    </b-row>
</template>

<script>
import { mapState } from "vuex";
import { registMemo } from "@/api/memo.js";

export default {
    name: "memowrite",
    data() {
        return {
            form: {
                articleno: "",
                userid: "",
                comment: "",
            },
        };
    },
    computed: {
        ...mapState(["userInfo"]),
    },
    methods: {
        onSubmit(event) {
            console.log(this.$route.params.articleno);
            event.preventDefault();
            this.form.userid = this.userInfo.userid;
            this.form.articleno = this.$route.params.articleno;
            registMemo(
                this.form,
                (response) => {
                    console.log(response);
                    this.$router.go();
                },
                (error) => {
                    console.log(error);
                }
            );
        },
    },
};
</script>

<style></style>
