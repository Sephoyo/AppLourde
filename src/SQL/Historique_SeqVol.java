/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author joseph.baert
 */
public class Historique_SeqVol {
    
    
    public boolean AddHistoriqueSequenceVol(String id_in, String id_mem, String id_av,
            String date, String temps, String heuresForfait,
            String prixSpecial, String taux, String reductionSemaine,
            String motif, String tauxInstructeur, boolean forfaitInitiation) {

        System.out.println("Dans la fonction AddSequenceVol :");

        try (Connection conn = connect.getConnection()) {
            String query = "INSERT INTO HISTORIQUE_SEQ_VOL (ID_IN, ID_MEM, ID_AV, DATE, TEMPS, HEURES_FORFAIT, "
                    + "PRIX_SPECIAL, TAUX, REDUCTION_SEMAINE, MOTIF, TAUX_INSTRUCTEUR, FORFAIT_INITIATION) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, Integer.parseInt(id_in));
                pst.setInt(2, Integer.parseInt(id_mem));
                pst.setInt(3, Integer.parseInt(id_av));
                pst.setDate(4, java.sql.Date.valueOf(date));
                pst.setInt(5, Integer.parseInt(temps));
                pst.setInt(6, Integer.parseInt(heuresForfait));
                pst.setInt(7, Integer.parseInt(prixSpecial));
                pst.setBigDecimal(8, new BigDecimal(taux));
                pst.setInt(9, Integer.parseInt(reductionSemaine));
                pst.setString(10, motif);
                pst.setBigDecimal(11, new BigDecimal(tauxInstructeur));
                pst.setBoolean(12, forfaitInitiation);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Séquence de vol ajoutée avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'ajout de la séquence de vol.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
