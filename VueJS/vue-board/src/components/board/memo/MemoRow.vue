<template>
    <b-row class="mb-1">
        <span
            v-for="(memo, index) in memos"
            v-bind:key="index"
            style="width: 100%"
        >
            <b-col>
                <b-card border-variant="info" class="mb-2" no-body>
                    <template>
                        <b-row class="m-1">
                            <b-col class="text-left ml-3"
                                ><strong>{{ memo.userid }}</strong>
                                {{ memo.memotime }}
                            </b-col>
                            <b-col class="text-right mr-3">
                                <b-button
                                    @click="modifyMemo(memo)"
                                    variant="link"
                                    >수정</b-button
                                >
                                <b-button
                                    @click="deleteMemo(memo.memono)"
                                    variant="link"
                                    >삭제</b-button
                                >
                            </b-col>
                        </b-row>
                    </template>
                    <b-card-body class="text-left">
                        <!-- <div>
                            {{ memo.comment }}
                        </div> -->
                        <div>
                            <b-form-textarea
                                id="comment"
                                v-model="memo.comment"
                                placeholder="댓글 입력..."
                                rows="2"
                            ></b-form-textarea>
                        </div>
                    </b-card-body>
                </b-card>
            </b-col>
        </span>
    </b-row>
</template>

<script>
import { getMemo, deleteMemo, modifyMemo } from "@/api/memo.js";
export default {
    name: "memorow",
    data() {
        return {
            memos: [],
            form: {
                articleno: "",
                userid: "",
                comment: "",
            },
        };
    },
    created() {
        getMemo(
            this.$route.params.articleno,
            (response) => {
                console.log(response);
                this.memos = response.data;
            },
            (error) => {
                console.log(error);
            }
        );
    },
    methods: {
        deleteMemo(memono) {
            // console.log(this.memos.memono + "댓글삭제!!");
            console.log("댓글삭제!!");
            if (confirm("정말로 삭제???")) {
                deleteMemo(
                    this.$route.params.articleno,
                    memono,
                    (response) => {
                        console.log(response);
                        this.$router.go();
                    },
                    (error) => {
                        console.log(error);
                    }
                );
            }
        },
        modifyMemo(memo) {
            modifyMemo(
                memo,
                (response) => {
                    console.log(response);
                    this.$router.go();
                },
                (error) => {
                    console.log(response);
                }
            );
        },
    },
};
</script>

<style></style>