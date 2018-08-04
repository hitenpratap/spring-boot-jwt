package com.clashmate.backend.util;

import com.clashmate.backend.commandObjects.tenant.TenantCO;
import com.clashmate.backend.model.security.Role;
import com.clashmate.backend.model.security.UserRole;
import com.clashmate.backend.model.superAdmin.SuperAdmin;
import com.clashmate.backend.model.tenant.Tenant;
import com.clashmate.backend.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap {

    private final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SuperAdminRepository superAdminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppConstant appConstant;

    public void createTenant() {
        List<String> tenantNameList = Arrays.asList("tenant1", "tenant2", "tenant3");
        for (String tenantName : tenantNameList) {
            String secondaryDomainName = tenantName + ".clashmate.in";
            if (tenantRepository.countBySecondaryDomainNameOrDomainName(secondaryDomainName, secondaryDomainName) == 0) {
                LOG.info("Creating Tenant with SubDomain        =====>>>>   " + secondaryDomainName);
                TenantCO tenantCO = new TenantCO();
                tenantCO.setName(tenantName);
                tenantCO.setSecondaryDomainName(secondaryDomainName);
                Tenant tenant = new Tenant(tenantCO);
                tenantRepository.save(tenant);
            }
        }
    }

    public void createRole() {
        List<String> roleList = Arrays.asList("ROLE_SUPER_ADMIN", "ROLE_TENANT_ADMIN", "ROLE_ADMIN", "ROLE_STUDENT", "ROLE_PARENT");
        for (String roleName : roleList) {
            if (roleRepository.countByName(roleName) == 0) {
                roleRepository.save(new Role(roleName));
            }
        }
    }

    public void createSuperAdmin() {
        if (superAdminRepository.countByEmailAddress("hitenpratap99@gmail.com") == 0) {
            SuperAdmin superAdmin = new SuperAdmin();
            superAdmin.setEmailAddress("hitenpratap99@gmail.com");
            superAdmin.setPassword(passwordEncoder.encode("clashMate@123#"));
            superAdmin.setFirstName("Hiten Pratap");
            superAdmin.setLastName("Singh");
            superAdminRepository.save(superAdmin);
            userRoleRepository.save(new UserRole(superAdmin, roleRepository.findByName(appConstant.ROLE_SUPER_ADMIN).get()));
        }
        if (superAdminRepository.countByEmailAddress("kp03015@gmail.com") == 0) {
            SuperAdmin superAdmin = new SuperAdmin();
            superAdmin.setEmailAddress("kp03015@gmail.com");
            superAdmin.setPassword(passwordEncoder.encode("clashMate@123#"));
            superAdmin.setFirstName("Kshitij");
            superAdmin.setLastName("Panghaal");
            superAdminRepository.save(superAdmin);
            userRoleRepository.save(new UserRole(superAdmin, roleRepository.findByName(appConstant.ROLE_SUPER_ADMIN).get()));
        }
    }

}
