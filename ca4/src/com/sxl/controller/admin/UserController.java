
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("userController")
@RequestMapping(value = "/user")
public class UserController extends MyController {

	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request) throws Exception {
		return "/user/index";
	}

	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request) throws Exception {
		String sql = "select * from t_product where nums<5 and userId=?";
		List<Map> list = db.queryForList(sql, new Object[] { getUser(request).get("id") });
		int size = list.size();
		model.addAttribute("size", size);
		return "/user/main";
	}

	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request) throws Exception {
		return "/user/password";
	}

	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model, HttpServletRequest request, String oldPassword,
			String newPassword) throws Exception {
		Map user = getUser(request);
		if (oldPassword.equals(user.get("password").toString())) {
			String sql = "update t_user set password=? where id=?";
			db.update(sql, new Object[] { newPassword, user.get("id") });
			return renderData(true, "1", null);
		} else {
			return renderData(false, "1", null);
		}
	}

	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request) throws Exception {
		Map user = getUser(request);
		Map map = db.queryForMap("select * from t_user where id=?", new Object[] { user.get("id") });
		model.addAttribute("map", map);
		return "/user/mine";
	}

	@RequestMapping(value = "/mineSave")
	public ResponseEntity<String> mineSave(Model model, HttpServletRequest request, Long id, String username,
			String password, String name, String gh, String mobile) throws Exception {
		int result = 0;
		String sql = "update t_user set name=?,gh=?,mobile=? where id=?";
		result = db.update(sql, new Object[] { name, gh, mobile, id });
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}
}
