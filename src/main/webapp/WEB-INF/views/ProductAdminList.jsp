<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html>
<html lang="en">
<head>

<title>project</title>

 <meta name="viewport" content="width=device-width,intial-scale=l">
 <meta charset="utf-8">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container">
<h2>Product List for Admin</h2>

<table class="table table-hover" id="api" class="display" border="2" width="80" aling="crnter">
<tr>
<th>S1 No</th>
<th>PID</th>
<th>Product Name</th>
<th>Product Supplier</th>
<th>Product Category</th>
<th>Description</th>
<th>Price</th>
<th>Stock</th>

<th>Image</th>

<th class="span2">Action</th>
</tr>

<c:if test="${empty prodList }">
<tr>
<td colspan="10" align="center">No record exists!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${prodList}">
<tr>

<td><c:out value="${st.count}"></c:out></td>
<td><c:out value="${p.pid}"></c:out></td>
<td><c:out value="${p.pname}"></c:out></td>
<td><c:out value="${p.supplier.supplierName}"></c:out></td>
<td><c:out value="${p.category.cname}"></c:out></td>
<td class="span3"><c:out  value="${p.description}"></c:out></td>
<td><c:out value="${p.price}"></c:out></td>
<td><c:out value="${p.stock}"></c:out></td>
<td><img src="${pageContext.request.contextPath}/resources/${p.imageName}" height="50px" width="50px"></td>
<td class="span4">
<c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
<%-- <a class="btn btn-info" role="button" href="${contextRoot}/admin/updateProdw">Editfg</a>--%>
<a class="btn btn-info" role="button" href="${contextRoot}/admin/updateProd?pid=<c:out value="${p.pid }"></c:out>">Edit</a>
<a class="btn btn-danger" role="button" href="<c:url value="/deleteProd/${p.pid }"/>">Delete</a></td>
</tr>
</c:forEach>
</table> 
</div>
</body>
</html>