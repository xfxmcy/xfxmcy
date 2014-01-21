<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	var regDialog;
	var regForm;
	$(function() {

		regDialog = $('#regDialog').show().dialog({
			title : '注册',
			modal : true,
			buttons : [ {
				text : '注册',
				handler : function() {
					regForm.submit();
				}
			} ],
			onOpen : function() {
				$(this).find('input[name=cname]').focus();
			},
			onClose : function() {
				$(this).find('input').val('');
				$('div.validatebox-tip').remove();
				loginDialog.find('input[name=cname]').focus();
			}
		}).dialog('close');

		regForm = regDialog.find('form').form({
			url : '${pageContext.request.contextPath}/xfxmcyBasePackage/humanLogin!registerEmployer.asp',
			success : function(data) {
				var d = $.parseJSON(data);
				if (d.success) {
					regDialog.dialog('close');
				} else {
					regDialog.find('input[tLogin=account]').focus();
				}
				$.messager.show({
					msg : d.message,
					title : '提示'
				});
			}
		});

	});
</script>
<div id="regDialog" style="display: none;width:250px;padding: 5px;">
	<form method="post">
		<table class="tableForm">
			<tr>
				<th style="width: 55px;">登录名</th>
				<td><input name="employer.paccount" tLogin="account" class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录名称'" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input name="employer.ppwd" type="password"  tLogin="password"  class="easyui-validatebox" data-options="required:'true',missingMessage:'请填写登录密码'" /></td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input type="password" class="easyui-validatebox" data-options="required:'true',missingMessage:'请再次填写密码',validType:'eqPassword[\'#regDialog input[tLogin=password]\']'" /></td>
			</tr>
		</table>
	</form>
</div>