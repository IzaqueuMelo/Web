package MatriparWeb.apimatripar.matripar;

import MatriparWeb.apimatripar.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Table(name = "medicos")
@Entity
@Getter
@AllArgsConstructor

@EqualsAndHashCode(of = "id")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicos_seq")
    @SequenceGenerator(name = "medicos_seq", sequenceName = "medicos_sequence", allocationSize = 1)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;
    @JsonProperty("email")
    private String email;
    @JsonProperty("crm")
    private String crm;
    @JsonProperty("telefone")
    private String telefone;

    @Enumerated(EnumType.STRING)
    @JsonProperty("especialidade")
    private Especialidade especialidade;
    private Boolean ativo;
    @Embedded
    @JsonProperty("endereco")
    private Endereco endereco;

    // Construtor padrão
    public Cadastro() {

    }

    public Boolean getAtivo() {return ativo;}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCrm() {
        return crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;

    }

    public Cadastro(DadosCadastroMatripar dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void AtualizarInformacoes(@Valid DadosAtualizacaoMedicos dados) {



        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());

        }
    }

    public void excluir() {
        this.ativo = false;
      }
}
