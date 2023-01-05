package med.vol.api.domain.endereco;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String lograudouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        String numero) {

}
