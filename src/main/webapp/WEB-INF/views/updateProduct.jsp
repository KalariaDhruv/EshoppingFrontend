<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container">

<c:url value="/ProductUpdate" var="pru"/>
<form method="post" action="ProductUpdate" enctype="multipart/form-data">
<span id="reauth-email" class="reauth-email"></span>

<input type="hidden" name="pid" value="${prod.pid}">

<h4 class="input-title">Product Name</h4><br>
<input class="${prod.pname}" type="text" name="pName" required/><br>

<h4 class="input-title">Product Description</h4><br>
<input class="${prod.description}" type="text" name="pDescription" required/>

<h4 class="input-title">Product Price</h4><br>
<input class="${prod.price }" type="number" name="pPrice" required/>

 <h4 class="input-title">Product Stock</h4><br>
<input class="${prod.stock}" type="text" name="pstock" required/>


<div class="form-group">
<table>
<tr>
	<td>Select Supplier</td>
	<td>
	<select class="form-control" name="pSupplier" required>
	<option>---Select Supplier</option>
	<c:forEach items="${satList}" var="sat">
	<option value="${sat.sid}">${sat.supplierName}</option>
	</c:forEach>
	</select>
	</td>
	</tr>

</table>
</div>


<div class="form-group">
<table>
<tr>
	<td>Select Category</td>
	<td>
	<select class="form-control" name="pCategory" required>
	<option>---Select Category</option>
	<c:forEach items="${catList}" var="cat">
	<option value="${cat.cid}">${cat.cname}</option>
	</c:forEach>
	</select>
	</td>
	</tr>

</table>
</div>

<div class="fileinput fileinput-new" data-provider="fileinput">

<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="image/*"></td>
</div>


<button class="btn btn-lg btn-primary" type="submit">Save</button>
<button class="btn btn-lg btn-warning" type="reset">Cancel</button>
</form>
</div>

</body>
</html>