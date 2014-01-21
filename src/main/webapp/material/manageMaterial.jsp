<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../initialEasyUI.jsp"></jsp:include>
<head>
<script type="text/javascript">
	var manageEmpDG;
	/*layout*/
	$(function() {
		$('#manage_manageMaterial_layout').layout({
			fit : true,
			border : false
		});
		/*datagrid*/
		manageEmpDG = $('#manage_manageMaterial_datagridMaterial')
				.datagrid(
						{
							fit : true, //强烈使用
							url : '{pageContext.request.contextPath}/xfxmcyBasePackage/personOperation!browseMaterial.asp',
							fitColumns : true,//列很少的情况使用,自使用,尽量不出现滚动条
							pagination : true,
							rownumbers : true,//渲染时间加长 ,数量大的时候,宽度不知道是否满足
							idField : "pid",//可能和选择的行数量有关,支持跨页选中,要满足唯一性
							checkOnSelect : false,//选中行时,是否选中复选框
							selectOnCheck : false,//选中复选框时,是否选中行   加设复选框
							singleSelect  : true,
							frozenColumns : [ [ {
								field : 'pid',
								//hidden : true,
								checkbox : true,
								width : 100   //不设置宽度,加载变慢
							}, {

								field : 'paccount',
								title : '账号',
								width : 100

							} ] ],
							columns : [ [ {
								field : 'pname',
								title : '姓名',
								width : 100
							}, {
								field : 'pqq',
								title : 'QQ',
								width : 100
							}, {
								field : 'ppwd',
								title : '密码',
								width : 80,
								formatter : function(value, row, index) {
									return "******";
								}
							}, {
								field : 'pmobilephone',
								title : '手机号',
								width : 100
							}, {
								field : 'pbirthday',
								title : '生日',
								width : 120
							}, {
								field : 'pzfb',
								title : '支付宝',
								width : 100
							} ] ],
							toolbar : [ {
								iconCls : 'icon-add',
								text : '增加',
								handler : function() {
									addMaterial();
								}
							}, '-', {
								iconCls : 'icon-edit',
								text : '编辑',
								handler : function() {
									editMaterial();
								}
							}, '-', {
								iconCls : 'icon-remove',
								text : '删除',
								handler : function() {
									removeMaterial();
								}
							}, '-'
							/*	, {
								iconCls : 'icon-save',
								text : '保存',
								handler : function() {

								}
							} 
							*/]

						});
		/*north面板的 两个linkbutton和input*/
		$('#manage_manageMaterial_search').linkbutton({
			iconCls : 'icon-search'
		});
		$('#manage_manageMaterial_clear').linkbutton({
			iconCls : 'icon-redo'
		});
		/*根据查询条件查询*/
		$('#manage_manageMaterial_search').bind('click', function() {

			manageEmpDG.datagrid('load', {});

		});
		/*查询条件清空*/
		$('#manage_manageMaterial_clear').bind('click', function() {

			manageEmpDG.datagrid('load');
		});
		$('#manage_manageMaterial_birthdayStart').datebox({
			required : true
		});
		$('#manage_manageMaterial_birthdayEnd').datebox({
			required : true
		});

	});
	/*addMaterial,editMaterial,removeMaterial*/
	function addMaterial() {
		var formDialog;
		var empDialog = parent.sy.dialog({
			title : '添加工作人员',
			href : '${pageContext.request.contextPath}/manage/Material.jsp',
			width : 440,
			height : 180,
			buttons : [ {
				text : '添加',
				handler : function() {
					formDialog = empDialog.find('form');
					formDialog.form('submit', {
						url : '${pageContext.request.contextPath}/xfxmcyBasePackage/personOperation!persistMaterial.asp',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								manageEmpDG.datagrid('reload');
								empDialog.dialog('close');
							}
							parent.sy.messagerShow({
								msg : json.message,
								title : '提示'
							});
						}
					});
				}
			}, {
				text : '清空',
				handler : function() {
					formDialog.form('clear');	
				}
			}],
			onLoad : function(){
				
				
				
				
				
			}
		});
		
	}
	
	function editMaterial() {
		
		var selectedInfo = sy.singleSelected(manageEmpDG);
		if(null == selectedInfo){
		
		}
		else{
			parent.sy.messagerShow({
				msg : selectedInfo,
				title : '提示'
			});	
		}
	}
	
	
	function removeMaterial() {
	//可以批量删除
		parent.sy.messagerConfirm({
			msg : '您真的要删除吗',
			title : '提示',
			fn : function(result){
				if(result){
					
				}
			}
		});
		/* var selectedInfo = sy.singleSelected(manageEmpDG);
		if(null == selectedInfo){
			parent.sy.messagerConfirm({
				msg : '您真的要删除吗',
				title : '提示',
				fn : function(result){
					if(result){
						
					}
				}
			});
		}
		else{
			parent.sy.messagerShow({
				msg : selectedInfo,
				title : '提示'
			});	
		}
 */
	}
	/*过滤查询 searchEmp,cleanSearchEmp*/
	function searchEmp(){
		
		manageEmpDG.datagrid("load",sy.serializeObject($('#searchForm')));
		/* manageEmpDG.datagrid("load",{
			'folk.endbirthday' : $("#searchForm input[name = 'folk.endbirthday']").val(),
			'folk.pname' : $("#searchForm input[name = 'folk.pname']").val(),
			'folk.prebirthday' : $("#searchForm input[name = 'folk.prebirthday']").val()
			
		}); */
		
	}
	function cleanSearchEmp(){
	//	$("#searchForm input[name = 'folk.pname']").val('');
	//	$("#searchForm input[name = 'folk.endbirthday']").val('');
	//	$("#searchForm input[name = 'folk.prebirthday']").val('');
	$("#searchForm input").val('');
		manageEmpDG.datagrid("load",{});
	}
</script>
</head>

<body>
	<div id="manage_manageMaterial_layout">
		<div region="north"  border=false
			plain=true  title="过滤查询"
			style="height:110px;overflow: hidden;">
			<form id="searchForm">
				<table class="tableForm datagrid-toolbar"
					style="width: 100%;height: 100%;FONT-SIZE: 15pt; FILTER: shadow(color=#AF0530); WIDTH: 100%; LINE-HEIGHT: 150%; FONT-FAMILY: 华文行楷 ">
					<tr>
						
						<td>姓名关键字&nbsp;&nbsp;<input name="folk.pname" style="width:317px;" /></td>
					</tr>
					<!-- 
					<tr>
						<th>生日</th>
						<td><input name="ccreatedatetimeStart"
							class="easyui-datetimebox" data-options="editable:false"
							style="width: 155px;" />至<input name="ccreatedatetimeEnd"
							class="easyui-datetimebox" data-options="editable:false"
							style="width: 155px;" /></td>
					</tr>-->
					
					<tr>
						
						<td>生日时间 &nbsp;&nbsp;<input name="folk.prebirthday"
							class="easyui-datebox" data-options="editable:false"
							style="width: 155px;" />至<input name="folk.endbirthday"
							class="easyui-datebox" data-options="editable:false"
							style="width: 155px;" />&nbsp;&nbsp;
							<a href="javascript:void(0);"
							class="easyui-linkbutton" onclick="searchEmp();">查询</a>&nbsp;
							<a href="javascript:void(0);" class="easyui-linkbutton"
							onclick="cleanSearchEmp();">清空</a></td>
					</tr>
					 
				</table>
			</form>
		</div>
		<div region="center" title="xfxmcyManagerTab" split="true">
			<table id="manage_manageMaterial_datagridMaterial"></table>
		</div>
	</div>
</body>
</html>
