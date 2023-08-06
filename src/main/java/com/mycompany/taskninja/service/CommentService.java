package com.mycompany.taskninja.service;

import com.mycompany.taskninja.domain.Comment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment updateComment(Comment comment);
    void deleteComment(Long commentId);
    Comment getCommentById(Long commentId);
    List<Comment> getCommentsByTask(Task task);
    List<Comment> getCommentsByUser(User user);
}
