<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<!DOCTYPE html>
<html lang="en">
<head>
  <title>ProjectCustList</title>  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container">
<div class="col-xs-6" jumbotron">
<div class="head">
<label>Customer Shipping Detalis</label>
</div>
<div class="outer">
<div class="well" style="width:100%">
<form action="${pageContext.request.contextPath }/Orderprocess" method="post">
<c:set var="gtot" value="0"></c:set>
<c:forEach var="c" items="${cart }">
<c:set var="gtot" value="${gtot + c.price * c.qty }"></c:set>
</c:forEach>
<div class="well">
<table>
<tr>
<td colspan="3">NAME</td><td>${user.name }</td>
</tr>

<tr>
<td colspan="3">EMAIL</td><td>${user.email }</td>
</tr>

<tr>
<td colspan="3">Address</td><td>${user.address }</td>
</tr>

<tr>
<td colspan="3">Phone</td><td>${user.phone }</td>
</tr>
</table>
<div class="outer">
<h3>Enter Payment Details</h3>
<br>
<label>Select Payment</label>
<select name="payment">
<option value="COD">Cash on Delivery</option>
<option value="Net">Net Banking</option>
</select><br><br>
<div>
Name:<input type="text" name="name on card">
Card number<input type="text" name="card number">
<input type="hidden name="total" value="${gtot }">
</div>
</div>

<input type="submit" value="PROCEED" style="width:75%" class="btn btn-danger">
</div>
</form>
</div>
</div>
</div>
</div>

</body>
</html>