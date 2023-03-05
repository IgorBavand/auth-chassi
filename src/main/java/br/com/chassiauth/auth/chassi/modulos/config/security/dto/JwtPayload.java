package br.com.chassiauth.auth.chassi.modulos.config.security.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JwtPayload {

    private String user;
    private String token;
    private String authorities;
    private String expiration;


}
