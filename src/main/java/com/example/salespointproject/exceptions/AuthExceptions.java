package com.example.salespointproject.exceptions;

public class AuthExceptions {

    public static class usuarioNoEncontradoException extends RuntimeException {
        public usuarioNoEncontradoException (String email) {
            super("No se encontro ningun usuario con este correo: " + email);
        }
    }

    public static class contrasenaIncorrectaException extends RuntimeException {
        public contrasenaIncorrectaException() {
            super("La contraseña es incorrecta");
        }
    }
}
