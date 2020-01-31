<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE>
<html>
<head>
<title>小当家网上订餐系统</title>
<link type="text/css" rel="stylesheet" href="${ctx }/resource/index/one/css/style.css" />
<script type="text/javascript" src="${ctx }/resource/index/one/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/resource/index/one/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo"><a href="index.html" style="color: white;">小当家网上订餐系统</a></div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">${adminBean.username }</a></li>
			<%--
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li> --%>
			<li><a href="${ctx }/adminLogin/out.html">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
	<ul id="nav_dot">
			<li>
	          <h4 class="M1"><span></span>个人中心</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/password.html' target="page">修改密码</a>
	          </div>
	        </li>
	        <li>
	          <h4 class="M1"><span></span>首页轮播管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/lbt/frame.html?flag=1' target="page">首页轮播列表</a>
	          </div>
	        </li> 
			<li>
	          <h4 class="M1"><span></span>客户信息管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/customer/frame.html?flag=1' target="page">客户信息列表</a>
	          </div>
	        </li>
	        <li>
	          <h4 class="M1"><span></span>商品类别管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/types/frame.html?flag=1' target="page">商品类别列表</a>
	          </div>
	        </li>
	        <li>
	          <h4 class="M1"><span></span>商品信息管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/product/frame.html?flag=1' target="page">商品信息列表</a>
	          </div>
	        </li>
			<li>
	          <h4 class="M1"><span></span>商家信息管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/user/frame.html?flag=1' target="page">商家信息列表</a>
	          </div>
	        </li>
	        <li>
	          <h4 class="M1"><span></span>投诉信息管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/contact/frame.html?flag=1' target="page">投诉信息列表</a>
	          </div>
	        </li>
	        <li>
	          <h4 class="M1"><span></span>订单管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/order/frame.html?flag=1' target="page">订单列表</a>
	          </div>
	        </li>
			<li>
	          <h4 class="M1"><span></span>统计中心</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/tj/tj1.html' target="page">按月销售额</a>
	            <a href='${ctx}/admin/tj/tj2.html' target="page">按季度销售额</a>
	            <a href='${ctx}/admin/tj/tj3.html' target="page">按年销售额</a>
	          </div>
	        </li>
	        
 	 </ul>
		</div>
		<div class="m-right">
			<div class="main">
				<iframe src="${ctx }/admin/main.html" width="100%" height="100%" frameborder="0" scrolling="yes" name="page"></iframe>
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>小当家网上订餐系统</p></div>
<script>navList(12);</script>
</body>
</html>

