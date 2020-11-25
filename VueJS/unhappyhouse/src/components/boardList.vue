<template>
    <div id="app">
        <b-button variant="info" v-on:click="noticeCreate"
            >공지사항 쓰기</b-button
        >

        <table class="table table-hover mt-2">
            <thead>
                <tr>
                    <th>글 번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성일</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(list, index) in noticeList" :key="index">
                    <td>{{ list.id }}</td>
                    <td>{{ list.title }}</td>
                    <td>{{ list.content }}</td>
                    <td>{{ list.createtime }}</td>
                    <td>
                        <b-button
                            variant="warning"
                            v-on:click="noticeEdit(index)"
                            >수정</b-button
                        >
                    </td>
                    <td>
                        <b-button
                            variant="danger"
                            v-on:click="noticeDelete(index)"
                            >삭제</b-button
                        >
                    </td>
                </tr>
            </tbody>
        </table>
        <!-- <div class="btn-cover">
            <button
                :disabled="pageNum === 0"
                @click="prevPage"
                class="page-btn"
            >
                이전
            </button>
            <span class="page-count"
                >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
            >
            <button
                :disabled="pageNum >= pageCount - 1"
                @click="nextPage"
                class="page-btn"
            >
                다음
            </button>
        </div> -->
    </div>
</template>

<script>
import { showNotice } from "@/api";
import { deleteNotice } from "@/api";

export default {
    // components: {
    //     showNotice,
    //     deleteNotice,
    // },
    data() {
        return {
            noticeList: [],
        };
    },
    el: "#app",
    created: function () {
        // `this` 는 vm 인스턴스를 가리킵니다.
        this.listshow();
    },
    methods: {
        makelistprops: function (notices) {
            var result = [];
            for (var i in notices.data) {
                result.push({
                    id: notices.data[i].id,
                    title: notices.data[i].title,
                    content: notices.data[i].content,
                    createtime: notices.data[i].createtime,
                });
            }
            return result;
        },
        listshow: async function () {
            const result = await showNotice();

            console.log(result);

            const data = this.makelistprops(result);
            for (var i in data) {
                this.noticeList.push(data[i]);
            }
        },
        noticeEdit: function (index) {
            var target = this.noticeList[index];

            var id = target.id;
            var title = target.title;
            var content = target.content;

            this.$router.push({
                name: "BoardEdit_",
                params: { id: id, title: title, content: content },
            });
        },
        noticeDelete: async function (index) {
            var target = this.noticeList.splice(index, 1); // todoList의 index값을 찾은 다음에 그 요소부터 시작해서 한 개를 지워주는 기능

            const test = await deleteNotice(target[0].id);

            console.log(test);
        },
        noticeCreate: function () {
            var router = this.$router;

            router.push({ path: "/boardCreate" }); // 해당하는 라우터 이름으로 이동
            // router.push({ path: '/siteList' }) // 해당하는 pathname을 입력하여 이동
        },
    },
};
</script>

<style scoped>
</style>