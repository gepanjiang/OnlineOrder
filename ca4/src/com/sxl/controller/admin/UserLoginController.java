package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.StringHelper;

@Controller("userLoginController")
@RequestMapping(value = "/userLogin")
public class UserLoginController extends MyController {

	@RequestMapping(value = "/login")
	public String index(Model model, HttpServletRequest request) throws Exception {
		return "/user/login";
	}

	@RequestMapping(value = "/save")
	public ResponseEntity<String> loginSave(Model model, HttpServletRequest request, String username, String password)
			throws Exception {
		String sql = "select * from t_user where username=?";
		List<Map> list = db.queryForList(sql, new Object[] { username });
		String result = "1";
		if (list != null && list.size() > 0) {
			Map map = list.get(0);
			if (StringHelper.get(map, "password").equals(password)) {
				request.getSession().setMaxInactiveInterval(60 * 60 * 24);
				request.getSession().setAttribute("userBean", map);
				result = "1";
			} else {
				result = "0";
			}
		} else {
			result = "0";
		}
		return renderData(true, result, null);
	}

	/**
	 * 商家注册
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
	@RequestMapping(value = "/registerSave")
	public ResponseEntity<String> mineSave(Model model, HttpServletRequest request, Long id, String username,
			String password, String name, String gh, String mobile) throws Exception {
		
		String sql_user = "select * from t_user where username=?";
		List users = db.queryForList(sql_user, new Object[]{username});
		if (users.size() != 0) {
			return renderData(false, "用户名已经存在！",null);
		}
		int result = 0;
		String sql = "insert into t_user(username,password,name,gh,mobile) values(?,?,?,?,?)";
		result = db.update(sql, new Object[] { username, password, name, gh, mobile });
		sql = "select * from t_user order by id desc limit 1";
		List<Map> list = db.queryForList(sql);
		request.getSession().setMaxInactiveInterval(60 * 60 * 24);
		request.getSession().setAttribute("userBean", list.get(0));

		return renderData(true, "操作成功", null);
	}

	/**
	 * 商家退出登录
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("userBean");
		return "redirect:/adminLogin/login.html";
	}

}
