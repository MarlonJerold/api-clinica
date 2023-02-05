package med.vol.api.domain.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Endereco")
@Table(name = "endereco")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
    private Boolean ativo;

    public Endereco(Endereco dados) {
        this.ativo = true;
        this.logradouro = dados.logradouro;
        this.bairro = dados.bairro;
        this.uf = dados.uf;
        this.cep = dados.cep;
        this.cidade = dados.cidade;
        this.complemento = dados.complemento;
        this.numero = dados.numero;

    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro() != null){
            this.logradouro = dados.logradouro();
        }if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }if(dados.cep() != null){
            this.cep = dados.cep();
        }if(dados.uf() != null){
            this.uf = dados.uf();
        }if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }if(dados.numero() != null){
            this.numero = dados.numero();
        }if(dados.complemento() != null){
            this.complemento = dados.complemento();
        }

    }
}
