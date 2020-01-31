
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
 * 顾客信息控制器
 * @author LiuFei
 *
 */
@Controller("adminCustomerController")
@RequestMapping(value = "/admin/customer")
public class AdminCustomerController extends MyController {

	/**
	 * 返回显示页面
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request) throws Exception {
		return "/admin/customer/frame";
	}

	/**
	 * 显示所有用户信息
	 * @param model
	 * @param request
	 * @param username
	 * @param customerName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String username, String customerName) throws Exception {
		String sql = "select a.* from t_customer a where 1=1";

		if (username != null && !"".equals(username)) {
			sql += " and username like '%" + username + "%'";
		}
		if (customerName != null && !"".equals(customerName)) {
			sql += " and customerName like '%" + customerName + "%'";
		}
		sql += " order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/customer/list";
	}

	/**
	 * 后台用户信息管理【增加和修改用户】
	 * @param model
	 * @param request
	 * @param id
	 * @param username
	 * @param password
	 * @param customerName
	 * @param sex
	 * @param address
	 * @param mobile
	 * @param account
	 * @param jf
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String username,
			String password, String customerName, String sex, String address, String phone, Integer account,
			Integer jf) throws Exception {
		int result = 0;
		if (id != null) {
			String sql = "update t_customer set username=?,password=?,customerName=?,sex=?,address=?,phone=?,account=?,jf=? where id=?";
			result = db.update(sql,
					new Object[] { username, password, customerName, sex, address, phone, account, jf, id });
		} else {
			String sql = "insert into t_customer(username,password,customerName,sex,address,phone,account,jf) values(?,?,?,?,?,?,?,?)";
			result = db.update(sql,
					new Object[] { username, password, customerName, sex, address, phone, account, jf });
		}
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}

	/**
	 * 删除操作
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model, HttpServletRequest request, Long id) throws Exception {

		String sql = "delete from t_customer where id=?";
		int result = db.update(sql, new Object[] { id });
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}

	}

	/**
	 * 修改性别
	 * @param model
	 * @param request
	 * @param id
	 * @param sex
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateColumnsex")
	public ResponseEntity<String> updateColumnsex(Model model, HttpServletRequest request, Long id, String sex)
			throws Exception {

		String sql = "update t_customer set sex=?   where id=?";
		int result = db.update(sql, new Object[] { sex, id });
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}

	}

	/**
	 * 点击页面修改按钮查询对应数据
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
			String sql = "select * from t_customer where id=?";
			Map map = db.queryForMap(sql, new Object[] { id });
			model.addAttribute("map", map);
		}
		String sql = "";

		return "/admin/customer/edit";
	}
}
