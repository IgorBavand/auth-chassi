package br.com.chassiauth.auth.chassi.modules.users.controller;

import br.com.chassiauth.auth.chassi.modules.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserResponse> getListAll() {
        return userService.getListAll();
    }

    @GetMapping("{id}")
    public UserResponse findById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping
    public UserResponse updateUser(Integer id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("{id}")
    public UserResponse deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
