<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'east',title:'拥有权限',split:true" style="width: 200px;">
		<ul></ul>
	</div>
	<div data-options="region:'center',title:'个人信息'" style="overflow: hidden;padding: 5px;">
		<form method="post">
			<input name="cid" type="hidden" value="${sessionInfo.userId}" />
			<table class="tableForm">
				<tr>
					<th style="width: 55px;">登录名</th>
					<td><input readonly="readonly" value="${sessionInfo.loginName}" /></td>
				</tr>
				<tr>
					<th>登录IP</th>
					<td><input readonly="readonly" value="${sessionInfo.ip}" /></td>
				</tr>
				<tr>
					<th>修改密码</th>
					<td><input name="cpwd" type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录密码'" /></td>
				</tr>
				<tr>
					<th>所属角色</th>
					<td><textarea readonly="readonly" style="height: 80px;">${sessionInfo.roleNames}</textarea></td>
				</tr>
				<tr style="display: none;">
					<th>权限ID</th>
					<td><input name="authIds" value="${sessionInfo.authIds}" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>