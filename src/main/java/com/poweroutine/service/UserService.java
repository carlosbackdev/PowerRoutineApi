package com.poweroutine.service;

import com.poweroutine.dtd.LoginUserDTD;
import com.poweroutine.model.UserModel;
import com.poweroutine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public LoginUserDTD login(UserModel user) {
        String email = user.getEmail();
        String nombre = user.getNombre();
        String password = user.getPassword();

        Optional<UserModel> optionalUser = Optional.empty();
        LoginUserDTD loginUserDTD=new LoginUserDTD(null,"");

        if (email != null && !email.isEmpty()) {
            optionalUser = userRepository.findByEmail(email);
        } else if (nombre != null && !nombre.isEmpty()) {
            optionalUser = userRepository.findByNombre(nombre);
        }

        if (optionalUser.isPresent()) {
            UserModel usuarioBaseDatos = optionalUser.get();
            loginUserDTD.setUsermodel(usuarioBaseDatos);

            if(usuarioBaseDatos.getPassword().equals(password)){
                loginUserDTD.setRespuesta("usuario correcto");
                return loginUserDTD;
            }else{
                loginUserDTD.setRespuesta("Contraseña Incorrecta");
                return loginUserDTD;
            }

        }else{
            loginUserDTD.setRespuesta("no existe el usuario");
        }
        return loginUserDTD;
    }

}
