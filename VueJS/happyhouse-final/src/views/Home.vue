<template>
    <div class="content">
      <div class="hot_apartment">
         <div class="hot_title">최근 인기 매물 TOP 5</div>
         <div class="map2" style="height: 500px; margin: 0 0 50px 0;">
            <iframe
               src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d25334.38581948137!2d126.92673827451796!3d37.46548567125698!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ffac52c471b%3A0x4db3138b56ffcdc9!2z7ISc7Jq47Yq567OE7IucIOq0gOyVheq1rA!5e0!3m2!1sko!2skr!4v1600246573212!5m2!1sko!2skr"
               width="100%" height="100%" frameborder="0" style="border: 0;"
               allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
         </div>
         <div class="hot_images">
            <img src="../assets/house1.jpg">
            <div class="hot_images_title">관악구 봉천동 123-45</div>
         </div>
         <div class="hot_images">
            <img src="../assets/house2.jpg">
            <div class="hot_images_title">종로구 종로동 123-45</div>
         </div>
         <div class="hot_images">
            <img src="../assets/house3.jpg">
            <div class="hot_images_title">동대문구 동대문동 101호</div>
         </div>
         <div class="hot_images">
            <img src="../assets/house4.jpg">
            <div class="hot_images_title">광진구 광진동 12-45</div>
         </div>
         <div class="hot_images">
            <img src="../assets/house5.jpg">
            <div class="hot_images_title">성동구 성동동 111-11</div>
         </div>

      </div>

      <div class="nownews">
         <div class="nownews_title" style="width: 155px; float: left;">
            실시간 뉴스<span class="badge badge-secondary"
               style="margin: 0 0 0 10px;">New</span>
         </div>
         <div class="nownews_content">
            <div class="nownews_image">
               <img src="../assets/mainnews.jpg">
            </div>
            <div class="nownews_image_story">
               <p style="font-size: 25px; font-weight: bold;">부동산 실거래 조사 때
                  등기·과세 등 금융정보 적극 활용하는 법안 나온다</p>
               <p style="font-size: 10px;">서울경제 | 2020.09.16 15:18</p>
               <p style="font-size: 18px;">
                  허영 민주당 의원 대표발의<br> <br> 실거래 신고내용 조사 위한 자료 명확히<br> <br>
                  개인정보 오·남용 방지 위한 내용도 담겨
               </p>
            </div>
         </div>
      </div>
   </div>
</template>

<script>
export default {
    name: "Main"
  };
</script>

<style>

.title {
   float: left;
   margin: 40px 0 0 100px;
   font-weight: bold;
   font-size: 50px;
   color: black;
   opacity: 0.8;
}

.login {
   float: right;
   margin: 100px 30px 0 0;
   font-weight: bold;
   position: absolute;
   top: 0px;
   right: 5px;
}

.findPassword {
   margin: 40px 30px 0 0;
   font-weight: bold;
   position: absolute;
   top: 0px;
   right: 5px;
}

.signup {
   float: right;
   margin: 100px 30px 0 0;
   position: absolute;
   top: 0px;
   right: 120px;
}

.navbar_bold {
   font-weight: bold;
   color: white;
}

.content {
   width: 90%;
   height: 1000px;
   margin: 30px 0 0 100px;
}

.content .map2 {
   float: left;
   width: 100%;
   height: 500px;
}


.content .hot_apartment {
   width: 100%;
   margin: 30px 5% 30px 0;
   float: left;
}

.content .hot_apartment .hot_title, .content .nownews .nownews_title {
   width: 180px;
   height: 40px;
   margin: 0 0 20px 10px;
   padding: 8px 0 0 10px;
   color: white;
   background-color: #343A40;
   border-radius: 20px 20px;
   border: 1px solid #343A40;
   position: relative;
}

.content .hot_apartment .hot_images {
   height: 300px;
   width: 310px;
   float: left;
   margin: 0 0 0 10px;
}

.content .hot_apartment .hot_images img {
   width: 300px;
   height: 250px;
   float: left;
   margin: 0 0 10px 0;
}

.content .hot_apartment .hot_images .hot_images_title {
   text-align: center;
   font-weight: bold;
   font-size: 20px;
}

.content .nownews {
   float: left;
   width: 100%;
   height: 50%;
   margin: 30px 0 0 0;
   overflow-y: scroll;
   overflow-x: hidden
}

.nownews_nextbtn {
   border: 1px solid black;
   width: 200px;
   float: left;
   margin: 5px 0 0 30px;
}

.content .nownews .nownews_content {
   width: 100%;
   height: 300px;
   margin: 0 0 0 10px;
   float: left;
}

.content .nownews .nownews_content .nownews_image {
   float: left;
}

.content .nownews .nownews_content .nownews_image img {
   height: 300px;
   margin: 0 20px 0 0;
}

.content .nownews .nownews_content .nownews_image_story {
   float: left;
   width: 1100px;
   height: 300px;
   margin: 20px 0 0 0;
}

.modal-title {
   margin-left: 110px;
   font-weight: bold;
}

label {
   font-weight: bold;
}

footer {
   border-top: 2px solid black;
   height: 200px;
   width: 100%;
   float: left;
}

.modal-login {
   color: #636363;
   width: 350px;
}

.modal-login .modal-content {
   padding: 20px;
   border-radius: 5px;
   border: none;
}

.modal-login .modal-header {
   border-bottom: none;
   position: relative;
   justify-content: center;
}

.modal-login h4 {
   text-align: center;
   font-size: 26px;
   margin: 30px 0 -15px;
}

.modal-login .form-control:focus {
   border-color: #70c5c0;
}

.modal-login .form-control, .modal-login .btn {
   min-height: 40px;
   border-radius: 3px;
}

.modal-login .close {
   position: absolute;
   top: -5px;
   right: -5px;
}

.modal-login .modal-footer {
   background: #ecf0f1;
   border-color: #dee4e7;
   text-align: center;
   justify-content: center;
   margin: 0 -20px -20px;
   border-radius: 5px;
   font-size: 13px;
}

.modal-login .modal-footer a {
   color: #999;
}

.modal-login .avatar {
   position: absolute;
   margin: 0 auto;
   left: 0;
   right: 0;
   top: -70px;
   width: 95px;
   height: 95px;
   border-radius: 50%;
   z-index: 9;
   background: #60c7c1;
   padding: 15px;
   box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.modal-login .avatar img {
   width: 100%;
}

.modal-login.modal-dialog {
   margin-top: 80px;
}

.modal-login .btn, .modal-login .btn:active {
   color: #fff;
   border-radius: 4px;
   background: #60c7c1 !important;
   text-decoration: none;
   transition: all 0.4s;
   line-height: normal;
   border: none;
}

.modal-login .btn:hover, .modal-login .btn:focus {
   background: #45aba6 !important;
   outline: none;
}

.inputcondition {
   font-size: 13px;
   color: #999;
}
</style>