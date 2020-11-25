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
                <tr v-for="(task, index) in paginatedData" :key="index">
                    <td>{{ task.dong }}</td>
                    <td>{{ task.aptName }}</td>
                    <td>{{ task.dealAmount }}</td>
                    <td>{{ task.area }}</td>
                    <td>{{ task.floor }}</td>
                    <td>{{ task.buildYear }}</td>
                </tr>
            </tbody>
        </table>
        <div class="btn-cover">
            <b-button
                variant="outline-info"
                :disabled="pageNum === 0"
                @click="prevPage"
                class="page-btn"
            >
                이전
            </b-button>
            <span class="page-count"
                >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
            >
            <b-button
                variant="outline-info"
                :disabled="pageNum >= pageCount - 1"
                @click="nextPage"
                class="page-btn"
            >
                다음
            </b-button>
        </div>
    </div>
</template>

<script>
import store from "../store/index.js";
export default {
    data() {
        return {
            pageNum: 0,
            pageSize: 10,
        };
    },
    computed: {
        // getAptList() {
        //     console.log(store.state.aptList);
        //     return store.state.aptList;
        // },
        pageCount() {
            let listLeng = store.state.aptList.length,
                listSize = this.pageSize,
                page = Math.floor(listLeng / listSize);
            if (listLeng % listSize > 0) page += 1;
            return page;
        },
        paginatedData() {
            const start = this.pageNum * this.pageSize,
                end = start + this.pageSize;
            var slicedList = store.state.aptList.slice(start, end);
            this.$store.commit("slicedList", { slicedList });
            return store.state.aptList.slice(start, end);
        },
    },
    mounted() {},
    methods: {
        nextPage() {
            this.pageNum += 1;
        },
        prevPage() {
            this.pageNum -= 1;
        },
    },

    watch: {},
};
</script>

<style>
table {
    width: 100%;
    border-collapse: collapse;
}
table th {
    font-size: 1.2rem;
}
table tr {
    height: 2rem;
    text-align: center;
    border-bottom: 1px solid #505050;
}
table tr:first-of-type {
    border-top: 2px solid #404040;
}
table tr td {
    padding: 1rem 0;
    font-size: 1.1rem;
}
.btn-cover {
    margin-top: 1.5rem;
    text-align: center;
}
.btn-cover .page-btn {
    width: 5rem;
    height: 2rem;
    letter-spacing: 0.5px;
}
.btn-cover .page-count {
    padding: 0 1rem;
}
</style>