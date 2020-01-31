<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<html>
<head><title></title>
<style type="text/css">
	body{
			width:auto; 
			margin-top:12px; 
      		font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
      		font-size:19px; 
      		color:#999;
      		line-height:25px;
      		letter-spacing:1px
      	}
    	p{
    		text-align: center;
    		margin-top: 10%;
    		font-size: 50px;
   	 }
   	 h2{
   	 	text-align: center;
   	 }
   	 h2 > a{
   	 	color: #999;
   	 }
</style></head>
<body>
	<p>您好：欢迎使用小当家订餐管理系统</p>
	<c:if test="${size!=0 }">
		<h2><a href="${ctx}/admin/product/frame.html">您有${size }款商品数量小于5件，请立即补货</a></h2>
	</c:if>
	<c:if test="${size==0 }">
		<h2>暂无急需补货商品</h2>
	</c:if>
</body>
</html>
