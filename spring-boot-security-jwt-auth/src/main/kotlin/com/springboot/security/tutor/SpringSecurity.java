package com.springboot.security.tutor;

/**
 * @author prabhakar, @Date 06-10-2024
 */
public class SpringSecurity {

    String content = """
            Spring Security is a powerful and highly customizable authentication and access-control framework.
            It is the de-facto standard for securing Spring-based applications.
            Here are some key features:
            """;

    String conceptOfSpringSecurity = """
            
            1. Authentication and Authorization:
                Provides comprehensive support for both authentication (verifying user identity) and
                authorization (controlling access to resources).
                
                Example:
                    
                    @Configuration
                    @EnableWebSecurity
                    public class SecurityConfig extends WebSecurityConfigurerAdapter {
                        @Override
                        protected void configure(HttpSecurity http) throws Exception {
                            http
                                .authorizeRequests()
                                    .antMatchers("/public/**").permitAll()
                                    .anyRequest().authenticated()
                                    .and()
                                .formLogin()
                                    .loginPage("/login")
                                    .permitAll()
                                    .and()
                                .logout()
                                    .permitAll();
                        }
                    }
                    
            2. Protection Against Common Attacks:
                Includes built-in protection against common security threats like CSRF (Cross-Site Request Forgery),
                XSS (Cross-Site Scripting), and session fixation attacks.
            
            3. Integration with Spring Data:
                Allows you to secure data access at the repository level,
                ensuring that only authorized users can access or modify data
            
                Example:
                    @Repository
                    public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {
                        @Query("select m from Message m where m.to.id = ?#{principal?.id}")
                        Page<Message> findInbox(Pageable pageable);
                    }
                    
            4. OAuth2 and JWT Support:
                Provides support for OAuth2 and JWT (JSON Web Token) for securing REST APIs.
                
                Integration Example
                    Combining Spring Data and Spring Security can help you create secure,
                    data-driven applications. For instance, you can restrict data access
                    based on the currently authenticated user:
                
                Example:
                
                @Query("select u from User u where u.username = ?#{principal.username}")
                User findCurrentUser();
                
            """;

}
