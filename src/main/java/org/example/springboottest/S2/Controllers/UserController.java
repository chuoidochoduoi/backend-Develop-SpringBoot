package org.example.springboottest.S2.Controllers;

import org.example.springboottest.S2.models.Task;
import org.example.springboottest.S2.models.User;
import org.example.springboottest.S2.servicce.TaskService;
import org.example.springboottest.S2.servicce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test2")
public class UserController {



    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUser(String username) {


        return ResponseEntity.ok(userService.findAllUsers(username));
    };
}
