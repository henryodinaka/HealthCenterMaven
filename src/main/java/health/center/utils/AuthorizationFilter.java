package health.center.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

/**
 *
 * @author LEOGOLD
 */
//@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
//        try {
//            HttpServletRequest request = (HttpServletRequest) servletRequest;
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            HttpSession ses = request.getSession(false);
//
//            String reqURI = request.getRequestURI();
//            if (reqURI.contains("/index.xhtml")
//                    || reqURI.contains("/login.xhtml")
//                    || reqURI.contains("/new_account.xhtml")
//                    || reqURI.contains("/admin_reg.xhtml")
//                    || (ses != null && ses.getAttribute("username") != null)
//                    || reqURI.contains("/public/")
//                    || reqURI.contains("javax.faces.resource")) {
//                chain.doFilter(request, servletResponse);
//            } else {
//                response.sendRedirect(request.getContextPath() + "/faces/login.xhtml");
//            }
//        } catch (IOException | ServletException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void destroy() {

    }
}
