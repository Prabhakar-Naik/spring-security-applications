package com.springboot.security.configurations;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author prabhakar, @Date 08-10-2024
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private JwtFilter jwtFilter;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

       /*
        httpSecurity.csrf(customizer -> customizer.disable()); // or AbstractHttpConfigurer::disable
        httpSecurity.authorizeHttpRequests(request ->
                request.anyRequest().authenticated());      // any request you pass it automatically authenticate
        httpSecurity.formLogin(Customizer.withDefaults());  // this is form login in web we must authorize
        httpSecurity.httpBasic(Customizer.withDefaults());  // this id http basic protocol in post man or rest Apis
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // above state, you must log in each and evey request from you in web not in postman or rest api
        // if you want that feature without log in every time just comment down the formLogin.
        // every time request give you new session id

        */      // alternatively we can customize

        /*
        // below this no of lines of code equals to httpSecurity.csrf(customizer -> customizer.disable());
        Customizer<CsrfConfigurer<HttpSecurity>> customizeCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                httpSecurityCsrfConfigurer.disable();
            }
        };
        httpSecurity.csrf(customizeCsrf);
        */
        // like this every line we can develop for above code

        //return httpSecurity.build();

        // this is also taking the username and password from properties file
        // static values. don't use in prod

        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request -> request
                .requestMatchers("/api/users/register","/api/users/login")
                .permitAll()
                .anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); not at the verification or login
        provider.setPasswordEncoder(this.bCryptPasswordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
       return configuration.getAuthenticationManager();
    }


/*      // this is also hard coded don't use in production
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User
                .withDefaultPasswordEncoder().username("kiran").password("k@123")
                .roles("USER").build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder().username("harsh").password("h@123")
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
*/





}
