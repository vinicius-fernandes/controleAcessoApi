package controleAcesso.controller;

import controleAcesso.model.Usuario;
import controleAcesso.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @GetMapping("/list")
    public List<Usuario> getUsuarioList(){
        return usuarioService.findAll();
    }

    @GetMapping("/{idUsuario}")
    public Usuario getUsuarioByID(@PathVariable("idUsuario") Long idUsuario) throws Exception {
        return usuarioService.getById(idUsuario).orElseThrow(()->new Exception("Usuario não encontrada"));
    }

    @PutMapping
    public Usuario updateJornada(@RequestBody Usuario usuario){
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> delete(@PathVariable("idUsuario") Long idUsuario){
        try {
            usuarioService.delete(idUsuario);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a Usuario",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Usuario deletada",
                HttpStatus.OK);
    }

}
