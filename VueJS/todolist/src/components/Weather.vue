<template>
    <div id= "test7">
        <v-card class="pa-3" v-for="list in weatherList"  width="200" height="350">
            <v-card-title class="nanum">날씨 예보</v-card-title>
            <v-card-subtitle class="nanum">지역 -
                {{list.region}}</v-card-subtitle>
                <br>
            <v-card-subtitle class="nanum">예보시각 -
                {{list.time}}</v-card-subtitle>
                <br>
            <v-card-subtitle class="nanum">예보 -
                {{list.weather}}
            </v-card-subtitle>
            <br>
            <v-card-subtitle class="nanum">강수확률 -
                {{list.rain}}%
            </v-card-subtitle>
            <br>
            <img v-bind:src="list.test"/>

        </v-card>
    </div>
</template>

<script>

    import {eventBus} from "../main"
    export default {props: ["weatherList"]}
</script>

<style scoped="scoped">
    @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap');
    @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
    .done {
        background-color: rgba(0,0,0,0.1);
    }
    .done p {
        text-decoration: line-through;
        color: rgba(0, 0,0, 0.5);
    }
    .nanum {
        font-family: 'Jua', sans-serif;
        font-size: 18px;
        color: rgb(0,0,0);

        margin-top: -10px;

    }

      #test7 {
      display:flex; 
      align-items:center;
     margin-block: 20px;
    }
</style>