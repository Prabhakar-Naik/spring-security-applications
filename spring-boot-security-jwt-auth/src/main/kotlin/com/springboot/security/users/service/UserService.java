package com.springboot.security.users.service;

import com.springboot.security.enums.Role;
import com.springboot.security.response.ApiResponse;
import com.springboot.security.response.UserResponse;
import com.springboot.security.users.model.Users;
import com.springboot.security.users.repository.UsersRepository;
import com.springboot.security.users.request.AddUserRequest;
import com.springboot.security.users.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authManager;


    public ResponseEntity<ApiResponse> registerUser(AddUserRequest request) {
        Users user = new Users();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(this.encoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        this.usersRepository.save(user);
        return ResponseEntity.ok(new ApiResponse("Here the Data: ", user));
    }

    public ResponseEntity<ApiResponse> loginUser(String email, String password) {
        Optional<Users> user = this.usersRepository.findByEmail(email);
        if (user.isPresent() && this.encoder.matches(password, user.get().getPassword())) {
            Authentication authentication =
                    authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            if (authentication.isAuthenticated()) {
                String response = "Login Success: " + true;
                UserResponse userResponse = new UserResponse(response,user.get());
                String jwtToken = this.jwtService.generateToken(userResponse);

                return ResponseEntity.ok(new ApiResponse("Here the Response: ", jwtToken));
            }
            return ResponseEntity.status(UNAUTHORIZED).body(new ApiResponse("Here the Response: ","Login Fail."));
        } else
            return ResponseEntity.badRequest().body(new ApiResponse("Here the Response: ", HttpStatus.BAD_REQUEST));
    }

    public ResponseEntity<ApiResponse> getUserById(String id) {
        return ResponseEntity.ok(new ApiResponse("Here the Data: ", this.usersRepository.findById(id)));
    }

    public ResponseEntity<ApiResponse> getUserByEmail(String email) {
        if (this.usersRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.ok(new ApiResponse("Here the Response: ", this.usersRepository.findByEmail(email)));
        } else
            return ResponseEntity.ok(new ApiResponse("Here the Response: ", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<ApiResponse> getAllUsers() {
        if (this.usersRepository.findAll().isEmpty()) {
            return ResponseEntity.ok().body(new ApiResponse("Here the Data: ", "No Records are found. Empty"));
        }
        return ResponseEntity.ok(new ApiResponse("Here the Data: ", this.usersRepository.findAll()));
    }

    public ResponseEntity<ApiResponse> updateUser(UpdateUserRequest request) {
        Optional<Users> user = this.usersRepository.findById(request.getId());

        if (user.isPresent()) {
            user.get().setName(request.getName());
            user.get().setPassword(this.encoder.encode(request.getPassword()));
            user.get().setEmail(request.getEmail());
            this.usersRepository.save(user.get());
            return ResponseEntity.ok(new ApiResponse("Here the Response: ", user.get()));
        } else
            return ResponseEntity.status(404).body(new ApiResponse("Here the Response: ", "User Not Found"));
    }

    public ResponseEntity<ApiResponse> deleteUser(String id) {
        if (this.usersRepository.findById(id).isPresent()) {
            this.usersRepository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse("Here the Response: ", "Record Deleted"));
        } else
            return ResponseEntity.status(404).body(new ApiResponse("Here the Response: ", "Record Not Found"));
    }


}
