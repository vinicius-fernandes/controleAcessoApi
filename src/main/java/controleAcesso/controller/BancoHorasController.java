package controleAcesso.controller;

import controleAcesso.model.BancoHoras;
import controleAcesso.services.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras create(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.save(bancoHoras);
    }

    @GetMapping("/list")
    public List<BancoHoras> getBancoHorasList(){
        return bancoHorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}")
    public BancoHoras getBancoHorasByID(@PathVariable("idBancoHoras") Long idBancoHoras) throws Exception {
        return bancoHorasService.getById(idBancoHoras).orElseThrow(()->new Exception("BancoHoras não encontrada"));
    }

    @PutMapping
    public BancoHoras updateJornada(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.update(bancoHoras);
    }

    @DeleteMapping("/{idBancoHoras}")
    public ResponseEntity<String> delete(@PathVariable("idBancoHoras") Long idBancoHoras){
        try {
            bancoHorasService.delete(idBancoHoras);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a BancoHoras",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "BancoHoras deletada",
                HttpStatus.OK);
    }

}
