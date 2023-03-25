package br.com.chassiauth.auth.chassi.modules.users.controller;

import br.com.chassiauth.auth.chassi.feign.PageRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.filter.UserFilter;
import br.com.chassiauth.auth.chassi.modules.users.dto.request.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.response.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Page<UserResponse> getAll(PageRequest pageRequest, UserFilter filter) {
        return userService.getAll(pageRequest, filter);
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
