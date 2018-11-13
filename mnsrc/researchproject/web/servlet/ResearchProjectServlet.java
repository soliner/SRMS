package cn.mnsrc.researchproject.web.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.itcast.usermng.domain.PageBean;
import cn.mnsrc.researchproject.domain.ResearchProject;
import cn.mnsrc.researchproject.service.ResearchProjectService;

public class ResearchProjectServlet extends BaseServlet {
	private ResearchProjectService researchProjectService = new ResearchProjectService();
	
	@SuppressWarnings("deprecation")
	public String export(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("octets/stream");
		String excelname = "科研项目统计表" + new Date("yyyy-MM-dd").toString();
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelname.getBytes("gb2312"), "ISO8859-1") + ".xls");
		OutputStream out = response.getOutputStream();
		ResearchProject project = new ResearchProject();
		researchProjectService.exportExcel1(excelname, getList(), out, "yyyy-MM-dd");
		out.close();
		request.setAttribute("msg", "导出成功");
		return "f:/msg.jsp";
	}
	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 100; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("number", 1000 + i);
			map.put("name", "张三" + i);
			int age = (int) (Math.random() * 100);
			do {
				age = (int) (Math.random() * 100);
			} while (age < 10 || age > 15);
			map.put("age", age);
			map.put("sex", age % 2 == 0 ? 0 : 1);
			list.add(map);
		}
		return list;
	}


	/**
	 * 添加项目
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public String add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 封装表单到ResearchProject对象中 3. 使用service方法完成添加工作 4. 向request域中保存成功信息
		 * 5. 转发
		 */

		ResearchProject c = CommonUtils.toBean(request.getParameterMap(), ResearchProject.class);
		researchProjectService.add(c);
		request.setAttribute("msg", "添加成功");
		return "f:/msg.jsp";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		ResearchProject rp = researchProjectService.load(pid);
		request.setAttribute("rp", rp);
		return "f:/scienceResearchProject/editProject.jsp";

	}

	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResearchProject rp = CommonUtils.toBean(request.getParameterMap(), ResearchProject.class);
		researchProjectService.edit(rp);
		request.setAttribute("msg", "编辑成功");
		return "f:/msg.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		researchProjectService.delete(pid);
		request.setAttribute("msg", "删除成功");
		return "f:/msg.jsp";
	}

	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResearchProject criteria = CommonUtils.toBean(request.getParameterMap(), ResearchProject.class);
		//request.setAttribute("criteria", criteria);
		criteria = endcoding(criteria);
		int pc = getPc(request);
		int ps = 1000;
		PageBean<ResearchProject> pb = researchProjectService.query(criteria, pc, ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/scienceResearchProject/scienceResearchStatistics.jsp";

	}

	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();// 获取项目名
		String servletPath = request.getServletPath();// 获取ServletPath，即CustomerServlet
		String queryString = request.getQueryString();// 获取问号之后的参数部分
		// 判断参数部分中是否包含pc这个参数，如果包含，需要截取下去，不要这一部分
		if (queryString.contains("&pc=")) {
			int index = queryString.lastIndexOf("&pc=");
			queryString = queryString.substring(0, index);
		}
		return contextPath + servletPath + "?" + queryString;
	}

	private int getPc(HttpServletRequest request) {
		String value = request.getParameter("pc");
		if (value == null || value.trim().isEmpty()) {
			return 1;
		}
		return Integer.parseInt(value);
	}

	private ResearchProject endcoding(ResearchProject criteria) throws UnsupportedEncodingException {
		String pid = criteria.get工号();
		String pname = criteria.get姓名();
		Date startdate = criteria.get起始时间();
		Date enddate = criteria.get结束时间();
		if (pid != null && !pid.trim().isEmpty()) {
			pid = new String(pid.getBytes("ISO-8859-1"), "utf-8");
			criteria.set工号(pid);
		}
		if (pname != null && !pname.trim().isEmpty()) {
			pname = new String(pname.getBytes("ISO-8859-1"), "utf-8");
			criteria.set姓名(pname);
		}

		return criteria;
	}

}
