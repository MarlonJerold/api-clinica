package med.vol.api.domain.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Class que representa o serviço de autenticação
//Para isso precisaremos implementar a seguinte interface
//Spring já chama essa class para realizar o serviço de autenticação
@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired //Realiza a injeção de dependência
    private UsuarioRepository repository;

//Toda vez que fizer login, será chamado esse método, o spring chama a class anotada como @Service chamando entao o método loadUserByUsername passando o username.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}
