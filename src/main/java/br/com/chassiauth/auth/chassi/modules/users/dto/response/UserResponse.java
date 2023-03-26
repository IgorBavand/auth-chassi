package br.com.chassiauth.auth.chassi.modules.users.dto.response;

import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private ESituation enabled;
    private List<String> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserResponse of(User user) {
        List<String> roles = new ArrayList<String>();
        user.getRoles().forEach(role -> roles.add(role.getName()));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .enabled(user.getEnabled())
                .roles(roles)
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
