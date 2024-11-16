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
