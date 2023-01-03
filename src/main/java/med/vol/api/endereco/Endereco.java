package med.vol.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.lograudouro();
        this.bairro = dados.bairro();
        this.uf = dados.uf();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.lograudouro() != null){
            this.logradouro = dados.lograudouro();
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
