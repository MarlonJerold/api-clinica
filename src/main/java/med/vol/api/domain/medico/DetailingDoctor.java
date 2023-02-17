package med.vol.api.domain.medico;

public record DetailingDoctor(Long id, String nome, String email, String crm, String telefone, Specialty especialidade) {

    public DetailingDoctor(Medico medico){
        this(medico.getId(), medico.getNome(),  medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade());
    }
}
