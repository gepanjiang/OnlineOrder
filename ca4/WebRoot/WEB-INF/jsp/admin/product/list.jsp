<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column title="商家" property="name"/>
			<display:column title="商品名称" property="productName"/>
			<display:column title="图片1">
				<img style="width:100px;" src="${ctx}/${row.productPic1}"/>
			</display:column>
			<display:column title="图片2">
				<img style="width:100px;" src="${ctx}/${row.productPic2}"/>
			</display:column>
			<display:column title="图片3">
				<img style="width:100px;" src="${ctx}/${row.productPic3}"/>
			</display:column>
			<display:column title="图片4">
				<img style="width:100px;" src="${ctx}/${row.productPic4}"/>
			</display:column>
			<display:column title="价格" property="price"/>
			<display:column title="原价" property="oldPrice"/>
			<display:column title="内容" property="content"/>
			<display:column title="数量" property="nums"/>
			<%--
			<display:column title="积分" property="jf"/> --%>
			<display:column title="推荐星级" property="tjxj"/>
			<display:column title="状态" property="status"/>
			<display:column title="分类" property="typesName"/>
						<c:choose>
							<c:when test="${param.flag==1 }"><display:column title="修改" style="width:40px;">
								<img src="${ctx}/resource/admin/images/pencil.png"
									onclick="return modifyOne('${row.id}');" style="cursor:hand;"/>
							</display:column>
							<display:column title="审核不通过删除" style="width:40px;">
								<img src="${ctx}/resource/admin/images/delete.png"
									onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
							</display:column></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							<display:column title="修改" style="width:40px;">
								<img src="${ctx}/resource/admin/images/pencil.png"
									onclick="return modifyOne('${row.id}');" style="cursor:hand;"/>
							</display:column>
							<display:column title="删除" style="width:40px;">
								<img src="${ctx}/resource/admin/images/delete.png"
									onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
							</display:column>
							</c:otherwise>
						</c:choose>
			
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
	function updateColumntjxj(tjxj,id){
		if(!confirm("确定要更新为"+tjxj+"吗?")){
			return false;
		}
		var params={id:id,tjxj:tjxj};
		$.post("updateColumntjxj.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function updateColumnstatus(status,id){
		if(!confirm("确定要更新为"+status+"吗?")){
			return false;
		}
		var params={id:id,status:status};
		$.post("updateColumnstatus.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function updateColumntypesId(typesId,id){
		if(!confirm("确定要更新为"+typesId+"吗?")){
			return false;
		}
		var params={id:id,typesId:typesId};
		$.post("updateColumntypesId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
		var params={id:id};
		$.post("editDelete.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function modifyOne(id,method){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}&method='+method,'modify',500,600);
	}
</script>
</html>
