package rest.api;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//Test Upload

@RestController
public class PersonController {

    PersonHandling personHandling = PersonHandling.getInstance();

    @RequestMapping("/")
    public String index(){
        return "Welcome to RestFull API";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/person")
    public List<Person> fetch(){
        return personHandling.fetchPerson();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/person/{id}")
    public List<Person> searchById(@PathVariable String id){
        return personHandling.getById(Integer.parseInt(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/person/search")
    public List<Person> searchByName(@RequestBody Map<String, String> body){
        return personHandling.getByName(body.get("searchParam"));
    }

    @PostMapping("/person")
    public Person create(@RequestBody Map<String,String> body){

        int id              = Integer.parseInt(body.get("id"));
        int idCard          = Integer.parseInt(body.get("idCard"));
        String fullName     = body.get("firstName")+" "+body.get("lastName");
        String birthDate    = body.get("birthDate");
        String email        = body.get("email");
        String address      = body.get("address");

        return personHandling.createPerson(id, idCard, fullName, birthDate, email, address);
    }

    @PutMapping("/person/{id}")
    public Person update(@PathVariable String id, @RequestBody Map<String, String> body){

        int sysId           = Integer.parseInt(id);
        int idCard          = Integer.parseInt(body.get("idCard"));
        String fullName     = body.get("firstName")+" "+body.get("lastName");
        String birthDate    = body.get("birthDate");
        String email        = body.get("email");
        String address      = body.get("address");

        return personHandling.updatePerson(sysId, idCard, fullName, birthDate, email, address);
    }

    @DeleteMapping("/person/{id}")
    public Boolean delete(@PathVariable String id){

        int sysId        = Integer.parseInt(id);

        return personHandling.deletePerson(sysId);
    }

    

}