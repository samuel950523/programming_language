<template>
    <div>
        <!-- <h2>{{ getAptList[0] }}</h2> -->
        <table class="table table-hover mt-2">
            <thead>
                <tr>
                    <th>법정동</th>
                    <th>아파트이름</th>
                    <th>지번</th>
                    <th>지역코드</th>
                    <th>가격</th>
                    <th>넓이</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(task, index) in getAptList" :key="index">
                    <td>{{ task.dong }}</td>
                    <td>{{ task.AptName }}</td>
                    <td>{{ task.jibun }}</td>
                    <td>{{ task.code }}</td>
                    <td>{{ task.dealAmount }}</td>
                    <td>{{ task.area }}</td>
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
            return store.state.aptList;
        },
    },
    mounted() {},
    methods: {},

    watch: {},
};
</script>