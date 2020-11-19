<template>
    <div class="content">
        <div class="map" id="map"></div>
        <div class="search">
            <select-code />
        </div>

        <div class="list">
            <table class="table table-hover mt-2">
                <thead>
                    <tr>
                        <th>법정동</th>
                        <th>아파트이름</th>
                        <th>지번</th>
                        <th>지역코드</th>
                        <th>위도</th>
                        <th>경도</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</template>

<script>
import selectCode from "../components/selectCode.vue";
// import { sidoCode, gugunCode, dongCode } from "../assets/map.js";

export default {
    components: { selectCode },
    name: "Map_",
    mounted() {
        window.kakao && window.kakao.maps
            ? this.initMap()
            : this.addKakaoMapScript();
    },
    methods: {
        addKakaoMapScript() {
            const script = document.createElement("script");
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src =
                "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=278146fb736e61be5c8d95d8b24bc1c0";
            document.head.appendChild(script);
        },
        initMap() {
            var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
            var options = {
                //지도를 생성할 때 필요한 기본 옵션
                center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
                level: 3, //지도의 레벨(확대, 축소 정도)
            };

            // var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
            new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        },
    },
};
// import { multi, map, initMap, addMarker, callHouseDealInfo } from '../assets/map.js'
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
