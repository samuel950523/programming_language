<template>
    <v-container id="test4" style="background-color :#FFFCD2">
        <v-layout row="row" wrap="wrap">

            <nav> 
                <!-- 툴바 작성 -->
                <v-toolbar flat="flat" app="app">
                    <!-- 툴바 타이틀 작성 -->

                    <v-toolbar-title id="test3" class="text-uppercase">
                        <img src="../assets/logo.png"/>
                    </v-toolbar-title>
                    <!-- 구성 요소는 사용 가능한 공간을 채우거나 두 구성 요소 사이에 공간을 만들려는 경우에 유용합니다. -->
                    <v-spacer></v-spacer>
                    <v-btn flat="flat" color="grey">
                        <span>로그아웃</span>
                        <v-icon right="right">exit_to_app</v-icon>
                    </v-btn>
                </v-toolbar>
            </nav>
            <v-flex>

                <div>
                     <img id= "test" src="../assets/foryou.png"/>

                    <p class="nanum">
                        <img id="test5" src="../assets/check.png"/>
                        전체 할 일
                        {{ todoList.length }}개  &nbsp;
                        <img id="test5" src="../assets/check.png"/>
                        완료된 할 일
                        {{ countDone }}개  &nbsp;
                        <img id="test5" src="../assets/check.png"/>
                        남은 할 일
                        {{ todoList.length - countDone }}개
                    </p>
                </div>
                <div>
                    <div id="test7">
                        <ListAdd @listAdd="listAdd" @listEdit="listEdit"></ListAdd>
                         <v-date-picker id="test8" v-model="picker" @dblclick:date="dblClick"   color="green lighten-1"></v-date-picker>
                    </div>
                </div>
                <div id="test7">
                    <List 
                        :todoList="todoList"
                        @statuscontrol="statuscontrol"
                        @listdelete="listdelete"/>
                    <div id="test9">
                    <Weather :weatherList="weatherList"/>  <!-- 날씨에 대한 부분 -->
                    </div>
                </div>
            </v-flex>
 
            <div id="test10">
                <Header/>
            </div>
        </v-layout>
    </v-container>
</template>

<script>
    import List from "./List";
    import ListAdd from "./ListAdd";
    import Calendar from "./Calendar.vue";
    import eventclick from "./event-click";

    import {createTodo} from "@/api";
    import {showTodolist} from "@/api";
    import {editMemo} from "@/api";
    import {deleteMemo} from "@/api";
    import EventClick from "./event-click.vue";
    import Header from "./Header.vue";
    import Weather from "./Weather.vue";

    import {showWeather} from "@/api";
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
            Header,
            Weather,
            showWeather
        },
        data() {
            return {
                todoList: [],
                weatherList: [],
                picker: new Date()
                    .toISOString()
                    .substr(0, 10)
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
                this
                    .todoList
                    .forEach((list) => {
                        if (list.status === "done") 
                            count++;
                        }
                    );
                return count;
            }
        },
        methods: {
            listAdd: async function (memo) {
                console.log(memo);
                const body = {
                    content: memo,
                    createdAt: this.picker
                }
                const time = await createTodo(body); // createTodo
                console.log(time);
                this
                    .todoList
                    .push({id: time.data, memo: memo, status: "created"});
            },
            makelistprops: function (memos) {
                var result = [];
                for (var i in memos.data) {
                    result.push({
                        id: memos
                            .data[i]
                            .id,
                        memo: memos
                            .data[i]
                            .content,
                        status: "created"
                    });
                }
                return result;
            },
            listshow: async function () {
                const result = await showTodolist();
                const data = this.makelistprops(result);
                for (var i in data) {
                    this
                        .todoList
                        .push(data[i]);
                }
            },
            statuscontrol(index, status) {
                this
                    .todoList[index]
                    .status = status;
            },
            listdelete: async function (index) {
                console.log(index + "??");
                var target = this
                    .todoList
                    .splice(index, 1); // todoList의 index값을 찾은 다음에 그 요소부터 시작해서 한 개를 지워주는 기능

                await deleteMemo(target[0].id);
            },
            listEdit: async function (memo, index) {
                // 수정
                var target = this.todoList[index];

                await editMemo(target.id, memo);
                this
                    .todoList[index]
                    .memo = memo;
            },

            dblClick: async function () { // 1. 더블 클릭으로 날짜를 받는다.
                console.log(this.picker); // 날짜 받아오기
                const params = { //params라는 것을 createdAt으로 하기
                    createdAt: this.picker
                };
                const result = await showTodolist(params); // await는 비동기로 제어하기 위해 쓰는 것
                const data = this.makelistprops(result);
                this.todoList = [];
                for (var i in data) { //data에 있는 값들을 하나하나 push하기
                    this
                        .todoList
                        .push(data[i]);
                }
                this.weatherList = [];
                this.listshow_weather(this.picker);
            },
            makelistprops_weather: function (gets, when) {
                var result = [];
                var check = 0;
                for (var i in gets.data) {
                    if (gets.data[i].time.includes(when)) {
                        if (gets.data[i].region.includes("서울")) {
                            check += 1;
                            if (check == 1 || check == 8) {

                                if (gets.data[i].weather.includes("맑음")) {
                                    var test = require("@/assets/sunny.png")
                                }
                                if (gets.data[i].weather.includes("구름많음")) {
                                    var test = require("@/assets/cloud.png")
                                }
                                if (gets.data[i].weather.includes("구름많고 비")) {
                                    var test = require("@/assets/verycloud_rain.png")
                                }
                                if (gets.data[i].weather.includes("흐림")) {
                                    var test = require("@/assets/herim.png")
                                }
                                if (gets.data[i].weather.includes("흐리고 비")) {
                                    var test = require("@/assets/cloud_rain.png")
                                }

                                result.push({
                                    region: gets
                                        .data[i]
                                        .region,
                                    time: gets
                                        .data[i]
                                        .time,
                                    weather: gets
                                        .data[i]
                                        .weather,
                                    rain: gets
                                        .data[i]
                                        .rain,
                                    test: test
                                });
                            }
                        }
                    }
                }
                return result;
            },
            listshow_weather: async function (when) {
                const result = await showWeather();
                const data = this.makelistprops_weather(result, when);
                for (var i in data) {
                    this
                        .weatherList
                        .push(data[i]);
                }
            }
        }
    };
</script>
<style>

    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
    .nanum {
        font-family: 'Nanum Gothic', sans-serif;
        font-size: 20px;

    }
    #test {
        margin-top: 70px;
        font-size: 70px;
        font-family: 'Nanum Gothic', sans-serif;
    }

    #test2 {
        font-family: 'Nanum Gothic', sans-serif;
        font-size: 50px;
        font-weight: bold;

    }
    #test3 {
        margin-top: 10px;
    }
    #test4 {
        background-color: "#fff200";
    }
    #test5 {
        margin-top: 10px;
    }
    #test7 {
      display:flex; align-items:center
    }
    #test8 {
     margin-top: -80px;
     margin-left:  150px;
    }
    #test9{ 
        margin-top: 10%;
        margin-left: 10%; 
        margin-bottom: 10%;
    }
    #test10{ 
        margin-top:  40%;
    }
    
</style>

<!-- 캘린더 날짜 클릭시 수행하는 내용 (11.22) 1. 더블 클릭으로 날짜를 받는다. 2. 그 날짜를 서버로 보낸다. -> get 요청의
날짜에 해당하는 메모를 반환하는 api 작성 ->pathvariable 3. 서버는 받은 날짜의 메모를 반환한다. 받은 날짜의 생성된 메모를
반환한다. -> DB에서 createdAt이 받은 날짜인 메모를 조회해서 반환 4. 프론트엔드는 받은 날짜의 메모를 표시한다.-> 2번 get
api로 부터 받은 메모를 화면에 띄운다. -->