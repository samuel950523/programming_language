<template>
    <div>
        <div class="map" id="map"></div>
    </div>
</template>

<script>
import store from "../store/index.js";
var map; //지도 생성 및 객체 리턴
// var markerPosition; // 마커
export default {
    computed: {
        messageComputed() {
            // console.log(store.state.change);
            return store.state.change;
        },
    },
    mounted() {
        if (!store.state.change && window.kakao && window.kakao.maps) {
            this.initMap();
        } else {
            this.addKakaoMapScript();
        }
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
                center: new kakao.maps.LatLng(37.5743822, 126.9688505), //지도의 중심좌표.
                level: 3, //지도의 레벨(확대, 축소 정도)
            };

            map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
        },
        setCenter(lat, lng) {
            // 이동할 위도 경도 위치를 생성합니다
            var moveLatLon = new kakao.maps.LatLng(lat, lng);

            // 지도 중심을 이동 시킵니다
            map.setCenter(moveLatLon);
        },

        panTo(lat, lng, positions) {
            // 이동할 위도 경도 위치를 생성합니다
            var moveLatLon = new kakao.maps.LatLng(lat, lng);

            // 마커 생성하기
            for (let i = 0; i < positions.length; i++) {
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: new kakao.maps.LatLng(
                        positions[i].lat,
                        positions[i].lng
                    ),
                });
                // console.log(positions);
                marker.setMap(map);
            }
            // 지도 중심을 부드럽게 이동시킵니다
            // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
            map.panTo(moveLatLon);
        },
    },

    watch: {
        messageComputed: function () {
            if (store.state.change && window.kakao && window.kakao.maps) {
                if (store.state.lat) {
                    this.panTo(
                        store.state.lat,
                        store.state.lng,
                        store.state.positions
                    );
                } else {
                    this.initMap();
                }
            } else {
                this.addKakaoMapScript();
            }
        },
    },
};
</script>