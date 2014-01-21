<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<TITLE>CY一下，你就知道</TITLE>
<STYLE>
HTML {
	OVERFLOW-Y: auto
}

#content {
	PADDING-BOTTOM: 100px; TEXT-ALIGN: center
}
#ftCon {
	OVERFLOW: hidden; HEIGHT: 100px; POSITION: absolute; TEXT-ALIGN: center; MARGIN: 0px auto; Z-INDEX: 0; WIDTH: 100%; BOTTOM: 44px
}
#ftConw {
	MARGIN: 0px auto; WIDTH: 720px
}
BODY {
	BACKGROUND: #fff; FONT: 12px arial
}
BODY {
	LIST-STYLE-TYPE: none; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; MARGIN: 0px; PADDING-RIGHT: 0px
}
P {
	LIST-STYLE-TYPE: none; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; MARGIN: 0px; PADDING-RIGHT: 0px
}
FORM {
	LIST-STYLE-TYPE: none; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; MARGIN: 0px; PADDING-RIGHT: 0px
}
UL {
	LIST-STYLE-TYPE: none; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; MARGIN: 0px; PADDING-RIGHT: 0px
}
LI {
	LIST-STYLE-TYPE: none; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; MARGIN: 0px; PADDING-RIGHT: 0px
}
BODY {
	POSITION: relative
}
FORM {
	POSITION: relative
}
#fm {
	POSITION: relative
}
TD {
	TEXT-ALIGN: left
}
IMG {
	BORDER-LEFT-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-TOP-WIDTH: 0px
}
A {
	COLOR: #00c
}
A:active {
	COLOR: #f60
}
.bg {
	BACKGROUND-IMAGE: url(${pageContext.request.contextPath}/images/icons_d3d3a658.png); BACKGROUND-REPEAT: no-repeat; _background-image: url(${pageContext.request.contextPath}/images/icons_b13038b3.gif)
}

.c-icon-triangle-down-blue {
	BACKGROUND-POSITION: -480px -24px
}
.c-icon-chevron-unfold2 {
	BACKGROUND-POSITION: -504px -24px
}
#u {
	COLOR: #999; PADDING-BOTTOM: 5px; TEXT-ALIGN: right; PADDING-TOP: 4px; PADDING-LEFT: 0px; PADDING-RIGHT: 10px
}
#u A {
	MARGIN: 0px 5px
}
#u .reg {
	MARGIN: 0px
}
#m {
	MARGIN: 0px auto; WIDTH: 720px
}
#nv A {
	FONT-SIZE: 14px
}
#nv B {
	FONT-SIZE: 14px
}
.btn {
	FONT-SIZE: 14px
}
#lk {
	FONT-SIZE: 14px
}
#fm {
	TEXT-ALIGN: left; PADDING-LEFT: 110px; Z-INDEX: 1
}
INPUT {
	BORDER-LEFT-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; BORDER-TOP-WIDTH: 0px
}
#nv {
	FONT-SIZE: 16px; HEIGHT: 19px; TEXT-ALIGN: left; MARGIN: 0px 0px 4px; TEXT-INDENT: 137px
}
.s_ipt_wr {
	BORDER-TOP: #9a9a9a 1px solid; HEIGHT: 30px; BORDER-RIGHT: #cdcdcd 1px solid; VERTICAL-ALIGN: top; BORDER-BOTTOM: #cdcdcd 1px solid; BACKGROUND-POSITION: 0px -288px; BORDER-LEFT: #9a9a9a 1px solid; DISPLAY: inline-block; WIDTH: 418px; MARGIN-RIGHT: 5px
}
.s_ipt {
	HEIGHT: 22px; BACKGROUND: #fff; OUTLINE-WIDTH: 0px; FONT: 16px/22px arial; MARGIN: 5px 0px 0px 7px; WIDTH: 405px; -webkit-appearance: none
}
.s_btn {
	CURSOR: pointer; FONT-SIZE: 14px; HEIGHT: 32px; BACKGROUND-POSITION: 0px -240px; PADDING-TOP: 2px; WIDTH: 95px; BACKGROUND-COLOR: #ddd
}
.s_btn_h {
	BACKGROUND-POSITION: -240px -240px
}
.s_btn_wr {
	HEIGHT: 34px; VERTICAL-ALIGN: top; POSITION: relative; BACKGROUND-POSITION: -120px -240px; Z-INDEX: 0; DISPLAY: inline-block; WIDTH: 97px
}
#lg IMG {
	MARGIN-BOTTOM: 3px; VERTICAL-ALIGN: top
}
#lk {
	MARGIN: 33px 0px
}
#lk SPAN {
	FONT: 14px "宋体"
}
#lm {
	HEIGHT: 60px
}
#lh {
	WORD-SPACING: 3px; MARGIN: 16px 0px 5px
}
.tools {
	RIGHT: 7px; POSITION: absolute; TOP: 10px
}
#mHolder {
	POSITION: relative; Z-INDEX: 296; DISPLAY: none; WIDTH: 62px
}
#mCon {
	CURSOR: pointer; HEIGHT: 18px; POSITION: absolute; LINE-HEIGHT: 18px
}
#mCon SPAN {
	CURSOR: default; COLOR: #00c; DISPLAY: block
}
#mCon .hw {
	CURSOR: pointer; TEXT-DECORATION: underline; DISPLAY: inline-block
}
#mCon .pinyin {
	DISPLAY: inline-block
}
#mCon .c-icon-chevron-unfold2 {
	MARGIN-LEFT: 5px
}
#mMenu A {
	HEIGHT: 100%; FILTER: none; TEXT-DECORATION: none; DISPLAY: block; LINE-HEIGHT: 22px; WIDTH: 100%; TEXT-INDENT: 6px
}
#mMenu {
	FILTER: progid:DXImageTransform.Microsoft.Shadow(Strength=2,Direction=135,Color="#cccccc"); box-shadow: 1px 1px 2px #ccc; -moz-box-shadow: 1px 1px 2px #ccc; -webkit-box-shadow: 1px 1px 2px #ccc
}
#user UL {
	FILTER: progid:DXImageTransform.Microsoft.Shadow(Strength=2,Direction=135,Color="#cccccc"); box-shadow: 1px 1px 2px #ccc; -moz-box-shadow: 1px 1px 2px #ccc; -webkit-box-shadow: 1px 1px 2px #ccc
}
#mMenu {
	LIST-STYLE-TYPE: none; BORDER-TOP: #9b9b9b 1px solid; BORDER-RIGHT: #9b9b9b 1px solid; BACKGROUND: #fff; RIGHT: 27px; BORDER-BOTTOM: #9b9b9b 1px solid; POSITION: absolute; BORDER-LEFT: #9b9b9b 1px solid; DISPLAY: none; TOP: 28px; WIDTH: 56px
}
#mMenu A:hover {
	BACKGROUND: #ebebeb
}
#mMenu .ln {
	OVERFLOW: hidden; FONT-SIZE: 1px; HEIGHT: 1px; BACKGROUND: #ebebeb; MARGIN-TOP: -1px; LINE-HEIGHT: 1px
}
#cp {
	COLOR: #666
}
#cp A {
	COLOR: #666
}
#seth {
	DISPLAY: none; BEHAVIOR: url(#default#homepage)
}
#setf {
	DISPLAY: none
}
#sekj {
	MARGIN-LEFT: 14px
}
#shouji {
	MARGIN-RIGHT: 14px
}
</STYLE>
<script type="text/javascript">
// 弹出搜索设置框
	function searchSetting(){
		 linkDialog = parent.sy.dialog({
				title : '搜索设置',
				href : '${pageContext.request.contextPath}/index/search/setting.jsp',
				width : 600,
				height : 193,
				buttons : [ {
					text : '保存设置',
					handler : function() {			
						formDialog = linkDialog.find('form');
						formDialog.form('submit', {
							url : '${pageContext.request.contextPath}/xfxmcyBasePackage/linkOperation!persistLinkMaterial.asp',
							success : function(d) {
								var json = $.parseJSON(d);
								if (json.success) {
									objectLink = {};
									manageLink.treegrid('reload');
									linkDialog.dialog('close');
								}
								parent.sy.messagerShow({
									msg : json.message,
									title : '提示'
								});
							}
						});
					}
				}, {
					text : '恢复默认',
					handler : function() {
						formDialog.form('clear');	
					}
				}],
				onLoad : function(){
					//formDialog = ('#material_link_linkForm').form();
				}
			});
		
	}
</script>

<BODY>
<DIV id=wrapper>
<DIV id=content>
<DIV id=u><A href="" onclick="searchSetting()"
name=tj_setting>搜索设置</A>|<A onclick="return false;" id=lb 
href="" 
name=tj_login>登录</A><A class=reg 
href="" 
name=tj_reg target=_blank>注册</A></DIV>
<DIV id=m>
<P id=lg><IMG src="${pageContext.request.contextPath}/images/aa.png" width=270 height=129></P>
<P id=nv><A >新&nbsp;闻</A>　<B>网&nbsp;页</B>　<A 
>贴&nbsp;吧</A>　<A 
>知&nbsp;道</A>　<A 
>音&nbsp;乐</A>　<A 
>图&nbsp;片</A>　<A 
>视&nbsp;频</A>　<A 
href="http://map.baidu.com/">地&nbsp;图</A></P>
<DIV id=fm>

<FORM name=f action="${pageContext.request.contextPath}/searchOperation.asp">
<SPAN class="bg s_ipt_wr"><INPUT id=kw class=s_ipt 
maxLength=100 name=searchContent></SPAN>
<INPUT type=hidden value=0 name=rsv_bp>
<INPUT type=hidden value=3 name=rsv_spt>
<INPUT type=hidden value=utf-8 name=ie>
<SPAN class="bg s_btn_wr">
<INPUT onmousedown="this.className='bg s_btn s_btn_h'" onmouseout="this.className='bg s_btn'" id=su class="bg s_btn" type=submit value=CY一下>
</SPAN></FORM>


<SPAN class=tools><SPAN id=mHolder>
<DIV id=mCon><SPAN>输入法</SPAN></DIV></SPAN></SPAN>
<UL id=mMenu>
  <LI><A href="" name=ime_hw>手写</A>
  <LI><A href="" name=ime_py>拼音</A></LI>
  <LI class=ln>
  <LI><A href="" name=ime_cl>关闭</A></LI></UL></DIV>
<P id=lk><A href="/">XF</A>　<A 
href="">XM</A>　<A 
href="">CY</A><SPAN>&nbsp;|&nbsp;<A 
href="">XFXMCY&gt;&gt;</A></SPAN></P>
<P id=lm></P></DIV></DIV>
<DIV id=ftCon>
<DIV id=ftConw>
<P><A onclick=h(this) 
onmousedown="return ns_c({'fm':'behs','tab':'homepage','pos':0})" id=seth 
href="">把xfxmcy设为主页</A><A 
onmousedown="return ns_c({'fm':'behs','tab':'favorites','pos':0})" id=setf 
href="" 
target=_blank>把xfxmcy设为主页</A><SPAN id=sekj><A 
onmousedown="return ns_c({'fm':'behs','tab':'bdbrwlk','pos':1})" 
href="" target=_blank>没有你</A></SPAN></P>
<P id=lh><A onmousedown="return ns_c({'fm':'behs','tab':'btlink','pos':2})" 
href="">你是我的鱼</A>&nbsp;|&nbsp;<A 
onmousedown="return ns_c({'fm':'behs','tab':'tj_bang'})" 
href="/">天苍苍</A>&nbsp;|&nbsp;<A 
onmousedown="return ns_c({'fm':'behs','tab':'tj_about'})" 
href="/">路茫茫</A>&nbsp;|&nbsp;<A 
onmousedown="return ns_c({'fm':'behs','tab':'tj_about_en'})" 
href="/">About CY</A></P>
<P id=cp>©2013&nbsp;XFXMCY&nbsp;<A href="" 
name=tj_duty>使用XFXMCY前必读</A>&nbsp;天津软件园1#50X&nbsp;<IMG 
src="${pageContext.request.contextPath}/images/gs.gif"></P></DIV></DIV></DIV>

</BODY></HTML>