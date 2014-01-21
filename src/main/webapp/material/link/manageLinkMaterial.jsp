<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="/initialEasyUI.jsp"></jsp:include>
<head>
<script type="text/javascript">
	var manageLink;
	var nodeCurrent ;// 当前选中节点
	var linkDialog;  // 链接form 
	var idIndex = 100;
	/* 右键menu */
	function onContextMenu(e,row){
		e.preventDefault();
		$(this).treegrid('select', row.id);
		$('#mm').menu('show',{
			left: e.pageX,
			top: e.pageY
		});
	}
	
	
	/*append*/
	function appendMaterialLink(){
		var formDialog;
		var objectLink;
		nodeCurrent = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		 linkDialog = parent.sy.dialog({
			title : '添加链接',
			href : '${pageContext.request.contextPath}/material/link/linkMaterial.jsp?parentId='+nodeCurrent.id,
			width : 440,
			height : 180,
			buttons : [ {
				text : '添加',
				handler : function() {			
					formDialog = linkDialog.find('form');
					formDialog.form('submit', {
						url : '${pageContext.request.contextPath}/xfxmcyBasePackage/linkOperation!persistLinkMaterial.asp',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								objectLink = {};
								manageLink.treegrid('reload');
							//	addLink(json.otherMessage);
								linkDialog.dialog('close');
							}
							sy.showParentMessage(json.message,'提示');
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
				//formDialog = ('#material_link_linkForm').form();
			}
			
		});
		
	}
	/*add link entity in front desk , not fresh page*/
	function addLink(objectLink){
		idIndex++;
		var createDate = new Date();
		//var node = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		$('#manage_manageMaterialLink_datagridMaterialLink').treegrid('append',{
			parent: nodeCurrent.id,
			data: [{
				id: objectLink.id,
				mtitle: objectLink.mtitle,
				linkStr: objectLink.linkStr,
				persistDate: $.fn.datebox.defaults.formatter(createDate),
				mdescription: objectLink.mdescription
			}]
		});
		//nodeCurrent = null;
	}
	
	
	function collapse(){
		var node = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		if (node){
			$('#manage_manageMaterialLink_datagridMaterialLink').treegrid('collapse', node.id);
		}
	}
	function expand(){
		var node = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		if (node){
			$('#manage_manageMaterialLink_datagridMaterialLink').treegrid('expand', node.id);
		}
	}
	
	
	
	/*layout*/
	$(function() {
		$('#manage_manageMaterialLink_layout').layout({
			fit : true,
			border : false
		});
		/*treegrid*/
		manageLink = $('#manage_manageMaterialLink_datagridMaterialLink')
				.treegrid(
						{
							fit : true, //强烈使用
							title : 'my Link',
							url : '${pageContext.request.contextPath}/xfxmcyBasePackage/linkOperation!queryLinkMaterial.asp',
						//	url : '${pageContext.request.contextPath}/jquery-easyui-1.3.3/demo/treegrid/treegrid_data2.json',
							fitColumns : true,//列很少的情况使用,自使用,尽量不出现滚动条
							pagination : true,
							rownumbers : true,//渲染时间加长 ,数量大的时候,宽度不知道是否满足
							animate: true,
							idField: 'id',
							pageSize:1,
							pageList:[1,2,4],
							treeField: 'mtitle',
							checkOnSelect : false,//选中行时,是否选中复选框
							selectOnCheck : false,//选中复选框时,是否选中行   加设复选框
							singleSelect  : true,
							onContextMenu: onContextMenu,
							frozenColumns : [ [ {
								field : 'mtitle',
								title : '标题',
								//hidden : true,
								//checkbox : true,
								width : 200   //不设置宽度,加载变慢
							}, {

								field : 'linkStr',
								title : '链接',
								width : 200,
								formatter:function(value){
									if(null == value || ""==value){
										return value;
									}
									return "<a href='"+value+"' target='_blank'>"+value+"</a>";
								}

							} ] ],
							columns : [ [ {
								field : 'persistDate',
								title : '添加时间',
								width : 150
							}, {
								field : 'mdescription',
								title : '说明',
								width : 200
							}] ]
						});
						
		/*north面板的 两个linkbutton和input*/
		$('#manage_manageMaterialLink_search').linkbutton({
			iconCls : 'icon-search'
		});
		$('#manage_manageMaterialLink_clear').linkbutton({
			iconCls : 'icon-redo'
		});
		/*根据查询条件查询*/
		$('#manage_manageMaterialLink_search').bind('click', function() {

			manageLink.datagrid('load', {});

		});
		/*查询条件清空*/
		$('#manage_manageMaterialLink_clear').bind('click', function() {

			manageLink.datagrid('load');
		});
		$('#manage_manageMaterialLink_birthdayStart').datebox({
			required : true
		});
		$('#manage_manageMaterialLink_birthdayEnd').datebox({
			required : true
		});

	});
	
	/*addMaterialLink,editMaterialLink,removeMaterialLink*/
	function editMaterialLink() {
		nodeCurrent = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		if(!isEdited(nodeCurrent)){
			sy.showParentMessage('当前节点不可操作','提示');
		}
		else{
			var parentNode = manageLink.treegrid("getParent",nodeCurrent.id);
		    linkDialog = parent.sy.dialog({
			title : '修改链接',
			href : '${pageContext.request.contextPath}/material/link/linkMaterial.jsp?mid='+nodeCurrent.id,
			width : 440,
			height : 180,
			buttons : [ {
				text : '修改',
				handler : function() {			
					formDialog = linkDialog.find('form');
					formDialog.form('submit', {
						url : '${pageContext.request.contextPath}/xfxmcyBasePackage/linkOperation!mergeLinkMaterial.asp',
						success : function(d) {
							var json = $.parseJSON(d);
							if (json.success) {
								objectLink = {};
								manageLink.treegrid('reload');
							//	addLink(json.otherMessage);	不刷新
								linkDialog.dialog('close');
							}
							sy.showParentMessage(json.message,'提示');
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
					formDialog = linkDialog.find('form');
					/*赋值*/
					formDialog.find('#mdescription').val(nodeCurrent.mdescription);
					formDialog.find('#mtitle').val(nodeCurrent.mtitle);
					formDialog.find('#linkStr').val(nodeCurrent.linkStr);
					formDialog.find('#parentId').val(parentNode.id);
				}	
			});
			
		}
	}
	
	/*删除链接确认*/
	function removeMaterialLink() {
		nodeCurrent = $('#manage_manageMaterialLink_datagridMaterialLink').treegrid('getSelected');
		if(!isEdited(nodeCurrent)){
			sy.showParentMessage('当前节点不可操作','提示');
		}	
		else{/*后期可以批量删除*/
			parent.sy.messagerConfirm({
				msg : '您真的要删除吗,删除父目录,子目录也会被删除',
				title : '提示',
				fn : function(result){
					/*确认删除*/
					if(result){
						removeIt(nodeCurrent.id);
					}
				}
			});
		
		}
	}
	/*验证选中节点是否可以编辑*/
	function isEdited(node){
		// 可以操作
		if(null != node && 1 != node.id){
			return true;
		}
		// 不可操作
		else{
			return false;
		}
	}
	/*remove*/
	function removeIt(nodeId){
		$.post('${pageContext.request.contextPath}/xfxmcyBasePackage/linkOperation!deleteLinkMaterial.asp?linkMaterial.mid='+nodeId,null,callBack);
		if (nodeId){
			$('#manage_manageMaterialLink_datagridMaterialLink').treegrid('remove', nodeId);
		}
	}
	/*callback 操作*/
	function callBack(data){
		var json = $.parseJSON(data);
		sy.showParentMessage(json.message,'提示');
	}
	/*过滤查询 searchEmp*/
	function searchEmp(){
		manageLink.datagrid("load",sy.serializeObject($('#searchForm')));
		/* manageLink.datagrid("load",{
			'folk.endbirthday' : $("#searchForm input[name = 'folk.endbirthday']").val(),
			'folk.pname' : $("#searchForm input[name = 'folk.pname']").val(),
			'folk.prebirthday' : $("#searchForm input[name = 'folk.prebirthday']").val()
			
		}); */
		
	}
	/*清空过滤*/
	function cleanSearchEmp(){
	//	$("#searchForm input[name = 'folk.pname']").val('');
	//	$("#searchForm input[name = 'folk.endbirthday']").val('');
	//	$("#searchForm input[name = 'folk.prebirthday']").val('');
		$("#searchForm input").val('');
		manageLink.datagrid("load",{});
	}
	
	
</script>
</head>

<body>
	<div id="manage_manageMaterialLink_layout">
		<div region="north"  border=false
			plain=true  title="过滤查询"
			style="height:110px;overflow: hidden;">
			<form id="searchForm">
				<table class="tableForm datagrid-toolbar"
					style="width: 100%;height: 100%;FONT-SIZE: 15pt; FILTER: shadow(color=#AF0530); WIDTH: 100%; LINE-HEIGHT: 150%; FONT-FAMILY: 华文行楷 ">
					<tr>
						
						<td>标题关键字&nbsp;&nbsp;<input name="folk.pname" style="width:317px;" /></td>
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
						
						<td>添加时间 &nbsp;&nbsp;<input name="folk.prebirthday"
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
			<table id="manage_manageMaterialLink_datagridMaterialLink"></table>
			<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="appendMaterialLink()" data-options="iconCls:'icon-add'">Append</div>
			<div onclick="editMaterialLink()" data-options="iconCls:'icon-remove'">Edit</div>
			<div onclick="removeMaterialLink()" data-options="iconCls:'icon-remove'">Remove</div>
			<div class="menu-sep"></div>
			<div onclick="collapse()">Collapse</div>
			<div onclick="expand()">Expand</div>
	</div>
		</div>
		
	</div>
</body>
</html>
