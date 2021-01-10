<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파양을 하지말아주세요.</h2>

	<form id="board" action="success.html"  method="POST">
		<input type="hidden" name="email" />
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"  /></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="nick"  /></td>
			</tr>
			<tr>
				<td>정보</td>
				<td>
					이름 : <input type="text" name="name" /> <br>
					성별 : <input id="male" type="radio" name="gender" value="남" /> <label for="male">남</label>
						 <input id="female" type="radio" name="gender" value="여" /> <label for="female">여</label>
						 <br>
					축종 : <select name="upkind" >
							<option value="개">개</option>
							<option value="고양이">고양이</option>
							<option value="기타">기타</option>
		   				 </select>		
		   				 <br>
		   			나이 : <input type="text" name="age" /> <br>
		   			지역 : <select name="sido" >
							<option value="서울">서울</option>
		   				 </select> 
		   				 <br>
		   				 <input type="text" name="address" /> <br>	
				</td>
			</tr>
			<tr>
				<td>Content</td>
				<td><textarea name="content"  ></textarea></td>
			</tr>
		</table>
	</form>	
	
</body>
</html>