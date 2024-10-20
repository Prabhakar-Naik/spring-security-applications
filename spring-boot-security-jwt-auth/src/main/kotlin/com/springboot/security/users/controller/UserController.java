package com.springboot.security.users.controller;

import com.springboot.security.response.ApiResponse;
import com.springboot.security.users.request.AddUserRequest;
import com.springboot.security.users.request.UpdateUserRequest;
import com.springboot.security.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody AddUserRequest request){
        return this.userService.registerUser(request);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestParam String email, @RequestParam String password){
        return this.userService.loginUser(email,password);
    }

    @GetMapping(value = "/getUserById/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable String id){
        return this.userService.getUserById(id);
    }

    @GetMapping(value = "/getUserByEmail/{email}")
    public ResponseEntity<ApiResponse> getUserByEmail(@PathVariable String email){
        return this.userService.getUserByEmail(email);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<ApiResponse> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PutMapping(value = "/updateUser")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UpdateUserRequest request){
        return this.userService.updateUser(request);
    }

    @DeleteMapping(value = "/deleteUserById/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String id){
        return this.userService.deleteUser(id);
    }


}
