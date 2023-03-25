package br.com.chassiauth.auth.chassi.modules.users.model;

import br.com.chassiauth.auth.chassi.modules.users.dto.UserRequest;
import br.com.chassiauth.auth.chassi.modules.users.enums.ESituation;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    @Enumerated(EnumType.STRING)
    private ESituation enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public static User of(UserRequest request) {
        return User.builder()
                .name(request.getName())
                .username(request.getUsername())
                .enabled(ESituation.ACTIVE)
                .build();
    }
}
