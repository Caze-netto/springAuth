package spring.security.auth.spring.Auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.auth.spring.Auth.model.Role;
import spring.security.auth.spring.Auth.model.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    List<Usuario> findByRole(Role role);
}
