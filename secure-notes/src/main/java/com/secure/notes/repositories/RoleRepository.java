package com.secure.notes.repositories;

import com.secure.notes.models.AppRole;
import com.secure.notes.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author prabhakar, @Date 07-11-2024
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(AppRole appRole);

}
