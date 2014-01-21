<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
	var loginDialog;
	var loginTabs;
	var loginInputForm;
	var loginDatagridForm;
	var loginComboboxForm;
	var loginDatagridName;
	var loginComboboxName;
	var role ;
	var sessionInfo;
	$(function() {

		var formParam = {
			url : '${pageContext.request.contextPath}/xfxmcyBasePackage/humanLogin!loginMutual.asp',
			success : function(data) {
				var json = $.parseJSON(data);
				if (json && json.success) {
					loginDialog.dialog('close');

					$('#sessionInfoDiv').html(sy.fs('[<strong>{0}</strong>]，欢迎你！您使用[<strong>{1}</strong>]IP登录！', json.otherMessage.loginName, json.otherMessage.ip));

					flashOnlineDatagrid();
				}
				$.messager.show({
					msg : json.message,
					title : '提示'
				});
			}
		};
		role = $('#role').combobox({   /*角色框更改 input name*/
			value:"Employer",
			panelHeight: 80,
			onChange:function(newValue,oldValue){
				if("Admin" == newValue){
					$('#loginAndRegDialog input[tLogin=account]').attr("name","administrator.paccount");
					$('#loginAndRegDialog input[tLogin=password]').attr("name","administrator.ppwd");
				}else{
					$('#loginAndRegDialog input[tLogin=account]').attr("name","employer.paccount");
					$('#loginAndRegDialog input[tLogin=password]').attr("name","employer.ppwd");
				}	
			} 	
			
		});  
		loginInputForm = $('#loginInputForm').form(formParam);
		loginDatagridForm = $('#loginDatagridForm').form(formParam);
		loginComboboxForm = $('#loginComboboxForm').form(formParam);

		loginDialog = $('#loginAndRegDialog').show().dialog({
			closable : false,
			title : '登录',
			modal : true,
			buttons : [ {
				text : '注册',
				handler : function() {
					regDialog.dialog('open');
				}
			}, {
				text : '登录',
				handler : function() {
					if ($('#onlineDatagrid').length > 0) {
						var f = loginTabs.tabs('getSelected').find('form');
						f.submit();
					}
				}
			} ],
			onOpen : function() {
				var t = $(this);
				window.setTimeout(function() {
					t.find('input[name=cname]').focus();
				}, 0);
			}
		});

		loginTabs = $('#loginTabs').tabs({
			onSelect : function(title) {
				if ('输入方式' == title) {
					window.setTimeout(function() {
						$('div.validatebox-tip').remove();
						loginInputForm.find('input[tLogin=account]').focus();
					}, 0);
				} else if ('表格方式' == title) {
				/*	window.setTimeout(function() {
						if (loginDatagridName.combogrid('options').url == '') {
							loginDatagridName.combogrid({
								url : '${pageContext.request.contextPath}/demo/userAction!doNotNeedSession_datagrid.action'
							});
						}
						$('div.validatebox-tip').remove();
						loginDatagridName.combogrid('textbox').focus();
					}, 0);	*/
				} else if ('补全方式' == title) {
					/*
					window.setTimeout(function() {
						if (loginComboboxName.combobox('options').url == '') {
							loginComboboxName.combobox({
								url : '${pageContext.request.contextPath}/demo/userAction!doNotNeedSession_combobox.action'
							});
						}
						$('div.validatebox-tip').remove();
						loginComboboxName.combobox('textbox').focus();
					}, 0);
					*/
				}
			}
		});

		loginDatagridName = $('#loginDatagridName').combogrid({
			required : true,
			loadMsg : '数据加载中....',
			panelWidth : 440,
			panelHeight : 180,
			required : true,
			fitColumns : true,
			value : '',
			idField : 'cname',
			textField : 'cname',
			mode : 'remote',
			url : '',
			pagination : true,
			pageSize : 5,
			pageList : [ 5, 10 ],
			columns : [ [ {
				field : 'cid',
				title : '编号',
				width : 60,
				hidden : true
			}, {
				field : 'cname',
				title : '登录名',
				width : 100,
				sortable : true
			}, {
				field : 'ccreatedatetime',
				title : '创建时间',
				width : 150,
				sortable : true
			}, {
				field : 'cmodifydatetime',
				title : '最后修改时间',
				width : 150,
				sortable : true
			} ] ],
			delay : 500
		});

		loginComboboxName = $('#loginComboboxName').combobox({
			required : true,
			url : '',
			textField : 'cname',
			valueField : 'cname',
			mode : 'remote',
			panelHeight : 'auto',
			delay : 500,
			value : ''
		});

		$('form input').bind('keyup', function(event) {/* 增加回车提交功能 */
			if (event.keyCode == '13') {
				$(this).submit();
			}
		});

		sessionInfo = {
			userId : '${sessionInfo.userId}',
			loginName : '${sessionInfo.loginName}',
			ip : '${sessionInfo.ip}'
		};
		if (sessionInfo.userId) {/*如果有userId说明已经登陆过了*/
			window.setTimeout(function() {
				$('div.validatebox-tip').remove();
			}, 500);
			loginDialog.dialog('close');
			flashOnlineDatagrid();
		}

	});

	function flashOnlineDatagrid() {/*刷新在线列表*/
		window.setTimeout(function() {
			if ($('#onlineDatagrid').length > 0) {
			/*	onlineDatagrid.datagrid({
					pagination : true,
					url : '${pageContext.request.contextPath}/demo/onlineAction!doNotNeedSession_onlineDatagrid.action'
				}); */
				var p = onlineDatagrid.datagrid('getPager');
				p.pagination({
					showPageList : false,
					showRefresh : false,
					beforePageText : '',
					afterPageText : '/{pages}',
					displayMsg : ''
				});
			}
		}, 3000);
	}
</script>
<div id="loginAndRegDialog" style="width:260px;height:250px;display: none;overflow: hidden;">
	<div id="loginTabs" data-options="fit:true,border:false">
		<div title="输入方式" style="overflow: hidden;">
			<div class="info">
				<div class="tip icon-tip"></div>
				<div>Employer的公共用户名cy,密码为cy</div>
			</div>
			<div align="center">
				<form id="loginInputForm" method="post">
					<table class="tableForm" style="margin: 5px;">
						<tr>
							<th>登陆名</th>
							<td><input tLogin="account" name="employer.paccount" class="easyui-validatebox" required="true" missingMessage="请填写登录名称" style="width: 145px;" />
							</td>
						</tr>
						<tr>
							<th>密码</th>
							<td><input tLogin="password" name="employer.ppwd" type="password" class="easyui-validatebox" required="true" missingMessage="请填写登录密码" style="width: 145px;"/>
							</td>
							
						</tr>
								<tr>
							<th>角色</th>
							<td>
								<select id="role" name="role" style="width:150px;" editable = "false">  
    								<option value="Employer" selected="selected">Employer</option>  
   			 						<option value="Admin" >Admin</option>  
								</select>  	
							</td>
					</table>
				</form>
			</div>
		</div>
		<div title="表格方式" style="overflow: hidden;">
			<div class="info">
				<div class="tip icon-tip"></div>
				<div>可模糊检索用户名,暂不支持</div>
			</div>
			<div align="center">
				<form id="loginDatagridForm" method="post">
					<table>
						<tr>
							<th style="text-align: right;">登录名</th>
							<td><select id="loginDatagridName" name="cname" style="display: none;width: 155px;"></select></td>
						</tr>
						<tr>
							<th style="text-align: right;">密码</th>
							<td><input name="cpwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写登录密码'" style="width: 150px;" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div title="补全方式" style="overflow: hidden;">
			<div class="info">
				<div class="tip icon-tip"></div>
				<div>可自动补全用户名,暂不支持</div>
			</div>
			<div align="center">
				<form id="loginComboboxForm" method="post">
					<table>
						<tr>
							<th style="text-align: right;">登录名</th>
							<td><select id="loginComboboxName" name="cname" style="display: none;width: 155px;"></select>
							</td>
						</tr>
						<tr>
							<th style="text-align: right;">密码</th>
							<td><input name="cpwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请填写登录密码'" style="width: 150px;" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>