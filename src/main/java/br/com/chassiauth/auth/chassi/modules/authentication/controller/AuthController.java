package br.com.chassiauth.auth.chassi.modules.authentication.controller;

import br.com.chassiauth.auth.chassi.config.security.dto.JwtPayload;
import br.com.chassiauth.auth.chassi.config.security.model.LoginRequest;
import br.com.chassiauth.auth.chassi.config.security.service.CustomAuthenticationProvider;
import br.com.chassiauth.auth.chassi.config.security.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @PostMapping("auth/token")
    public JwtPayload token(@RequestBody LoginRequest userLogin) throws AuthenticationException {

        //TODO -> IN MEMORY
       //Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));

        Authentication authentication = customAuthenticationProvider
                .authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));

        return tokenService.generateToken(authentication);
    }

}
