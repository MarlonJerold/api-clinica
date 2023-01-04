package med.vol.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.endereco.Endereco;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.text.DateFormat;


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
    private Endereco endereco;
    private String cpf;
    private String nome;
    private byte idade;

    public Paciente(DadosCadastradoPaciente dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.idade = dados.idade();
        this.dataNascimento = dados.dataNascimento();
    }

}
