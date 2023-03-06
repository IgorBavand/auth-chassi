package br.com.chassiauth.auth.chassi.modules.users.dto;

import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import lombok.Data;

@Data
public class UserRequest {
    private String name;
    private String username;
    private String password;
    private ESituation enabled;
}
