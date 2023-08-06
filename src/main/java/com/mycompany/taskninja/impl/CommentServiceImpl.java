package com.mycompany.taskninja.impl;

import com.mycompany.taskninja.domain.Comment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import com.mycompany.taskninja.repository.CommentRepository;
import com.mycompany.taskninja.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public List<Comment> getCommentsByTask(Task task) {
        return commentRepository.findByTask(task);
    }

    @Override
    public List<Comment> getCommentsByUser(User user) {
        return commentRepository.findByUser(user);
    }
}

