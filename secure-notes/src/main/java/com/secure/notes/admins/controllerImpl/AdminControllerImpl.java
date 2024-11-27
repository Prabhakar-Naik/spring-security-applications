package com.secure.notes.admins.controllerImpl;

import com.secure.notes.admins.controller.AdminController;
import com.secure.notes.users.dtos.UserDTO;
import com.secure.notes.users.model.Role;
import com.secure.notes.users.model.User;
import com.secure.notes.users.service.UserService;
import com.secure.notes.users.serviceImpl.UserServiceImpl;
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
    private UserServiceImpl userService;

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

        userService.updateAccountLockStatus(userId, lock);
        return ResponseEntity.ok("Account lock status updated");
    }

    @Override
    public List<Role> getAllRoles() {
        return userService.getAllRoles();
    }

    @Override
    public ResponseEntity<String> updateAccountExpiryStatus(Long userId, boolean expire) {
        userService.updateAccountExpiryStatus(userId, expire);
        return ResponseEntity.ok("Account expiry status updated");
    }

    @Override
    public ResponseEntity<String> updateAccountEnabledStatus(Long userId, boolean enabled) {
        userService.updateAccountEnabledStatus(userId, enabled);
        return ResponseEntity.ok("Account enabled status updated");
    }

    @Override
    public ResponseEntity<String> updateCredentialsExpiryStatus(Long userId, boolean expire) {
        userService.updateCredentialsExpiryStatus(userId, expire);
        return ResponseEntity.ok("Credentials expiry status updated");
    }

    @Override
    public ResponseEntity<String> updatePassword(Long userId, String password) {
        try {
            this.userService.updatePassword(userId, password);
            return ResponseEntity.ok("Password updated");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
