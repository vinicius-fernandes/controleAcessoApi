package controleAcesso.controller;

import controleAcesso.model.JornadaTrabalho;
import controleAcesso.repository.JornadaRepository;
import controleAcesso.services.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;
    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);
    }
    @GetMapping("/list")
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(()-> new Exception("Jornada não encontrada")));
    }


    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity<String> deleteByJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        try {
            jornadaService.delete(idJornada);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a jornada",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Jornada deletada",
                HttpStatus.OK);
    }


}
