<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Reader Test</title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
</head>
<body>
	<h4>파일 Text, With Javascript</h4>
	<input type="file" id="fileText" onchange="doText(this);">
	<p id="pFileText"></p>
	<br>
	<h4>파일 Images, With Javascript & Jquery</h4>
	<input type="file" id="fileImage" multiple>
	<div id="divFileImage"></div>
	<p>For Better UI? Use CSS</p>
<script>

function doText(input){
	let file = input.files[0];
	let reader = new FileReader();
	reader.readAsText(file);
	reader.onload = function() {
	    document.getElementById("pFileText").innerText=reader.result;
	};
}

$(document).ready(function(){
	$("#fileImage").change(function(){
		if( this.files && this.files[0] ){

			for( var i=0; i<this.files.length; i++ ){

				var reader = new FileReader();
				reader.readAsDataURL(this.files[i]);
				reader.onload = function(e){
					$("#divFileImage").append('<img src="' + e.target.result +'" width="100">'); //reader.result : 마지막 것만 그려짐
				}
			}
		}
	});
});
</script>	
</body>
</html>