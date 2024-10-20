package com.springboot.security.users.repository;

import com.springboot.security.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);

    @Query("SELECT u FROM Users u WHERE u.email = :email AND u.password = :password")
    Optional<Users> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
