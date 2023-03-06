package br.com.chassiauth.auth.chassi.config.security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JwtPayload {

    private String user;
    private String token;
    private String authorities;
    private String expiration;


}
