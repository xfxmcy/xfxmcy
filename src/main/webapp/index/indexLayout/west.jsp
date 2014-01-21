<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" charset="utf-8">
	var tree;
	var menuPanel;
	$(function() {
		menuPanel = $('#menuPanel').panel({
			tools : [ {
				iconCls : 'icon-reload',
				handler : function() {
					tree.tree('reload');
				}
			}, {
				iconCls : 'icon-redo',
				handler : function() {
					var node = tree.tree('getSelected');
					if (node) {
						tree.tree('expandAll', node.target);
					} else {
						tree.tree('expandAll');
					}
				}
			}, {
				iconCls : 'icon-undo',
				handler : function() {
					var node = tree.tree('getSelected');
					if (node) {
						tree.tree('collapseAll', node.target);
					} else {
						tree.tree('collapseAll');
					}
				}
			} ]
		});

		tree = $('#menu').tree({
			url : '${pageContext.request.contextPath}/xfxmcyBasePackage/menuOperation!ctrlTree.asp',
			lines : true,
			onClick : function(node) {
				addTab(node);
			},
			onDblClick : function(node) {
				if (node.state == 'closed') {
					$(this).tree('expand', node.target);
				} else {
					$(this).tree('collapse', node.target);
				}
			}  
		});
	});
</script>
<div class="easyui-accordion" fit="true" border="false">
	<div title="菜单">
		<div id="menuPanel" fit="true" border="false" title="功能菜单" style="padding: 5px;">
			<ul id="menu"></ul>
		</div>
	</div>
	<div title="其他内容" href="others.jsp"></div>
</div>