package controleAcesso.controller;

import controleAcesso.model.TipoData;
import controleAcesso.services.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {
    @Autowired
    TipoDataService tipoDataService;

    @PostMapping
    public TipoData create(@RequestBody TipoData tipoData){
        return tipoDataService.save(tipoData);
    }

    @GetMapping("/list")
    public List<TipoData> getTipoDataList(){
        return tipoDataService.findAll();
    }

    @GetMapping("/{idTipoData}")
    public TipoData getTipoDataByID(@PathVariable("idTipoData") Long idTipoData) throws Exception {
        return tipoDataService.getById(idTipoData).orElseThrow(()->new Exception("TipoData não encontrada"));
    }

    @PutMapping
    public TipoData updateJornada(@RequestBody TipoData tipoData){
        return tipoDataService.update(tipoData);
    }

    @DeleteMapping("/{idTipoData}")
    public ResponseEntity<String> delete(@PathVariable("idTipoData") Long idTipoData){
        try {
            tipoDataService.delete(idTipoData);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a TipoData",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "TipoData deletada",
                HttpStatus.OK);
    }

}
