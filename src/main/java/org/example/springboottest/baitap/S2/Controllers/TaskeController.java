package org.example.springboottest.baitap.S2.Controllers;

import org.example.springboottest.baitap.S2.models.Task;
import org.example.springboottest.baitap.S2.servicce.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TaskeController {

    @Autowired
    TaskService TaskService;


    @GetMapping("/task")
    public ResponseEntity<List<Task>> getUserTasks(@RequestParam String tittle) {


        return ResponseEntity.ok(TaskService.findAllTasks(tittle));
    };


    @PostMapping("/task")
    public ResponseEntity<List<Task>> assignedTo(@RequestBody Task newTask ) {

if (TaskService.saveTask(newTask)) {

    return ResponseEntity.ok(TaskService.findAllTasks(newTask.getTitle()));
}


return ResponseEntity.notFound().build();
    };

}
