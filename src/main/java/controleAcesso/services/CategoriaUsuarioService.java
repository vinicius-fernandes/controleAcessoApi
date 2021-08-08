package controleAcesso.services;

import controleAcesso.model.CategoriaUsuario;
import controleAcesso.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaUsuarioService {
    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> findAll() {
        return   categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> getById(Long idCategoriaUsuario) {
        return categoriaUsuarioRepository.findById(idCategoriaUsuario);
    }

    public CategoriaUsuario update(CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public void delete(Long idCategoriaUsuario) {
        categoriaUsuarioRepository.deleteById(idCategoriaUsuario);
    }
}
