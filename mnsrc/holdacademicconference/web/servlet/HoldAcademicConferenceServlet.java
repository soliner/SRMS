package cn.mnsrc.holdacademicconference.web.servlet;
                                                                                                                                                                                                                                 

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.itcast.usermng.domain.PageBean;

import cn.mnsrc.holdacademicconference.domain.HoldAcademicConference;
import cn.mnsrc.holdacademicconference.service.HoldAcademicConferenceService;


public class HoldAcademicConferenceServlet extends BaseServlet {
	private HoldAcademicConferenceService holdAcademicConferenceService = new HoldAcademicConferenceService();

	/**
	 * 添加项目
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 封装表单到ResearchProject对象中 3. 使用service方法完成添加工作 4. 向request域中保存成功信息
		 * 5. 转发
		 */

		HoldAcademicConference s = CommonUtils.toBean(request.getParameterMap(), HoldAcademicConference.class);

		holdAcademicConferenceService.add(s);
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
		HoldAcademicConference ep = holdAcademicConferenceService.load(pid);
		request.setAttribute("ep", ep);
		return "f:/academicEvents/editHoldAcademicConference.jsp";

	}

	public String edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HoldAcademicConference s = CommonUtils.toBean(request.getParameterMap(), HoldAcademicConference.class);
		holdAcademicConferenceService.edit(s);
		request.setAttribute("msg", "编辑成功");
		return "f:/msg.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		holdAcademicConferenceService.delete(pid);
		request.setAttribute("msg", "删除成功");
		return "f:/msg.jsp";
	}

	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HoldAcademicConference criteria = CommonUtils.toBean(request.getParameterMap(), HoldAcademicConference.class);
		//request.setAttribute("criteria", criteria);
		criteria = endcoding(criteria);
		int pc = getPc(request);
		int ps = 10;
		PageBean<HoldAcademicConference> pb = holdAcademicConferenceService.query(criteria, pc, ps);
		pb.setUrl(getUrl(request));
		request.setAttribute("pb", pb);
		return "f:/academicEvents/holdAcademicConference.jsp";

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

	private HoldAcademicConference endcoding(HoldAcademicConference criteria) throws UnsupportedEncodingException {
		String pid = criteria.get负责人();
		String pname = criteria.get举办时间();
		if (pid != null && !pid.trim().isEmpty()) {
			pid = new String(pid.getBytes("ISO-8859-1"), "utf-8");
			criteria.set负责人(pid);
		}
		if (pname != null && !pname.trim().isEmpty()) {
			pname = new String(pname.getBytes("ISO-8859-1"), "utf-8");
			criteria.set举办时间(pname);
		}

		return criteria;
	}

}
