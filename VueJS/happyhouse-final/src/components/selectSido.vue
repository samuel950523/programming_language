<template>
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
</template>

<script>
export default {
    methods: {
        sidoChange(event) {
            // console.log(event.target.value);
            let val = event.target.value;
            this.$store.commit("sidoVal", { val });
        },
    },
};
</script>