package controleAcesso.services;

import controleAcesso.model.Ocorrencia;
import controleAcesso.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OcorrenciaService {
    @Autowired
    OcorrenciaRepository ocorrenciaRepository;

    public Ocorrencia save(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public List<Ocorrencia> findAll() {
        return   ocorrenciaRepository.findAll();
    }

    public Optional<Ocorrencia> getById(Long idOcorrencia) {
        return ocorrenciaRepository.findById(idOcorrencia);
    }

    public Ocorrencia update(Ocorrencia ocorrencia){
        return ocorrenciaRepository.save(ocorrencia);
    }

    public void delete(Long idOcorrencia) {
        ocorrenciaRepository.deleteById(idOcorrencia);
    }
}
