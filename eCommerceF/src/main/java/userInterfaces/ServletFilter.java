package userInterfaces;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter("")
public class ServletFilter  implements Filter {
       
   
	
	
    public ServletFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	public void destroy() {
		System.out.println("encerro");
	}

	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		if(user.equals("")) {
			out.println("<h2>Inform your name");
		}
		else
		{
		
		
		
		chain.doFilter(request, response);
	}
	}
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("abriu");
	}

}
