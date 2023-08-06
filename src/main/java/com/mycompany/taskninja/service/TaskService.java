package com.mycompany.taskninja.service;

import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
    Task getTaskById(Long taskId);
    List<Task> getAllTasks();
    List<Task> getTasksByAssignee(User assignee);
}
