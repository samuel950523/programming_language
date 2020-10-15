<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Reader Test</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
</head>
<body>
	<h4>파일 하나, With Javascript</h4>
	<input type="file" id="fileSingle" onchange="doSingle(this);">
	<br>
	<h4>파일 여럿, With Javascript & jQuery</h4>
	<input type="file" id="fileMultiple" multiple>
<script>

function doSingle(input){
	let file = input.files[0];
	alert("File Name : " + file.name );
}

$(document).ready(function(){
	$("#fileMultiple").change(function(){
		if( this.files && this.files[0] ){
			
			for( var i=0; i<this.files.length; i++ ){
				console.log(this.files[i]);
				alert("File Name : " + this.files[i].name );
			}
		}
	});
});
</script>	
</body>
</html>