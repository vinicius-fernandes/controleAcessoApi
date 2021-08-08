package controleAcesso.controller;

import controleAcesso.model.CategoriaUsuario;
import controleAcesso.services.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoriausuario")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.save(categoriaUsuario);
    }

    @GetMapping("/list")
    public List<CategoriaUsuario> getCategoriaUsuarioList(){
        return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idCategoriaUsuario}")
    public CategoriaUsuario getCategoriaUsuarioByID(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario) throws Exception {
        return categoriaUsuarioService.getById(idCategoriaUsuario).orElseThrow(()->new Exception("CategoriaUsuario não encontrada"));
    }

    @PutMapping
    public CategoriaUsuario updateJornada(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.update(categoriaUsuario);
    }

    @DeleteMapping("/{idCategoriaUsuario}")
    public ResponseEntity<String> delete(@PathVariable("idCategoriaUsuario") Long idCategoriaUsuario){
        try {
            categoriaUsuarioService.delete(idCategoriaUsuario);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a CategoriaUsuario",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "CategoriaUsuario deletada",
                HttpStatus.OK);
    }

}
