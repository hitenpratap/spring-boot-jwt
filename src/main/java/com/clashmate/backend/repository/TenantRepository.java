package com.clashmate.backend.repository;

import com.clashmate.backend.model.tenant.Tenant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TenantRepository extends CrudRepository<Tenant, String> {

    Optional<Tenant> findBySecondaryDomainNameOrDomainName(String secondaryDomainName, String domainName);

    Integer countBySecondaryDomainNameOrDomainName(String secondaryDomainName, String domainName);

}
