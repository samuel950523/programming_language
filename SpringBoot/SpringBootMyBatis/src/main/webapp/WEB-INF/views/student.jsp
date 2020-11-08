<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
		<h4>학생 목록</h4>
		<hr>
		<table style="border: 1px; margin: auto; text-align: center;">
			<thead>
				<tr><td>StudentId</td><td>StudentNm</td><td>Email</td><td>Phone</td></tr>
			</thead>
			<tbody id="tbodyStudent">
				
			</tbody>
		</table>
		<hr>
		<form>
			<table style="border: 1px; margin: auto; text-align: center;">
				<tbody>
					<tr><td>StudentNm</td><td><input type="text" name="studentNm" id="inputName"></td></tr>
					<tr><td>Email</td><td><input type="text" name="email" id="inputEmail"></td></tr>
					<tr><td>Phone</td><td><input type="text" name="phone" id="inputPhone"></td></tr>
				</tbody>
			</table>
		</form>
		<div style="border: 1px; margin: auto; text-align: center;">
			<button id="btnInsert">학생 등록</button>
			<button id="btnUpdate">학생 수정</button>
			<button id="btnDelete">학생 삭제</button>
			<button id="btnClear">초기화</button>
		</div>
		
<script>
	var CURRENT_ID;
	
	$(document).ready(function() {
		list();
		
		//insert
		$("#btnInsert").click(function(){
			insertStudent();
		});
		
		//update
		$("#btnUpdate").click(function(){
			updateStudent();
		});
		//delete
		$("#btnDelete").click(function(){
			deleteStudent();
		});
		
		//초기화
		$("#btnClear").click(function(){
			clear();
		});
		
	});

	function list(){
		$.ajax(
		{
	        type : 'get',
	        url : '/students',
	        dataType : 'json',
	        success : function(data, status, xhr) { 

	        	makeListHtml(data);
	        }, 
	        error: function(jqXHR, textStatus, errorThrown) 
	        { 
	        	console.log(jqXHR.responseText); 
	        }
	    });
	}
	
	function makeListHtml(list){

		$("#tbodyStudent").html("");

		for( var i=0; i<list.length; i++){
			
			var studentId = list[i].studentId;
			var studentNm = list[i].studentNm;
			var phone = list[i].phone;
			var email = list[i].email;
			
			var listHtml =
				'<tr style="cursor:pointer" data-studentId=' + studentId +'><td>' + studentId + '</td><td>' + studentNm + '</td><td>' + email + '</td><td>' + phone + '</td></tr>';

			$("#tbodyStudent").append(listHtml);
		}

		makeListHtmlEventHandler();
	}
	
	function makeListHtmlEventHandler(){
		$("#tbodyStudent tr").click(function(){
			var studentId = $(this).attr("data-studentId");
			detail(studentId);
		});
	}
	
	function detail(studentId){
		
	}
	
	function makeDetailHtml(detail){
		console.log(detail);
		var studentId = detail.studentId;
		var studentNm = detail.studentNm;
		var phone = detail.phone;
		var email = detail.email;

		CURRENT_ID = studentId;
		
		$("#inputName").val(studentNm);
		$("#inputPhone").val(phone);
		$("#inputEmail").val(email);
	}
	
	function insertStudent(){
		var student = { studentNm:$("#inputName").val(), phone: $("#inputPhone").val(), email: $("#inputEmail").val() };
		
		$.ajax(
		{
	        type : 'post',
	        url : '/students',
	        dataType : 'json',
	        data : JSON.stringify( student ),
	        contentType : 'application/json',
	        success : function(data, status, xhr) { 

	        	list();
	        	clear();
	        }, 
	        error: function(jqXHR, textStatus, errorThrown) 
	        { 
	        	console.log(jqXHR.responseText); 
	        }
	    });
	}
	
	function updateStudent(){

	}
	
	function deleteStudent(){

	}
	
	function clear(){
		CURRENT_ID = "";
		$("#inputName").val("");
		$("#inputPhone").val("");
		$("#inputEmail").val("");
	}

</script>
</body>
</html>