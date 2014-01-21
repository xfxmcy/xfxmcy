<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>xfxmcy 管理系统</title>
<jsp:include page="../initialEasyUI.jsp"></jsp:include>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',href:'${pageContext.request.contextPath}/index/indexLayout/north.jsp'" style="height: 60px;overflow: hidden;" class="logo"></div>
	<div data-options="region:'west',title:'功能导航',href:'${pageContext.request.contextPath}/index/indexLayout/west.jsp'" style="width: 150px;overflow: hidden;"></div>
	<div data-options="region:'east',title:'日历',split:true,href:'${pageContext.request.contextPath}/index/indexLayout/east.jsp'" style="width: 200px;overflow: hidden;"></div>
	<div data-options="region:'center',title:'welcome to xfxmcy system',href:'${pageContext.request.contextPath}/index/indexLayout/center.jsp'" style="overflow: hidden;"></div>
	<div data-options="region:'south',href:'${pageContext.request.contextPath}/index/indexLayout/south.jsp'" style="height: 20px;overflow: hidden;"></div>

	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/reg.jsp"></jsp:include>

	<jsp:include page="isIe.jsp"></jsp:include>
</body>
</html>