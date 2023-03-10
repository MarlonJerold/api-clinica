package med.vol.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.domain.endereco.Endereco;
import org.hibernate.validator.constraints.NotBlank;

public record DoctorRegisterRecord(

        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Specialty especialidade,
        @NotNull
        @Valid
        Endereco endereco) {
}
