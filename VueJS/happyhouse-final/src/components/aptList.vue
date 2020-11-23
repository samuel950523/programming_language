<template>
    <div>
        <!-- <h2>{{ getAptList[0] }}</h2> -->
        <table class="table table-hover mt-2">
            <thead>
                <tr>
                    <th>법정동</th>
                    <th>아파트이름</th>
                    <th>가격</th>
                    <th>넓이</th>
                    <th>층</th>
                    <th>건축년도</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(task, index) in getAptList" :key="index">
                    <td>{{ task.dong }}</td>
                    <td>{{ task.aptName }}</td>
                    <td>{{ task.dealAmount }}</td>
                    <td>{{ task.area }}</td>
                    <td>{{ task.floor }}</td>
                    <td>{{ task.buildYear }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import store from "../store/index.js";
export default {
    computed: {
        getAptList() {
            console.log(store.state.aptList);
            return store.state.aptList;
        },
    },
    mounted() {},
    methods: {},

    watch: {},
};
</script>