package med.vol.api.domain.medico;

import med.vol.api.domain.endereco.Endereco;

public record DadosDatalhamentoMedico(Long id, String nome, String email, String crm,String telefone, Especialidade especialidade) {

    public DadosDatalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(),  medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade());
    }
}
