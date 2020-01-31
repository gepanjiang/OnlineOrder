
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
 * 商家控制器
 * @author LiuFei
 *
 */
@Controller("adminUserController")
@RequestMapping(value = "/admin/user")
public class AdminUserController extends MyController {

	/**
	 * 返回商家信息主页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request) throws Exception {
		return "/admin/user/frame";
	}

	/**
	 * 查询商家信息
	 * @param model
	 * @param request
	 * @param username
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String username, String name) throws Exception {
		String sql = "select a.* from t_user a where 1=1";

		if (username != null && !"".equals(username)) {
			sql += " and username like '%" + username + "%'";
		}
		if (name != null && !"".equals(name)) {
			sql += " and name like '%" + name + "%'";
		}
		sql += " order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/user/list";
	}

	/**
	 * 增加或修改商家信息
	 * @param model
	 * @param request
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @param gh
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String username,
			String password, String name, String gh, String mobile) throws Exception {
		int result = 0;
		if (id != null) {
			String sql = "update t_user set username=?,password=?,name=?,gh=?,mobile=? where id=?";
			result = db.update(sql, new Object[] { username, password, name, gh, mobile, id });
		} else {
			String sql = "insert into t_user(username,password,name,gh,mobile) values(?,?,?,?,?)";
			result = db.update(sql, new Object[] { username, password, name, gh, mobile });
		}
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}

	/**
	 * 删除商家信息
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model, HttpServletRequest request, Long id) throws Exception {

		String sql = "delete from t_user where id=?";
		int result = db.update(sql, new Object[] { id });
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}

	}

	/**
	 * 编辑之前的查询操作
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request, Long id) throws Exception {
		if (id != null) {
			// 修改
			String sql = "select * from t_user where id=?";
			Map map = db.queryForMap(sql, new Object[] { id });
			model.addAttribute("map", map);
		}
		String sql = "";

		return "/admin/user/edit";
	}
}
