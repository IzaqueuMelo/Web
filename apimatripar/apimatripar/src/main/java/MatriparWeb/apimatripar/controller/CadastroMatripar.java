package MatriparWeb.apimatripar.controller;

import MatriparWeb.apimatripar.matripar.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/cadastros")

public class CadastroMatripar {

    private final CadastroRepository repository;

    // Injeção de dependência via construtor
    @Autowired
    public CadastroMatripar(CadastroRepository repository) {
        this.repository = repository;
    }

    /**
     * Endpoint para cadastrar novos médicos.
     *
     * @param dados Dados do cadastro recebidos no corpo da requisição.
     */
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMatripar dados) {
        System.out.println("Dados recebidos no backend: " + dados);
        repository.save(new Cadastro(dados));
        //return ResponseEntity.ok("Cadastro realizado com sucesso!");
    }

    /**
     * Endpoint para listar médicos paginados.
     *
     * @return Página de médicos no formato de DadosListagemMedicos.
     */
    @GetMapping
    public List<DadosListagemMedicos> listar() {
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();

    }

    @CrossOrigin(origins = "http://localhost:63342") // Permitir acesso ao frontend

    //@RequestMapping("/cadastros")
    @PutMapping("/{id}")
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.AtualizarInformacoes(dados);
    }
    @RequestMapping("/cadastros")
    @DeleteMapping("/id")
    @Transactional
   public void excluir(@PathVariable long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
