<%@page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");

@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
<body>
	<display:table name="list" requestURI="list.html" class="list" id="row"
		cellspacing="0" cellpadding="0" pagesize="5">
		<display:column style="width:60px;" media="html" title="编号">
			<c:out value="${row_rowNum}" />
		</display:column>
		<display:column title="用户" property="name" />
		<display:column title="订单号" property="orderNum" />
		<display:column title="订单详细" property="productDetail" />
		<display:column title="订单总价格" property="allPrice" />
		<display:column title="状态" property="status" />
		<display:column title="下单日期" property="insertDate" />
		<display:column title="物流信息" property="pl" />
		<c:choose>
			<c:when test="${param.flag==1 }"></c:when>
			<c:when test="${param.flag==2 }"></c:when>
			<c:when test="${param.flag==3 }"></c:when>
			<c:otherwise>
				<%--
				<display:column title="修改" style="width:40px;">
					<img src="${ctx}/resource/admin/images/pencil.png"
						onclick="return modifyOne('${row.id}');" style="cursor:hand;" />
				</display:column> --%>
				<display:column title="删除" style="width:40px;">
					<img src="${ctx}/resource/admin/images/delete.png"
						onclick="return deleteOne('${row.id}');" style="cursor:hand;" />
				</display:column>
			</c:otherwise>
		</c:choose>
		<display:column title="状态更新">
			<c:if test="${row.status=='未烹饪' }">
				<a href="javascript:updateColumnstatus('烹饪中','${row.id}');">烹饪中</a>
				<br />
			</c:if>
			<c:if test="${row.status=='烹饪中' }">
				<a href="javascript:updateColumnstatus('配送中','${row.id}');">配送中</a>
				<br />
			</c:if>
			<c:if test="${row.status=='配送中' }">
				<a href="javascript:updateColumnstatus('已完成','${row.id}');">已完成</a>
				<a href="javascript:updateColumnstatus('未完成','${row.id}');">未完成</a>
				<br />
			</c:if>
		</display:column>
		<display:column title="物流信息更新">
			<a href="javascript:updateColumnstatuswl('${row.id}');">更新</a>
		</display:column>
		<c:if test="${1==1 }"></c:if>
	</display:table>
</body>
<script type="text/javascript">
	function updateColumncustomerId(customerId, id) {
		if (!confirm("确定要更新为" + customerId + "吗?")) {
			return false;
		}
		var params = {
			id : id,
			customerId : customerId
		};
		$.post("updateColumncustomerId.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.parent.form1.submit();
			}
		});
	}
	function updateColumnstatus(status, id) {
		if (!confirm("确定要更新为" + status + "吗?")) {
			return false;
		}
		var params = {
			id : id,
			status : status
		};
		$.post("updateColumnstatus.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.parent.form1.submit();
			}
		});
	}
	
	function updateColumnstatuswl( id) {
		var pl = prompt("请输入物流信息:","");
		if($.trim(pl) == '') {
			alert('请输入物流信息！');
			return false;
		}
		var params = {
			id : id,
			pl : pl
		};
		$.post("updateColumnstatuswl.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.parent.form1.submit();
			}
		});
	}
	
	
	function deleteOne(id) {
		if (!confirm("确定要删除吗?")) {
			return false;
		}
		var params = {
			id : id
		};
		$.post("editDelete.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.parent.form1.submit();
			}
		});
	}
	function modifyOne(id) {
		MyWindow.OpenCenterWindow('edit.html?id=' + id + '&flag=${param.flag}',
				'modify', 500, 600);
	}
</script>
</html>
