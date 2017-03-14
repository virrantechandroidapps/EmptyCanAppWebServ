<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

</style>

 <script src="${pageContext.request.contextPath}/js/jquery_Version_1_10_2.min.js"></script>
 <%-- <script src="${pageContext.request.contextPath}/js/d3.v3.min.js"></script> --%>
 <script src="${pageContext.request.contextPath}/js/raphael-2.1.4.min.js"></script>
 <script src="${pageContext.request.contextPath}/js/justgage.js"></script>
	
	<script>
	$(function(){
		 var gauge2 = new JustGage({
	          id: "gauge1",
	          title: "#2",
	          value: 50,
	          min: 0,
	          max: 100,
	          humanFriendly: false,
	          decimals: 0,
	          counter: true
	      });
	})
	 
	</script>
</head>
<body>
<div id="gauge1"></div>

</body>
</html>