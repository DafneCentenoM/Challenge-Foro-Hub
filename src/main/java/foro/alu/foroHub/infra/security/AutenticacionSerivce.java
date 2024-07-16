package foro.alu.foroHub.infra.security;

import foro.alu.foroHub.domain.usuario.UsuarioRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionSerivce  implements UserDetailsService {

    @Autowired
    UsuarioRespository usuarioRespository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRespository.findByEmail(username);
    }
}
