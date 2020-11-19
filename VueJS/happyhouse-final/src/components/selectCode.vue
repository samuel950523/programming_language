<template>
    <div>
        <form action="/action_page.php">
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
            <select @change="dongChange($event)" id="dong">
                <option
                    v-for="(dong, dongcode) in dongList"
                    :value="dongcode"
                    :key="dongcode"
                >
                    {{ dong.dong }}
                </option>
            </select>
            <label class="badge badge-secondary">아파트이름</label>
            <input
                type="text"
                id="aptdetail"
                name="aptdetail"
                style="margin: 50px 20px 0 50px"
            /><br />
        </form>
    </div>
</template>

<script>
import { gugunCode, dongCode } from "../assets/map.js"; // static 배열 import

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

export default {
    data() {
        return {
            gugunList: gugunList,
            dongList: dongList,
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

            // console.log(gugunList);
        },
        gugunChange(event) {
            let val = gugunCode[event.target.value - 1].gugun_code; // 구군코드 5자리가 받아짐
            // console.log(gugunCode[val]);
            dongList.length = 0; // 동 배열 초기화
            dongList.push({
                dongcode: "0",
                city: "",
                gugun: "",
                dong: "선택",
            });
            // console.log("Val " + val);

            for (let i = 0; i < dongCode.length; i++) {
                // 배열 탐색
                if (parseInt(dongCode[i].dongcode.substring(0, 5)) == val) {
                    // 시도구군 코드가 같다면
                    dongList.push(dongCode[i]); // push 해줌
                }
            }
            // console.log(dongList);
        },

        dongChange(event) {
            let val = event.target.value;
            console.log(val);
            // 여기에 검색 기능 추가
        },
    },
};
</script>