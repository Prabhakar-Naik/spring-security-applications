package com.springboot.security.tutor;

/**
 * @author prabhakar, @Date 06-10-2024
 */
public class SpringMVC {

    String content = """
            Spring MVC (Model-View-Controller) is a framework within the Spring ecosystem.
            It's designed for building web applications. It follows the MVC design pattern,
            which separates an application into three main components: Model, View, and Controller.
            Here’s a brief overview of each component:
            """;

    String conceptOfSpringMVC = """
            
            1. Model: Represents the application’s data and business logic.
                      It can be a single object or a collection of objects.
            2. View: Responsible for rendering the user interface. Typically,
                     JSP (JavaServer Pages) is used, but Spring MVC also supports other
                     view technologies like Thymeleaf, FreeMarker, and Apache Velocity.
            3. Controller: Handles user input and interactions, processes the data from the Model,
                           and returns the appropriate View.
            
            Key Features of Spring MVC
                1.1: DispatcherServlet: Acts as the front controller, intercepting all incoming requests and dispatching them to the appropriate handlers (controllers).
                1.2: Handler Mapping: Maps incoming requests to the appropriate controller methods.
                1.3: View Resolver: Resolves the view names returned by controllers to actual view pages.
                1.4: Form Handling: Simplifies handling form submissions and binding form data to model objects.
                1.5: Validation: Supports validation of form data using annotations and custom validators.
            
            Example Workflow
                2.1: Request Handling: The DispatcherServlet receives an HTTP request.
                2.2: Controller Invocation: The request is mapped to a controller method using handler mappings.
                2.3: Business Logic Execution: The controller processes the request, interacts with the model, and prepares data for the view.
                2.4: View Resolution: The controller returns a view name, which the ViewResolver maps to an actual view page.
                2.5: Response Rendering: The view renders the response and sends it back to the client.
            
            Example Code
            Here’s a simple example of a Spring MVC controller:
            
                @Controller
                public class HomeController {
                
                    @GetMapping("/home")
                    public String home(Model model) {
                        model.addAttribute("message", "Welcome to Spring MVC!");
                        return "home"; // This will be resolved to a view named 'home.jsp' or 'home.html'
                    }
                }
                
            Advantages of Spring MVC
                Separation of Concerns: Clearly separates the application’s business logic, user interface, and control flow.
                Flexibility: Supports various view technologies and can be easily integrated with other frameworks and libraries.
                Ease of Testing: The separation of concerns makes it easier to test individual components.
                
            Spring MVC is a powerful framework for building robust and maintainable web applications.
            """;
}
