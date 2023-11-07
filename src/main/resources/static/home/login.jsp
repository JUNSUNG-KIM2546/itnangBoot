<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
	<jsp:include page="../head.jsp"></jsp:include>
  </head>
  <body>
	<jsp:include page="../nav.jsp"></jsp:include>
	
	<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.4.0/kakao.min.js" integrity="sha384-mXVrIX2T/Kszp6Z0aEWaA8Nm7J6/ZeWXbL8UpGRjKwWe56Srd/iyNmWMBhcItAjH" crossorigin="anonymous"></script>
	<script>
	  Kakao.init('63c0f4f3e00e8d6c49088160aa0fdd64'); /* 사용하려는 앱의 JavaScript 키 입력 */</script>
	
	<!-- HK Wrapper -->
	<div class="hk-wrapper">

        <!-- Page Banner Start -->
    <div id="page-banner-area" class="page-banner">
      <div class="page-banner-title">
        <div class="text-center">
          <h2>Log</h2>
          <a href="#"><i class="lni-home"></i> Home</a>
          <span class="crumbs-spacer"><i class="lni-chevron-right"></i></span>
          <span class="current">Log</span>
        </div>
      </div>
    </div>
    <!-- Page Banner End -->

    <!-- Content section Start --> 
    <section id="content" class="section-padding">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5 col-md-6 col-xs-12">
            <div class="page-login-form box">
              <h3>
                로그인
              </h3>
              <!-- 일반 로그인 -->
              <form class="login-form" method="post" action="/actionLogin">
				    <div class="form-group">
				        <div class="form-group">
				            <!-- 체크박스를 클릭할 때 JavaScript 함수를 호출하여 카카오 로그인 버튼 활성화/비활성화 -->
				            <input type="checkbox" name="userType" value="true" onclick="toggleKakaoLoginButton()"> 중개사무소 로그인
				        </div>
				        <input type="hidden" name="userType" value="false">
				        <div class="input-icon">
				            <i class="lni-user"></i>
				            <input type="text" id="sender-email" class="form-control" name="userId" placeholder="이메일 아이디를 입력하세요">
				        </div>
				    </div>
				    <div class="form-group">
				        <div class="input-icon">
				            <i class="lni-lock"></i>
				            <input type="password" class="form-control" name="userPw" placeholder="비밀번호를 입력하세요">
				        </div>
				    </div>
				
				    <button class="btn btn-common log-btn" type="submit">로그인</button>
				</form>
				<script>
				    // 체크박스 클릭 시 카카오 로그인 버튼 활성화/비활성화 함수
				    function toggleKakaoLoginButton() {
				        var checkbox = document.querySelector('input[name="userType"]');
				        var kakaoLoginButton = document.getElementById('kakao-login-btn');
				
				        // 체크박스가 체크되었을 때 카카오 로그인 버튼 비활성화
				        if (checkbox.checked) {
				        	kakaoLoginButton.style.display = 'none';
				        } else {
				            // 체크박스가 해제되었을 때 카카오 로그인 버튼 활성화
				            kakaoLoginButton.style.display = 'inline-block';
				        }
				    }
				</script>
				
				<!-- 카카오 로그인 -->
				<div class="btn-cont" style="text-align: center;">
				    <!-- 카카오 로그인 버튼을 비활성화 상태로 시작 -->
				    <a class="btn-kakao" id="kakao-login-btn" href="#" data-type="login" style="display: inline-block;">
				        <img src="../resources/comm/kakao_login_medium_wide.png" alt="카카오 로그인 버튼" style="margin: 0 auto;" />
				    </a>
				</div>
				<!-- 카카오 로그인/회원가입 폼 -->
				<form action="/kakaoLogin" id="joinFrm" name="joinFrm" method="post">
					<input type="hidden" name="userId" />
					<input type="hidden" name="userName" />
					<!-- <input type="hidden" name="loginType" value=""/> -->
					<!-- <input type="hidden" name="userId" /> -->
					<!-- <input type="hidden" name="userNm" /> -->
					<!-- <input type="hidden" name="emailAdres" /> -->
				</form>
		    	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
				<script>
					$(document).ready(function() {
						// 카카오 로그인 버튼
						$(".btn-kakao").click(function() {
						const type = $(this).data("type");
						kakaoLogin(type);
						return false;
						});
					});
					
					// 카카오 키 정보 입력 (본인 JAVASCRIPT키)
					Kakao.init('63c0f4f3e00e8d6c49088160aa0fdd64');
					
					// 카카오SDK 초기화 
					Kakao.isInitialized();
					
					// 카카오 로그인
					function kakaoLogin(type) {
						Kakao.Auth.login({
							success: function (response) {
								Kakao.API.request({
									url: '/v2/user/me',
									success: function (response) {
										console.log(response)
										$("#joinFrm input[name=userId]").val(response.id);
										$("#joinFrm input[name=userName]").val(response.properties.nickname);
										/* $("input[name=loginType]").val("KAKAO"); */
										/* $("input[name=userId]").val(response.id); */
										/* $("input[name=userNm]").val(response.properties.nickname); */
										/* $("input[name=emailAdres]").val(response.kakao_account.email); */
										$("#joinFrm").submit();
									},
									fail: function (error) {
										console.log(error)
									},
								})
							}, fail: function (error) {
								console.log(error)
							},
						})
					}
					<c:if test="${not empty message}">
						alert("${message}");
					</c:if>
					<c:if test="${not empty loginMessage}">
						alert("${loginMessage}");
					</c:if>
				</script>
		    	
				<!-- <script>
					function loginWithKakao() {
					    Kakao.Auth.authorize({
					      redirectUri: 'https://developers.kakao.com/tool/demo/oauth',
					      state: 'userme',
					    });
					  }
					Kakao.init('63c0f4f3e00e8d6c49088160aa0fdd64'); // 사용하려는 앱의 JavaScript 키 입력
	
					function requestUserInfo() {
						  Kakao.API.request({
						    url: '/v2/user/me',
						  })
						  .then(function(res) {
						    // 가져온 사용자 정보를 UserVO에 설정
						    var userVO = {
						      userId: res.id,  // 예시: 카카오 사용자 ID를 userId 필드에 설정
						      // 다른 필드들도 필요에 따라 설정
						    };

						    // 이제 userVO를 사용하여 필요한 서버 요청 또는 작업을 수행할 수 있습니다.
						  })
						  .catch(function(err) {
						    alert('failed to request user information: ' + JSON.stringify(err));
						  });
						}
	
					  // 아래는 데모를 위한 UI 코드입니다.
					  displayToken()
					  function displayToken() {
					    var token = getCookie('authorize-access-token');
	
					    if(token) {
					      Kakao.Auth.setAccessToken(token);
					      Kakao.Auth.getStatusInfo()
					        .then(function(res) {
					          if (res.status === 'connected') {
					            document.getElementById('token-result').innerText
					              = 'login success, token: ' + Kakao.Auth.getAccessToken();
					          }
					        })
					        .catch(function(err) {
					          Kakao.Auth.setAccessToken(null);
					        });
					    }
					  }
	
					  function getCookie(name) {
					    var parts = document.cookie.split(name + '=');
					    if (parts.length === 2) { return parts[1].split(';')[0]; }
					  }
				</script> -->
			
              	<br>
              <hr>
              <ul class="form-links">
                <li class="text-center"> 아직 회원이 아니신가요?&nbsp;&nbsp; <a href="/user/add"> 회원 가입하기 </a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Content section End --> 
    </div>
	<!-- /HK Wrapper -->
	<%-- <jsp:include page="../footer.jsp"></jsp:include> --%>
	<script>
		
	</script>
	<jsp:include page="../js.jsp"></jsp:include>

	

  </body>
</html>

