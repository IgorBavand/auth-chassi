package br.com.chassiauth.auth.chassi.modules.users.dto.filter;

import br.com.chassiauth.auth.chassi.modules.users.predicate.UserPredicate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.BooleanBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFilter {

    private String name;
    private String email;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @JsonIgnore
    public BooleanBuilder toPredicate() {
        return new UserPredicate()
                .withName(this.name)
                .withEmail(this.email)
                .withDate(startDate, endDate)
                .build();
    }


}
