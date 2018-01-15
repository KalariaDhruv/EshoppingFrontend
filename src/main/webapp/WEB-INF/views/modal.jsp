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
<hr>
<div class="modal fade bs-example-modal-sm" tabindex="i" role="dialog"

aria-labelledby="myModel" aria-hidden="true" id="onload">

<div class="modal-dialog modal-sm">
<div class="modal-context">
<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">X</button>
		</div>
		
		<div class="modal-body"><span>Added Successfully</span></div>

		<div class="modal-footer">
		<a href="${pageContext.request.contextPath }/admin/adding" class="btn btn-primary" role="button">Back</a>
</div>
</div>
</div>
</div>

</div>
<script type="text/javascript">

$(document).ready(function()
		{
			$('#onload').modal('show');}
		)
</script>
</body>
</html>
