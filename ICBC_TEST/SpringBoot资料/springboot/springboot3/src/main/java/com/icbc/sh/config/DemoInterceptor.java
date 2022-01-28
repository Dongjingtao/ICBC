package com.icbc.sh.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Slf4j
public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		if(request.getRequestURI().contains("evil")){
			log.info("拒绝服务");
			returnDefaultError(response);
			return false;
		}
		return true;
	}
	private void returnDefaultError(HttpServletResponse response) {
		PrintWriter writer = null;
		response.setCharacterEncoding("gbk");
		response.setContentType("text/html;charset=gbk");
		try {
			writer = response.getWriter();
			writer.print("拒绝服务");
		} catch (Exception e) {
			log.error("返回拒绝服务时失败");
		} finally {
			if(writer != null) {
				writer.close();
			}
		}
	}
}
