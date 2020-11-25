<template>
    <div>
        <form>
            <label class="badge badge-secondary">시</label>
            <select @change="sidoChange($event)" id="sido">
                <option value="0">선택</option>
                <option value="11">서울특별시</option>
                <option value="26">부산광역시</option>
                <option value="27">대구광역시</option>
                <option value="28">인천광역시</option>
                <option value="29">광주광역시</option>
                <option value="30">대전광역시</option>
                <option value="31">울산광역시</option>
                <option value="36">세종특별자치시</option>
                <option value="41">경기도</option>
                <option value="42">강원도</option>
                <option value="43">충청북도</option>
                <option value="44">충청남도</option>
                <option value="45">전라북도</option>
                <option value="46">전라남도</option>
                <option value="47">경상북도</option>
                <option value="48">경상남도</option>
                <option value="50">제주특별자치도</option>
            </select>
            <br />
            <br />
            <label class="badge badge-secondary">군 / 구</label>
            <select @change="gugunChange($event)" id="gugun">
                <option
                    v-for="(gugun, gugun_code) in gugunList"
                    :value="gugun_code"
                    :key="gugun_code"
                >
                    {{ gugun.gugun_name }}
                </option>
            </select>
            <br />
            <br />
            <label class="badge badge-secondary">동</label>
            <select @change="isDongChange($event)" id="dong">
                <option
                    v-for="(dong, dongcode) in dongList"
                    :value="dongcode"
                    :key="dongcode"
                >
                    {{ dong.dong }}
                </option>
            </select>
            <label class="badge badge-secondary">아파트이름</label>
            <input type="text" @input="aptSearch($event)" id="aptSearch" />
            <br />
        </form>
    </div>
</template>

<script>
import axios from "axios";
import { gugunCode, dongCode } from "../assets/map.js"; // static 배열 import
import { loc } from "../assets/loc.js";
// import { aptDeal } from "../assets/aptDeal.js";

var gugunList = [
    {
        gugun_code: "",
        gugun_name: "선택",
    },
];
var dongList = [
    {
        dongcode: "0",
        city: "",
        gugun: "",
        dong: "선택",
    },
];
var dongChange = "";
var aptChange = "";

var lat = 0;
var lng = 0;
var cnt = 0;
var positions = [];
var aptList = [];
var aptNameInput = "";
export default {
    data() {
        return {
            gugunList: gugunList,
            dongList: dongList,
            dongChange: dongChange,
            aptChange: aptChange,
            dongCode: "",
            lat: lat,
            lng: lng,
            cnt: cnt,
            positions: positions,
            aptList: aptList,
            aptNameInput: aptNameInput,
        };
    },
    methods: {
        sidoChange(event) {
            // console.log(event.target.value);
            let val = event.target.value;
            gugunList.length = 0; // 구군 배열 초기화
            gugunList.push({
                gugun_code: "",
                gugun_name: "선택",
            });
            // console.log(val);
            // this.$store.commit("sidoVal", { val }); // vuex 사용시
            for (let i = 0; i < gugunCode.length; i++) {
                // 배열 탐색
                if (parseInt(gugunCode[i].gugun_code.substring(0, 2)) == val) {
                    // 시도 코드가 같다면
                    gugunList.push(gugunCode[i]); // push 해줌
                }
            }
        },
        gugunChange(event) {
            let val = gugunCode[event.target.value - 1].gugun_code; // 구군코드 5자리가 받아짐
            dongList.length = 0; // 동 배열 초기화
            dongList.push({
                dongcode: "0",
                city: "",
                gugun: "",
                dong: "선택",
            });

            for (let i = 0; i < dongCode.length; i++) {
                // 배열 탐색
                if (parseInt(dongCode[i].dongcode.substring(0, 5)) == val) {
                    // 시도구군 코드가 같다면
                    dongList.push(dongCode[i]); // push 해줌
                }
            }
        },
        makelistprops: function (houses) {
            var result = [];
            for (var i in houses.data) {
                result.push({
                    dong: houses.data[i].dong,
                    aptName: houses.data[i].aptName,
                    dealAmount: houses.data[i].dealAmount.trim(),
                    area: houses.data[i].area,
                    floor: houses.data[i].floor,
                    buildYear: houses.data[i].buildYear,
                    // status: "created",
                });
            }
            return result;
        },
        isDongChange: async function (event) {
            let dongName = 0;
            dongName = dongList[event.target.value].dong;

            // loc.js에서 맞는 동들 찾음

            // loc에는 서울의 모든 아파트 좌표들이 다 들어있다.
            // 매물들의 좌표
            var lat = 0;
            var lng = 0;
            var cnt = 0;
            var positions = [];

            for (let i = 0; i < loc.length; i++) {
                if (loc[i].dong == dongName) {
                    lat += parseFloat(loc[i].lat);
                    lng += parseFloat(loc[i].lng);
                    cnt++;
                    positions.push({
                        lat: loc[i].lat,
                        lng: loc[i].lng,
                        aptName: loc[i].AptName,
                    });
                }
            }

            lat = parseFloat(lat / cnt); // 이 데이터를
            lng = parseFloat(lng / cnt); // kakaoMap.vue로 넘겨주어야함

            // 매물들의 상세 정보
            // 여기는 DB에서 받아와야한다.

            const showAptlist = (params) => {
                return new Promise((resolve) => {
                    try {
                        const result = axios.get(
                            `http://127.0.0.1:8080/getAptInDong?dongName=${params}`,
                            {
                                params: params, // 여기에 동 이름을 넣는 것
                            }
                            // axiosConfig
                        );
                        resolve(result);
                    } catch (error) {
                        resolve(false);
                    }
                });
            };
            const result = await showAptlist(dongName); // await는 비동기로 제어하기 위해 쓰는 것
            const data = this.makelistprops(result);

            var aptList = [];
            for (var i in data) {
                aptList.push(data[i]);
            }

            dongChange = dongName;

            // store로 보내기
            this.$store.commit("latVal", { lat });
            this.$store.commit("lngVal", { lng });
            this.$store.commit("isDongChange", { dongChange });
            this.$store.commit("positions", { positions });
            this.$store.commit("aptList", { aptList });
        },

        aptSearch: async function (event) {
            // 아파트명으로 검색
            let aptName = event.target.value;
            const showAptSearchlist = (dong, name) => {
                return new Promise((resolve) => {
                    try {
                        const result = axios.get(
                            `http://127.0.0.1:8080/getAptSearch?info=${[
                                dong,
                                name,
                            ]}`,
                            {
                                dong: dong,
                                name: name,
                            }
                            // axiosConfig
                        );
                        resolve(result);
                    } catch (error) {
                        resolve(false);
                    }
                });
            };

            const result = await showAptSearchlist(
                this.$store.state.dongChange,
                aptName
            ); // await는 비동기로 제어하기 위해 쓰는 것
            const data = this.makelistprops(result);
            var aptList = [];
            for (var i in data) {
                aptList.push(data[i]);
            }

            var lat = 0;
            var lng = 0;
            var cnt = 0;
            var positions = [];

            for (let i = 0; i < loc.length; i++) {
                if (
                    loc[i].dong == this.$store.state.dongChange &&
                    loc[i].AptName.includes(aptName)
                ) {
                    console.log(loc[i].AptName + " " + aptName);
                    lat += parseFloat(loc[i].lat);
                    lng += parseFloat(loc[i].lng);
                    cnt++;
                    positions.push({
                        lat: loc[i].lat,
                        lng: loc[i].lng,
                        aptName: loc[i].AptName,
                    });
                }
            }

            lat = parseFloat(lat / cnt); // 이 데이터를
            lng = parseFloat(lng / cnt); // kakaoMap.vue로 넘겨주어야함
            dongChange = this.$store.state.dongChange;
            aptChange = aptName;

            // store로 보내기
            this.$store.commit("latVal", { lat });
            this.$store.commit("lngVal", { lng });
            this.$store.commit("isDongChange", { dongChange });
            this.$store.commit("isAptChange", { aptChange });
            this.$store.commit("positions", { positions });
            this.$store.commit("aptList", { aptList });
        },
    },
};
</script>