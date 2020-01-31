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
			<table class="mobile" style="width: 95%;margin: 0 auto;">
				<tr class="pageheader">
					<td colspan="2"><strong>信息处理</strong></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">商品名称： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input type="text" id="productName"
						value="${map.productName }" name="productName" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">图片1： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="f_fileImg0" name="cmfile"
						onchange="triggerUploadImg0(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="productPic1"
						id="bbbbbImg0" value="${map.productPic1 }"> <c:if
							test="${map.productPic1!=null }">
							<img style='width:100px;' src="${ctx }/${map.productPic1}"
								id="aaaaaImg0" />
						</c:if></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">图片2： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="f_fileImg1" name="cmfile"
						onchange="triggerUploadImg1(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="productPic2"
						id="bbbbbImg1" value="${map.productPic2 }"> <c:if
							test="${map.productPic2!=null }">
							<img style='width:100px;' src="${ctx }/${map.productPic2}"
								id="aaaaaImg1" />
						</c:if></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">图片3： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="f_fileImg2" name="cmfile"
						onchange="triggerUploadImg2(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="productPic3"
						id="bbbbbImg2" value="${map.productPic3 }"> <c:if
							test="${map.productPic3!=null }">
							<img style='width:100px;' src="${ctx }/${map.productPic3}"
								id="aaaaaImg2" />
						</c:if></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">图片4： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="f_fileImg3" name="cmfile"
						onchange="triggerUploadImg3(this);" title="选择图片" type="file">
						<input class="text" type="hidden" name="productPic4"
						id="bbbbbImg3" value="${map.productPic4 }"> <c:if
							test="${map.productPic4!=null }">
							<img style='width:100px;' src="${ctx }/${map.productPic4}"
								id="aaaaaImg3" />
						</c:if></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">价格： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="price" type="text"
						value="${map.price }" name="price" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">原价： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="oldPrice" type="text"
						value="${map.oldPrice }" name="oldPrice" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">描述： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><textarea rows="5" id="content"
							cols="50" name="content">${map.content }</textarea></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">数量： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="nums" type="text"
						value="${map.nums }" name="nums" /></td>
				</tr>
				<%--
				<tr height="25">
					<td class="outDetail" style="width: 30%">积分： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input id="jf" type="text"
						value="${map.jf }" name="jf" /></td>
				</tr> --%>
				<tr height="25">
					<td class="outDetail" style="width: 30%">推荐星级： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><select id="tjxj" name="tjxj">
							<option value="一星" ${map.tjxj=='一星'?'selected':'' }>一星</option>
							<option value="二星" ${map.tjxj=='二星'?'selected':'' }>二星</option>
							<option value="三星" ${map.tjxj=='三星'?'selected':'' }>三星</option>
							<option value="四星" ${map.tjxj=='四星'?'selected':'' }>四星</option>
							<option value="五星" ${map.tjxj=='五星'?'selected':'' }>五星</option>
					</select></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">状态： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><select id="status" name="status">
							<option value="上架" ${map.status=='上架'?'selected':'' }>上架</option>
							<option value="下架" ${map.status=='下架'?'selected':'' }>下架</option>
					</select></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">分类： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><select id="typesId" name="typesId">
							<c:forEach items="${typesList }" var="lists">
								<option value="${lists.id }" ${map.typesId==lists.id?'selected':'' }>${lists.typesName
									}</option>
							</c:forEach>
					</select></td>
				</tr>
				<c:if test="${1==1 }"></c:if>
			</table>
		<p align="center">
			<br>
			<c:if test="${param.method!='show' }">
				<input type="button" class="btn" value="保  存" onclick="save(this);" />
			</c:if>
			<input type="button" class="btn" value="关  闭"
				onclick="window.close();" />
		</p>
	</form>
</body>
<script type="text/javascript">

	//校验数据
	function validate(){
		//商品名称
		var productName = $("#productName").val();
		//商品价格
		var price = $("#price").val();
		//商品旧价格
		var oldPrice = $("#oldPrice").val();
		//描述
		var content = $("#content").val();
		//数量
		var nums = $("#nums").val();
		//类型
		var typesId = $("#typesId").val();
		if( !productName ) {
			alert("请填写商品名称！");
			return false;
		}
		if( !price ) {
			alert("请填写商品价格！");
			return false;
		}
		if ( isNaN(price) ) {
			alert("商品价格必须是数字！");
			return false;
		}
		if ( price <= 0) {
			alert("商品价格必须大于0！");
			return false;
		}
		if ( !oldPrice ) {
			alert("商品原价必填！");
			return false;
		}
		if ( isNaN(oldPrice) ) {
			alert("商品原价必须是数字！");
			return false;
		}
		if ( oldPrice <= 0){
			alert("商品原价必须大于0！");
			return false;
		}
		if ( !content ) {
			alert("请填写商品描述！");
			return false;
		}
		if ( !nums ) {
			alert("请填写商品数量！");
			return false;
		}
		if( isNaN(nums) ) {
			alert("商品数量必须是数字！");
			return false;
		}
		if( nums <= 0 ) {
			alert("商品数量必须大于0！");
			return false;
		}
		return true;
	}
	function save(src) {
		if ( validate() ) {
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
	}
	function triggerUploadImg0(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg0',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg0").val(data.data.filepath);
				$("#aaaaaImg0").remove();
				$("#bbbbbImg0").after("<img  id='aaaaaImg0' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
	function triggerUploadImg1(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg1',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg1").val(data.data.filepath);
				$("#aaaaaImg1").remove();
				$("#bbbbbImg1").after("<img  id='aaaaaImg1' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
	function triggerUploadImg2(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg2',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg2").val(data.data.filepath);
				$("#aaaaaImg2").remove();
				$("#bbbbbImg2").after("<img  id='aaaaaImg2' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
	function triggerUploadImg3(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg3',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg3").val(data.data.filepath);
				$("#aaaaaImg3").remove();
				$("#bbbbbImg3").after("<img  id='aaaaaImg3' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
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
