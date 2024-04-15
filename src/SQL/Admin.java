/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author baert
 */
public class Admin {

    public static boolean authenticate(String email, String password) {
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT * FROM admin WHERE email = ? AND mdp = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, md5Hash(password));
                try (ResultSet rs = pst.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String md5Hash(String input) {
        try {
            // Créer un objet MessageDigest pour MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Mettre la chaîne d'entrée dans l'objet MessageDigest
            md.update(input.getBytes());

            // Calculer le hash MD5
            byte[] hashBytes = md.digest();

            // Convertir le tableau de bytes en une représentation hexadécimale
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            // Retourner le hash MD5 sous forme de chaîne hexadécimale
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Gérer l'exception NoSuchAlgorithmException
            e.printStackTrace();
            return null; // Retourner null en cas d'erreur
        }
    }

}
