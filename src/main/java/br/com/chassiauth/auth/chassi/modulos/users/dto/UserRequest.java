package br.com.chassiauth.auth.chassi.modulos.users.dto;

import br.com.chassiauth.auth.chassi.modulos.users.enums.ESituation;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String username;
    private String password;
    private ESituation enabled;
}
