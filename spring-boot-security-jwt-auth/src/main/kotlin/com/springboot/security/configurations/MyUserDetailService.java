package com.springboot.security.configurations;

import com.springboot.security.users.model.Users;
import com.springboot.security.users.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Service
public class MyUserDetailService implements UserDetailsService {


    private final UsersRepository usersRepository;

    public MyUserDetailService(UsersRepository customersRepository) {
        this.usersRepository = customersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = this.usersRepository.findByEmail(username);

        if (user.isEmpty()) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Not Found");
        }

        return new MyUserPrincipal(user.get());
    }


}
