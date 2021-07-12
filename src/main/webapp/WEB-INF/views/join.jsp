<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
 <br/>
<div class="container">
  <h2>임시 회원가입 페이지</h2>
  <form action="/join" method="post">
  <div class="form-group">
      <label for="id">아이디</label>
      <div class="d-flex justify-content-end">
				<button type="button" class="btn-sm btn-primary" id="">중복확인</button>
			</div><!-- 새창 띄우지 않고 확인 되면 사용하기나 뭐 그런 버튼으로 바꾸ㅣ면 좋겠당 -->
      <input type="text" class="form-control" id="id" placeholder="아이디를 입력해주세요" name="id">
      <div class="valid">영문 소문자, 숫자 4~8자</div>
			
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호</label>
      <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력해주세요" name="password">
       <div class="valid">영문 소문자, 숫자, 특수문자 포함 8~16자</div>
    </div>
     <div class="form-group">
      <label for="pwd">비밀번호 확인</label>
      <input type="password" class="form-control" id="pwConfirm" placeholder="비밀번호를 한번더 입력해주세요" name="password">
      <div class="valid">비밀번호를 다시 입력하세요. </div>
    </div>
    <div class="form-group">
      <label for="email">이메일</label>
       <div class="d-flex justify-content-end">
				<button type="button" class="btn-sm btn-primary" >이메일인증</button>
			</div>
      <input type="email" class="form-control" id="email" placeholder="이메일을 입력해주세요" name="email">
    </div>
    
      <label for="gender">성별</label>
      <br/>
      <input type="radio" id="gender" name="gender" value="female" />여성&nbsp;
      <input type="radio" id="gender" name="gender" value="male" />남성
      
      <br/>
      <br/>
      
       <label for="gender">나이</label>
       <br/>
      <input type="radio" id="age" name="age" value="age_10" />10대 &nbsp;
      <input type="radio" id="age" name="age" value="age_20" />20대 &nbsp;
       <input type="radio" id="age" name="age" value="age_30" />30대 &nbsp;
        <input type="radio" id="age" name="age" value="age_40" />40대 &nbsp;
         <input type="radio" id="age" name="age" value="age_more" />50대 이상 &nbsp;

      <br/>
      <br/>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form> 
</div>

</body>
</html>