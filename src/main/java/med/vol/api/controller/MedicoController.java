package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.endereco.EnderecoRepository;
import med.vol.api.domain.medico.*;
import med.vol.api.service.RegisterDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;
    @PostMapping
    @Transactional
    public ResponseEntity registerDoctor(@RequestBody @Valid DadosCadastradoMedico dados, UriComponentsBuilder uriBuilder){
        RegisterDoctor registerDoctor = new RegisterDoctor();
        registerDoctor.registerDoctor(dados, uriBuilder);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(new Medico(dados).getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDatalhamentoMedico(new Medico(dados)));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);


        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
      //  medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDatalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.ok(new DadosDatalhamentoMedico(medico));
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDatalhamentoMedico(medico));
    }



    @GetMapping("/{especialidade}")
    public ResponseEntity filterByEspecialidade(@PathVariable Especialidade especialidade){
        try {
            Especialidade filterEspec = GetMedicoByEspecialidade(especialidade);

            if (filterEspec != null) {
                return new ResponseEntity(filterEspec, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception ex) {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}



















