package com.clashmate.backend.repository;

import com.clashmate.backend.model.security.Role;
import com.clashmate.backend.model.security.User;
import com.clashmate.backend.model.security.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, String> {

    Iterable<UserRole> findAllByUser(User user);

    Iterable<UserRole> findAllByRole(Role role);

}
