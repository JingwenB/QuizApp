package com.bfs.quizApp.filter;

import com.bfs.quizApp.domain.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("In LoginFilter");
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            String path = request.getRequestURI();
            User u = (User) session.getAttribute("user");
            if(!u.isActive()){
                response.sendRedirect("/login");
            }
            if(!u.isAdmin() && (path.contains("/admin") )){
                System.out.println("not admin getting user home");
                response.sendRedirect("/user_home");
            } else if (u.isAdmin() && (path.contains("/user") ||
//                    path.contains("details") ||
                    path.contains("submit") ||
                    path.equals("/contact_us")||
                    path.equals("/feedback") ||
                    path.equals("/setCategory"))){
                response.sendRedirect("/admin_home");
            } else {
                filterChain.doFilter(request, response);
            }
//            filterChain.doFilter(request, response);

        } else {
            // redirect back to the login page if user is not logged in
            response.sendRedirect("/login");

        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return "/login".equals(path) || "/register".equals(path) || "/create_user".equals(path);
    }
}
