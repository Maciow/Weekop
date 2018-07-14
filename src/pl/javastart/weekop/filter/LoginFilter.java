package pl.javastart.weekop.filter;

import pl.javastart.weekop.model.User;
import pl.javastart.weekop.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;
        if (httpReq.getUserPrincipal()!=null && httpReq.getSession().getAttribute("user")==null){
            saveUserInSession(httpReq);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private void saveUserInSession(HttpServletRequest request) {
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByUsername = userService.getUserByUsername(username);
        request.getSession(true).setAttribute("user",userByUsername);
    }

    @Override
    public void destroy() {

    }
}
