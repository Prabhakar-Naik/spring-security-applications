package com.secure.notes.controller;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.Role;
import com.secure.notes.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author prabhakar, @Date 07-11-2024
 */
@RequestMapping(value = "/api/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public interface AdminController {


    @GetMapping("/getAllUsers")
    ResponseEntity<List<User>> getAllUsers();

    @PutMapping("/update-role")
    ResponseEntity<String> updateUserRole(@RequestParam Long userId, @RequestParam String roleName);

    @GetMapping("/user/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable Long id);

    @PutMapping("/update-lock-status")
    ResponseEntity<String> updateAccountLockStatus(@RequestParam Long userId,
                                                   @RequestParam boolean lock);

    @GetMapping("/roles")
    List<Role> getAllRoles();

    @PutMapping("/update-expiry-status")
    ResponseEntity<String> updateAccountExpiryStatus(@RequestParam Long userId,
                                                     @RequestParam boolean expire);

    @PutMapping("/update-enabled-status")
    ResponseEntity<String> updateAccountEnabledStatus(@RequestParam Long userId,
                                                      @RequestParam boolean enabled);

    @PutMapping("/update-credentials-expiry-status")
    ResponseEntity<String> updateCredentialsExpiryStatus(@RequestParam Long userId,
                                                         @RequestParam boolean expire);

    @PutMapping("/update-password")
    ResponseEntity<String> updatePassword(@RequestParam Long userId,
                                          @RequestParam String password);
}
