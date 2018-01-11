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
<h2>Authentication Error!!!</h2>
<h3>Go back to Home or<a href="${pageContext.request.contextPath }/goToLogin">Login</a>page</h3>


 <div class="item">
      <img class="img-rounded" class="img-responsive center-block" src=<spring:url value="/resources/error.jpg"/> alt="Error" style="width:50%">
    </div>

</div>
</body>
</html>