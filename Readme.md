<h1>Overview</h1>

Repository to track development of RESTful web services

<h1>Notes</h1>

1. <strong>@RestController</strong> <br>
    Annotation to tell Spring that a class is a RestController. <br>
    <em>@RestController</em> is a combination of <em>@Controller</em> and <em>@ResponseBody</em>. <br>
    <pre>Example:
        @RestController
        public class DemoRestController {
            ...
        } </pre><br>
2. <strong>@RequestMapping</strong> <br>
    Annotation when annotated on a class, tells Spring that a class will respond a specified sub-path. <br>
    Any Mapping in this class will respond to path with the prefix specified in class annotated path. <br>
    <pre>Example:
        @RestController
        @RequestMapping("/test")
        public class DemoRestController {
            ...
        }
   <em>Note: All mapping inside the DemoRestController class will respond to /test/... URI</em></pre> <br>
3. <strong>@GetMapping</strong> <br>
    Annotation when annotated on a method, tells Spring that a method will respond a specified path. <br>
    <pre>Example:
        @RestController
        @RequestMapping("/test")
        public class DemoRestController {
            @GetMapping("/hello")
            public String getHello(){
                return "Hello World!";
            }
        } </pre><br>
4. <strong>JSON Binding in SpringBoot</strong> <br>
   &emsp;a. JSON Binding is also called Serialization/Deserialization or Mapping or Marshalling/ Unmarshalling. <br>
   &emsp;b. It is process of converting JSON string to POJO and vice versa. <br>
   &emsp;c. Jackson Project dependency is used to handle this conversion/ binding. <br>
   &emsp;d. Jackson uses appropriate Getter and Setter methods thus the POJO should have these methods defined in POJO. <br>
   &emsp;e. In Spring REST application, JSON binding is handled by Spring. <br>
   &emsp;&emsp;-> Any JSON data being passed to REST controller will be converted to POJO. <br>
   &emsp;&emsp;-> Any Java object being returned from REST Controller is converted to JSON. <br><br>
5. <strong>@PathVariable</strong> <br>
   Annotation to tell Spring that a parameter to a mapped controller method is a path parameter. <br>
   The mapping annotation must have the path parameter placeholder in the path string. <br>
   The path parameter placeholder and the parameter name should match. <br>
   <pre>Example:
      @RestController
      @RequestMapping("/api")
      public class StudentRestController {
   
          @GetMapping("/students/{studentId}")
          public Student getStudent(@PathVariable Integer studentId){
              return students.get(studentId);
          }
   
      }</pre> <br>
6. <strong>Exception Handling in Spring REST Api</strong> <br>
   ![Exception Handling](./img/exceptionhandling.PNG?raw=true "ExceptionHandling") <br><br>
   Steps for returning custom error response in Spring API: <br>
   &emsp;a. Create a custom error response class that will have all details related to error to send to client/caller. <br>
      <pre>Example:
      public class StudentErrorResponse {
          private int status;
          private String message;
          private long timestamp;
         // Constructors, getters and setter defined 
      }</pre>
   &emsp;b. Create a custom exception class for the exception we want to handle
      <pre>Example:
      public class StudentNotFoundException extends RuntimeException{
         // Constructors of different types as per need
      }</pre>
   &emsp;c. Throw exception of required type from controller mapped method
      <pre>Example:
      @RestController
      @RequestMapping("/api")
      public class StudentRestController {
         
         @GetMapping("/students/{studentId}")
         public Student getStudent(@PathVariable Integer studentId){
           if(studentId>=students.size() || studentId<0)
               throw new StudentNotFoundException("Student id not found - "+studentId);
           return students.get(studentId);
         }
   
      }</pre>
   &emsp;d. Add exception handler using @ExceptionHandler annotated method. <br>
   It can be inside any bean being managed by Spring but advised to be in class Annotated with @ControllerAdvice. <br>
   <pre>Example: 
         @RestController
         @RequestMapping("/api")
         public class StudentRestController {

            @ExceptionHandler
            public ResponseEntity&lt;StudentErrorResponse&gt; handleException(StudentNotFoundException exc){
              StudentErrorResponse error = new StudentErrorResponse();
            
              error.setStatus(HttpStatus.NOT_FOUND.value());
              error.setMessage(exc.getMessage());
              error.setTimestamp(System.currentTimeMillis());
            
              return new ResponseEntity&lt;&gt;(error, HttpStatus.NOT_FOUND);
            }
   
         }</pre> <br>
7. <strong>@ExceptionHandler</strong> <br>
   Annotation to tell Spring that a method is handler when a particular exception type is thrown at run-time. <br>
   <pre>Example:
      @RestController
      @RequestMapping("/api")
      public class StudentRestController {

         @ExceptionHandler
         public ResponseEntity&lt;StudentErrorResponse&gt; handleException(StudentNotFoundException exc){
           StudentErrorResponse error = new StudentErrorResponse();
         
           error.setStatus(HttpStatus.NOT_FOUND.value());
           error.setMessage(exc.getMessage());
           error.setTimestamp(System.currentTimeMillis());
         
           return new ResponseEntity&lt;&gt;(error, HttpStatus.NOT_FOUND);
         }
   
      }
   
      <em>Note: The above handler method handles the exception of type StudentNotFoundException</em>
   </pre> <br>
