package MatriparWeb.apimatripar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/pagina-principal")
    public String mostrarPagina() {
        return "PaginaPrincial"; // Nome do arquivo sem a extensão .html
    }
}
