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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicLayer.LogicLayer;


/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter("")
public class ServletFilter  implements Filter {
       
   
	
	
    public ServletFilter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("abriu");
	}


	
    

	
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		LogicLayer logicLayer = new LogicLayer();
		
		
		
		if(session == null) {
			
		session = req.getSession();	
		String session_tk = session.getId();
		logicLayer.createSession(session_tk);
		
		}
		
		
		chain.doFilter(request, response);
		
		
	}
	
	
	public void destroy() {
		System.out.println("encerro");
	}

	
	
}
