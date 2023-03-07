package br.com.chassiauth.auth.chassi.modules.teste;

import br.com.chassiauth.auth.chassi.modules.authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloWorldController {


    @Autowired
    private AuthService authService;

    @GetMapping
    public String hello() {
        var user = authService.getUserAuthenticated();
        return "HELLO " + user.getName();
    }
}
