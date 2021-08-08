package controleAcesso.controller;

import controleAcesso.model.Calendario;
import controleAcesso.services.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    CalendarioService calendarioService;

    @PostMapping
    public Calendario create(@RequestBody Calendario calendario){
        return calendarioService.save(calendario);
    }

    @GetMapping("/list")
    public List<Calendario> getCalendarioList(){
        return calendarioService.findAll();
    }

    @GetMapping("/{idCalendario}")
    public Calendario getCalendarioByID(@PathVariable("idCalendario") Long idCalendario) throws Exception {
        return calendarioService.getById(idCalendario).orElseThrow(()->new Exception("Calendario não encontrada"));
    }

    @PutMapping
    public Calendario updateJornada(@RequestBody Calendario calendario){
        return calendarioService.update(calendario);
    }

    @DeleteMapping("/{idCalendario}")
    public ResponseEntity<String> delete(@PathVariable("idCalendario") Long idCalendario){
        try {
            calendarioService.delete(idCalendario);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a Calendario",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Calendario deletada",
                HttpStatus.OK);
    }

}
