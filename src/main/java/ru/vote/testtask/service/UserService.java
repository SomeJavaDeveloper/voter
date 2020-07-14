package ru.vote.testtask.service;

import org.springframework.stereotype.Service;
import ru.vote.testtask.model.User;
import ru.vote.testtask.repository.jpa.JpaUserRepository;
import java.util.List;

@Service
public class UserService {

    private final JpaUserRepository repository;

    public UserService(JpaUserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll(){
        return repository.getAll();
    }

    public void delete(int userId){
        repository.delete(userId);
    }

    public User get(int userId){
        return repository.get(userId);
    }

    public User save(User user){
        return repository.save(user);
    }

    public User update(User user){
        return repository.save(user);
    }
}
