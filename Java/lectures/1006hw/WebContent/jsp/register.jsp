<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css" />
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css" />
        <title>회원가입</title>
    </head>

    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>HELLO</h1>
                <p>HI</p>
            </div>
            <h2>Register</h2>
            <form novalidate>
                <div class="form-group">
                    <label for="userName">Username:</label> <input type="text" class="form-control" id="userName" placeholder="Enter userName" name="userName" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">아이디는 8글자 이상입니다.</div>
                </div>
                <div class="form-group">
                    <label for="userPassword">Password:</label> <input type="password" class="form-control" id="userPassword" placeholder="Enter password" name="userPassword" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">대소문자, 숫자, 특수문자의 조합으로 만들어야합니다.</div>
                </div>
                <div class="form-group">
                    <label for="userPassword2">Password Confirm:</label> <input type="password" class="form-control" id="userPassword2" placeholder="Confirm password" name="userPassword2" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">비밀번호가 같지 않습니다.</div>
                </div>
                <div class="form-group">
                    <label for="userEmail">Email:</label> <input type="text" class="form-control" id="userEmail" placeholder="Enter email" name="userEmail" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                </div>
            </form>
            <button id="btnRegister" class="btn btn-primary">Register</button>

        </div>
    </body>
    <script>
        $(document).ready(function() {
            $("#userName").focus();

            $("#userName").blur(function() {
                if (validateUserName($(this))) {
                    $(this).removeClass("is-invalid").addClass('is-valid');
                } else {
                    $(this).removeClass("is-valid").addClass('is-invalid');
                }
            });

            $("#userPassword").blur(function() {
                if (validatePassword($(this)))
                    $(this).removeClass("is-invalid").addClass("is-valid");
                else
                    $(this).removeClass("is-valid").addClass("is-invalid");
            });

            $("#userPassword2").blur(function() {
                if (validatePassword2($(this)))
                    $(this).removeClass("is-invalid").addClass("is-valid");
                else
                    $(this).removeClass("is-valid").addClass("is-invalid");
            });

            $("#userEmail").blur(function() {
                if (validateEmail($(this)))
                    $(this).removeClass("is-invalid").addClass("is-valid");
                else
                    $(this).removeClass("is-valid").addClass("is-invalid");
            });

            $(':input').focus(function() {
                $(this).removeClass('is-valid is-invalid');
            });

            $("#btnRegister").click(function() {
                if ($("form").find(".is-invalid").length > 0) {
                    alert("입력이 올바르지 않습니다.")
                } else {
                    // 전송
                    register();
                }
            });
        })

        function validateUserName(userName) {
            if (userName.val().length >= 8)
                return true;
            else
                return false;
        }

        function validatePassword(userPassword) {
            let userPasswordValue = userPassword.val();

            var patternEngAtListOne = new RegExp(/[a-zA-Z]+/); // + for at least one
            var patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/); // + for at least one
            var patternNumAtListOne = new RegExp(/[0-9]+/); // + for at least one

            if (patternEngAtListOne.test(userPasswordValue) &&
                patternSpeAtListOne.test(userPasswordValue) &&
                patternNumAtListOne.test(userPasswordValue) &&
                userPasswordValue.length >= 8) {
                return true;
            } else
                return false;
        }

        function validatePassword2(userPassword2) {
            if (userPassword2.val() == $("#userPassword").val())
                return true;
            else
                return false;
        }

        function validateEmail(userEmail) {
            // ^ 시작일치, $ 끝 일치
            // {2, 3} 2개 ~ 3개
            // * 0회 이상, + 1회 이상
            // [-_.] - 또는 _ 또는 .
            // ? 없거나 1회
            let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if (regexp.test(userEmail.val()))
                return true;
            else
                return false;
        }

        function register() {
            $.ajax({
                type: 'post',
                url: '/register',
                dataType: 'json',
                data: {
                    userName: $("#userName").val(),
                    userEmail: $("#userEmail").val(),
                    userPassword: $("#userPassword").val()
                },
                success: function(data, status, xhr) {
                    console.log(data.result);

                    if (data.result == "success") {
                        alertify.alert('Welcome!', '회원가입을 축하합니다. 로그인 페이지로 이동합니다.',
                            function() {
                                window.location.href = "/jsp/login.jsp";
                            });
                    } else {
                        alertify.notify('Opps!! 회원가입에 문제가 생겼습니다.', 'error', 3,
                            function() {
                                console.log(xhr.responseText);
                            });
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alertify.notify('Opps!! 회원가입에 문제가 생겼습니다.', 'error', 3,
                        function() {
                            console.log(jqXHR.responseText);
                        });
                }
            });
        }
    </script>

    </html>