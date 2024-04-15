/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *x
 * @author baert
 */
public class Civilite {

    public String[] getCivil() {
        List<String> civilList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select long from civilite";

            try (Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        civilList.add(resultSet.getString("long"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convertir la liste en tableau de chaînes de caractères
        String[] civilTab = new String[civilList.size()];
        civilTab = civilList.toArray(civilTab);

        // Retourner le tableau de qualificatifs
        return civilTab;
    }
    
    
    //Fonction pour récupérer l'id suite à l'ajout d'un membre et instructeurs
    public int FoundIdCivi(String qualif){
        int id = 0;
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select num_civilite from civilite where long=? ";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, qualif);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    String id_qualif = resultSet.getString("num_civilite");
                    id = parseInt(id_qualif);
                } else {
                    System.out.println("Aucun id trouvé avec l'appelation : " + qualif);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'id avec : " + qualif);
        }
        return id;
    }
    
    //Fonction pour avoir le nom et prenom d'un membre par son id
    public String getCivilByid(int id){
        String civil ="";
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select long from civilite where num_civilite=? ";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    civil = resultSet.getString("long");
                } else {
                    System.out.println("Aucun id trouvé avec l'id : " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'id avec : " + id);
        }
        return civil;
    }
}
