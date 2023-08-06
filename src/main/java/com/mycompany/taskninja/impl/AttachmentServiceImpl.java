package com.mycompany.taskninja.impl;

import com.mycompany.taskninja.domain.Attachment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import com.mycompany.taskninja.repository.AttachmentRepository;
import com.mycompany.taskninja.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment createAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment updateAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public void deleteAttachment(Long attachmentId) {
        attachmentRepository.deleteById(attachmentId);
    }

    @Override
    public Attachment getAttachmentById(Long attachmentId) {
        return attachmentRepository.findById(attachmentId).orElse(null);
    }

    @Override
    public List<Attachment> getAttachmentsByTask(Task task) {
        return attachmentRepository.findByTask(task);
    }

    @Override
    public List<Attachment> getAttachmentsByUser(User user) {
        return attachmentRepository.findByUser(user);
    }
}

