package controleAcesso.services;

import controleAcesso.model.BancoHoras;
import controleAcesso.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasService {
    @Autowired
    BancoHorasRepository bancoHorasRepository;

    public BancoHoras save(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public List<BancoHoras> findAll() {
        return   bancoHorasRepository.findAll();
    }

    public Optional<BancoHoras> getById(Long idBanco) {
        return bancoHorasRepository.findById(idBanco);
    }

    public BancoHoras update(BancoHoras bancoHoras){
        return bancoHorasRepository.save(bancoHoras);
    }

    public void delete(Long idBanco) {
        bancoHorasRepository.deleteById(idBanco);
    }
}
