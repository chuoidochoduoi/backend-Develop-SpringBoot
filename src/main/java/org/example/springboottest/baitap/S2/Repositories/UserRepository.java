package org.example.springboottest.baitap.S2.Repositories;

import org.example.springboottest.baitap.S2.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> users = new ArrayList<>(List.of(
            new User(1, "cuong", "cuong@gmail.com", "admin"),
            new User(2, "an", "an@gmail.com", "user"),
            new User(3, "binh", "binh@gmail.com", "user")
    ));

    public User findById(int id) {

        return  users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }


}
