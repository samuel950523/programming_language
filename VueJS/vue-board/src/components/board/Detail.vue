<template>
    <b-container class="bv-example-row mt-3">
        <b-row>
            <b-col>
                <h3>글보기</h3>
            </b-col>
        </b-row>
        <b-row class="mb-1">
            <b-col class="text-left">
                <b-button variant="outline-primary" @click="listArticle"
                    >목록</b-button
                >
            </b-col>
            <b-col class="text-right">
                <b-button
                    variant="outline-info"
                    size="sm"
                    @click="moveModifyArticle"
                    class="mr-2"
                    >글수정</b-button
                >
                <b-button
                    variant="outline-danger"
                    size="sm"
                    @click="deleteArticle"
                    >글삭제</b-button
                >
            </b-col>
        </b-row>
        <b-row class="mb-1">
            <b-col>
                <b-card
                    :header-html="`<h3>${article.articleno}.
          ${article.subject}</h3><h6>${article.userid} ${article.regtime}</h6>`"
                    class="mb-2"
                    border-variant="dark"
                    no-body
                >
                    <b-card-body class="text-left">
                        <div>
                            <template v-for="(msg, index) in message">
                                {{ msg }}<br :key="index" />
                            </template>
                        </div>
                    </b-card-body>
                </b-card>
            </b-col>
        </b-row>
        <!-- 댓글 -->
        <memo-write />
        <memo-row v-for="(memo, index) in memos" :key="index" />
    </b-container>
</template>

<script>
import MemoWrite from "./memo/MemoWrite";
import MemoRow from "./memo/MemoRow";
import { getArticle, deleteArticle } from "@/api/board.js";

export default {
    name: "detail",
    components: {
        MemoWrite,
        MemoRow,
    },
    data() {
        // const articleno = Number(this.$route.params.articleno);
        // console.log(articleno + "번글입니다.");
        return {
            article: {
                articleno: 0,
                subject: "",
                content: "",
                userid: "",
                hit: 0,
                regtime: "",
            },
            memos: [1],
        };
    },
    computed: {
        message: function () {
            return this.article.content.split("\n");
        },
    },
    created() {
        getArticle(
            this.$route.params.articleno,
            (response) => {
                console.log(response);
                this.article = response.data;
            },
            (error) => {
                console.log(error);
            }
        );
    },
    methods: {
        listArticle() {
            this.$router.push({ name: "board-list" });
        },
        moveModifyArticle() {
            this.$router.replace({
                name: "board-modify",
                params: { articleno: this.article.articleno },
            });
            //   this.$router.push({ path: `/board/modify/${this.articleno}` });
        },
        deleteArticle() {
            console.log(this.article.articleno + "글삭제!!");
            if (confirm("정말로 삭제???")) {
                deleteArticle(
                    this.$route.params.articleno,
                    (response) => {
                        console.log(response);
                        this.$router.push({ name: "board-list" });
                    },
                    (error) => {
                        console.log(error);
                    }
                );
            }
        },
    },
};
</script>

<style></style>