package org.example.springboottest.baitap.S2.servicce;

import org.example.springboottest.baitap.S2.Repositories.UserRepository;
import org.example.springboottest.baitap.S2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {

    @Autowired
 UserRepository userRepository;

    public List<User> findAllUsers(String username) {
        List<User> search =userRepository.users;
        List<User> users = new ArrayList<>();

        for (User t : search) {
            if (t.getUsername().contains(username)){
                users.add(t);
            }
        }

        return users;
    }


    public User findUserByID(int id) {

        return userRepository.findById(id);
    }

}
