package br.com.chassiauth.auth.chassi.modulos.teste;

import br.com.chassiauth.auth.chassi.modulos.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloWorlController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String hello() {
        return userRepository.findAll().toString();
    }

}
