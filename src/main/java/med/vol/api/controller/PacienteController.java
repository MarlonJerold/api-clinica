package med.vol.api.controller;

import jakarta.transaction.Transactional;

import med.vol.api.paciente.Paciente;
import med.vol.api.paciente.PacienteRepository;

import jakarta.validation.Valid;
import med.vol.api.paciente.DadosCadastradoPaciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastradoPaciente dados){
        repository.save(new Paciente(dados));
    }
}
