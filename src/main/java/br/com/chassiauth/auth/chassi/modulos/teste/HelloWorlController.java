package br.com.chassiauth.auth.chassi.modulos.teste;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloWorlController {

    @GetMapping
    public String hello() {
        return "hello world!";
    }

}
