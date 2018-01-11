<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>

<meta name="viewport" content="width=device-width,intial-scale=l">
<meta cherset="utf-8">
<script src="http://ajax.google.com/ajax/libs/jquary/3.2.1/jquary.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstra/3.3.7/css/bootstra.min.css" rel="stylesheet">

</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>Welcome to login page</h2>
<form action="${pageContext.request.contextPath}/login" class="form-sigin" method="post">
<h3><lable>Email:</lable></h3>
<input type="text" name="username" class="login-box" placeholder="Enter username" required>

<h3><lable>Password:</lable></h3>
<input type="password" name="password" class="login-box" placeholder="Enter password" required>

<button class="btn btn-lg btn-info" type="submit">Login</button>
<button class="btn btn-lg btn-info" type="reset">Cancel</button>

</form>
</div>

</body>
</html>