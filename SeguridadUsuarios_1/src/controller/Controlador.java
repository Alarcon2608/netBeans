package controller;

import model.Usuario;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Controlador {
    private Map<String, Usuario> usuarios;
    private static final String USERS_FILE = "RegistroUsuarios.txt";

    public Controlador() {
        this.usuarios = new HashMap<>();
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        File file = new File(USERS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Usuario usuario = Usuario.fromString(line);
                    usuarios.put(usuario.getNombre(), usuario);
                }
            } catch (IOException e) {
                System.err.println("Error al cargar usuarios: " + e.getMessage());
            }
        }
    }

    public void registrarUsuario(String nombre, String contrasena) throws IllegalArgumentException {
        if (usuarios.containsKey(nombre)) {
            throw new IllegalArgumentException("Usuario ya registrado.");
        }
        Usuario nuevoUsuario = new Usuario(nombre, contrasena);
        usuarios.put(nombre, nuevoUsuario);
        guardarRegistroUsuarios();
    }

    public boolean iniciarSesion(String nombre, String contrasena) {
        Usuario usuario = usuarios.get(nombre);
        return usuario != null && usuario.validarContrasena(contrasena);
    }

    private void guardarRegistroUsuarios() {
        try (PrintWriter out = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (Usuario usuario : usuarios.values()) {
                out.println(usuario.toString());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public Map<String, Usuario> getUsuarios() {
        return new HashMap<>(usuarios);  // Return a copy to preserve encapsulation
    }
}


