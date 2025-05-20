package services;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImplement implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //Convierto los datos de laa sesion en un string
        String username = (String) session.getAttribute("username");
        /*Creo una condicion en la cual valido si al obtener el nombre del usuario es distinto de nulo obtengo el uername
        caso contrario devuelvo la sesion vacia
         */
        if (username != null) {
            return Optional.of(username);
            } else{
                return Optional.empty();
            }
        }

    }

