<template>
    <div id="app">
        <table class="table table-hover mt-2">
            <ul>
                <li>제목 : <input type="text" v-model="title" id="title" name="title" required minlength="1" maxlength="45" size="50"></li>
                <li>내용 : <input type="text" v-model="content" id="content" name="content" required minlength="1" maxlength="200" size="50"></li>
            </ul>
        </table>

        <button v-on:click="noticeCreate">제출</button>
    </div>
</template>

<script>
import { createNotice } from "@/api";

export default {

    components: {
        createNotice,
    },
    data() {
     return {
         title: "",
         content: "",
     }
    },
    methods:{
        noticeCreate: async function (){
            var title = this.title;
            var content = this.content;
            var test = await createNotice(title, content);

            console.log(test);

            var router = this.$router;

            router.push({ path: '/board' }) // 해당하는 라우터 이름으로 이동
        }
    },
}
</script>

<style scoped>

</style>