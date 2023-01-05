package med.vol.api.medico;

import med.vol.api.endereco.Endereco;

public record DadosDatalhamentoMedico(Long id, String nome, String email, String crm,String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDatalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(),  medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
