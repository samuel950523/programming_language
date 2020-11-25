<template>
    <div>
        <div class="map" id="map"></div>
    </div>
</template>

<script>
import store from "../store/index.js";
var map; //지도 생성 및 객체 리턴
var mapTypeControl;
// var markerPosition; // 마커
export default {
    computed: {
        messageComputed() {
            // console.log(store.state.change);
            return store.state.dongChange;
        },
        aptMessageComputed() {
            // console.log(store.state.change);
            return store.state.aptChange;
        },
    },
    mounted() {
        if (!store.state.dongChange && window.kakao && window.kakao.maps) {
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
                level: 5, //지도의 레벨(확대, 축소 정도)
            };

            map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
            mapTypeControl = new kakao.maps.MapTypeControl();

            // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
            // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            map.addOverlayMapTypeId(kakao.maps.MapTypeId.TRAFFIC);
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

            // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
            function makeOverListener(map, marker, infowindow) {
                return function () {
                    infowindow.open(map, marker);
                };
            }

            // 인포윈도우를 닫는 클로저를 만드는 함수입니다
            function makeOutListener(infowindow) {
                return function () {
                    infowindow.close();
                };
            }

            // 마커 생성하기
            for (let i = 0; i < positions.length; i++) {
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: new kakao.maps.LatLng(
                        positions[i].lat,
                        positions[i].lng
                    ),
                    clickable: true,
                });
                // console.log(positions);

                // 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다

                // ------------------------- //
                //  여기에 집 정보 올려놔야   //
                // ------------------------- //
                // positions[i].aptName 에 아파트 이름이 담겨져있다.
                // console.log(positions[i].aptName);
                var iwContent =
                        '<div style="padding:5px;">' +
                        positions[i].aptName +
                        "</div>", // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
                    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

                // 인포윈도우를 생성합니다
                var infowindow = new kakao.maps.InfoWindow({
                    content: iwContent,
                    removable: iwRemoveable,
                });
                // 마커에 클릭이벤트를 등록합니다

                kakao.maps.event.addListener(
                    marker,
                    // "click",
                    "mouseover",
                    makeOverListener(map, marker, infowindow)
                );
                kakao.maps.event.addListener(
                    marker,
                    "mouseout",
                    makeOutListener(infowindow)
                );
                marker.setMap(map);
            }
            // 지도 중심을 부드럽게 이동시킵니다
            // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다

            map.panTo(moveLatLon);
        },
        // 인포윈도우를 표시하는 클로저를 만드는 함수입니다
    },

    watch: {
        messageComputed: function () {
            if (store.state.dongChange && window.kakao && window.kakao.maps) {
                if (store.state.lat) {
                    this.initMap(); // 마커가 누적되지 않게 초기화
                    console.log(store.state.positions);
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
        aptMessageComputed: function () {
            if (store.state.aptChange && window.kakao && window.kakao.maps) {
                if (store.state.lat) {
                    console.log(store.state.positions);
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