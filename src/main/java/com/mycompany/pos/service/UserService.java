package com.mycompany.pos.service;

import com.mycompany.pos.entity.User;
import com.mycompany.pos.exception.UserNotFoundException;
import com.mycompany.pos.repository.UserRepository;
import com.mycompany.pos.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {return userRepository.findAll();}
    
    public void delete(User user) {userRepository.delete(user);}

    public void save(User user) {
        Optional<String> password = Optional.ofNullable(user.getPassword());
        if(password.isPresent()) {
            String hashed = HashUtil.hash(password.get());
            user.setPassword(hashed);
        }
        userRepository.save(user);
    }

    public Boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        return HashUtil.checkIfPasswordMatched(password, user.get().getPassword());
    }
}
