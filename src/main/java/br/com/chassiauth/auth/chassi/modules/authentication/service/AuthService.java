package br.com.chassiauth.auth.chassi.modules.authentication.service;

import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public UserResponse getUserAuthenticated() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUsername(username);

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }

}
