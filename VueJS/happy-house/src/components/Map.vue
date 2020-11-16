<template>
  <div class="content">
		<div class="map" id="map">
            <iframe
               src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25334.38581948137!2d126.92673827451796!3d37.46548567125698!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ffac52c471b%3A0x4db3138b56ffcdc9!2z7ISc7Jq47Yq567OE7IucIOq0gOyVheq1rA!5e0!3m2!1sko!2skr!4v1600246573212!5m2!1sko!2skr"
               width="100%" height="100%" frameborder="0" style="border: 0;"
               allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
        </div>
		<div class="search">
			<form action="/action_page.php">
				<label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">시</label>
				<select id="sido">
					<option value="0">선택</option>
				</select> <br> <br> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">군
					/ 구</label> <select id="gugun">
					<option value="0">선택</option>
				</select> <br> <br> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">동</label>
				<select id="dong">
					<option value="0">선택</option>
				</select> <label class="badge badge-secondary"
					style="margin: 50px 20px 0 50px; height: 30px; font-size: 20px;">아파트이름</label>
				<input type="text" id="aptdetail" name="aptdetail"
					style="margin: 50px 20px 0 50px"><br>
			</form>
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
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</template>

<script>
  export default {
    name: "Map_",
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

.content .search .search_city, .content .search .search_gu, .content .search .search_dong
	{
	float: left;
	width: 100%;
	height: 20%;
}

.content .search .search_select .select_apartment, .content .search .search_select .select_jutaek
	{
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

#page>ul li a {
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
</style>