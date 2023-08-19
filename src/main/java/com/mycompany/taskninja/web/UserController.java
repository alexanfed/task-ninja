package com.mycompany.taskninja.web;

import com.mycompany.taskninja.domain.User;
import com.mycompany.taskninja.service.UserService;
import com.mycompany.taskninja.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /*
    @GetMapping("/getAllUsers")

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
     */

    @GetMapping("/list")
    public ModelAndView getAllUsers() {

        //logger.debug("Listing Users");

        List<User> users = this.userService.getAllUsers();

        return new ModelAndView("list","users",users);
    }

    @GetMapping("/create")
    public String showCreate() {

        //logger.debug("Show Create");

        return "create";
    }

    @PostMapping("/create")
    public String createUser(HttpServletRequest req) {

        //logger.debug("Create User");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = this.createUser(null, name, email, password);

        this.userService.createUser(user);

        return "redirect:/list";
    }

    private User createUser(String id,String name, String email, String password) {
        User user = new User(Util.parseId(id),name,email,password);

        return user;
    }
}

