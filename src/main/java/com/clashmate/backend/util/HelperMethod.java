package com.clashmate.backend.util;

import com.clashmate.backend.model.tenant.Tenant;
import com.clashmate.backend.repository.TenantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
public class HelperMethod {

    private final Logger LOG = LoggerFactory.getLogger(HelperMethod.class);

    @Autowired
    TenantRepository tenantRepository;

    public String fetchRandomUniqueStr() {
        return UUID.randomUUID().toString();
    }

    public Tenant fetchTenantFromRequest(HttpServletRequest request) {
        String domain = request.getServerName();
        return tenantRepository.findBySecondaryDomainNameOrDomainName(domain, domain).orElse(null);
    }

}
