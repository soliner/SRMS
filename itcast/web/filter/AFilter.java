package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter{
	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		/*
		 * 1.得到application中的map
		 * 2.从request中获取当前客户端的ip地址
		 * 3.查看map中是否存在这个ip对应的访问次数，如果存在，把次数+1再保存回去
		 * 4.如果不存在这个ip，那么是第一次访问本站，设置访问次数为1
		 */
		ServletContext app = config.getServletContext();
		Map<String,Integer> map = (Map<String, Integer>) app.getAttribute("map");
		//获取客户端的ip地址
		String ip = request.getRemoteAddr();
		//进行判断
		if(map.containsKey(ip)){//这个ip在map中存在，说明不是第一次访问
			int cnt = map.get(ip);
			map.put(ip, cnt+1);
		}else{//这个ip在map中不存在，说明是第一次访问
			map.put(ip, 1);
		}
		app.setAttribute("map", map);
		
		chain.doFilter(request, response);
	}
	/**
	 * 在服务器启动时就会执行本方法，而且本方法只执行一次！
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = filterConfig;
	}

}
