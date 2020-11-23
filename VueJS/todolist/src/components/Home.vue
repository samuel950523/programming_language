<template>
    <v-container>
        <v-layout row wrap>
            <v-flex xs12 text-xs-center>
                <h1>투두 리스트</h1>
                <p>
                    전체 할일: {{ todoList.length }} / 완료된 할일:
                    {{ countDone }} / 남은 할일:
                    {{ todoList.length - countDone }}
                </p>
            </v-flex>
            <v-flex xs6 pa-2>
                <List
                    :todoList="todoList"
                    @statusControl="statusControl"
                    @listDelete="listDelete"
                />
            </v-flex>

            <v-flex xs6 pa-2>
                <ListAdd @listAdd="listAdd" @listEdit="listEdit"></ListAdd>
            </v-flex>

            <div id="app">
                <v-app id="inspire">
                    <v-row justify="center">
                        <v-date-picker
                            v-model="picker"
                            @dblclick:date="dblClick"
                        ></v-date-picker>
                        <!-- 더블클릭시 date가 dblClick이벤트호출 -->
                    </v-row>
                </v-app>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
import List from "./List";
import ListAdd from "./ListAdd";
import Calendar from "./Calendar.vue";
import eventclick from "./event-click";

import { createTodo } from "@/api";
import { showTodolist } from "@/api";
import { editMemo } from "@/api";
import { deleteMemo } from "@/api";
import EventClick from "./event-click.vue";

export default {
    components: {
        List,
        ListAdd,
        Calendar,
        eventclick,
        createTodo,
        showTodolist,
        editMemo,
        deleteMemo,
        EventClick,
    },
    data() {
        return {
            todoList: [],
            picker: new Date().toISOString().substr(0, 10),
        };
    },
    el: "#app",
    created: function () {
        // `this` 는 vm 인스턴스를 가리킵니다.
        this.listshow();
    },
    computed: {
        countDone() {
            let count = 0;
            this.todoList.forEach((list) => {
                if (list.status === "done") count++;
            });
            return count;
        },
    },
    methods: {
        listAdd: async function (memo) {
            console.log(memo);
            const body = {
                content: memo,
                createdAt: this.picker,
            };
            const time = await createTodo(body); // createTodo
            console.log(time);
            this.todoList.push({
                id: time.data,
                memo: memo,
                status: "created",
            });
        },
        makelistprops: function (memos) {
            var result = [];
            for (var i in memos.data) {
                result.push({
                    id: memos.data[i].id,
                    memo: memos.data[i].content,
                    status: "created",
                });
            }
            return result;
        },
        listshow: async function () {
            const result = await showTodolist();
            const data = this.makelistprops(result);
            for (var i in data) {
                this.todoList.push(data[i]);
            }
        },
        statusControl(index, status) {
            this.todoList[index].status = status;
        },
        listDelete: async function (index) {
            console.log(index + "??");
            var target = this.todoList.splice(index, 1); // todoList의 index값을 찾은 다음에 그 요소부터 시작해서 한 개를 지워주는 기능

            await deleteMemo(target[0].id);
        },
        listEdit: async function (memo, index) {
            // 수정
            var target = this.todoList[index];

            await editMemo(target.id, memo);
            this.todoList[index].memo = memo;
        },

        dblClick: async function () {
            // 1. 더블 클릭으로 날짜를 받는다.
            console.log(this.picker); // 날짜 받아오기
            const params = {
                //params라는 것을 createdAt으로 하기
                createdAt: this.picker,
            };
            const result = await showTodolist(params); // await는 비동기로 제어하기 위해 쓰는 것
            const data = this.makelistprops(result);
            this.todoList = [];
            for (var i in data) {
                //data에 있는 값들을 하나하나 push하기
                this.todoList.push(data[i]);
            }
        },
    },
};
</script>





<!-- 캘린더 날짜 클릭시 수행하는 내용 (11.22)
 1. 더블 클릭으로 날짜를 받는다. 
 2. 그 날짜를 서버로 보낸다.  -> get 요청의 날짜에 해당하는 메모를 반환하는 api 작성 ->pathvariable  
 3. 서버는 받은 날짜의 메모를 반환한다. 받은 날짜의 생성된 메모를 반환한다.  -> DB에서 createdAt이 받은 날짜인 메모를 조회해서 반환
 4. 프론트엔드는 받은 날짜의 메모를 표시한다.-> 2번 get api로 부터 받은 메모를 화면에 띄운다.  -->