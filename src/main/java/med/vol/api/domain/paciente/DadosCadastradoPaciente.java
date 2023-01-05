package med.vol.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vol.api.domain.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;


public record DadosCadastradoPaciente(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @CPF
        String cpf,

        byte idade,

        String dataNascimento,


        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco

){
}



