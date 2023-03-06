package br.com.chassiauth.auth.chassi.modules.users.controller;

import br.com.chassiauth.auth.chassi.modules.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("{id}")
    public UserResponse findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
}
