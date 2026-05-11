package com.example.salespointproject.utils;

//Imports de librerias
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public void crearCookieToken(HttpServletResponse response, String token) {
        //Hacemos la cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(3600); //1hr

        //Entregamos la cookie
        response.addCookie(cookie);
    }

}
