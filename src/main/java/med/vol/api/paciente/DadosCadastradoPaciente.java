package med.vol.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

import java.text.DateFormat;


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



