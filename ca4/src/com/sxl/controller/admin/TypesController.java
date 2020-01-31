
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

/**
 * 商品类别控制器
 * @author LiuFei
 *
 */
@Controller("typesController")
@RequestMapping(value = "/admin/types")
public class TypesController extends MyController {

	/**
	 * 返回商品类别页面
	 * @param model
	 * @param request
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request, String flag) throws Exception {
		return "/admin/types/frame";
	}

	/**
	 * 显示商品类别信息
	 * @param model
	 * @param request
	 * @param flag
	 * @param typesName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String flag, String typesName) throws Exception {
		String sql = "select a.* from t_types a where 1=1";

		if (typesName != null && !"".equals(typesName)) {
			sql += " and typesName like '%" + typesName + "%'";
		}
		sql += " order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/types/list";
	}

	/**
	 * 编辑或新增商品类别
	 * @param model
	 * @param request
	 * @param id
	 * @param flag
	 * @param typesName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String flag,
			String typesName) throws Exception {
		int result = 0;
		if (id != null) {
			String sql = "update t_types set typesName=? where id=?";
			result = db.update(sql, new Object[] { typesName, id });
		} else {
			String sql = "insert into t_types(typesName) values(?)";
			result = db.update(sql, new Object[] { typesName });
		}
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}

	/**
	 * 删除商品类别
	 * @param model
	 * @param request
	 * @param id
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model, HttpServletRequest request, Long id, String flag)
			throws Exception {

		String sql = "delete from t_types where id=?";
		int result = db.update(sql, new Object[] { id });
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}

	}

	
	/**
	 * 编辑之前的查找操作
	 * @param model
	 * @param request
	 * @param id
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
		if (id != null) {
			// 修改
			String sql = "select * from t_types where id=?";
			Map map = db.queryForMap(sql, new Object[] { id });
			model.addAttribute("map", map);
		}
		String sql = "";

		return "/admin/types/edit";
	}
}
