package br.com.chassiauth.auth.chassi.modules.users.service;

import br.com.chassiauth.auth.chassi.feign.PageRequest;
import br.com.chassiauth.auth.chassi.modules.common.exception.NotFoundException;
import br.com.chassiauth.auth.chassi.modules.users.dto.filter.UserFilter;
import br.com.chassiauth.auth.chassi.modules.users.dto.request.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.dto.response.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.model.Role;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import br.com.chassiauth.auth.chassi.modules.users.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    public Page<UserResponse> getAll(PageRequest pageRequest, UserFilter filter) {
        return userRepository.findAll(filter.toPredicate(), pageRequest).map(UserResponse::of);
    }

    public UserResponse getById(Integer id) {
        return UserResponse.of(findById(id));
    }

    public UserResponse deleteUser(Integer id) {
        var user = findById(id);

        userRepository.delete(user);
        return UserResponse.of(user);
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
