package br.com.chassiauth.auth.chassi.modules.users.predicate;

import br.com.chassiauth.auth.chassi.modules.users.model.QUser;
import com.querydsl.core.BooleanBuilder;
import org.springframework.util.StringUtils;

public class UserPredicate {
    private final QUser user = QUser.user;

    private final BooleanBuilder builder;

    public UserPredicate() {
        this.builder = new BooleanBuilder();
    }

    public UserPredicate withName(String name) {
        if(!StringUtils.isEmpty(name)) {
            builder.and(user.name.likeIgnoreCase("%" + name + "%"));
        }
        return this;
    }

    public BooleanBuilder build() {
        return this.builder;
    }

}
