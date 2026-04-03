package org.example.springboottest.baitap.S2.servicce;

import org.example.springboottest.baitap.S2.Repositories.TaskRepository;
import org.example.springboottest.baitap.S2.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService  {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    public List<Task> findAllTasks(String titlle) {

        List<Task> search =taskRepository.tasks;
        List<Task> tasks = new ArrayList<>();

        for (Task t : search) {
            if (t.getTitle().contains(titlle)){
                tasks.add(t);
            }
        }

        return tasks;
    }

    public boolean saveTask(Task task) {

        if (userService.findUserByID(task.getUserId()) == null) {
            return false;
        }

        taskRepository.add(task);

        return true;

    }

}
