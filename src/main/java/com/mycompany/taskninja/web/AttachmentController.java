package com.mycompany.taskninja.web;

import com.mycompany.taskninja.domain.Attachment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import com.mycompany.taskninja.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {
    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @PostMapping
    public ResponseEntity<Attachment> createAttachment(@RequestBody Attachment attachment) {
        Attachment createdAttachment = attachmentService.createAttachment(attachment);
        return ResponseEntity.ok(createdAttachment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attachment> updateAttachment(@PathVariable Long id, @RequestBody Attachment attachment) {
        attachment.setId(id);
        Attachment updatedAttachment = attachmentService.updateAttachment(attachment);
        return ResponseEntity.ok(updatedAttachment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachmentById(@PathVariable Long id) {
        Attachment attachment = attachmentService.getAttachmentById(id);
        return ResponseEntity.ok(attachment);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByTask(@PathVariable Long taskId) {
        Task task = new Task();
        task.setId(taskId);
        List<Attachment> attachments = attachmentService.getAttachmentsByTask(task);
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<Attachment> attachments = attachmentService.getAttachmentsByUser(user);
        return ResponseEntity.ok(attachments);
    }
}

