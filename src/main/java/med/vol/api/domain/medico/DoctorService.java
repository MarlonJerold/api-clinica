package med.vol.api.domain.medico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import med.vol.api.domain.endereco.Endereco;
import med.vol.api.domain.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repository;

    private EnderecoRepository addressService;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<Medico> getMedicoByEspecialidade(Specialty especialidade){
        return em.createNamedStoredProcedureQuery("getMedicoByEspecialidade").setParameter("tEspecialidade",especialidade).getResultList();
    }

    public Medico registerDoctor(@RequestBody @Valid DoctorRegisterRecord dados) {
        var medico = new Medico(dados);
        var endereco = new Endereco(dados.endereco());
       // repositoryAddress.save(endereco);
        repository.save(medico);
        return medico;
    }







}
