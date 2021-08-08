package controleAcesso.services;

import controleAcesso.model.Movimentacao;
import controleAcesso.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovimentacaoService {
    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    public Movimentacao save(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return   movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> getById(Long idMovimentacao) {
        return movimentacaoRepository.findById(idMovimentacao);
    }

    public Movimentacao update(Movimentacao movimentacao){
        return movimentacaoRepository.save(movimentacao);
    }

    public void delete(Long idMovimentacao) {
        movimentacaoRepository.deleteById(idMovimentacao);
    }
}
