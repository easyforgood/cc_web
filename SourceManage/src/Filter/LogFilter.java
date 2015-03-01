package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	private FilterConfig config;

	public void setFilterConfig(FilterConfig config) {
		this.config = config;
	}

	public FilterConfig getFilterConfig() {
		return config;
	}

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		System.out.println("------开始过滤---------");
		HttpServletRequest hrequest = (HttpServletRequest) request;
		System.out.println("------请求地址 ： " + hrequest.getServletPath());
		chain.doFilter(request, response); // no chain parameter needed here
		long after = System.currentTimeMillis();
		System.out.println("------结束过滤---------");
		System.out.println("请求被定位到" + hrequest.getRequestURI() + "所花时间为: "
				+ (after - before) +"微秒");
	}
}
