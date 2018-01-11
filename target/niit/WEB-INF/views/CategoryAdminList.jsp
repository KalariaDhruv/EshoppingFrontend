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
<h2>Category List for Admin</h2>

<table class="table table-hover" id="api" class="display" border="2" width="80" aling="crnter">
<tr>
<th>S1 No</th>
<th>CID</th>
<th>Category Name</th>

<th class="span2">Action</th>
</tr>

<c:if test="${empty satList }">
<tr>
<td colspan="10" aling="center">No record exists!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="${catList}">
<tr>

<td><c:out value="${st.count}"></c:out></td>
<td><c:out value="${p.cid}"></c:out></td>
<td><c:out value="${p.cname}"></c:out></td>
<td class="span4">
<c:set var="cotextRoot" value="${pageContext.request.contextPath}"></c:set>
<a class="btn btn-info" role="button" href="#">Edit</a>
<a class="btn btn-danger" role="button" href="#">Delete</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>