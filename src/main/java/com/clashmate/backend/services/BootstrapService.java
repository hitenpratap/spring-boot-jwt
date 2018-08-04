package com.clashmate.backend.services;

import com.clashmate.backend.repository.RoleRepository;
import com.clashmate.backend.repository.UserRepository;
import com.clashmate.backend.repository.UserRoleRepository;
import com.clashmate.backend.security.JwtTokenProvider;
import com.clashmate.backend.util.Bootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BootstrapService implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(BootstrapService.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    Bootstrap bootstrap;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

        bootstrap.createRole();

        bootstrap.createTenant();

        bootstrap.createSuperAdmin();

        LOG.info("...Bootstrapping completed");
    }

}
