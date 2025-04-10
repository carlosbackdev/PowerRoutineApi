package com.poweroutine.service;

import com.poweroutine.dtd.LoginUserDTD;
import com.poweroutine.dtd.RegisterUserDTD;
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
        String name = user.getName();
        String password = user.getPassword();

        Optional<UserModel> optionalUser = Optional.empty();
        LoginUserDTD loginUserDTD=new LoginUserDTD(null,"");

        if (email != null && !email.isEmpty()) {
            optionalUser = userRepository.findByEmail(email);
        } else if (name != null && !name.isEmpty()) {
            optionalUser = userRepository.findByName(name);
        }

        if (optionalUser.isPresent()) {
            UserModel usuarioBaseDatos = optionalUser.get();

            if(usuarioBaseDatos.getPassword().equals(password)){
                loginUserDTD.setRespuesta("usuario correcto");
                usuarioBaseDatos.setPassword(null);
                loginUserDTD.setUserModel(usuarioBaseDatos);
                return loginUserDTD;
            }else{
                loginUserDTD.setRespuesta("Contraseña Incorrecta");
                user.vaciar();
                return loginUserDTD;
            }

        }else{
            loginUserDTD.setRespuesta("no existe el usuario");
            user.vaciar();
            return loginUserDTD;
        }
    }

    public RegisterUserDTD register(UserModel user){
        String email = user.getEmail();
        String name = user.getName();
        String password = user.getPassword();
        RegisterUserDTD respuesta= new RegisterUserDTD();
        respuesta.setSucessful(true);

        if(userRepository.findByEmail(email).isPresent()){
            respuesta.setRespuesta("El email ya esta registrado");
            respuesta.setSucessful(false);
        }
        if(userRepository.findByName(name).isPresent()){
            respuesta.setRespuesta("El nombre de usuario ya esta registrado");
            respuesta.setSucessful(false);
        }

        if(respuesta.isSucessful()){
            userRepository.save(user);
            respuesta.setRespuesta("Usuario registrado correctamente");
            return respuesta;
        }
        return respuesta;
    }

}
