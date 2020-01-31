
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
 * 建议控制器
 * @author LiuFei
 *
 */
@Controller("contactController")
@RequestMapping(value = "/admin/contact")
public class ContactController extends MyController {

	/**
	 * 返回建议主页面
	 * @param model
	 * @param request
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request, String flag) throws Exception {
		return "/admin/contact/frame";
	}

	/**
	 * 查询建议信息
	 * @param model
	 * @param request
	 * @param flag
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request, String flag, String phone) throws Exception {
		String aa = "select * from t_customer ";
		List<Map> list11 = db.queryForList(aa);
		System.out.println(list11);

		String sql = "select a.phone, a.*,(select max(customerName) from t_customer b where a.customerId=b.id) customerName  from t_contact a where 1=1";

		if (1 == 2) {
			sql += "and customerId=" + getCustomer(request).get("id") + " ";
		}
		if (phone != null && !"".equals(phone)) {
			sql += " and phone like '%" + phone + "%'";
		}
		sql += " order by id desc";
		List list = db.queryForList(sql);
		System.out.println(sql);
		request.setAttribute("list", list);
		System.out.println(list);
		return "/admin/contact/list";
	}

	/**
	 * 编辑或新增建议信息
	 * @param model
	 * @param request
	 * @param id
	 * @param flag
	 * @param customerId
	 * @param phone
	 * @param content
	 * @param insertDate
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String flag,
			Integer customerId, String phone, String content, String insertDate) throws Exception {
		int result = 0;
		if (id != null) {
			String sql = "update t_contact set phone=?,content=? where id=?";
			result = db.update(sql, new Object[] { phone, content, id });
		} else {
			String sql = "insert into t_contact(customerId,phone,content,insertDate) values(?,?,?,now())";
			result = db.update(sql, new Object[] { getCustomer(request).get("id"), phone, content });
		}
		if (result == 1) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}

	/**
	 * 删除建议信息
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

		String sql = "delete from t_contact where id=?";
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
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
		if (id != null) {
			// 修改
			String sql = "select * from t_contact where id=?";
			Map map = db.queryForMap(sql, new Object[] { id });
			model.addAttribute("map", map);
		}
		String sql = "";

		return "/admin/contact/edit";
	}
}
