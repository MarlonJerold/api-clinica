package med.vol.api.service;

import jakarta.validation.Valid;
import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.endereco.EnderecoRepository;
import med.vol.api.domain.medico.DoctorRegisterRecord;
import med.vol.api.domain.medico.Medico;
import med.vol.api.domain.medico.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public class RegisterDoctor {

    @Autowired
    private DoctorRepository repository;
    @Autowired
    private EnderecoRepository repositoryAddress;
    public void registerDoctor(@RequestBody @Valid DoctorRegisterRecord dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        var endereco = new Endereco(dados.endereco());
        repositoryAddress.save(endereco);
        repository.save(medico);

    }

}
