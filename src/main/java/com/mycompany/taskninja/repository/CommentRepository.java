package com.mycompany.taskninja.repository;

import com.mycompany.taskninja.domain.Comment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);

    List<Comment> findByUser(User user);
    // You can define custom query methods here if needed
}
