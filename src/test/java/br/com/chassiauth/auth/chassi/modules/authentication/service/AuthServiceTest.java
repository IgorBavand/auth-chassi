package br.com.chassiauth.auth.chassi.modules.authentication.service;

import br.com.chassiauth.auth.chassi.modules.users.dto.UserResponse;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @MockBean
    private UserService userService;

    //TODO - ERROR
    @Test
    public void getUserAuthenticated_returnUserAuthenticated_whenExistsAuthentication() {

        var username = "bavand";

        when(SecurityContextHolder.getContext().getAuthentication().getName())
                .thenReturn(username);

        when(userService.findByUsername(username))
                .thenReturn(mockUser());

        assertThat(authService.getUserAuthenticated())
                .extracting("id", "name", "username")
                .containsExactly(1, "igor bavand", "bavand");

    }

    private static User mockUser() {
        return User.builder()
                .id(1)
                .name("igor bavand")
                .username("bavand")
                .password("12345")
                .build();
    }

}
