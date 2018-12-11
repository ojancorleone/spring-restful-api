package rest.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class BlogController {

    BlogMockData blogMockData = BlogMockData.getInstance();

    @RequestMapping("/")
    public String index(){
        return "Welcome to RestFull API";
    }

    @GetMapping("/blog")
    public List<Blog> fetchHandling(){
        return blogMockData.fetchBlog();
    }

    @GetMapping("/blog/{id}")
    public Blog searchByIdHandling(@PathVariable String id){
        return blogMockData.getById(Integer.parseInt(id));
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body){
        return blogMockData.searchByText(body.get("searchParam"));
    }

    @PostMapping("/blog")
    public Blog createHandling(@RequestBody Map<String,String> body){

        int id          = Integer.parseInt(body.get("id"));
        String title    = body.get("title");
        String content  = body.get("content");

        return blogMockData.createBlog(id, title, content);
    }

    @PutMapping("/blog/{id}")
    public Blog updateHandling(@PathVariable String id, @RequestBody Map<String, String> body){

        int blogId          = Integer.parseInt(id);
        String title        = body.get("title");
        String content      = body.get("content");

        return blogMockData.updateBlog(blogId, title, content);
    }

    

}