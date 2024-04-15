/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joseph
 */
public class Comptes {

    //Fonction pour ajouter la colonne dans la talbe compte intilisé à 0
    public boolean AddCoAv(String id) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour ajouter une colonne
            String query = "ALTER TABLE COMPTES ADD COLUMN " + id + " INT DEFAULT 0;";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                // Exécution de la requête d'ajout de colonne
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

    //Suppression d'une colonne dans la table compte lors de la suppression d'un avion
    public boolean DelCoAv(String nomColonne) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer une colonne
            String query = "ALTER TABLE COMPTES DROP COLUMN " + nomColonne + ";";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                // Exécution de la requête de suppression de colonne
                int lignesAffectees = pst.executeUpdate();

                // Vérification du nombre de lignes affectées
                if (lignesAffectees > 0) {
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

    public int IdCoByIdM(String id) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour sélectionner l'ID
            String query = "SELECT id_compte FROM COMPTES WHERE ID = ?";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, Integer.parseInt(id));
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        int Id = rs.getInt("id_compte");
                        System.out.println(id);
                        System.out.println(Id);
                        return Id;
                    } else {

                        return -1;
                    }
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            return -1; // ou une autre valeur pour indiquer une erreur
        }
    }

    public void UpForfait(String imm, int h, int id, int debit) {
        System.out.println("Je suis dans la fonction upForfait");
        int idco = IdCoByIdM(String.valueOf(id));
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour mettre à jour le forfait d'un avion  d'un compte en fonction de l'ID
            String updateQuery = "UPDATE COMPTES SET " + imm + " = " + imm + " + ? WHERE id_compte = ?";
            
            try (PreparedStatement pst = conn.prepareStatement(updateQuery)) {
                pst.setInt(1, h);
                pst.setInt(2, idco);
                
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) { 
                    // La mise à jour a réussi
                    String comm = "Recharge du forfait pour l'avion "+imm;
                    AddOpForfait(idco,0,id,comm,debit,0);
                    System.out.println( "Mise à jour réussie pour l'ID " + idco);
                } else {
                    // Aucune ligne mise à jour (ID non trouvé)
                    System.out.println( "Aucun compte trouvé avec l'ID " + idco);
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la mise à jour du compte");
        }

    }
    public void AddOpForfait(int idCO, int idSeq, int idMem, String commentaire, int debit, int credit) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour insérer une nouvelle ligne dans la table OPERATION_COMPTE
            String insertQuery = "INSERT INTO OPERATION_COMPTE (DATE, ID_CO, ID_SEQ, ID_MEM, COMMENTAIRE, DEBIT, CREDIT) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(insertQuery)) {
                // Définition des valeurs des paramètres
                pst.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Date actuelle
                pst.setInt(2, idCO);
                pst.setInt(3, idSeq);
                pst.setInt(4, idMem);
                pst.setString(5, commentaire);
                pst.setInt(6, debit);
                pst.setInt(7, credit);

                // Exécution de la requête
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("L'opération a été ajoutée avec succès.");
                } else {
                    System.out.println("Erreur lors de l'ajout de l'opération.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur SQL lors de l'ajout de l'opération.");
        }
    }
    
    //Fonction pour avoir le forfait par rapport un avion et l'id du membre
    public String getForfaitByImmId(String imm, int id) {
        String forfait = "";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT "+imm.trim()+" FROM comptes WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    forfait = resultSet.getString(imm.trim());
                } else {
                    System.out.println("Aucun avion trouvé avec les infos : " + imm + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion avec les infos: " + imm + id);
        }

        return forfait;
    }
}
