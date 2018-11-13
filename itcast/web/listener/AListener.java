package cn.itcast.web.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {
/**
 * ServletContext生死监听 
 * 可以在这个监听器存放一些在Tomcat启动时就要完成的代码
 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("哇！我来也");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("哇！我去也");
		//创建Map
		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		//得到ServletContext
		ServletContext application = arg0.getServletContext();
		//把Map保存到application中
		application.setAttribute("map", map);

	}

}
