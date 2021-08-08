package controleAcesso.services;

import controleAcesso.model.TipoData;
import controleAcesso.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoDataService {
    @Autowired
    TipoDataRepository tipoDataRepository;

    public TipoData save(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public List<TipoData> findAll() {
        return   tipoDataRepository.findAll();
    }

    public Optional<TipoData> getById(Long idTipoData) {
        return tipoDataRepository.findById(idTipoData);
    }

    public TipoData update(TipoData tipoData){
        return tipoDataRepository.save(tipoData);
    }

    public void delete(Long idTipoData) {
        tipoDataRepository.deleteById(idTipoData);
    }
}
