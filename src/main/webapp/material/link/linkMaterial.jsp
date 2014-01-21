<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
		<form id="material_link_linkForm"  method="post">
				<table class="tableForm datagrid-toolbar"
					style="width: 100%;height: 110px;">
					<tr>
						<td>标题 &nbsp; &nbsp;<input name="linkMaterial.mtitle" id="mtitle" style="width:130px;" /></td>
						<td>说明 &nbsp; &nbsp;<input name="linkMaterial.mdescription" id='mdescription'  style="width:130px;" /></td>
					</tr>
					
					<tr>
						<td>链接 &nbsp; &nbsp;<input name="linkMaterial.linkStr" id="linkStr"   value="${param.linkStr}" style="width:130px;" /></td>
						<td>
							<input name="parentId" id="parentId" value="${param.parentId}"   style="width:130px;display: none;" />
							
							<input name="mid" value="${param.mid}"  style="width:130px;display: none;" />
						</td>
							
					
					</tr> 
				</table>
			</form>
		
</body>
</html>