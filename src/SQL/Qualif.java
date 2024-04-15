/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baert
 */
public class Qualif {

    public String[] getQualif() {
        List<String> qualifList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select appelation from qualif";

            try (Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        qualifList.add(resultSet.getString("appelation"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
         // Convertir la liste en tableau de chaînes de caractères
        String[] qualifTab = new String[qualifList.size()];
        qualifTab = qualifList.toArray(qualifTab);

        // Retourner le tableau de qualificatifs
        return qualifTab;
    }

}
