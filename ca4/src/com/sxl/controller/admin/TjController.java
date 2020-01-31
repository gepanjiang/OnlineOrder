
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("TjController")
@RequestMapping(value = "/admin/tj")
public class TjController extends MyController {

	@RequestMapping(value = "/tj1")
	public String tj1(Model model, HttpServletRequest request, String flag) throws Exception {

		String sql = "select date_format(insertDate,'%y-%m') days,sum(allPrice) price from t_order group by date_format(insertDate,'%y-%m')";
		List<Map> list = db.queryForList(sql);
		String aa = "";
		String bb = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					aa = "'" + list.get(i).get("days") + "'";
					bb = list.get(i).get("price") + "";
				} else {
					aa += ",'" + list.get(i).get("days") + "'";
					bb += "," + list.get(i).get("price") + "";
				}
			}

		}
		model.addAttribute("aa", aa);
		model.addAttribute("bb", bb);
		return "/admin/tj/tj1";
	}

	@RequestMapping(value = "/tj2")
	public String tj2(Model model, HttpServletRequest request, String flag) throws Exception {

		String sql = "select concat(date_format(insertDate, '%Y'),FLOOR((date_format(insertDate, '%m')+2)/3)) days,sum(allPrice) price from t_order group by concat(date_format(insertDate, '%Y'),FLOOR((date_format(insertDate, '%m')+2)/3))";
		List<Map> list = db.queryForList(sql);
		String aa = "";
		String bb = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					aa = "'" + list.get(i).get("days") + "'";
					bb = list.get(i).get("price") + "";
				} else {
					aa += ",'" + list.get(i).get("days") + "'";
					bb += "," + list.get(i).get("price") + "";
				}
			}

		}
		model.addAttribute("aa", aa);
		model.addAttribute("bb", bb);
		return "/admin/tj/tj2";
	}

	@RequestMapping(value = "/tj3")
	public String tj3(Model model, HttpServletRequest request, String flag) throws Exception {

		String sql = "select date_format(insertDate,'%y') days,sum(allPrice) price from t_order group by date_format(insertDate,'%y')";
		List<Map> list = db.queryForList(sql);
		String aa = "";
		String bb = "";
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i == 0) {
					aa = "'" + list.get(i).get("days") + "'";
					bb = list.get(i).get("price") + "";
				} else {
					aa += ",'" + list.get(i).get("days") + "'";
					bb += "," + list.get(i).get("price") + "";
				}
			}

		}
		model.addAttribute("aa", aa);
		model.addAttribute("bb", bb);
		return "/admin/tj/tj3";
	}

}
