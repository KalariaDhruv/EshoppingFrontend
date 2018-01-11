<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<!DOCTYPE html>
<html lang="en">
<head>
  <title>Project</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span> 
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                       
      </button>
      
      <a class="navbar-brand" href="<c:url value="index"/> ">WATCH-SHOP</a>
    </div>
    <div align="right" class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="display:block">
    
    <img src="${pageContext.servletContext.contextPath}/resources/logo1.jpg" width="70" height="70" align=left>
    <div class="collapse navbar-collapse" id="navDemo">
      <ul class="nav navbar-nav">
        
        <li class="dropdown">
            <li class="active"><a href="index">Home</a></li>
            <li><a href="contact"><i class="fa fa-address-book" aria-hidden="true"></i></a></li>
            <li><a href="productList">ProductList</a></li>
        <li class="dropdown">
        <a class="dropdown-toggel" data-toggel="dropdown" href="#">
        Category Choice<span class="caret"></span></a>
     	<ul class="dropdown-menu">
     	<c:forEach var="catVal" items="${catList }">
     	<li><a href="${pageContext.request.contextPath }/productCustList?cid=${catVal.cid}">${catVal.cname }</a></li>
        </c:forEach>
     </ul>  

             
             <li><a href="${pageContext.request.contextPath }/admin/adding">Admin</a></li>
             
            <li class="dorpdown"><a class="dropdoen-toddle" data-toggle="dropdown" 
            href="#">Admin List<span class="caret"></span></a>
            <ul class="dropdown-menu">
            		<li><a href="${pageContext.request.contextPath }/admin/productList" >Product</a></li>
           			<li><a href="${pageContext.request.contextPath }/admin/supplierList" >Supplier</a></li>
            		<li><a href="${pageContext.request.contextPath }/admin/categoryList" >Category</a></li>
            </ul>
            </li>
            
             <ul class="nav navbar-nav navbar right">
            
            <c:if test="${pageContext.request.userPrincipal.name==null }">
            <li><a href="${pageContext.request.contextPath }/goToRegister">Register</a></li>
            <li><a href="${pageContext.request.contextPath }/goToLogin">Login</a></li>
            </c:if>
            
            <c:if test="${pageContext.request.userPrincipal.name!=null }">
            <li><a> Welcome: ${pageContext.request.userPrincipal.name}</a></li>
            <li><a href="${pageContext.request.contextPath }/logout">Logout</a></li>
            </c:if>
            </ul>
          
          </li>  
    </div>
  </div>
  </div>
</nav>
  

</body>
</html>
      
      
      
      