package crud.project.controller;

import crud.project.model.User;
import crud.project.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;



    //@requestbody é necessario para o spring "achar" Spring não mapeava JSON do corpo da requisição
    @PostMapping
    public User createUser(@RequestBody User user){
        return service.saveUser(user);
    }
    
    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.getById(id).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario nao encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
