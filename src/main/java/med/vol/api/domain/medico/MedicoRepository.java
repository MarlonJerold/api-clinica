package med.vol.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.util.Assert;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Object> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Procedure("GetMedicoByEspecialidade")
    List<Medico> GetMedicoByEspecialidade(Especialidade especialidade);
}
