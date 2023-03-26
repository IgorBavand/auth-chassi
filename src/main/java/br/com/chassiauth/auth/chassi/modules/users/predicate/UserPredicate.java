package br.com.chassiauth.auth.chassi.modules.users.predicate;

import br.com.chassiauth.auth.chassi.modules.users.model.QUser;
import com.querydsl.core.BooleanBuilder;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserPredicate {
    private final QUser user = QUser.user;

    private final BooleanBuilder builder;

    public UserPredicate() {
        this.builder = new BooleanBuilder();
    }

    public UserPredicate withName(String name) {
        if (!StringUtils.isEmpty(name)) {
            builder.and(user.name.likeIgnoreCase("%" + name + "%"));
        }
        return this;
    }

    public UserPredicate withEmail(String email) {
        if (!StringUtils.isEmpty(email)) {
            builder.and(user.email.eq(email));
        }
        return this;
    }

    public UserPredicate withDate(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null) {
            builder.and(user.createdAt.between(startDate.atStartOfDay(),
                    endDate.atTime(LocalTime.MAX)));
        }
        return this;
    }

    public BooleanBuilder build() {
        return this.builder;
    }

}
