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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author baert
 */
public class Instructeurs {

    public DefaultTableModel getAllInstru() {
        // Déclaration du modèle de table
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nom");
        model.addColumn("Prénom");
        model.addColumn("Email");
        model.addColumn("Action");

        // Connexion à la base de données
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL
            String query = "SELECT * FROM instructeurs";

            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                // Exécution de la requête SQL
                ResultSet resultSet = pst.executeQuery();
                // Parcours des résultats et ajout des membres au modèle de table
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nom = resultSet.getString("nom");
                    String prenom = resultSet.getString("prenom");
                    String email = resultSet.getString("email");
                    nom = nom.trim();
                    prenom = prenom.trim();
                    email=email.trim();
                    // Ajout des informations du membre au modèle de table
                    model.addRow(new Object[]{id, nom, prenom, email});
                }
            }
        } catch (SQLException e) {
            // Gestion des exceptions liées à la base de données
            e.printStackTrace();
        }
        return model; // Retourner le modèle de table avec les données
    }

    public String getInstruById(int id) {
        String InstruInfo = " (";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT * FROM instructeurs WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom").trim();
                    String prenom = resultSet.getString("prenom").trim();
                    InstruInfo += nom.toUpperCase() + " " + prenom + ")";
                } else {
                    System.out.println("Aucun instru trouvé avec l'ID : " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'instru avec l'ID : " + id);
        }

        return InstruInfo;
    }

    public HashMap<String, String> getInById(int instruid) {
        HashMap<String, String> instruDetails = new HashMap<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL avec une clause WHERE pour récupérer un seul membre par son ID
            String query = "SELECT * FROM instructeurs WHERE id = ?";

            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, instruid); // Remplacer le premier paramètre par l'ID du membre
                // Exécution de la requête SQL
                ResultSet resultSet = pst.executeQuery();
                // S'il y a un résultat, stockez les détails du membre dans la HashMap
                if (resultSet.next()) {
                    instruDetails.put("id", String.valueOf(resultSet.getInt("id")));
                    instruDetails.put("nom", resultSet.getString("nom"));
                    instruDetails.put("prenom", resultSet.getString("prenom"));
                    instruDetails.put("email", resultSet.getString("email"));
                    instruDetails.put("badge", resultSet.getString("num_badge"));
                    instruDetails.put("adresse", resultSet.getString("adresse"));
                    instruDetails.put("tel", resultSet.getString("tel"));
                    instruDetails.put("cp", resultSet.getString("code_postal"));
                    instruDetails.put("ville", resultSet.getString("ville"));
                    instruDetails.put("date_vm", resultSet.getString("date_vm"));
                    instruDetails.put("validite_vm", resultSet.getString("validite_vm"));
                    instruDetails.put("date_sep", resultSet.getString("date_sep"));
                    instruDetails.put("validite_sep", resultSet.getString("validite_sep"));
                    instruDetails.put("carte_federale", resultSet.getString("carte_federale"));
                    instruDetails.put("date_attestation", resultSet.getString("date_attestation"));
                    instruDetails.put("fax", resultSet.getString("fax"));
                    instruDetails.put("taux_instructeur", resultSet.getString("taux_instructeur"));
                    instruDetails.put("date_bb", resultSet.getString("date_bb"));
                    instruDetails.put("date_ppla", resultSet.getString("date_ppla"));
                    instruDetails.put("numero_bb", resultSet.getString("numero_bb"));
                    instruDetails.put("numero_ppla", resultSet.getString("numero_ppla"));
                    instruDetails.put("comm",resultSet.getString("commentaire"));
                    instruDetails.put("num_civilite",resultSet.getString("num_civilite"));
                    instruDetails.put("mdp",resultSet.getString("mdp"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instruDetails;
    }

    public boolean InstructeurDel(int id) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "DELETE FROM instructeurs WHERE id = ?";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id); // Remplacer le premier paramètre par l'ID du membre
                // Exécution de la requête de suppression
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
    
    
    private Civilite CiviLite = new Civilite();
    private Admin ad = new Admin();
    //Fonction pour ajouter un instructeur
    public boolean AddInstructeur(String num_civilite, String nom,
            String prenom, String adresse, String code_postal, String tel, String email,
            String commentaire, String num_badge, String ville, String date_vm, String validite_vm,
            String date_sep, String validite_sep, String carte_federale, String date_attestation,
            String mdp, String taux_instructeur, String fax,
            String date_bb, String date_ppla, String numero_bb, String numero_ppla) {

        System.out.println("Dans la fonction AddInstructeur :");

        int civilite = CiviLite.FoundIdCivi(num_civilite);

        try (Connection conn = connect.getConnection()) {
            String query = "INSERT INTO INSTRUCTEURS (NUM_CIVILITE, NOM, PRENOM, ADRESSE, CODE_POSTAL, TEL, EMAIL, COMMENTAIRE, NUM_BADGE, VILLE, DATE_VM, VALIDITE_VM, DATE_SEP, VALIDITE_SEP, CARTE_FEDERALE, DATE_ATTESTATION, MDP, TAUX_INSTRUCTEUR, FAX, DATE_BB, DATE_PPLA, NUMERO_BB, NUMERO_PPLA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                java.sql.Date sqlDateVM = convertStringToDate(date_vm);
                java.sql.Date sqlDateValiditeVM = convertStringToDate(validite_vm);
                java.sql.Date sqlDateSEP = convertStringToDate(date_sep);
                java.sql.Date sqlDateValiditeSEP = convertStringToDate(validite_sep);
                java.sql.Date sqlDateAttestation = convertStringToDate(date_attestation);
                java.sql.Date sqlDateBB = convertStringToDate(date_bb);
                java.sql.Date sqlDatePPLA = convertStringToDate(date_ppla);

                pst.setInt(1, civilite);
                pst.setString(2, nom);
                pst.setString(3, prenom);
                pst.setString(4, adresse);
                int cp = Integer.parseInt(code_postal);
                pst.setInt(5, cp);
                pst.setString(6, tel);
                pst.setString(7, email);
                pst.setString(8, commentaire);
                pst.setString(9, num_badge);
                pst.setString(10, ville);
                pst.setDate(11, sqlDateVM);
                pst.setDate(12, sqlDateValiditeVM);
                pst.setDate(13, sqlDateSEP);
                pst.setDate(14, sqlDateValiditeSEP);
                pst.setString(15, carte_federale);
                pst.setDate(16, sqlDateAttestation);
                pst.setString(17, ad.md5Hash(mdp));
                pst.setBigDecimal(18, new BigDecimal(taux_instructeur));
                pst.setString(19, fax);
                pst.setDate(20, sqlDateBB);
                pst.setDate(21, sqlDatePPLA);
                pst.setString(22, numero_bb);
                pst.setString(23, numero_ppla);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Instructeur ajouté avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'ajout de l'instructeur.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Fonction pour ajouter un instructeur
    public boolean UpInstructeur(int id,String num_civilite, String nom,
            String prenom, String adresse, String code_postal, String tel, String email,
            String commentaire, String num_badge, String ville, String date_vm, String validite_vm,
            String date_sep, String validite_sep, String carte_federale, String date_attestation,
            String mdp, String taux_instructeur, String fax,
            String date_bb, String date_ppla, String numero_bb, String numero_ppla) {

        System.out.println("Dans la fonction AddInstructeur :");

        int civilite = CiviLite.FoundIdCivi(num_civilite);

        try (Connection conn = connect.getConnection()) {
            String query = "UPDATE INSTRUCTEURS SET NUM_CIVILITE=?, NOM=?, PRENOM=?, "
                    + "ADRESSE=?, CODE_POSTAL=?, TEL=?, EMAIL=?, COMMENTAIRE=?, NUM_BADGE=?, "
                    + "VILLE=?, DATE_VM=?, VALIDITE_VM=?, DATE_SEP=?, VALIDITE_SEP=?, "
                    + "CARTE_FEDERALE=?, DATE_ATTESTATION=?, MDP=?, TAUX_INSTRUCTEUR=?, "
                    + "FAX=?, DATE_BB=?, DATE_PPLA=?, NUMERO_BB=?, NUMERO_PPLA=? "
                    + "WHERE id=?;";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                java.sql.Date sqlDateVM = convertStringToDate(date_vm);
                java.sql.Date sqlDateValiditeVM = convertStringToDate(validite_vm);
                java.sql.Date sqlDateSEP = convertStringToDate(date_sep);
                java.sql.Date sqlDateValiditeSEP = convertStringToDate(validite_sep);
                java.sql.Date sqlDateAttestation = convertStringToDate(date_attestation);
                java.sql.Date sqlDateBB = convertStringToDate(date_bb);
                java.sql.Date sqlDatePPLA = convertStringToDate(date_ppla);

                pst.setInt(1, civilite);
                pst.setString(2, nom);
                pst.setString(3, prenom);
                pst.setString(4, adresse);
                int cp = Integer.parseInt(code_postal);
                pst.setInt(5, cp);
                pst.setString(6, tel);
                pst.setString(7, email);
                pst.setString(8, commentaire);
                pst.setString(9, num_badge);
                pst.setString(10, ville);
                pst.setDate(11, sqlDateVM);
                pst.setDate(12, sqlDateValiditeVM);
                pst.setDate(13, sqlDateSEP);
                pst.setDate(14, sqlDateValiditeSEP);
                pst.setString(15, carte_federale);
                pst.setDate(16, sqlDateAttestation);
                pst.setString(17, ad.md5Hash(mdp));
                pst.setBigDecimal(18, new BigDecimal(taux_instructeur));
                pst.setString(19, fax);
                pst.setDate(20, sqlDateBB);
                pst.setDate(21, sqlDatePPLA);
                pst.setString(22, numero_bb);
                pst.setString(23, numero_ppla);
                pst.setInt(24,id);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Instructeur update avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'update de l'instructeur.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public java.sql.Date convertStringToDate(String dateString) {
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateString);
            return new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Fonction pour récupérer tout les membre par nom prénom dans un tableau pour afficher dans une combobox
    public String[] getInstrus() {
        List<String> insList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select nom, prenom from instructeurs";

            try (java.sql.Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        insList.add(resultSet.getString("nom").trim()+" "+resultSet.getString("prenom").trim());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convertir la liste en tableau de chaînes de caractères
        String[] insTab = new String[insList.size()];
        insTab = insList.toArray(insTab);

        // Retourner le tableau des membres
        return insTab;
    }
    
    public String getInstruTauxByNP(String nom, String prenom) {
        String InstruInfo ="";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT taux_instructeur FROM instructeurs WHERE nom = ? and prenom = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, nom);
                pst.setString(2,prenom);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    InstruInfo = resultSet.getString("taux_instructeur");
                } else {
                    System.out.println("Aucun instru trouvé avec les infos : " + nom+" "+prenom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'instru avec les infos: " + nom+" "+prenom);
        }

        return InstruInfo;
    }
    
    
    public String getInstruIdByNP(String nom, String prenom) {
        String InstruInfo ="";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT id FROM instructeurs WHERE nom = ? and prenom = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, nom);
                pst.setString(2,prenom);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    InstruInfo = resultSet.getString("id");
                } else {
                    System.out.println("Aucun instructeur trouvé avec les infos : " + nom+" "+prenom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération de l'instructeur avec les infos: " + nom+" "+prenom);
        }

        return InstruInfo;
    }
    //Fonction pour avoir le nom et prenom d'un instructeur par son id
    public String getinsNPbyid(int id){
        String civil ="";
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select nom,prenom from membres where id=? ";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    civil = resultSet.getString("nom").trim() + " " + resultSet.getString("prenom").trim();
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
