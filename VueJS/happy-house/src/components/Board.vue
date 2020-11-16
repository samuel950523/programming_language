<template>
   <div class="container">

      <h4 class="text-center" style="margin-top:20px">게시판 - Main</h4>

      <div class="input-group mb-3">
         <input id="inputSearchWord" type="text" class="form-control"
            placeholder="Search">
         <div class="input-group-append">
            <button id="btnSearchWord" class="btn btn-success">Go</button>
         </div>
      </div>

      <table class="table table-hover">
         <thead>
            <tr>
               <th>#</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일시</th>
               <th>조회수</th>
            </tr> 
         </thead>
         <tbody id="boardTbody">
      <tr>
        <td>1</td>
        <td>안녕하세요. </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>478382</td>
      </tr>
     <tr>
        <td>2</td>
        <td>조회수 관련 공지드립니다.  </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>472</td>
      </tr>
       <tr>
        <td>3</td>
        <td> 회원 수 100명 돌파 . 감사합니다  </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>3434472</td>
      </tr>
       <tr>
        <td>4</td>
        <td> 회원 수 10000명 돌파 . 감사합니다  </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>342</td>
      </tr>
             <tr>
        <td>5</td>
        <td> 회원 수 100000명 돌파 . 감사합니다  </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>32</td>
      </tr>
             <tr>
        <td>6</td>
        <td> 회원가입 가이드  </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>342</td>
      </tr>
      <tr>
        <td>7</td>
        <td> 아파트관련 공지사항 </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>31231242</td>
      </tr>
            <tr>
        <td>8</td>
        <td> 안녕하세요!   </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>34472</td>
      </tr>
            <tr>
        <td>9</td>
        <td> 감사합니다. </td>
        <td>happyhouse관리자</td>
        <td>2020-11-16</td>
        <td>3434472</td>
      </tr>
         </tbody>
      </table>

      <div id="paginationWrapper"></div>

      <button class="btn btn-sm btn-primary" id="btnInsertPage" style="margin-bottom:25px;">글쓰기</button>
   </div>
</template>

<script>

</script>