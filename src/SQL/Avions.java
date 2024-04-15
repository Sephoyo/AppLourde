/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baert
 */
public class Avions {

    private Comptes comptes = new Comptes();

    public DefaultTableModel getAllAvions() {
        // Déclaration du modèle de table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Num avion");
        model.addColumn("Type");
        model.addColumn("Taux");
        model.addColumn("Immatriculation");
        model.addColumn("Action");

        // Connexion à la base de données
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL
            String query = "SELECT * FROM avion";

            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                // Exécution de la requête SQL
                ResultSet resultSet = pst.executeQuery();
                // Parcours des résultats et ajout des membres au modèle de table
                while (resultSet.next()) {
                    int id = resultSet.getInt("num_avion");
                    String nom = resultSet.getString("type");
                    String prenom = resultSet.getString("taux");
                    String email = resultSet.getString("immatriculation");
                    // Ajout des informations du membre au modèle de table
                    nom = nom.trim();
                    prenom = prenom.trim();
                    email = email.trim();
                    model.addRow(new Object[]{id, nom, prenom, email});
                }
            }
        } catch (SQLException e) {
            // Gestion des exceptions liées à la base de données
            e.printStackTrace();
        }
        return model; // Retourner le modèle de table avec les données
    }

    public String getAvionById(int id) {
        String avionInfo = " (";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT * FROM avion WHERE num_avion = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    String immatriculation = resultSet.getString("immatriculation").trim();
                    avionInfo += immatriculation + ")";
                } else {
                    System.out.println("Aucun avion trouvé avec l'ID : " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion avec l'ID : " + id);
        }

        return avionInfo;
    }

    public HashMap<String, String> getAvById(int memberId) {
        HashMap<String, String> avion = new HashMap<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL avec une clause WHERE pour récupérer un seul membre par son ID
            String query = "SELECT * FROM avion WHERE num_avion = ?";

            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, memberId); // Remplacer le premier paramètre par l'ID du membre
                // Exécution de la requête SQL
                ResultSet resultSet = pst.executeQuery();
                // S'il y a un résultat, stockez les détails du membre dans la HashMap
                if (resultSet.next()) {
                    avion.put("num_avion", String.valueOf(resultSet.getInt("num_avion")));
                    avion.put("type", resultSet.getString("type"));
                    avion.put("taux", resultSet.getString("taux"));
                    avion.put("forfait1", resultSet.getString("forfait1"));
                    avion.put("forfait2", resultSet.getString("forfait2"));
                    avion.put("forfait3", resultSet.getString("forfait3"));
                    avion.put("heures_forfait1", resultSet.getString("heures_forfait1"));
                    avion.put("heures_forfait2", resultSet.getString("heures_forfait2"));
                    avion.put("heures_forfait3", resultSet.getString("heures_forfait3"));
                    avion.put("reduction_semaine", resultSet.getString("reduction_semaine"));
                    avion.put("immatriculation", resultSet.getString("immatriculation"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avion;
    }

    public boolean AvionDel(int id) {
        String immatriculation = null;
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour sélectionner l'immatriculation avant de supprimer l'avion
            String selectQuery = "SELECT immatriculation FROM avion WHERE num_avion = ?";
            try (PreparedStatement selectPst = conn.prepareStatement(selectQuery)) {
                selectPst.setInt(1, id);
                try (ResultSet resultSet = selectPst.executeQuery()) {
                    if (resultSet.next()) {
                        immatriculation = resultSet.getString("immatriculation");
                    }
                }
            }

            // Création de la requête SQL pour supprimer l'avion par son ID
            String deleteQuery = "DELETE FROM avion WHERE num_avion = ?";
            try (PreparedStatement deletePst = conn.prepareStatement(deleteQuery)) {
                deletePst.setInt(1, id);
                int rowsAffected = deletePst.executeUpdate();
                if (rowsAffected > 0) {
                    comptes.DelCoAv(immatriculation);
                    return true;
                }else{
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean AddAvion(String type, String taux, String forfait1, String forfait2,
            String forfait3, String heuresForfait1, String heuresForfait2,
            String heuresForfait3, String reductionSemaine, String immatriculation) {

        System.out.println("Dans la fonction addAvion :");

        try (Connection conn = connect.getConnection()) {
            String query = "INSERT INTO AVION (TYPE, TAUX, FORFAIT1, FORFAIT2, FORFAIT3, "
                    + "HEURES_FORFAIT1, HEURES_FORFAIT2, HEURES_FORFAIT3, REDUCTION_SEMAINE, IMMATRICULATION) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, type);
                pst.setBigDecimal(2, new BigDecimal(taux));
                pst.setBigDecimal(3, new BigDecimal(forfait1));
                pst.setBigDecimal(4, new BigDecimal(forfait2));
                pst.setBigDecimal(5, new BigDecimal(forfait3));
                pst.setInt(6, Integer.parseInt(heuresForfait1));
                pst.setInt(7, Integer.parseInt(heuresForfait2));
                pst.setInt(8, Integer.parseInt(heuresForfait3));
                pst.setBigDecimal(9, new BigDecimal(reductionSemaine));
                pst.setString(10, immatriculation);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Avion ajouté avec succès.");
                    //Si l'ajout est bon on peut ajouter la colonne de l'avion dans la table compte
                    comptes.AddCoAv(immatriculation);
                    return true;
                } else {
                    System.out.println("Échec de l'ajout de l'avion.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean UpAvion(int id,String type, String taux, String forfait1, String forfait2,
            String forfait3, String heuresForfait1, String heuresForfait2,
            String heuresForfait3, String reductionSemaine, String immatriculation) {

        System.out.println("Dans la fonction addAvion :");

        try (Connection conn = connect.getConnection()) {
            String query = "UPDATE AVION SET TYPE=?, TAUX=?, FORFAIT1=?, FORFAIT2=?, FORFAIT3=?, "
                + "HEURES_FORFAIT1=?, HEURES_FORFAIT2=?, HEURES_FORFAIT3=?, REDUCTION_SEMAINE=?, IMMATRICULATION=? "
                + "WHERE num_avion=?";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, type);
                pst.setBigDecimal(2, new BigDecimal(taux));
                pst.setBigDecimal(3, new BigDecimal(forfait1));
                pst.setBigDecimal(4, new BigDecimal(forfait2));
                pst.setBigDecimal(5, new BigDecimal(forfait3));
                pst.setInt(6, Integer.parseInt(heuresForfait1));
                pst.setInt(7, Integer.parseInt(heuresForfait2));
                pst.setInt(8, Integer.parseInt(heuresForfait3));
                pst.setBigDecimal(9, new BigDecimal(reductionSemaine));
                pst.setString(10, immatriculation);
                pst.setInt(11, id);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Avion update avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'update de l'avion.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Fonction pour récupérer tout les avions par type dans un tableau pour afficher dans une combobox
    public String[] getAvions() {
        List<String> avionList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select type from avion";

            try (Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        avionList.add(resultSet.getString("type").trim());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convertir la liste en tableau de chaînes de caractères
        String[] avionTab = new String[avionList.size()];
        avionTab = avionList.toArray(avionTab);

        // Retourner le tableau des avions
        return avionTab;
    }
    
    //Fonction pour récupérer tout les avions par immatriculation dans un tableau pour afficher dans une combobox
    public String[] getAvionsImm() {
        List<String> avionList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select immatriculation from avion";

            try (Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        avionList.add(resultSet.getString("immatriculation").trim());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convertir la liste en tableau de chaînes de caractères
        String[] avionTab = new String[avionList.size()];
        avionTab = avionList.toArray(avionTab);

        // Retourner le tableau des avions
        return avionTab;
    }

    public String getAvionTRByType(String type) {
        String AvionInfo = "";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT taux,reduction_semaine FROM avion WHERE type = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, type);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    AvionInfo = resultSet.getString("taux");
                    AvionInfo += " " + resultSet.getString("reduction_semaine");
                } else {
                    System.out.println("Aucun avion trouvé du type : " + type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion du type : " + type);
        }

        return AvionInfo;
    }

    public String getAvIdByType(String type) {
        String AvInfo = "";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT num_avion FROM avion WHERE type = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, type);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    AvInfo = resultSet.getString("num_avion");
                } else {
                    System.out.println("Aucun avion trouvé avec les infos : " + type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion avec les infos: " + type);
        }

        return AvInfo;
    }
    
    public int getAvIdByImm(String imm) {
        int AvInfo = 0;
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT num_avion FROM avion WHERE immatriculation = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, imm);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    AvInfo = resultSet.getInt("num_avion");
                } else {
                    System.out.println("Aucun avion trouvé avec les infos : " + imm);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion avec les infos: " + imm);
        }

        return AvInfo;
    }
    public String getAvImmByType(String type) {
        String AvInfo = "";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT immatriculation FROM avion WHERE type = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, type);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    AvInfo = resultSet.getString("immatriculation");
                } else {
                    System.out.println("Aucun avion trouvé avec les infos : " + type);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'avion avec les infos: " + type);
        }

        return AvInfo;
    }
    //Fonction pour avoir le type de l'avion par son id
    public String getAvionTypeByid(int id){
        String avion ="";
        try (Connection conn = connect.getConnection()) {
            String query = "select type from avion where num_avion=? ";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    avion = resultSet.getString("type");
                } else {
                    System.out.println("Aucun id trouvé avec l'id : " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'id avec : " + id);
        }
        return avion;
    }
    
    
    
    public DefaultTableModel coByIdMem(int id){
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Avion");
            model.addColumn("Forfait");
            String[] AvImm = getAvionsImm();
            // Connexion à la base de données
            try (Connection conn = connect.getConnection()) {
                // Création de la requête SQL
                String query = "SELECT * FROM COMPTES WHERE id= ?";
                // Création de l'instruction SQL
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    // Exécution de la requête SQL
                    pst.setInt(1,id);
                    ResultSet resultSet = pst.executeQuery();
                    // Parcours des résultats et ajout des membres au modèle de table
                    while (resultSet.next()) {
                        for(String avion : AvImm){
                            int forfait = resultSet.getInt(avion);
                            model.addRow(new Object[]{avion,forfait});
                        }
                    }
                }
            } catch (SQLException e) {
                // Gestion des exceptions liées à la base de données
                e.printStackTrace();
            }
            return model;
        } 
}
