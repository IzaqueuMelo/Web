package MatriparWeb.apimatripar.matripar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface CadastroRepository extends JpaRepository <Cadastro, Long > {


}
