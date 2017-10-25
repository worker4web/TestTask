package ua.com.worker4web.uth.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.worker4web.uth.test1.services.FileService;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by worker4web on 10/25/2017.
 */

@Component
public class URLFilter implements Filter {

    @Autowired
    FileService fileService;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        //System.out.println("remout IP::"+req.getRemoteAddr());
        if(!fileService.isBlok(req.getRemoteHost()))
            chain.doFilter(req, res);
        else
            ((HttpServletResponse)res).setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

    public void destroy() {

    }

}
