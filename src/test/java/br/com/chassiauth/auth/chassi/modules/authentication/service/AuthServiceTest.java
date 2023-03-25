package br.com.chassiauth.auth.chassi.modules.authentication.service;

import br.com.chassiauth.auth.chassi.modules.users.model.User;
import br.com.chassiauth.auth.chassi.modules.users.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserService userService;

    @Mock
    private SecurityContext securityContext;


    @Test
    public void getUserAuthenticated_returnUserAuthenticated_whenExistsAuthentication() {

        var username = "bavand";
        var auth = SecurityContextHolder.getContext().getAuthentication();


        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(auth.getName()).thenReturn(username);

        when(userService.findByUsername(username))
                .thenReturn(mockUser());

        assertThat(authService.getUserAuthenticated())
                .extracting("id", "name", "username")
                .containsExactly(1, "igor bavand", "bavand");

    }

    @Mock
    private Authentication authentication;

    @Before
    @Ignore
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        SecurityContextHolder.setContext(securityContext);
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
