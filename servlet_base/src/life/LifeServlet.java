package life;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

// servlet程序的生命周期由tomcat服务器控制
public class LifeServlet extends HttpServlet {

	//4个生命周期-方法
	 // 1.构造方法
	public LifeServlet(){
		System.out.println("1.servlet对象被创建了。");
	}

	// 2.init方法
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.init方法被调用");
	}
	
	 // 3.service方法，每次请求时调用
	@Override			
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("3.service方法被调用");
	}
	
	 // 4.destroy方法，关闭服务器时调用
	@Override
	public void destroy() {
		System.out.println("4.servlet对象销毁了");
	}
	
	
}
