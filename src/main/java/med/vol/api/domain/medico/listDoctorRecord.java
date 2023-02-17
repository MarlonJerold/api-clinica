package med.vol.api.domain.medico;

public record listDoctorRecord(Long id, String nome, String email, String crm, Specialty especialidade) {

    public listDoctorRecord(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
