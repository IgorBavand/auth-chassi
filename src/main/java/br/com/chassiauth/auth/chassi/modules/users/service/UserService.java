package br.com.chassiauth.auth.chassi.modules.users.service;

import br.com.chassiauth.auth.chassi.modules.common.exception.NotFoundException;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modules.users.model.Role;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import br.com.chassiauth.auth.chassi.modules.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        var user =userRepository.save(User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .enabled(ESituation.ACTIVE)
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(new Role(1), new Role(2)))
                .build());

        return UserResponse.of(user);
    }

    public UserResponse findById(Integer id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));
        return UserResponse.of(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }

}
