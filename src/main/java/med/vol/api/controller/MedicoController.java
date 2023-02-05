package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.endereco.EnderecoRepository;
import med.vol.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private EnderecoRepository repositoryAddress;

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoService service;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastradoMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        var endereco = new Endereco(dados.endereco());
        repositoryAddress.save(endereco);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDatalhamentoMedico(medico));
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
 //   @GetMapping("/medicos/{especialidade}")
 //   public ResponseEntity filterByEspecialidade(@PathVariable Especialidade especialidade){
//        var medico = repository.getReferenceByEspecialidade(especialidade);

 //       return ResponseEntity.ok(new DadosDatalhamentoMedico((Medico) medico));
  //  }
    @GetMapping("/medicos/{especialidade}")
    public List<Medico> getMedicoByEspecialidade(@RequestParam("especialidade") Especialidade especialidade){
        return service.getMedicoByEspecialidade(especialidade);
    }


}
