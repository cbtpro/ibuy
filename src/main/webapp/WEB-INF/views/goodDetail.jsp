<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String goodUUID = (String) request.getAttribute("goodUUID");
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript" src="<%=basePath %>js/3rdparty/jqGrid_5.1.0/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
var goodUUID = "<%=goodUUID %>";
$.ajax({
	url: '<%=basePath %>servlet/queryGoodDetail',
	method: 'get',
	data: {goodUUID: goodUUID},
	success: function(msg) {
		document.title = msg;
	}
});
</script>
</body>
</html>