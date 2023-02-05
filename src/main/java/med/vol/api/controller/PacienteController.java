package med.vol.api.controller;

import jakarta.transaction.Transactional;

import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.endereco.EnderecoRepository;
import med.vol.api.domain.medico.DadosDatalhamentoMedico;
import med.vol.api.domain.paciente.DadosDetalhamentoPaciente;
import med.vol.api.domain.paciente.Paciente;
import med.vol.api.domain.paciente.PacienteRepository;

import jakarta.validation.Valid;
import med.vol.api.domain.paciente.DadosCadastradoPaciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private EnderecoRepository repositoryAddress;
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosCadastradoPaciente dados, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dados);
        var endereco = new Endereco(dados.endereco());
        repositoryAddress.save(endereco);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }
}
