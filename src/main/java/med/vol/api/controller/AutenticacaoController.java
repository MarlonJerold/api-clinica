package med.vol.api.controller;


import jakarta.validation.Valid;
import med.vol.api.domain.usuario.DadosAutenticacao;
import med.vol.api.domain.usuario.Usuario;
import med.vol.api.infra.security.DataTokenJWT;
import med.vol.api.infra.security.TokenServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired //Pede ao spring injetar o parametro
    private AuthenticationManager manager;

    @Autowired

    private TokenServie tokenServie;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var authenticationTokenoken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationTokenoken);

        var tokenJWT = tokenServie.generateToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
