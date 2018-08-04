package com.clashmate.backend.repository;

import com.clashmate.backend.model.superAdmin.SuperAdmin;
import org.springframework.data.repository.CrudRepository;

public interface SuperAdminRepository extends CrudRepository<SuperAdmin, String> {

    Integer countByEmailAddress(String emailAddress);

}
