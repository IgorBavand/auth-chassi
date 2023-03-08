package br.com.chassiauth.auth.chassi.modules.users.service;

import br.com.chassiauth.auth.chassi.modules.common.exception.NotFoundException;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modules.users.model.Role;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import br.com.chassiauth.auth.chassi.modules.users.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        var user = User.of(request);

        Set<Role> roles = new HashSet<>();

        request.getRoles()
                .forEach(role -> roles.add(new Role(role)));

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);

        return UserResponse.of(userRepository.save(user));
    }

    @Transactional
    public UserResponse updateUser(Integer id, UserRequest request) {
        var user = findById(id);
        BeanUtils.copyProperties(user, request, "id");

        Set<Role> roles = new HashSet<>();
        request.getRoles()
                .forEach(role -> roles.add(new Role(role)));

        user.setRoles(roles);
        return UserResponse.of(user);
    }

    public List<UserResponse> getListAll() {
        return UserResponse.of(userRepository.findAll());
    }

    public UserResponse getById(Integer id) {
        return UserResponse.of(findById(id));
    }

    private User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found."));
    }

}
