package med.vol.api.domain.medico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public List<Medico> getMedicoByEspecialidade(Especialidade especialidade){
        return em.createNamedStoredProcedureQuery("getMedicoByEspecialidade").setParameter("tEspecialidade",especialidade).getResultList();
    }
}
