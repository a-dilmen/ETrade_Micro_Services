package com.dilmen.repository;

import com.dilmen.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
        Optional<User> findOptionalByAuthId(Long authId);

}
