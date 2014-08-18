package com.lhdx.www.server.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class ManagerInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		System.out.println("afterCompletion");
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav) throws Exception {
		System.out.println("postHandle");
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		request.setCharacterEncoding("UTF-8");
		/*if(request.getSession().getAttribute("user")!=null){
			return true;
		}else{
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}*/
		System.out.println("pre");
		return true;
	}

}
