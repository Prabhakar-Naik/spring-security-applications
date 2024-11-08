package com.secure.notes.security;

import com.secure.notes.users.model.AppRole;
import com.secure.notes.users.model.Role;
import com.secure.notes.users.model.User;
import com.secure.notes.users.repository.RoleRepository;
import com.secure.notes.users.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.time.LocalDate;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author prabhakar, @Date 25-10-2024
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {


    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) ->
                request.requestMatchers("/hello").permitAll()
                .requestMatchers("/public").permitAll()
                .requestMatchers("/admin").denyAll()
                .requestMatchers("/admin/**").denyAll()
                        .anyRequest().authenticated());

        //httpSecurity.formLogin(withDefaults());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        httpSecurity.httpBasic(withDefaults());
        return httpSecurity.build();
    }*/

    // there is no differ above one and below one clear picture on testing purpose
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((request) ->
                request.anyRequest().authenticated());

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        //httpSecurity.formLogin(withDefaults());
        httpSecurity.httpBasic(withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    // no need this configuration after configuring database based users
    // in userDetails to communication with spring security framework.
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        JdbcUserDetailsManager manager =
                new JdbcUserDetailsManager(dataSource);
        if (!manager.userExists("User1")){
            manager.createUser(
                    User.withUsername("User1")
                            .password("{noop}password1")
                            .roles("USER")
                            .build());
        }
        if (!manager.userExists("admin")){
            manager.createUser(
                    User.withUsername("admin")
                            .password("{noop}adminPass")
                            .roles("ADMIN")
                            .build()
            );
        }

        return manager;
    }
*/
    // dummy role data for testing

    @Bean
    public CommandLineRunner initData(RoleRepository roleRepository, UserRepository userRepository){
        return args -> {
            Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_USER)));

            Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_ADMIN)));

            if (!userRepository.existsByUsername("user1")){
                User user1 = new User("user1","user1@gmail.com","{noop}password1");
                user1.setAccountNonLocked(false);
                user1.setAccountNonExpired(true);
                user1.setCredentialsNonExpired(true);
                user1.setEnabled(true);
                user1.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
                user1.setAccountExpiryDate(LocalDate.now().plusYears(1));
                user1.setTwoFactorEnabled(false);
                user1.setSignupMethod("email");
                user1.setRole(userRole);
                userRepository.save(user1);
            }

            if (!userRepository.existsByUsername("admin")){
                User admin = new User("admin","admin@gmail.com","{noop}adminPassword1");
                admin.setAccountNonLocked(true);
                admin.setAccountNonExpired(true);
                admin.setCredentialsNonExpired(true);
                admin.setEnabled(true);
                admin.setCredentialsExpiryDate(LocalDate.now().plusYears(1));
                admin.setAccountExpiryDate(LocalDate.now().plusYears(1));
                admin.setTwoFactorEnabled(false);
                admin.setSignupMethod("email");
                admin.setRole(adminRole);
                userRepository.save(admin);
            }


        };
    }

}
