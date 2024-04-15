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
    import java.util.HashMap;
    import javax.swing.table.DefaultTableModel;

    /**
     *
     * @author baert
     */
    public class SeqVols {

        private Avions av = new Avions();
        private Membres mem = new Membres();
        private Instructeurs instru = new Instructeurs();
        private Operation_compte opco = new Operation_compte();

        public DefaultTableModel getAllSeqVols() {
            // Déclaration du modèle de table
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Num Seq");
            model.addColumn("Id Instru");
            model.addColumn("Id Mem");
            model.addColumn("Id Av");
            model.addColumn("Action");

            // Connexion à la base de données
            try (Connection conn = connect.getConnection()) {
                // Création de la requête SQL
                String query = "SELECT * FROM seq_vol";
                // Création de l'instruction SQL
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    // Exécution de la requête SQL
                    ResultSet resultSet = pst.executeQuery();
                    // Parcours des résultats et ajout des membres au modèle de table
                    while (resultSet.next()) {
                        int id = resultSet.getInt("num_seq");
                        String in = resultSet.getString("id_in") + instru.getInstruById(Integer.parseInt(resultSet.getString("id_in")));
                        String instru = resultSet.getString("id_mem") + mem.getMemById(Integer.parseInt(resultSet.getString("id_mem")));
                        String avion = resultSet.getString("id_av") + av.getAvionById(Integer.parseInt(resultSet.getString("id_av")));
                        // Ajout des informations du membre au modèle de table
                        model.addRow(new Object[]{id, in, instru, avion});
                    }
                }
            } catch (SQLException e) {
                // Gestion des exceptions liées à la base de données
                e.printStackTrace();
            }
            return model; // Retourner le modèle de table avec les données
        }
        
        //fonction pour récuperer un model pour la visualisation du compte
        public DefaultTableModel getSeqByMemId(int id){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Num_Seq");
            model.addColumn("Heures");
            model.addColumn("Instruteur");
            // Connexion à la base de données
            try (Connection conn = connect.getConnection()) {
                // Création de la requête SQL
                String query = "SELECT * FROM SEQ_VOL WHERE id_mem= ?";
                // Création de l'instruction SQL
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    // Exécution de la requête SQL
                    pst.setInt(1,id);
                    ResultSet resultSet = pst.executeQuery();
                    // Parcours des résultats et ajout des membres au modèle de table
                    while (resultSet.next()) {
                        int id_seq = resultSet.getInt("num_seq");
                        int h = resultSet.getInt("temps");
                        String in = resultSet.getString("id_in") + instru.getInstruById(Integer.parseInt(resultSet.getString("id_in")));
                        // Ajout des informations du membre au modèle de table
                        model.addRow(new Object[]{id_seq,h,in});
                    }
                }
            } catch (SQLException e) {
                // Gestion des exceptions liées à la base de données
                e.printStackTrace();
            }
            return model;
        } 

        public HashMap<String, String> getSeqById(int seqvol) {
            HashMap<String, String> seqvolDetails = new HashMap<>();
            try (Connection conn = connect.getConnection()) {
                // Création de la requête SQL avec une clause WHERE pour récupérer un seul membre par son ID
                String query = "SELECT * FROM seq_vol WHERE num_seq = ?";
                // Création de l'instruction SQL
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setInt(1, seqvol); // Remplacer le premier paramètre par l'ID du membre
                    // Exécution de la requête SQL
                    ResultSet resultSet = pst.executeQuery();
                    // S'il y a un résultat, stockez les détails du membre dans la HashMap
                    if (resultSet.next()) {
                        seqvolDetails.put("num_seq", String.valueOf(resultSet.getInt("num_seq")));
                        seqvolDetails.put("id_in", resultSet.getString("id_in"));
                        seqvolDetails.put("id_mem", resultSet.getString("id_mem"));
                        seqvolDetails.put("id_av", resultSet.getString("id_av"));
                        seqvolDetails.put("date", resultSet.getString("date"));
                        seqvolDetails.put("temps", resultSet.getString("temps"));
                        seqvolDetails.put("heures_forfait", resultSet.getString("heures_forfait"));
                        seqvolDetails.put("prix_special", resultSet.getString("prix_special"));
                        seqvolDetails.put("taux", resultSet.getString("taux"));
                        seqvolDetails.put("reduction_semaine", resultSet.getString("reduction_semaine"));
                        seqvolDetails.put("motif", resultSet.getString("motif"));
                        seqvolDetails.put("taux_instructeur", resultSet.getString("taux_instructeur"));
                        seqvolDetails.put("forfait_initiation", resultSet.getString("forfait_initiation"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return seqvolDetails;
        }

        public boolean SeqVolDel(int id) {
            try (Connection conn = connect.getConnection()) {
                // Création de la requête SQL pour supprimer un membre par son ID
                String query = "DELETE FROM seq_vol WHERE num_seq = ?";

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

        public boolean AddSequenceVol(String id_in, String id_mem, String id_av,
                String date, String temps, String heuresForfait,
                String prixSpecial, String taux, String reductionSemaine,
                String motif, String tauxInstructeur, boolean forfaitInitiation) {

            System.out.println("Dans la fonction AddSequenceVol :");

            try (Connection conn = connect.getConnection()) {
                String query = "INSERT INTO SEQ_VOL (ID_IN, ID_MEM, ID_AV, DATE, TEMPS, HEURES_FORFAIT, "
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

        public boolean UpSequenceVol(int id,String id_in, String id_mem, String id_av,
                String date, String temps, String heuresForfait,
                String prixSpecial, String taux, String reductionSemaine,
                String motif, String tauxInstructeur, boolean forfaitInitiation) {

            System.out.println("Dans la fonction AddSequenceVol :");

            try (Connection conn = connect.getConnection()) {
                String query = "UPDATE SEQ_VOL SET ID_IN=?, ID_MEM=?, ID_AV=?, DATE=?, TEMPS=?, HEURES_FORFAIT=?, "
                    + "PRIX_SPECIAL=?, TAUX=?, REDUCTION_SEMAINE=?, MOTIF=?, TAUX_INSTRUCTEUR=?, FORFAIT_INITIATION=? "
                    + "WHERE num_seq=?";

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
                    pst.setInt(13, id);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Séquence de vol update avec succès.");
                        return true;
                    } else {
                        System.out.println("Échec de l'update de la séquence de vol.");
                        return false;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }
