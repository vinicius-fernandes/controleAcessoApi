package controleAcesso.services;

import controleAcesso.model.Usuario;
import controleAcesso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return   usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario update(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}
