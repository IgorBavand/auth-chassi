package br.com.chassiauth.auth.chassi.modules.users.repository;

import br.com.chassiauth.auth.chassi.modules.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
