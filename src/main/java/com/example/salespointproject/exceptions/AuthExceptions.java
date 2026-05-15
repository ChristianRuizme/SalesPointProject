package com.example.salespointproject.exceptions;

public class AuthExceptions {

    public static class UsuarioNoEncontradoException extends RuntimeException {
        public UsuarioNoEncontradoException (String email) {
            super("No se encontro ningun usuario con este correo: " + email);
        }
    }

    public static class ContrasenaIncorrectaException extends RuntimeException {
        public ContrasenaIncorrectaException() {
            super("La contraseña es incorrecta");
        }
    }

    public static class EmailYaRegistradoException extends RuntimeException {
        public EmailYaRegistradoException(String email) { super("El email " + email + " ya esta registrado"); }
    }
}
