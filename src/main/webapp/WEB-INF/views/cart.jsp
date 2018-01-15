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

<table class="table table-hover" id="apl" class="display" border="2" width="80" aling="crnter">
<tr>


<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Price</th>
<th>Product Image</th>
<th>Sub Total</th>
<th>Image</th>

<th class="span2">Action</th>
</tr>

<c:if test="${empty cartInfo }">
<tr>
<td colspan="10" aling="center">No record exists!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${cartInfo}">
<tr>

<td><c:out value="${p.prodName}"></c:out></td>
<td><c:out value="${p.qty}"></c:out></td>
<td><c:out value="${p.price}"></c:out></td>
<td><c:out value="${p.stock}"></c:out></td>

<td><img src="${pageContext.request.contextPath}/resources/${p.imageName}" height="50px" width="50px"></td>
<td><c:out value="${p.qty *p.price }"/></td>

<td class="span2">

<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
</td>
<a class="btn btn-danger" role="button" href="<c:url value="/deletePCart/${p.cartId }"/>">Details</a>
</tr>
</c:forEach>
<td>
<c:set var="gtot" value="${p.qty *p.price }"></c:set>
<span class="col-lg-9" align="right"><lable>Grand Total</lable><c:out value="${gtot }"/></span>
</td>
<tfoot>
<td>
<a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath }/index">Continue Shopping</a>
</td>
<td>
<a class="btn btn-success btn-lg" href="${pageContext.request.contextPath }/checkout">Checkout</a>
</td>

</tfoot>

</table> 
</div>
</body>
</html>

