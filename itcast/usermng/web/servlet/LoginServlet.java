package cn.itcast.usermng.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.usermng.domain.User;
import cn.itcast.usermng.service.UserException;
import cn.itcast.usermng.service.UserService;

/**
 * 处理登录请求
 * 它是web层，所有与web相关的内容可以出现在这里！
 * 例如；request、repsonse、ServletContext，它们只能出现在web层！
 * @author cxf
 *
 */
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 依赖service
		UserService userService = new UserService();
		
		/*
		 * 1. 一句封装
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		/*
		 * 2. 输入校验（略）
		 */
		/*
		 * 3. 调用userService的login()方法，完成业务
		 */
		/*
		 * 验证码
		 */
		Map<String,String> errors = new HashMap<String,String>();
		String verifyCode = form.getVerifyCode();
		String session_vcode = (String)request.getSession().getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) {//非空校验
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(session_vcode)) {
			errors.put("verifyCode", "验证码错误！");
		}
		
		/*
		 * 查看是否存在错误，若存在，把errors保存到request域
		 * 回显：把用户填写的表单数据，归还给页面，让页面显示！把form保存到request中
		 * 并转发到regist.jsp
		 */
		if(errors.size() > 0) {
			// 保存errors到request域
			request.setAttribute("errors", errors);
			// 保存表单数据，为了页面的回显
			request.setAttribute("form", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		try {
			User user = userService.login(form);
			/*
			 * 执行到这里，说明登录成功了
			 */
			// 保存当前用户到session中
			request.getSession().setAttribute("session_user", user);
			// 重定向到index.jsp
			response.sendRedirect(request.getContextPath() + "/WebContent/index.html");
		} catch (UserException e) {
			/*
			 * 执行到这里，说明登录失败
			 * 1. 保存异常信息、form，到reuqest域
			 * 2. 转发到login.jsp
			 */
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("form", form);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}
}
