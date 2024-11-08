package com.secure.notes.serviceImpl;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.models.AppRole;
import com.secure.notes.models.Role;
import com.secure.notes.models.User;
import com.secure.notes.repositories.RoleRepository;
import com.secure.notes.repositories.UserRepository;
import com.secure.notes.service.UserService;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author prabhakar, @Date 07-11-2024
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void updateUserRole(Long userId, String roleName) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found."));
        AppRole appRole = AppRole.valueOf(roleName);

        Role role = this.roleRepository.findByRoleName(appRole)
                .orElseThrow(() -> new RuntimeException("Role Not Found"));
        user.setRole(role);
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserDTO getUserById(Long id) {
        //return this.userRepository.findById(id).orElseThrow();
        User user = this.userRepository.findById(id).orElseThrow();
        return convertToDto(user);
    }

    private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.isAccountNonLocked(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                user.getCredentialsExpiryDate(),
                user.getAccountExpiryDate(),
                user.getTwoFactorSecret(),
                user.isTwoFactorEnabled(),
                user.getSignupMethod(),
                user.getRole(),
                user.getCreatedDate(),
                user.getUpdatedDate()
        );
    }


    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void updateAccountLockStatus(Long userId, boolean lock) {

    }

    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public void updateAccountExpiryStatus(Long userId, boolean expire) {

    }

    @Override
    public void updateAccountEnabledStatus(Long userId, boolean enabled) {

    }

    @Override
    public void updateCredentialsExpiryStatus(Long userId, boolean expire) {

    }

    @Override
    public void updatePassword(Long userId, String password) {

    }

    @Override
    public void generatePasswordResetToken(String email) {

    }

    @Override
    public void resetPassword(String token, String newPassword) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public GoogleAuthenticatorKey generate2FASecret(Long userId) {
        return null;
    }

    @Override
    public boolean validate2FACode(Long userId, int code) {
        return false;
    }

    @Override
    public void enable2FA(Long userId) {

    }

    @Override
    public void disable2FA(Long userId) {

    }
}
