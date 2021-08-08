package controleAcesso.controller;

import controleAcesso.model.Localidade;
import controleAcesso.services.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade){
        return localidadeService.save(localidade);
    }

    @GetMapping("/list")
    public List<Localidade> getLocalidadeList(){
        return localidadeService.findAll();
    }

    @GetMapping("/{idLocalidade}")
    public Localidade getLocalidadeByID(@PathVariable("idLocalidade") Long idLocalidade) throws Exception {
        return localidadeService.getById(idLocalidade).orElseThrow(()->new Exception("Localidade não encontrada"));
    }

    @PutMapping
    public Localidade updateJornada(@RequestBody Localidade localidade){
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{idLocalidade}")
    public ResponseEntity<String> delete(@PathVariable("idLocalidade") Long idLocalidade){
        try {
            localidadeService.delete(idLocalidade);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a Localidade",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Localidade deletada",
                HttpStatus.OK);
    }

}
