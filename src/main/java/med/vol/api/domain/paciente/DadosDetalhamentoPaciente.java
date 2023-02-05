package med.vol.api.domain.paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String telefone, String email,String cpf) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf());
    }

}
