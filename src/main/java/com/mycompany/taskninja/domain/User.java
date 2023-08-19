package com.mycompany.taskninja.domain;

import com.mycompany.taskninja.util.Util;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(int parseId, String name, String email, String password) {
    }

    public User() {

    }

    private User createUser(String id,String name, String email, String password) {
        User user = new User(Util.parseId(id),name,email,password);

        return user;
    }
}
