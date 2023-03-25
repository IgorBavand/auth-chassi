package br.com.chassiauth.auth.chassi.modules.users.dto.filter;

import br.com.chassiauth.auth.chassi.modules.users.predicate.UserPredicate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFilter {

    private String name;

    @JsonIgnore
    public BooleanBuilder toPredicate() {
        return new UserPredicate()
                .withName(this.name)
                .build();
    }


}
