<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<link href="${ctx}/css/validate.css" rel="stylesheet" type="text/css" />
<html>
<head>
<title>信息内容功能</title>
</head>
<body>
	<form id="form1" name="form1" action="" method="post">
		<input type="hidden" value="${param.flag }" name="flag" /> <input
			type="hidden" value="${map.id }" name="id" id="id" />
			<table class="mobile" style="width: 95%;margin:0 auto;">
				<tr class="pageheader">
					<td colspan="2"><strong>信息处理</strong></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">账号： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="username"
						value="${map.username }" name="username" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">密码： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="password"
						value="${map.password }" name="password" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">姓名： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="customerName"
						value="${map.customerName }" name="customerName" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">性别： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><select id="sex" name="sex">
							<option value="男" ${map.sex=='男'?'selected':'' }>男</option>
							<option value="女" ${map.sex=='女'?'selected':'' }>女</option>
					</select></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">地址： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="address"
						value="${map.address }" name="address" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">手机： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="phone"
						value="${map.phone }" name="phone" /></td>
				</tr>
<!-- 				<tr height="25"> -->
<!-- 					<td class="outDetail" style="width: 30%">金额： <label -->
<!-- 						style="font-weight: bold; color: red"> </label></td> -->
<!-- 					<td class="outDetail2"><input type="text" id="account" -->
<%-- 						value="${map.account }" name="account" /></td> --%>
<!-- 				</tr> -->
<!-- 				<tr height="25"> -->
<!-- 					<td class="outDetail" style="width: 30%">积分： <label -->
<!-- 						style="font-weight: bold; color: red"> </label></td> -->
<!-- 					<td class="outDetail2"><input type="text" id="jf" -->
<%-- 						value="${map.jf }" name="jf" /></td> --%>
<!-- 				</tr> -->
				<c:if test="${1==1 }"></c:if>
			</table>
		<p align="center">
			<br> <input type="button" class="btn" value="保  存"
				onclick="save(this);" /> <input type="button" class="btn"
				value="关  闭" onclick="window.close();" />
		</p>
	</form>
</body>
<script type="text/javascript">
		
	//新增或修改用户信息
	function save(src) {
		var username = $("#username").val();
		if($.trim(username)==''){
			alert('账号不能为空');
			return false;
		}
		var password = $("#password").val();
		if($.trim(password)==''){
			alert('密码不能为空');
			return false;
		}
		var customerName = $("#customerName").val();
		if($.trim(customerName)==''){
			alert('姓名不能为空');
			return false;
		}
		var address = $("#address").val();
		if ($.trim(address) == ''){
			alert("地址必填！");
			return false;
		}
		var phone = $("#phone").val();
		if ($.trim(phone) == ''){
			alert("手机号码必填！");
			return false;
		}
		var rule = /^[1][3,4,5,7,8][0-9]{9}$/;
		if (!rule.test(phone)){
			alert('手机号码格式不对！');
			return false;
		}
		$.post("editSave.html",$("#form1").serializeArray(),
		       function(result){
		        	result = eval("("+result+")");
		    		if(result.status == "true" || result.status == true){
		    			alert('成功');
		    			saveAnd();
		    		}else{
		    			alert('保存失败，请重试');
		    		}
		        }
			);
	}
	function triggerUpload(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_file',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("input[name='img']").val(data.data.filepath);
				$("#imgUrlShow").attr("src",
						"${ctx}/" + data.data.filepath + "");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
</script>
</html>
