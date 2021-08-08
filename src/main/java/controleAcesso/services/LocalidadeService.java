package controleAcesso.services;

import controleAcesso.model.Localidade;
import controleAcesso.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocalidadeService {
    @Autowired
    LocalidadeRepository localidadeRepository;

    public Localidade save(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public List<Localidade> findAll() {
        return   localidadeRepository.findAll();
    }

    public Optional<Localidade> getById(Long idLocalidade) {
        return localidadeRepository.findById(idLocalidade);
    }

    public Localidade update(Localidade localidade){
        return localidadeRepository.save(localidade);
    }

    public void delete(Long idLocalidade) {
        localidadeRepository.deleteById(idLocalidade);
    }
}
