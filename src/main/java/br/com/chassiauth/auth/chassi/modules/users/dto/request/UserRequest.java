package br.com.chassiauth.auth.chassi.modules.users.dto.request;

import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String name;
    private String username;
    private String password;
    private ESituation enabled;
    private List<Integer> roles;
}
