/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.beans.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;
import SQL.Admin;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Membres {

    public DefaultTableModel getAllMembres() {
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
            String query = "SELECT * FROM membres";

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
                    email = email.trim();
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

    public String getMemById(int id) {
        String MembreInfo = " (";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT * FROM membres WHERE id = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, id);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    String nom = resultSet.getString("nom").trim();
                    String prenom = resultSet.getString("prenom").trim();
                    MembreInfo += nom.toUpperCase() + " " + prenom + ")";
                    System.out.println(MembreInfo);
                } else {
                    System.out.println("Aucun membre trouvé avec l'ID : " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération du membre avec l'ID : " + id);
        }

        return MembreInfo;
    }

    public HashMap<String, String> getMembreById(int memberId) {
        HashMap<String, String> memberDetails = new HashMap<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL avec une clause WHERE pour récupérer un seul membre par son ID
            String query = "SELECT * FROM membres WHERE id = ?";

            // Création de l'instruction SQL
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setInt(1, memberId); // Remplacer le premier paramètre par l'ID du membre
                // Exécution de la requête SQL
                ResultSet resultSet = pst.executeQuery();
                // S'il y a un résultat, stockez les détails du membre dans la HashMap
                if (resultSet.next()) {
                    memberDetails.put("id", String.valueOf(resultSet.getInt("id")));
                    memberDetails.put("num_civilite", resultSet.getString("num_civilite"));
                    memberDetails.put("nom", resultSet.getString("nom"));
                    memberDetails.put("prenom", resultSet.getString("prenom"));
                    memberDetails.put("email", resultSet.getString("email"));
                    memberDetails.put("badge", resultSet.getString("num_badge"));
                    memberDetails.put("adresse", resultSet.getString("adresse"));
                    memberDetails.put("tel", resultSet.getString("tel"));
                    memberDetails.put("cp", resultSet.getString("code_postal"));
                    memberDetails.put("ville", resultSet.getString("ville"));
                    memberDetails.put("dvm", resultSet.getString("date_vm"));
                    memberDetails.put("dvmv", resultSet.getString("validite_vm"));
                    memberDetails.put("sep", resultSet.getString("date_sep"));
                    memberDetails.put("sepv", resultSet.getString("validite_sep"));
                    memberDetails.put("cartf", resultSet.getString("carte_federale"));
                    memberDetails.put("attest", resultSet.getString("date_attestation"));
                    memberDetails.put("prof", resultSet.getString("profession"));
                    memberDetails.put("comm", resultSet.getString("commentaire"));
                    memberDetails.put("mdp", resultSet.getString("mdp"));
                    memberDetails.put("datenaiss", resultSet.getString("date_naissance"));
                    memberDetails.put("lieu", resultSet.getString("lieu_naissance"));
                    memberDetails.put("date_theorique_bb", resultSet.getString("date_theorique_bb"));
                    memberDetails.put("date_theorique_ppla", resultSet.getString("date_theorique_ppla"));
                    memberDetails.put("date_bb", resultSet.getString("date_bb"));
                    memberDetails.put("date_ppla", resultSet.getString("date_ppla"));
                    memberDetails.put("numero_bb", resultSet.getString("numero_bb"));
                    memberDetails.put("numero_ppla", resultSet.getString("numero_ppla"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberDetails;
    }

    public boolean MembreDel(int id) {
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "DELETE FROM membres WHERE id = ?";

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
    private Comptes comptes = new Comptes();

    //Fonction Ajout d'un membre qui reprends tout les paramètres pour l'ajouter  
    public boolean AddMembre(String num_civilite, String nom,
            String prenom, String adresse, String code_postal, String tel, String email,
            String commentaire, String num_badge, String ville, String date_vm, String validite_vm,
            String date_sep, String validite_sep, String carte_federale, String date_attestation,
            String mdp, String profession, String date_naissance,
            String lieu_naissance, String date_theorique_bb, String date_theorique_ppla,
            String date_bb, String date_ppla, String numero_bb, String numero_ppla,
            boolean membre_actif, boolean membre_inscrit) {

        System.out.println("Dans la fonction addMembre :");
        int civilite = CiviLite.FoundIdCivi(num_civilite);

        try (Connection conn = connect.getConnection()) {
            String query = "INSERT INTO MEMBRES (NUM_CIVILITE, NOM, PRENOM, "
                    + "ADRESSE, CODE_POSTAL, TEL, EMAIL, COMMENTAIRE, NUM_BADGE, VILLE, "
                    + "DATE_VM, VALIDITE_VM, DATE_SEP, VALIDITE_SEP, CARTE_FEDERALE, "
                    + "DATE_ATTESTATION, MDP, PROFESSION, DATE_NAISSANCE, LIEU_NAISSANCE, "
                    + "DATE_THEORIQUE_BB, DATE_THEORIQUE_PPLA, DATE_BB, DATE_PPLA, NUMERO_BB, "
                    + "NUMERO_PPLA, MEMBRE_ACTIF, MEMBRE_INSCRIT) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                java.sql.Date sqlDateVM = convertStringToDate(date_vm);
                java.sql.Date sqlDateValiditeVM = convertStringToDate(validite_vm);
                java.sql.Date sqlDateSEP = convertStringToDate(date_sep);
                java.sql.Date sqlDateValiditeSEP = convertStringToDate(validite_sep);
                java.sql.Date sqlDateAttestation = convertStringToDate(date_attestation);
                java.sql.Date sqlDateNaissance = convertStringToDate(date_naissance);
                java.sql.Date sqlDateTheoriqueBB = convertStringToDate(date_theorique_bb);
                java.sql.Date sqlDateTheoriquePPLA = convertStringToDate(date_theorique_ppla);
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
                pst.setString(18, profession);
                pst.setDate(19, sqlDateNaissance);
                pst.setString(20, lieu_naissance);
                pst.setDate(21, sqlDateTheoriqueBB);
                pst.setDate(22, sqlDateTheoriquePPLA);
                pst.setDate(23, sqlDateBB);
                pst.setDate(24, sqlDatePPLA);
                pst.setString(25, numero_bb);
                pst.setString(26, numero_ppla);
                pst.setBoolean(27, membre_actif);
                pst.setBoolean(28, membre_inscrit);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Membre ajouté avec succès.");
                    return true;
                } else {
                    System.out.println("Échec de l'ajout du membre.");
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

    //Fonction pour récupérer tout les membres par nom prénom dans un tableau pour afficher dans une combobox
    public String[] getMems() {
        List<String> memList = new ArrayList<>();
        try (Connection conn = connect.getConnection()) {
            // Création de la requête SQL pour supprimer un membre par son ID
            String query = "select nom, prenom from membres";

            try (java.sql.Statement st = conn.createStatement()) {
                try (ResultSet resultSet = st.executeQuery(query)) {
                    while (resultSet.next()) {
                        memList.add(resultSet.getString("nom").trim() + " " + resultSet.getString("prenom").trim());
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Convertir la liste en tableau de chaînes de caractères
        String[] memTab = new String[memList.size()];
        memTab = memList.toArray(memTab);

        // Retourner le tableau des membres
        return memTab;
    }

    public String getMemIdByNP(String nom, String prenom) {
        String MemInfo = "";
        try (Connection conn = connect.getConnection()) {
            String query = "SELECT id FROM membres WHERE nom = ? and prenom = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, nom);
                pst.setString(2, prenom);
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    MemInfo = resultSet.getString("id");
                } else {
                    System.out.println("Aucun membre trouvé avec les infos : " + nom + " " + prenom);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la récupération du membre avec les infos: " + nom + " " + prenom);
        }

        return MemInfo;
    }

    //Fonction pour avoir le nom et prenom d'un membre par son id
    public String getmemNPbyid(int id) {
        String civil = "";
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

    //Fonction update d'un membre qui reprends tout les paramètres pour l'ajouter  
    public boolean UpMembre(int id, String num_civilite, String nom,
            String prenom, String adresse, String code_postal, String tel, String email,
            String commentaire, String num_badge, String ville, String date_vm, String validite_vm,
            String date_sep, String validite_sep, String carte_federale, String date_attestation,
            String mdp, String profession, String date_naissance,
            String lieu_naissance, String date_theorique_bb, String date_theorique_ppla,
            String date_bb, String date_ppla, String numero_bb, String numero_ppla,
            boolean membre_actif, boolean membre_inscrit) {

        System.out.println("Dans la fonction addMembre :");
        int civilite = CiviLite.FoundIdCivi(num_civilite);

        try (Connection conn = connect.getConnection()) {
            String query = "UPDATE MEMBRES SET NUM_CIVILITE=?, NOM=?, PRENOM=?, "
                    + "ADRESSE=?, CODE_POSTAL=?, TEL=?, EMAIL=?, COMMENTAIRE=?, "
                    + "NUM_BADGE=?, VILLE=?, DATE_VM=?, VALIDITE_VM=?, DATE_SEP=?, "
                    + "VALIDITE_SEP=?, CARTE_FEDERALE=?, DATE_ATTESTATION=?, MDP=?, "
                    + "PROFESSION=?, DATE_NAISSANCE=?, LIEU_NAISSANCE=?, DATE_THEORIQUE_BB=?, "
                    + "DATE_THEORIQUE_PPLA=?, DATE_BB=?, DATE_PPLA=?, NUMERO_BB=?, "
                    + "NUMERO_PPLA=?, MEMBRE_ACTIF=?, MEMBRE_INSCRIT=? "
                    + "WHERE id=?;";

            try (PreparedStatement pst = conn.prepareStatement(query)) {
                java.sql.Date sqlDateVM = convertStringToDate(date_vm);
                java.sql.Date sqlDateValiditeVM = convertStringToDate(validite_vm);
                java.sql.Date sqlDateSEP = convertStringToDate(date_sep);
                java.sql.Date sqlDateValiditeSEP = convertStringToDate(validite_sep);
                java.sql.Date sqlDateAttestation = convertStringToDate(date_attestation);
                java.sql.Date sqlDateNaissance = convertStringToDate(date_naissance);
                java.sql.Date sqlDateTheoriqueBB = convertStringToDate(date_theorique_bb);
                java.sql.Date sqlDateTheoriquePPLA = convertStringToDate(date_theorique_ppla);
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
                pst.setString(18, profession);
                pst.setDate(19, sqlDateNaissance);
                pst.setString(20, lieu_naissance);
                pst.setDate(21, sqlDateTheoriqueBB);
                pst.setDate(22, sqlDateTheoriquePPLA);
                pst.setDate(23, sqlDateBB);
                pst.setDate(24, sqlDatePPLA);
                pst.setString(25, numero_bb);
                pst.setString(26, numero_ppla);
                pst.setBoolean(27, membre_actif);
                pst.setBoolean(28, membre_inscrit);
                pst.setInt(29, id);

                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Membre modifier avec succès.");
                    return true;

                } else {
                    System.out.println("Échec de la modification du membre.");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean authenticate(String email, String password) {
        try (Connection conn = connect.getConnection()) {
            boolean result = false;
            String query = "SELECT MEMBRE_INSCRIT FROM membres WHERE email = ? AND mdp = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, email);
                pst.setString(2, md5Hash(password));
                ResultSet resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    result = resultSet.getBoolean("MEMBRE_INSCRIT");
                    return result;
                }
                return result;
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
