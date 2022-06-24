<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style/style.css">
  <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
</head>
<body>
<header>
		<div class="logo">
			<img src="images/clean.jpg">
		</div>	
	</header>
    <main>
		<div id="main">
		<h1>Sign Up</h1>
			<form  id = "form" >
				<table>
				<tr>
						<td>Full NAME</td>
						<td><input  type="text" name="fname" id = "fname">
						 <span class = "fname-error"></span><br>
						  </td>
					</tr>
					<tr>
						<td>User NAME</td>
						<td><input  type="text" name="uname" id = "uname"/>
						<span class = "uname-error"></span><br></td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td><input type="email" name="email" id = "email" />
						<span class = "email-error"></span><br></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="text" name="password" id = "password" />
						<span class = "password-error"></span><br>
						</td>
					</tr>
					<tr>
					<td>CONFIRM PASSWORD</td>
						<td><input  type="text" name="confirm_password" id = "confirm_password"/>
						<span class = "confirm-error"></span><br></td>
					</tr>
				</table>
				<br> <input type="button" value="Regsiter" id = "submit" />		
			</form>						
			<script src="javascript/validations.js"></script>
		</div>
	</main>
</body>
</html>