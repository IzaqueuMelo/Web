package MatriparWeb.apimatripar.matripar;


import MatriparWeb.apimatripar.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.CrossOrigin;



public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}