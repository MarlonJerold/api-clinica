package med.vol.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //método que irá fazer a consulta no banco de dados na tabela de usuarios
    UserDetails findByLogin(String login);
}
