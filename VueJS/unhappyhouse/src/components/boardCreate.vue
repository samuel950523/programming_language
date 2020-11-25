<template>
    <div id="app">
        <table class="table table-hover mt-2">
            <ul style="list-style: none">
                <li>
                    제목
                    <input
                        type="text"
                        v-model="title"
                        class="form-control"
                        id="title"
                        name="title"
                        required
                        minlength="1"
                        maxlength="45"
                        size="50"
                    />
                </li>
                <li>
                    내용
                    <textarea
                        type="text"
                        v-model="content"
                        id="content"
                        class="form-control"
                        rows="3"
                        minlength="1"
                        maxlength="200"
                        size="50"
                    ></textarea>
                </li>
                <li>
                    <b-button variant="success" v-on:click="noticeCreate"
                        >글쓰기</b-button
                    >
                </li>
            </ul>
        </table>
    </div>
</template>

<script>
import { createNotice } from "@/api";

export default {
    // components: {
    //     createNotice,
    // },
    data() {
        return {
            title: "",
            content: "",
        };
    },
    methods: {
        noticeCreate: async function () {
            var title = this.title;
            var content = this.content;
            var test = await createNotice(title, content);

            console.log(test);

            var router = this.$router;

            router.push({ path: "/board" }); // 해당하는 라우터 이름으로 이동
        },
    },
};
</script>

<style scoped>
li {
    margin: 20px;
}
.form-control {
    width: 50%;
    margin-top: 10px;
}
.pink-textarea textarea.md-textarea:focus:not([readonly]) {
    border-bottom: 1px solid #f48fb1;
    box-shadow: 0 1px 0 0 #f48fb1;
}
.active-pink-textarea.md-form label.active {
    color: #f48fb1;
}
.active-pink-textarea.md-form
    textarea.md-textarea:focus:not([readonly])
    + label {
    color: #f48fb1;
}
</style>