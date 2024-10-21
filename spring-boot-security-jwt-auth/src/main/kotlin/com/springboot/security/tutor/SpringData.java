package com.springboot.security.tutor;

/**
 * @author prabhakar, @Date 06-10-2024
 */
public class SpringData {

    String content = """
            Spring Data is a part of the larger Spring ecosystem that simplifies data access and manipulation.
            It provides a consistent and easy-to-use approach to working with different kinds of data stores,
            including relational databases, NoSQL databases, and even cloud-based data services.
            Here are some key features:
            """;


    String conceptOfSpringData = """
            
            1. Repositories:
                    Spring Data provides repository interfaces that reduce boilerplate code for data access.
                    You can define your own repository interfaces and Spring Data will automatically provide implementations.
                    
                Example:
                    public interface UserRepository extends JpaRepository<User, Long> {
                        List<User> findByLastName(String lastName);
                    }
                    
            2. Query Methods:
                    Allows you to define query methods directly in the repository interface using method naming conventions.
            
                Example:
                    List<User> findByFirstNameAndLastName(String firstName, String lastName);
                
            3. Custom Queries: Supports custom queries using JPQL, SQL, or native queries.
                Example:
                    @Query("SELECT u FROM User u WHERE u.email = ?1")
                    User findByEmail(String email);
                    
            4. Auditing:
                    Automatically tracks and logs changes to your entities, such as creation and modification dates.
            
            
            """;

}
