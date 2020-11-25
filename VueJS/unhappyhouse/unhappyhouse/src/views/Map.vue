<template>
    <div class="content">
        <div>
            <kakao-map />
        </div>
        <div class="search">
            <select-code />
        </div>

        <div class="list">
            <apt-list />
        </div>
    </div>
</template>

<script>
import selectCode from "../components/selectCode.vue";
import kakaoMap from "../components/kakaoMap.vue";
import aptList from "../components/aptList.vue";
// import { sidoCode, gugunCode, dongCode } from "../assets/map.js";

export default {
    components: { selectCode, kakaoMap, aptList },
    name: "Map_",
};
</script>

<style>
.content {
    width: 90%;
    margin: 30px 0 50px 100px;
}

.content .map {
    float: left;
    width: 70% !important;
    height: 500px;
}

.content .search {
    float: left;
    width: 20%;
    height: 500px;
    margin: 0 0 0 30px;
}

.content .search .search_city,
.content .search .search_gu,
.content .search .search_dong {
    float: left;
    width: 100%;
    height: 20%;
}

.content .search .search_select .select_apartment,
.content .search .search_select .select_jutaek {
    float: left;
    width: 50%;
    height: 100%;
}

.content .list {
    width: 100%;
    float: left;
    margin: 30px 0 30px 0;
}

.information {
    height: 250px;
}

.information-title {
    text-align: center;
    background-color: cadetblue;
    padding: 5px;
}

#page > ul li a {
    padding: 8px;
    margin-right: 8px;
    width: 15px;
    color: #000;
    font: 15px tahoma;
    border: 1px solid #eee;
    text-align: center;
}

#write {
    border: 1px solid #eee;
    padding: 7px;
    margin-left: 90%;
    background-color: darkgray;
    color: white;
    font: 15px tahoma;
}

.house_detail {
    height: 750px;
}

.house_detail .house_detail_img {
    float: left;
    width: 60%;
    height: 100%;
    margin: 0 20px 0 0;
}

.house_detail .house_detail_img img {
    width: 100%;
    height: 60%;
    margin: 120px 0 0 0;
}

.house_detail .house_detail_content {
    float: left;
    width: 35%;
    height: 100%;
}

.modal-title {
    margin-left: 110px;
    font-weight: bold;
}

label {
    font-weight: bold;
}

.badge {
    margin: 50px 20px 0 50px;
    height: 30px;
    font-size: 20px;
}
</style>
