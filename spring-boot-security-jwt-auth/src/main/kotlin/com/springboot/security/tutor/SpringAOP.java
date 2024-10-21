package com.springboot.security.tutor;

/**
 * @author prabhakar, @Date 06-10-2024
 */
public class SpringAOP {

    String content = """
            Aspect-Oriented Programming (AOP) in Spring Boot is a programming paradigm
                that aims to increase modularity by allowing the separation of cross-cutting
                concerns. These are aspects of a program that affect multiple layers or components,
                such as logging, security, and transaction management.
            """;


    String conceptOfAOP = """
            Here’s a breakdown of the key concepts and benefits of AOP in Spring Boot:
            
            1. Aspect: A module that encapsulates a concern that cuts across multiple classes.
                       For example, logging or security.
               Example:
                    
                    @Aspect
                    @Component
                    public class LoggingAspect {
                        private Logger logger = LoggerFactory.getLogger(this.getClass());
                    
                        @Before("execution(* com.example.service.*.*(..))")
                        public void logBefore(JoinPoint joinPoint) {
                            logger.info("Executing: " + joinPoint.getSignature().getName());
                        }
                    }
                    
            2. Join Point: A point during the execution of a program, such as the execution of a method or the handling of an exception.
            3. Advice: The action taken by an aspect at a particular join point. Types of advice include:
                3.1: Before: Executed before a join point.
                3.2: After: Executed after a join point.
                3.3: Around: Executed before and after a join point.
                3.4: After Returning: Executed after a join point completes normally.
                3.5: After Throwing: Executed if a method exits by throwing an exception.
            4. Pointcut: An expression that matches join points.
               Advice is associated with a pointcut expression and runs at any join point matched by the pointcut.
                Example:
                    
                    @Pointcut("execution(* com.example.service.*.*(..))")
                    public void serviceLayer() {}
                    
            Benefits of AOP
            Modularity: Separates cross-cutting concerns from business logic, making the code cleaner and easier to maintain.
            Re-usability: Common functionalities like logging and security can be reused across different parts of the application.
                         Maintainability: Changes to cross-cutting concerns need to be made in one place, reducing the risk of errors and making the code easier to maintain.
            
            Example in Spring Boot
                   To use AOP in a Spring Boot application, you need to add the spring-boot-starter-aop
                   dependency to your pom.xml:
                   <dependency>
                       <groupId>org.springframework.boot</groupId>
                       <artifactId>spring-boot-starter-aop</artifactId>
                   </dependency>
                
                @Aspect
                @Component
                public class LoggingAspect {
                    private Logger logger = LoggerFactory.getLogger(this.getClass());
                
                    @Before("execution(* com.example.service.*.*(..))")
                    public void logBefore(JoinPoint joinPoint) {
                        logger.info("Executing: " + joinPoint.getSignature().getName());
                    }
                }
            
            """;

}
