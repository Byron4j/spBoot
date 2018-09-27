package com.example.myboot.cfg;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Configuration
public class WebConfiguration {

    /**
     * 自定义过滤器
     */
    public class MyFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest hsr = (HttpServletRequest)request;
            System.out.println("访问URL:" + ((HttpServletRequest) request).getRequestURI());
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    }
}
