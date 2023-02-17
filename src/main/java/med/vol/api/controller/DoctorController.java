package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class DoctorController {

    @Autowired
    private DoctorService service;

    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailingDoctor> registerDoctor(
            @RequestBody @Valid DoctorRegisterRecord dados,
            UriComponentsBuilder uriBuilder)
    {
        var doctor = service.registerDoctor(dados);
        var doctorInformation = uriBuilder.path("/medicos/{id}").buildAndExpand(doctor.getId()).toUri();

        DetailingDoctor doctorDetails = new DetailingDoctor(doctor);

        return ResponseEntity.created(doctorInformation).body(doctorDetails);
    }


    @GetMapping
    public ResponseEntity<Page<listDoctorRecord>> listDoctor(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(listDoctorRecord::new);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional
    public ResponseEntity Update(@RequestBody @Valid UpdateDoctorRecord data){
        var doctor = repository.getReferenceById(data.id());
      //  medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetailingDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.excluir();

        return ResponseEntity.ok(new DetailingDoctor(doctor));
    }
    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetailingDoctor(doctor));
    }


/*
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
*/
}



















