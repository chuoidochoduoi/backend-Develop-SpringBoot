package org.example.springboottest.baitap.S2.Repositories;

import org.example.springboottest.baitap.S2.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class TaskRepository {
   public List<Task> tasks = new ArrayList<>(List.of(
            new Task(1, "Learn Java", "Study basic Java", "High", 1),
            new Task(2, "Learn Spring Boot", "Build REST API", "High", 1),
            new Task(3, "Fix bug login", "Debug authentication issue", "Medium", 2),
            new Task(4, "Design database", "Create ERD diagram", "High", 2),
            new Task(5, "Write documentation", "API docs", "Low", 3),
            new Task(6, "Test API", "Use Postman", "Medium", 1),
            new Task(7, "Deploy project", "Deploy to server", "High", 3),
            new Task(8, "Optimize query", "Improve SQL performance", "Medium", 2),
            new Task(9, "UI update", "Improve layout", "Low", 3),
            new Task(10, "Refactor code", "Clean code structure", "Medium", 1)
    ));


   public void add(Task task) {
       tasks.add(task);

   }


}
