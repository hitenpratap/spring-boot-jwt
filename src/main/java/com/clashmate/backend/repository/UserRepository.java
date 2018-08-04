package com.clashmate.backend.repository;

import com.clashmate.backend.model.security.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByPhoneNumberOrEmailAddress(String phoneNumber, String emailAddress);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Boolean existsByEmailAddress(String emailAddress);

    Boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByUniqueId(String uniqueId);

}
