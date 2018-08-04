package com.clashmate.backend.interceptors;

import com.clashmate.backend.model.tenant.Tenant;
import com.clashmate.backend.util.HelperMethod;
import com.clashmate.backend.util.tenant.TenantContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TenantInterceptor extends HandlerInterceptorAdapter {

    private final Logger LOG = LoggerFactory.getLogger(TenantInterceptor.class);

    @Autowired
    HelperMethod helperMethod;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Tenant tenant = helperMethod.fetchTenantFromRequest(request);
        Boolean tenantSet = Boolean.FALSE;
        if (tenant == null) {
            LOG.warn("**********************        Tenant not found");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"error\": \"No tenant supplied\"}");
            response.getWriter().flush();
        } else {
            LOG.info("**********************        Tenant found    ====>>>>    " + tenant.getUniqueId());
            TenantContext.setCurrentTenant(tenant);
            tenantSet = Boolean.TRUE;
        }

        return tenantSet;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        TenantContext.clear();
    }
}
