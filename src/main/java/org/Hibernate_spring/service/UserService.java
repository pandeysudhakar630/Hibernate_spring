package org.Hibernate_spring.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.Hibernate_spring.repository.UserRepository;
import org.Hibernate_spring.entity.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void createUser(String name){
        repo.save(new User(name));
    }

    @Transactional(readOnly = true)
    public List<?> getUsers(){
        return repo.findAll();
    }

    @Transactional
    public void deleteUser(User user){
        repo.delete(user);
    }


}
