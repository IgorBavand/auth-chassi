package br.com.chassiauth.auth.chassi.modulos.users.service;

import br.com.chassiauth.auth.chassi.modulos.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modulos.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modulos.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modulos.users.model.Role;
import br.com.chassiauth.auth.chassi.modulos.users.model.User;
import br.com.chassiauth.auth.chassi.modulos.users.repository.UserRepository;
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

    public UserResponse findById(Integer id) throws ChangeSetPersister.NotFoundException {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return UserResponse.of(user);
    }

    public User findByUsername(String username) throws ChangeSetPersister.NotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

}
