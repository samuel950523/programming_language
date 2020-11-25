<template>
    <div class="content">
      <div class="board">
            <board-edit />
        </div>
   </div>
</template>

<script>
import boardEdit from "../components/boardEdit";

export default {
    components: { boardEdit,
                  
    },
    name: "BoardEdit_",
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