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
                        class="form-control"
                        id="content"
                        maxlength="200"
                        size="50"
                        width="50%"
                    ></textarea>
                </li>
                <li>
                    <b-button variant="success" v-on:click="noticeEdit"
                        >수정하기</b-button
                    >
                </li>
            </ul>
        </table>
    </div>
</template>

<script>
import { editNotice } from "@/api";

export default {
    // components: {
    //     editNotice,
    // },
    data() {
        return {
            title: this.$route.params.title,
            content: this.$route.params.content,
            id: this.$route.params.id,
        };
    },
    methods: {
        noticeEdit: async function () {
            var id = this.id;
            var title = this.title;
            var content = this.content;

            var test = await editNotice(id, title, content);

            console.log(test);

            var router = this.$router;

            router.push({ path: "/board" }); // 해당하는 라우터 이름으로 이동
        },
    },
};
</script>

<style scoped>
li {
    margin: 10px;
}
.form-control {
    width: 50%;
}
</style>