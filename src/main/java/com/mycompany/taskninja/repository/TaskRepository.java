package com.mycompany.taskninja.repository;

import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignee(User assignee);
    // You can define custom query methods here if needed
}