package com.clashmate.backend.repository;

import com.clashmate.backend.model.security.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, String> {

    Optional<Role> findByName(String name);

    Integer countByName(String name);

}
