package controleAcesso.controller;


import controleAcesso.model.Empresa;
import controleAcesso.model.JornadaTrabalho;
import controleAcesso.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.save(empresa);
    }

    @GetMapping("/list")
    public List<Empresa> getEmpresaList(){
        return empresaService.findAll();
    }

    @GetMapping("/{idEmpresa}")
    public Empresa getEmpresaByID(@PathVariable("idEmpresa") Long idEmpresa) throws Exception {
        return empresaService.getById(idEmpresa).orElseThrow(()->new Exception("Empresa não encontrada"));
    }

    @PutMapping
    public Empresa updateJornada(@RequestBody Empresa empresa){
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{idEmpresa}")
    public ResponseEntity<String> delete(@PathVariable("idEmpresa") Long idEmpresa){
        try {
            empresaService.delete(idEmpresa);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a empresa",
                    HttpStatus.BAD_REQUEST);
        }
     return  new ResponseEntity<>(
                "Empresa deletada",
                HttpStatus.OK);
    }
}
