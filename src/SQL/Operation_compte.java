/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph
 */
public class Operation_compte {

    private Comptes co = new Comptes();

    public boolean AddOperationAfterSeqVol(String id_in, String id_mem, String id_av,
            String date, String temps, String heuresForfait,
            String prixSpecial, String taux, String reductionSemaine,
            String motif, String tauxInstructeur, boolean forfaitInitiation) {
        int debit;
        int tauxInstru = Integer.parseInt(tauxInstructeur);
        int prixSpe = Integer.parseInt(prixSpecial);
        int tau = Integer.parseInt(taux);
        int tps = Integer.parseInt(temps);
        int rds = Integer.parseInt(reductionSemaine);
        //mettre dans la table seq vol le forfait corresponf a l'avion du membre dans la table compte
        int hforfait = Integer.parseInt(heuresForfait);
        if (prixSpe > 0) {
            debit = prixSpe;
        } else {
            if (hforfait - tps < 0) {
                debit = tps - hforfait;
                debit = debit * 60;
                debit = (debit * tau) + (debit * tauxInstru);
                debit = debit - rds;
            } else {
                debit = (tps * 60) * tauxInstru;
            }
        }
        //Mon débit est calculer plus qu'a faire mon ajouts
        //récupération de mon id_seq

        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "INSERT INTO OPERATION_COMPTE(date,id_co,id_seq,id_mem,commentaire,debit,credit)"
                    + " VALUES(NOW(),?,?,?,?,?,?);";
            
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, co.IdCoByIdM(id_mem));
                pst.setInt(2, 0);
                pst.setInt(3, Integer.parseInt(id_mem));
                pst.setString(4, motif);
                pst.setInt(5, debit);
                pst.setInt(6, 0);
                int rowsAffected = pst.executeUpdate();

                // Vérification du nombre de lignes affectées
                if (rowsAffected > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public int FindIdByMoMem(String motif,String mem){
//            try (Connection conn = connect.getConnection()) {
//            // Création de la requête SQL pour sélectionner l'ID
//            String query = "SELECT num_seq FROM SEQ_VOL WHERE motif = ? and id_mem = ?";
//
//            try (PreparedStatement pst = conn.prepareStatement(query)) {
//                pst.setString(1, motif);
//                pst.setInt(2,Integer.parseInt(mem));
//                
//                try (ResultSet rs = pst.executeQuery()) {
//                    if (rs.next()) {
//                        int Id = rs.getInt("num_seq");
//                        return Id;
//                    } else {
//
//                        return -1;
//                    }
//                }
//            }
//        } catch (SQLException | NumberFormatException e) {
//            e.printStackTrace();
//            return -1; // ou une autre valeur pour indiquer une erreur
//        }
//            
//        }
    //fonction pour récuperer un model pour la visualisation du compte
    public DefaultTableModel getOpeVyIdMem(String id) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ope num");
        model.addColumn("Motif");
        model.addColumn("Débit");
        model.addColumn("Crédit");
        // Connexion à la base de données
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL
            String query = "SELECT * FROM OPERATION_COMPTE WHERE id_mem= ?";
            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                // Exécution de la requête SQL
                pst.setString(1, id);
                ResultSet resultSet = pst.executeQuery();
                // Parcours des résultats et ajout des membres au modèle de table
                while (resultSet.next()) {
                    int id_seq = resultSet.getInt("id");
                    String motif = resultSet.getString("commentaire").trim();
                    int debit = resultSet.getInt("debit");
                    int credit = resultSet.getInt("credit");
                    // Ajout des informations du membre au modèle de table
                    model.addRow(new Object[]{id_seq, motif, debit, credit});
                }
            }
        } catch (SQLException e) {
            // Gestion des exceptions liées à la base de données
            e.printStackTrace();
        }
        return model;
    }

    public boolean addOperationCompte(String idCo, String idSeq, String idMem,
            String commentaire, String debit, String credit) {

        System.out.println("Dans la fonction addOperationCompte :");

        try (Connection conn = connect.getConnection()) {
            String query = "INSERT INTO OPERATION_COMPTE (DATE, ID_CO, ID_SEQ, ID_MEM, COMMENTAIRE, DEBIT, CREDIT) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, "NOW()");
                pst.setString(2, String.valueOf(co.IdCoByIdM(idCo)));
                pst.setString(3, idSeq);
                pst.setString(4, idMem);
                pst.setString(5, commentaire);
                pst.setInt(6, Integer.parseInt(debit));
                pst.setInt(7, Integer.parseInt(credit));

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Opération de compte ajoutée avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'ajout de l'opération de compte.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
