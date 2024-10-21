package com.springboot.security.tutor;

/**
 * @author prabhakar, @Date 06-10-2024
 */
public class SpringDIAndIoC {

    String content = """
            Dependency Injection (DI) and Inversion of Control (IoC) are
            core concepts in Spring Boot that help manage object creation and dependencies,
            promoting loose coupling and enhancing flexibility.
            """;


    String conceptOfDIAndIoC = """
            
            1. Inversion of Control (IoC)
                IoC is a design principle where the control of object creation and
                management is transferred from the application code to a container or framework.
                In traditional programming, your code controls the flow and creates dependencies.
                With IoC, the framework takes over this control, calling your code when needed.
               
            2. Dependency Injection (DI)
                DI is a specific implementation of IoC. It involves injecting dependencies
                (objects that a class needs to function) into a class, rather than the class creating them itself.
                This can be done in three main ways in Spring Boot:
                2.1: Constructor Injection: Dependencies are provided through the class constructor.
                    Example
                    
                        @Service
                        public class MyService {
                            private final Dependency dependency;
                        
                            @Autowired
                            public MyService(Dependency dependency) {
                                this.dependency = dependency;
                            }
                        }
                2.2: Setter Injection: Dependencies are provided through setter methods.
                    Example
                    
                        @Service
                        public class MyService {
                            private Dependency dependency;
                        
                            @Autowired
                            public void setDependency(Dependency dependency) {
                                this.dependency = dependency;
                            }
                        }
                2.3: Field Injection: Dependencies are directly injected into fields using annotations like @Autowired.
                    Example
                        
                        @Service
                        public class MyService {
                            @Autowired
                            private Dependency dependency;
                        }
                        
            ==> Benefits of DI and IoC
                Loose Coupling: Classes are less dependent on each other, making the code more modular and easier to maintain.
                Easier Testing: Dependencies can be easily mocked or stubbed, facilitating unit testing.
                Flexibility:    It’s easier to switch between different implementations of a dependency.
               
            """;

}
