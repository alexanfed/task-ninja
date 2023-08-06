package com.mycompany.taskninja.repository;

import com.mycompany.taskninja.domain.Attachment;
import com.mycompany.taskninja.domain.Task;
import com.mycompany.taskninja.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findByTask(Task task);

    List<Attachment> findByUser(User user);
    // You can define custom query methods here if needed
}

