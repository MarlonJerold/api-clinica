package med.vol.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.domain.endereco.Endereco;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String dataNascimento;
    private String telefone;
    private String email;
    private String cpf;
    private String nome;
    private byte idade;

public Paciente(DadosCadastradoPaciente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.idade = dados.idade();
        this.dataNascimento = dados.dataNascimento();
    }

}
