
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
 * 管理员控制器
 * @author LiuFei
 *
 */
@Controller("adminController")
@RequestMapping(value = "/admin")
public class AdminController extends MyController {

	/**
	 * 返回主页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request) throws Exception {
		return "/admin/index";
	}

	/**
	 * 登录后显示的页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request) throws Exception {
		return "/admin/main";
	}

	/**
	 * 返回按月统计页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/tj1")
	public String tj1(Model model, HttpServletRequest request) throws Exception {
		String sql = "select DATE_FORMAT(insertDate,'%Y-%m-%d') dates,sum(allPrice) price from t_order order by DATE_FORMAT(insertDate,'%Y-%m-%d')  desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/admin/tj/tj1";
	}

	/**
	 * 返回密码页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request) throws Exception {
		return "/admin/password";
	}

	/**
	 * 修改密码
	 * @param model
	 * @param request
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model, HttpServletRequest request, String oldPassword,
			String newPassword) throws Exception {
		Map admin = getAdmin(request);
		if (oldPassword.equals(admin.get("password").toString())) {
			String sql = "update t_admin set password=? where id=?";
			db.update(sql, new Object[] { newPassword, admin.get("id") });
			return renderData(true, "1", null);
		} else {
			return renderData(false, "1", null);
		}
	}
}
