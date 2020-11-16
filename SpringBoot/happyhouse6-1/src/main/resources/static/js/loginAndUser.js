// login 
		function loginValidate() {
			var isUserNameValid = false;
			var isUserPasswordValid = false;

			var userNameValue = $("#Lusername").val();
			var userNameLength = userNameValue.length;

			if (userNameLength > 0) {
				isUserNameValid = true;
			}

			var userPasswordValue = $("#Lpassword").val();
			var userPasswordLength = userPasswordValue.length;

			if (userPasswordLength > 0) {
				isUserPasswordValid = true;
			}

			if (isUserNameValid && isUserPasswordValid) {
				return true;
			} else {
				return false;
			}
		}

		// sign up
		function validateUserName(userName) {
			if (userName.val().length >= 8)
				return true;
			else
				return false;
		}

		function validatePassword(password) {
			if (password.val().length >= 4)
				return true;
			else
				return false;
		}

		function validatePassword2(password2) {
			if (password2.val() == $("#Spassword").val())
				return true;
			else
				return false;
		}

		function validatePhone(phone) {
			// \d 숫자
			// {3,4} 3개 ~ 4개
			let regexp = /^\d{3}-\d{3,4}-\d{4}$/;
			if (regexp.test(phone.val()))
				return true;
			else
				return false;
		}

		function validateEmail(email) {
			// ^ 시작일치, $ 끝 일치
			// {2, 3} 2개 ~ 3개
			// * 0회 이상, + 1회 이상
			// [-_.] - 또는 _ 또는 .
			// ? 없거나 1회
			let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			if (regexp.test(email.val()))
				return true;
			else
				return false;
		}

		function register() {
			let jsonData = JSON.stringify({
				userName : $("#Susername").val(),
				userPassword : $("#Spassword").val(),
				userEmail : $("#Semail").val()
			});

			console.log(jsonData);

			$.ajax({
				type : 'post',
				url : '/register',
				dataType : 'json',
				data : jsonData,
				contentType : 'application/json',
				success : function(data, status, xhr) {
					console.log(data.result);
					alertify.alert('Welcome!', '회원가입을 축하합니다.', function() {
						window.location.reload();
					});
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alertify.notify('Opps!! 회원가입에 문제가 생겼습니다.', 'error', 3,
							function() {
								console.log(jqXHR.responseText);
							});
				}
			});
		}

		function login() {
			let jsonData = JSON.stringify({
				userName : $("#Lusername").val(),
				userPassword : $("#Lpassword").val()
			});

			console.log(jsonData);

			$.ajax({
				type : 'post',
				url : '/login',
				dataType : 'json',
				data : jsonData,
				contentType : 'application/json',
				success : function(data, status, xhr) {
					console.log(data);
					window.location.reload();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alertify.notify('Opps!! 서버에 문제가 발생했습니다.', 'error', // error, warning, message
					3, // -1
					function() {
						console.log(jqXHR.responseText);
					});
				}
			});
		}
		
		 // detail
	      function userInfoDetail(userName){
	         console.log("success");
	         $.ajax(
	         {
	              type : 'get',
	              url : '/userInfo/userInfoDetail/'+userName,
	              dataType : 'json',
	              data : {
	      		},
	            contentType : 'application/json',
	              success : function(data, status, xhr) { 
	               console.log(data);
	                 makeDetailHtml(data);
	              }, 
	              error: function(jqXHR, textStatus, errorThrown) 
	              {
	                alertify.notify(
	                      'Opps!! 회원 정보 조회 과정에 문제가 생겼습니다.', 
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
	         
	         var userSeq = detail.userSeq;
	         var userName = detail.userName;
	         var userPassword = detail.userPassword;
	         var userEmail = detail.userEmail;
	         var regDt = detail.regDt;

	         console.log(userName);
	         
	         
	         $("#userNameDetail").html(userName);
	         $("#passwordDetail").html(userPassword);
	         $("#emailDetail").html(userEmail);

	         if( userSeq != '<%=userDto.getUserSeq()%>'){
	            $("#btnUserInfoUpdateForm").hide();
	            $("#btnUserInfoDeleteConfirm").hide();
	         }else{
	            $("#btnUserInfoUpdateForm").show();
	            $("#btnUserInfoDeleteConfirm").show();
	         }

	         $("#userInfoDetailModal").modal("show");
	      }

//	       // update
	      function validateUpdate(){
	         var isPasswordUpdateValid = false;
	         var isEmailUpdateValid = false;

	         var passwordUpdate = $("#passwordUpdate").val();
	         var passwordUpdateLength = passwordUpdate.length;
	         
	         if( passwordUpdateLength > 0 ){
	            isPasswordUpdateValid = true;
	         }
	         
	         var emailUpdate = $("#emailUpdate").val();
	         var emailUpdateLength = emailUpdate.length;
	         
	         if( emailUpdateLength > 0 ){
	            isEmailUpdateValid = true;
	         }

	         if(   isPasswordUpdateValid && isEmailUpdateValid ){
	            return true;
	         }else{
	            return false;
	         }
	      }

	      function userInfoUpdate(userName){
	         console.log($("#passwordUpdate").val());
	         $.ajax(
	         {
	              type : 'put',
	              url : '/userInfo/userInfoUpdate/' + userName,
	              dataType : 'json',
	              data : 
	            {
	            	  userName : userName,
	                 userPassword : $("#passwordUpdate").val(),
	                 userEmail: $("#emailUpdate").val()
	            },
	            contentType : 'application/json',
	              success : function(data, status, xhr) { 
	                 if(data.result == "success"){
	                    alertify.success('회원정보가 수정되었습니다.');
	                 }
	                 else{
	                    alertify.success('성공은 했으나, 무언가 잘못되었습니다.');
	                 }
	              }, 
	              error: function(jqXHR, textStatus, errorThrown) 
	              {
	                 alertify.notify(
	                      'Opps!! 회원정보 수정 과정에 문제가 생겼습니다.', 
	                      'error', //'error','warning','message'
	                      3, //-1
	                      function(){
	                         console.log(jqXHR.responseText); 
	                      }
	                   );
	              }
	          });
	      }

//	       // delete
	      function userInfoDelete(userName){
	         $.ajax(
	         {
	              type : 'post',
	              url : '/userInfo/userInfoDelete/' +userName,
	            dataType : 'json',
	            data : {
	            },
	            contentType : 'application/json',
	            success : function(data, status, xhr) {
	               if (data.result == "success") {
	                  alertify.success('탈퇴되었습니다.');
	                  window.location.reload();
	               }
	            },
	            error : function(jqXHR, textStatus, errorThrown) {
	               alertify.notify('Opps!! 탈퇴 과정에 문제가 생겼습니다.', 'error', //'error','warning','message'
	               3, //-1
	               function() {
	                  console.log(jqXHR.responseText);
	               });
	            }
	         });
	      }