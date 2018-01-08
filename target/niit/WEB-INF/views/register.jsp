<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>

<title>Demo</title>

 <meta name="viewport" content="width=device-width,intial-scale=l">
 <meta cherset="utf-8">
 <script src="http://ajax.google.com/ajax/libs/jquary/3.2.1/jquary.min.js"></script>
 <link href="https://maxcdn.bootstrapcdn.com/bootstra/3.3.7/css/bootstra.min.css">

</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>Registration Form</h2>
<div class="col-lg-12">
<div class="row">

<form:form commandName="user" action="saveRegister" method="post">
<div class="form group">
<label>Name: </label><br>
<form:input path="name" clas="form-control" plaseholder="Enter Name"/>
</div>

<div class="form group">
<label>Email: </label><br>
<form:input path="email" clas="form-control" plaseholder="Enter Email"/>
</div>

<div class="form group">
<label>Password: </label><br>
<form:input path="password" type="password" clas="form-control" plaseholder="Enter Password"/>
</div>

<div class="form group">
<label>Adderss: </label><br>
<form:input path="address" clas="form-control" plaseholder="Enter Address"/>
</div>

<div class="form group">
<label>Phone: </label><br>
</div>
<form:input path="phone" clas="form-control" plaseholder="Enter Phone"/>



<br><br>
<button type="submit" class="btn btn-lg btn-info">SUBMIT</button>
<button type="cancle" class="btn btn-lg btn-info">CANCLE</button>
</form:form>

</html>