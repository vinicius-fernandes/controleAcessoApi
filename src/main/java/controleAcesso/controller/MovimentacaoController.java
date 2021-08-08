package controleAcesso.controller;

import controleAcesso.model.Movimentacao;
import controleAcesso.services.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.save(movimentacao);
    }

    @GetMapping("/list")
    public List<Movimentacao> getMovimentacaoList(){
        return movimentacaoService.findAll();
    }

    @GetMapping("/{idMovimentacao}")
    public Movimentacao getMovimentacaoByID(@PathVariable("idMovimentacao") Long idMovimentacao) throws Exception {
        return movimentacaoService.getById(idMovimentacao).orElseThrow(()->new Exception("Movimentacao não encontrada"));
    }

    @PutMapping
    public Movimentacao updateJornada(@RequestBody Movimentacao movimentacao){
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping("/{idMovimentacao}")
    public ResponseEntity<String> delete(@PathVariable("idMovimentacao") Long idMovimentacao){
        try {
            movimentacaoService.delete(idMovimentacao);
        }
        catch(Exception e){
            new ResponseEntity<>(
                    "Falha ao deletar a Movimentacao",
                    HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(
                "Movimentacao deletada",
                HttpStatus.OK);
    }

}
