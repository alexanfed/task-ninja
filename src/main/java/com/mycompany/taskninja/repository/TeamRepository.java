package com.mycompany.taskninja.repository;

import com.mycompany.taskninja.domain.Team;
import com.mycompany.taskninja.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByMembers(User member);
    // You can define custom query methods here if needed
}

