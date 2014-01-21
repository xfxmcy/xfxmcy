<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
		<form id="searchForm"  method="post">
				<table class="tableForm datagrid-toolbar"
					style="width: 100%;height: 110px;">
					<tr>
						<td>账号 &nbsp; &nbsp;<input name="employer.paccount" style="width:130px;" /></td>
						<td>密码 &nbsp; &nbsp;<input name="employer.ppwd" type="password" style="width:130px;" /></td>
					</tr>
					
					<tr>
						<td>QQ &nbsp; &nbsp; &nbsp;<input name="employer.pqq" style="width:130px;" /></td>

							<td>生日 &nbsp;&nbsp;<input name="employer.pbirthday"
							class="easyui-datebox" data-options="editable:false"
							style="width: 130px;" /></td>
					
					</tr> 
				</table>
			</form>
		
</body>
</html>