package controleAcesso.services;

import controleAcesso.model.Calendario;
import controleAcesso.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CalendarioService {
    @Autowired
    CalendarioRepository calendarioRepository;

    public Calendario save(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public List<Calendario> findAll() {
        return   calendarioRepository.findAll();
    }

    public Optional<Calendario> getById(Long idCalendario) {
        return calendarioRepository.findById(idCalendario);
    }

    public Calendario update(Calendario calendario){
        return calendarioRepository.save(calendario);
    }

    public void delete(Long idCalendario) {
        calendarioRepository.deleteById(idCalendario);
    }
}
