package com.user.user.services;

import com.user.user.User;
import com.user.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
//    reference to the user repo
@Autowired private UserRepository repo;

    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        } else{
            throw new UserNotFoundException("No user with id" + id);
        }
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("No user with id" + id);
        }
        repo.deleteById(id);
    }

}
