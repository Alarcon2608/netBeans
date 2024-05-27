package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String contrasenaHash;
    private String salt;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.salt = generateSalt();
        this.contrasenaHash = encriptarContrasena(contrasena);
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String encriptarContrasena(String contrasena) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest((salt + contrasena).getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validarContrasena(String contrasena) {
        return this.contrasenaHash.equals(encriptarContrasena(contrasena));
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public String toString() {
        return nombre + "," + salt + "," + contrasenaHash;
    }

    public static Usuario fromString(String userData) {
        String[] parts = userData.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("informacion de usuario invalida");
        }
        Usuario user = new Usuario(parts[0], "");
        user.salt = parts[1];
        user.contrasenaHash = parts[2];
        return user;
    }
}
