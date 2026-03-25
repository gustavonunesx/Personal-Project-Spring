package crud.project.service;

import crud.project.model.User;
import crud.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    //optional por ser OPCIONAL a busca por id (nao sendo obrigatorio colocar na url)
    public Optional<User> getById(Long id){
        return repository.findById(id);
    }





    
}
