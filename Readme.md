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
