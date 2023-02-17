package med.vol.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(
        name = "GetMedicoByEspecialidade",
        procedureName = "GetMedicoByEspecialidade",
        resultClasses = Medico.class)
})
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty especialidade;

    private Boolean ativo;

    public Medico(DoctorRegisterRecord dados) {
        this.ativo = true;
        this.nome = dados.nome();
        //this.endereco = new Endereco(dados.endereco());
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
    }

    //public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
//            this.nome = dados.nome();
  //      }if (dados.endereco() != null){
 //           this.telefone = dados.telefone();
  //      }if (dados.endereco() != null){
//        }

 //   }

    public void excluir() {
        this.ativo = false;
    }
}
