package br.com.chassiauth.auth.chassi.modules.users.dto;

import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import br.com.chassiauth.auth.chassi.modules.users.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private ESituation enabled;
    private List<String> roles;

    public static UserResponse of(User user) {
        List<String> roles = new ArrayList<String>();
        user.getRoles().forEach(role -> roles.add(role.getName()));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .enabled(user.getEnabled())
                .roles(roles)
                .build();
    }

    public static List<UserResponse> of(List<User> users) {
        if ( users == null ) {
            return null;
        }
        List<UserResponse> list = new ArrayList<UserResponse>( users.size() );
        users.forEach(user -> list.add(of(user)));

        return list;
    }
}
