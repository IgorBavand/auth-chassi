package br.com.chassiauth.auth.chassi.modulos.users.controller;

import br.com.chassiauth.auth.chassi.modulos.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modulos.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modulos.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modulos.users.model.Role;
import br.com.chassiauth.auth.chassi.modulos.users.model.User;
import br.com.chassiauth.auth.chassi.modulos.users.repository.UserRepository;
import br.com.chassiauth.auth.chassi.modulos.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public UserResponse findById(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return userService.findById(id);
    }
}
