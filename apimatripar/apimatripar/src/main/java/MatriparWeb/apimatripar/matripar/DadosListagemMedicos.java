package MatriparWeb.apimatripar.matripar;


import org.springframework.web.bind.annotation.CrossOrigin;


public record DadosListagemMedicos(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicos(Cadastro medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}