package com.mycompany.taskninja.service;

import com.mycompany.taskninja.domain.Attachment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;

import java.util.List;

public interface AttachmentService {
    Attachment createAttachment(Attachment attachment);
    Attachment updateAttachment(Attachment attachment);
    void deleteAttachment(Long attachmentId);
    Attachment getAttachmentById(Long attachmentId);
    List<Attachment> getAttachmentsByTask(Task task);
    List<Attachment> getAttachmentsByUser(User user);
}