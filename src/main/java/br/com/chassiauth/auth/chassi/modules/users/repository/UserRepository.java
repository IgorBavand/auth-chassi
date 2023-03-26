package br.com.chassiauth.auth.chassi.modules.users.repository;

import br.com.chassiauth.auth.chassi.modules.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>,
        QuerydslPredicateExecutor<User> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsernameIgnoreCase(String username);
    boolean existsByEmailIgnoreCase(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);

}
