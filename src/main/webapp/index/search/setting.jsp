<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

		
		
		<form id="searchForm"  method="post">
				<table class="tableForm datagrid-toolbar"
					style="width: 100%;height: 110px;">
					<tr>
						<td colspan="2"><span style="FONT-SIZE: 15pt; FILTER: shadow(color=#AF0530); WIDTH: 100%; LINE-HEIGHT: 150%; FONT-FAMILY: 华文行楷 ;">搜索设置</span></td>
					</tr>
					<tr>
						<td colspan="2"><span>请确认您的浏览器是否启用了cookie,否则无法使用搜索设置</span></td>
					</tr>
					<tr>
						<td>是否希望在搜索时显示搜索框提示</td>
						<td><input type="radio" style="width: 30px;" checked="checked" name="tip"/>显示 &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" style="width: 30px;" name="tip"/>不显示</td>
					</tr>
					<tr>
						<td>设定您所搜索的网页内容的语言</td>
						<td><input type="radio" style="width: 30px;" checked="checked" name="language"/>全部语言 &nbsp;
							<input style="width: 30px;"  type="radio" name="language"/>仅简体中文&nbsp;&nbsp;&nbsp;
							<input type="radio" style="width: 30px;"  name="language"/>仅繁体中文</td>
					</tr>
					<tr>
						<td>设定您所搜索结果显示的条数</td>
						<td>
						<select id="demo1_rmjs_combo" class="easyui-combobox" name="dept" style="width:150px;">  
									    <option selected="selected">每页显示10条</option>  
									    <option>每页显示20条</option>  
									    <option>每页显示30条</option>  
									    <option>每页显示50条</option>  
									</select> 
						
						
						
						&nbsp;&nbsp;xfxmcy的原始设定10条最有效且最快</td>
					</tr>
				</table>
			</form>
		
</body>
</html>