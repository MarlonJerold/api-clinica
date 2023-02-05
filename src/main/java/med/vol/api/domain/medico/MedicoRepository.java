package med.vol.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Object> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    public List<Medico> getReferenceByEspecialidade(Especialidade especialidade);

}
