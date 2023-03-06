package br.com.chassiauth.auth.chassi.modulos.users.repository;

import br.com.chassiauth.auth.chassi.modulos.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
