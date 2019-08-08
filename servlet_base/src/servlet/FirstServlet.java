package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
 
// servlet基于http协议
public class FirstServlet extends HttpServlet	{
	
	// GET 请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//浏览器响应内容
		resp.getWriter().write("this is first servlet");
	}

}
