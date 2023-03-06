package br.com.chassiauth.auth.chassi.modules.teste;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloWorldController {

    @GetMapping
    public String hello() {
        //TODO => IMPLEMENTS CLASS AUTHSERVICE
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return "HELLO " + username;
    }
}
