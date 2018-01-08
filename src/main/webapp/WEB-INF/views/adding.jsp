<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Project</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="utf-8">
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container">
<div class="row">
<div class="col-md-6">
<div class="panel with-nav-tabs panel-primary">
<div class="panel-heading">
     <ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Category</a></li>
		<li><a href="#tab2" data-toggle="tab">Supplier</a></li>
		<li><a href="#tab3" data-toggle="tab">Product</a></li>
	
	</ul>

<div class="panel-body">
<div class="tab-contect">

<div class="tab-pane fad in active" id="tab1">
<form method="post" action="<c:url value="/productList"/>" class="form-signin">
<span id="reauth-email" class="reauth-email"></span>
<h4 class="input-title">Supplier Id</h4><br>
<input class="form-control" type="number" name="sid" required/>

<h4 class="input-title">Supplier Name</h4><br>
<input class="form-control" type="text" name="sname" required/>

<button class="btn btn-lg btn-primary" type="submit">Save</button>
<button class="btn btn-lg btn-warnig" type="reset">Cancel</button>

</form>
</div>

<div class="tab-pane fad in active" id="tab1">
<form method="post" action="<c:url value="/saveCat"/>" class="form-signin">
<span id="reauth-email" class="reauth-email"></span>
<h4 class="input-title">Category Id</h4><br>
<input class="form-control" type="number" name="cid" required/>

<h5 class="input-title">Category Name</h5><br>
<input class="form-control" type="text" name="cname" required/>

<button class="btn btn-lg btn-primary" type="submit">Save</button>
<button class="btn btn-lg btn-warnig" type="reset">Cancel</button>
</form>
</div>

</div>
</div>
</div>
</div>
</div>

</div>
</div>


</body>
</html>