<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.dto.*, java.util.*"%>
<%
	String contextPath = request.getContextPath();
UserDto userDto = (UserDto) session.getAttribute("userDto");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<meta charset="utf-8">
<title>Board</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />
</head>
<body>
	<nav class="navbar navbar-expand-md">
		<a class="navbar-brand" href="#"><img
			src="<%=contextPath + userDto.getUserProfileImageUrl()%>" alt="Logo"
			style="width: 40px; border-radius: 50%;"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<%=contextPath%>/board/boardMain">게시판</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h4 class="text-center">게시판 - Main</h4>
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
			</tbody>
		</table>
		<div id="paginationWrapper"></div>

		<button class="btn btn-sm btn-primary" id="btnInsertPage">글쓰기</button>
	</div>
	<!-- Modal detail-->

	<!-- modal begin ------------------------------------------------------------------------->

	<!-- Modal insert-->
	<div class="modal fade" id="boardInsertModal">
		<div class="modal-dialog modal-simple">
			<form class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글쓰기</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xl-12 form-group">
							<input id="titleInsert" type="text" class="form-control"
								name="title" placeholder="제목">
						</div>
						<div class="col-xl-12 form-group">
							<textarea id="contentInsert" class="form-control" rows="5"
								placeholder="내용"></textarea>
						</div>
						<div class="col-md-12 float-right">
							<button id="btnBoardInsert"
								class="btn btn-sm btn-primary btn-outline" data-dismiss="modal"
								type="button">등록</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- End Modal -->
	<div class="modal fade" id="boardDetailModal">
		<div class="modal-dialog modal-simple">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글 상세</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<div class="modal-body">

					<div class="example table-responsive">
						<table class="table table-hover">
							<tbody>
								<tr>
									<td>글번호</td>
									<td id="boardIdDetail">#</td>
								</tr>
								<tr>
									<td>제목</td>
									<td id="titleDetail">#</td>
								</tr>
								<tr>
									<td>내용</td>
									<td id="contentDetail">#</td>
								</tr>
								<tr>
									<td>작성자</td>
									<td id="userNameDetail">#</td>
								</tr>
								<tr>
									<td>작성일시</td>
									<td id="regDtDetail">#</td>
								</tr>
								<tr>
									<td>조회수</td>
									<td id="readCountDetail">#</td>
								</tr>
							</tbody>
						</table>
					</div>
					<button id="btnBoardUpdateForm"
						class="btn btn-sm btn-primary btn-outline" data-dismiss="modal"
						type="button">글 수정하기</button>
					<button id="btnBoardDeleteConfirm"
						class="btn btn-sm btn-warning btn-outline" data-dismiss="modal"
						type="button">글 삭제하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->
	<!-- Modal update-->
	<div class="modal fade" id="boardUpdateModal">
		<div class="modal-dialog modal-simple">
			<form class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">글수정</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xl-12 form-group">
							<input id="titleUpdate" type="text" class="form-control"
								name="title" placeholder="제목">
						</div>
						<div class="col-xl-12 form-group">
							<textarea id="contentUpdate" class="form-control" rows="5"
								placeholder="내용"></textarea>
						</div>
						<div class="col-md-12 float-right">
							<button id="btnBoardUpdate"
								class="btn btn-sm btn-primary btn-outline" data-dismiss="modal"
								type="button">수정</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- End Modal -->
	<script src="<%=contextPath%>/js/util.js"></script>		
<script>

var LIST_ROW_COUNT = 10;	//limit
var OFFSET = 0;
var SEARCH_WORD = "";

$(document).ready(function(){
	
	boardList();
	
	$("#btnSearchWord").click(function(){

		SEARCH_WORD = $("#inputSearchWord").val();
		
		if( searchWord != "" ){
			SEARCH_WORD = searchWord;
		}else{
			SEARCH_WORD = "";
		}
		
		boardList();
		
	});
	
	
	// insert Page
	$("#btnInsertPage").click(function(){
		
		$("#titleInsert").val("");
		$("#contentInsert").val("");
		
		$("#boardInsertModal").modal("show");
	});
	
	// insert
	$("#btnBoardInsert").click(function(){
		
		if( validateInsert() ){
			boardInsert();
		}
	});
	
	// update
	$("#btnBoardUpdateForm").click(function(){
		
		var boardId = $("#boardDetailModal").attr("data-boardId");
		$("#boardUpdateModal").attr("data-boardId", boardId);
		
		$("#titleUpdate").val( $("#titleDetail").html() );
		$("#contentUpdate").val( $("#contentDetail").html() );
		
		$("#boardDetailModal").modal("hide");
		$("#boardUpdateModal").modal("show");
	});
	
	$("#btnBoardUpdate").click(function(){
		
		if( validateUpdate() ){
			boardUpdate();
		}
	});
	
	// delete
	$("#btnBoardDeleteConfirm").click(function(){
		 alertify.confirm('삭제 확인', '이 글을 삭제하시겠습니까?',
 			function() {
				boardDelete();
 			},
			function(){
 				console.log('cancel');
			}
		);
	});
});

function boardList(){
	$.ajax(
	{
        type : 'get',
        url : '<%=contextPath%>/board/boardList',
        dataType : 'json',
        data : 
		{
        	limit: LIST_ROW_COUNT,
			offset: OFFSET,
			searchWord: SEARCH_WORD
		},
        success : function(data, status, xhr) { 
        	makeListHtml(data);
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	console.log(textStatus);
        	
        	alertify.notify(
       			'Opps!! 글 조회 과정에 문제가 생겼습니다.', 
       			'error', //'error','warning','message'
       			3, //-1
       			function(){
       				console.log(jqXHR.responseText); 
       			}
       		);
        }
    });
}

function makeListHtml(list){

	$("#boardTbody").html("");

	for( var i=0; i<list.length; i++){
	
		var boardId = list[i].boardId;
		var userName = list[i].userName;
		var title = list[i].title;
		var content = list[i].content;
		var regDt = list[i].regDt;	// javascript of parsed from LocalDateTime
		
		var regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.');
		
		var readCount = list[i].readCount;
		
		var listHtml =
			'<tr style="cursor:pointer" data-boardId=' + boardId +'><td>' + boardId + '</td><td>' + title + '</td><td>' + userName + '</td><td>' + regDtStr + '</td><td>' + readCount + '</td></tr>';

		$("#boardTbody").append(listHtml);
	}
	
	makeListHtmlEventHandler();
	
	boardListTotalCnt();
}

function makeListHtmlEventHandler(){
	$("#boardTbody tr").click(function(){
		var boardId = $(this).attr("data-boardId");
		var userSeq = '<%=userDto.getUserSeq()%>';
		boardDetail(boardId, userSeq);
	});
}

var PAGE_LINK_COUNT = 10;	// pagination link 갯수
var TOTAL_LIST_ITEM_COUNT = 0;
var CURRENT_PAGE_INDEX = 1;

function boardListTotalCnt(){
	
	$.ajax(
	{
        type : 'get',
        url : '<%=contextPath%>/board/boardListTotalCnt',
        dataType : 'json',
        data : 
		{
			searchWord: SEARCH_WORD
		},
        success : function(data, status, xhr) {
        	TOTAL_LIST_ITEM_COUNT = data.totalCnt;
        	addPagination();
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	alertify.notify(
       			'Opps!! 글 전체 갯수 조회 과정에 문제가 생겼습니다.', 
       			'error', //'error','warning','message'
       			3, //-1
       			function(){
       				console.log(jqXHR.responseText); 
       			}
       		);
        }
    });
}

function addPagination(){

	makePaginationHtml(LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
}

function movePage(pageIndex){
	OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
	CURRENT_PAGE_INDEX = pageIndex;
	boardList();
}


// insert
function validateInsert(){
	var isTitleInsertValid = false;
	var isContentInsertValid = false;

	var titleInsert = $("#titleInsert").val();
	var titleInsertLength = titleInsert.length;
	
	if( titleInsertLength > 0 ){
		isTitleInsertValid = true;
	}
	
	var contentInsertValue = $("#contentInsert").val();
	var contentInsertLength = contentInsertValue.length;
	
	if( contentInsertLength > 0 ){
		isContentInsertValid = true;
	}

	if(	isTitleInsertValid && isContentInsertValid ){
		return true;
	}else{
		return false;
	}
}

function boardInsert(){

	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardInsert',
        dataType : 'json',
        data : 
		{
        	userSeq: '<%=userDto.getUserSeq()%>',
        	title: $("#titleInsert").val(),
        	content: $("#contentInsert").val()
		},
        success : function(data, status, xhr) { 
		
        	if(data.result == "success"){
        		alertify.success('글이 등록되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        { 
        	alertify.notify(
      			'Opps!! 글 등록 과정에 문제가 생겼습니다.', 
      			'error', //'error','warning','message'
      			3, //-1
      			function(){
      				console.log(jqXHR.responseText); 
      			}
      		);
        	
        }
    });
}

// detail
function boardDetail(boardId, userSeq){

	$.ajax(
	{
        type : 'get',
        url : '<%= contextPath%>/board/boardDetail',
        dataType : 'json',
        data : 
		{
        	boardId: boardId
		},
        success : function(data, status, xhr) { 

        	makeDetailHtml(data);
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
    		alertify.notify(
       			'Opps!! 글 상세 조회 과정에 문제가 생겼습니다.', 
       			'error', //'error','warning','message'
       			3, //-1
       			function(){
       				console.log(jqXHR.responseText); 
       			}
       		);
        }
    });
}

function makeDetailHtml(detail){
	
	var boardId = detail.boardId;
	var userSeq = detail.userSeq;
	var userName = detail.userName;
	var title = detail.title;
	var content = detail.content;
	var regDt = detail.regDt;

	var regDtStr = makeDateStr(regDt.date.year, regDt.date.month, regDt.date.day, '.') + ' ' + makeTimeStr(regDt.time.hour, regDt.time.minute, regDt.time.second, ':');
	
	var readCount = detail.readCount;

	$("#boardDetailModal").attr("data-boardId", boardId);
	$("#boardIdDetail").html("#" + boardId);
	$("#titleDetail").html(title);
	$("#contentDetail").html(content);
	$("#userNameDetail").html(userName);
	$("#regDtDetail").html(regDtStr);
	$("#readCountDetail").html(readCount);
	
	if( userSeq != '<%=userDto.getUserSeq()%>' ){
		$("#btnBoardUpdateForm").hide();
		$("#btnBoardDeleteConfirm").hide();
	}else{
		$("#btnBoardUpdateForm").show();
		$("#btnBoardDeleteConfirm").show();
	}
	
	$("#boardDetailModal").modal("show");
}

// update
function validateUpdate(){
	var isTitleUpdateValid = false;
	var isContentUpdateValid = false;

	var titleUpdate = $("#titleUpdate").val();
	var titleUpdateLength = titleUpdate.length;
	
	if( titleUpdateLength > 0 ){
		isTitleUpdateValid = true;
	}
	
	var contentUpdateValue = $("#contentUpdate").val();
	var contentUpdateLength = contentUpdateValue.length;
	
	if( contentUpdateLength > 0 ){
		isContentUpdateValid = true;
	}

	if(	isTitleUpdateValid && isContentUpdateValid ){
		return true;
	}else{
		return false;
	}
}

function boardUpdate(){

	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardUpdate',
        dataType : 'json',
        data : 
		{
        	boardId: $("#boardUpdateModal").attr("data-boardId"),
        	title: $("#titleUpdate").val(),
        	content: $("#contentUpdate").val()
		},
        success : function(data, status, xhr) { 
		
        	if(data.result == "success"){
        		alertify.success('글이 수정되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
        	alertify.notify(
       			'Opps!! 글 수정 과정에 문제가 생겼습니다.', 
       			'error', //'error','warning','message'
       			3, //-1
       			function(){
       				console.log(jqXHR.responseText); 
       			}
       		);
        }
    });
}

// delete
function boardDelete(){
	$.ajax(
	{
        type : 'post',
        url : '<%= contextPath%>/board/boardDelete',
        dataType : 'json',
        data : 
		{
        	boardId: $("#boardDetailModal").attr("data-boardId")
		},
        success : function(data, status, xhr) { 
			console.log("RGR");
        	if(data.result == "success"){
        		alertify.success('글이 삭제되었습니다.');
        		boardList();
        	}
        }, 
        error: function(jqXHR, textStatus, errorThrown) 
        {
        	alertify.notify(
       			'Opps!! 글 삭제 과정에 문제가 생겼습니다.', 
       			'error', //'error','warning','message'
       			3, //-1
       			function(){
       				console.log(jqXHR.responseText); 
       			}
       		);
        }
    });
}
</script>
</body>
</html>