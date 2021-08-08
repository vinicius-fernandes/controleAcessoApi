package controleAcesso.controller;

import controleAcesso.model.NivelAcesso;
import controleAcesso.services.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {
    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.save(nivelAcesso);
    }

    @GetMapping("/list")
    public List<NivelAcesso> getNivelAcessoList(){
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{idNivelAcesso}")
    public NivelAcesso getNivelAcessoByID(@PathVariable("idNivelAcesso") Long idNivelAcesso) throws Exception {
        return nivelAcessoService.getById(idNivelAcesso).orElseThrow(()->new Exception("NivelAcesso não encontrada"));
    }

    @PutMapping
    public NivelAcesso updateJornada(@RequestBody NivelAcesso nivelAcesso){
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{idNivelAcesso}")
    public ResponseEntity<String> delete(@PathVariable("idNivelAcesso") Long idNivelAcesso){
        try {
            nivelAcessoService.delete(idNivelAcesso);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a NivelAcesso",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "NivelAcesso deletada",
                HttpStatus.OK);
    }

}
