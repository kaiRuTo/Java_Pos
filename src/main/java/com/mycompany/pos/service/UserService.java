package com.mycompany.pos.service;

import com.mycompany.pos.entity.User;
import com.mycompany.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {return userRepository.findAll();}
    
    public void delete(User user) {userRepository.delete(user);}

    public void save(User user) {userRepository.save(user);}
}
