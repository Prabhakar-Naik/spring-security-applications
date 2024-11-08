package com.secure.notes.controllerImpl;

import com.secure.notes.controller.AdminController;
import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.Role;
import com.secure.notes.models.User;
import com.secure.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author prabhakar, @Date 07-11-2024
 */
@RestController
public class AdminControllerImpl implements AdminController {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateUserRole(Long userId, String roleName) {
        this.userService.updateUserRole(userId,roleName);
        return ResponseEntity.ok("User Role Updated");
    }

    @Override
    public ResponseEntity<UserDTO> getUser(Long id) {
        return new ResponseEntity<>(this.userService.getUserById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateAccountLockStatus(Long userId, boolean lock) {
        return ResponseEntity.ok("");
    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public ResponseEntity<String> updateAccountExpiryStatus(Long userId, boolean expire) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateAccountEnabledStatus(Long userId, boolean enabled) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateCredentialsExpiryStatus(Long userId, boolean expire) {
        return null;
    }

    @Override
    public ResponseEntity<String> updatePassword(Long userId, String password) {
        return null;
    }
}
