package com.techsharezone.bootifycrudm.controller;

/*
 * @created 12/11/2020 -13:44
 * @project bootify-crud-mongodb
 * @author  saurabhshcs
 */

import com.techsharezone.bootifycrudm.exception.UserException;
import com.techsharezone.bootifycrudm.model.User;
import com.techsharezone.bootifycrudm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userApi")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        LOG.info("Fetch all users..");
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        LOG.info("Getting user with ID: {}.", userId);

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }

        return user.orElseThrow(() -> new UserException("No user found for this " + userId));
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        LOG.info("Create User");
        userRepository.save(user);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

}
