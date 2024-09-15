package com.example.ClinicaOdontologicaSpringMVC.Security;

import com.example.ClinicaOdontologicaSpringMVC.Entity.Usuario;
import com.example.ClinicaOdontologicaSpringMVC.Entity.UsuarioRole;
import com.example.ClinicaOdontologicaSpringMVC.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        String passCifrado= bCryptPasswordEncoder.encode("admin");
        Usuario usuario= new Usuario("Gian","admin",passCifrado,"gianpc@digitalhouse.com", UsuarioRole.ROLE_USER);
        System.out.println("pass: "+passCifrado);
        usuarioRepository.save(usuario); */

        String passCifradoAdmin = bCryptPasswordEncoder.encode("admin");
        Usuario admin = new Usuario("Admin", "admin", passCifradoAdmin, "admin@digitalhouse.com", UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(admin);

        String passCifradoUser = bCryptPasswordEncoder.encode("user");
        Usuario user = new Usuario("User", "user", passCifradoUser, "user@digitalhouse.com", UsuarioRole.ROLE_USER);
        usuarioRepository.save(user);


    }
}
