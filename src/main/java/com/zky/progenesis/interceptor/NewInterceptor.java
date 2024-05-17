package com.zky.progenesis.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.zky.progenesis.config.MyContextHandler;
import com.zky.progenesis.config.UserContext;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String tenantId = request.getParameter("tenantId");

        UserContext userContext = UserContext.builder().organizationId(tenantId).build();

        MyContextHandler.set(userContext);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MyContextHandler.remove();
    }
}
