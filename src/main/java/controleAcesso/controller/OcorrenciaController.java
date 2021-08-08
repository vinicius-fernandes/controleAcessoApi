package controleAcesso.controller;

import controleAcesso.model.Ocorrencia;
import controleAcesso.services.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {
    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping("/list")
    public List<Ocorrencia> getOcorrenciaList(){
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{idOcorrencia}")
    public Ocorrencia getOcorrenciaByID(@PathVariable("idOcorrencia") Long idOcorrencia) throws Exception {
        return ocorrenciaService.getById(idOcorrencia).orElseThrow(()->new Exception("Ocorrencia não encontrada"));
    }

    @PutMapping
    public Ocorrencia updateJornada(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{idOcorrencia}")
    public ResponseEntity<String> delete(@PathVariable("idOcorrencia") Long idOcorrencia){
        try {
            ocorrenciaService.delete(idOcorrencia);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a Ocorrencia",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Ocorrencia deletada",
                HttpStatus.OK);
    }

}
