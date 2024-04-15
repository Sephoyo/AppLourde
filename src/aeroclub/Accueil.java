/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aeroclub;

import Action.TableActionCellEditor;
import Action.TableActionCellRender;
import Action.TableActionEvent;
import SQL.Membres;
import SQL.Avions;
import SQL.Instructeurs;
import SQL.SeqVols;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author baert
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    private Membres mem = new Membres();
    private Avions av = new Avions();
    private Instructeurs instru = new Instructeurs();
    private SeqVols seq = new SeqVols();

    public Accueil() {
        initComponents();
        getContentPane().setLayout(null);
        //Ajout de la table membre pour le début en attendant lde faire la page de départ
        DefaultTableModel model = mem.getAllMembres();
        TableMembre.setModel(model);
        setupCustomTableColumnMembres();
        TableMembre.setRowHeight(50);
    }

    public void setupCustomTableColumnMembres() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new Edit(0, idInteger).setVisible(true);

            }

            @Override
            public void onDelete(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                //Création du message de suppresion
                Integer idInteger = (Integer) id;
                HashMap<String, String> Membre = mem.getMembreById(idInteger);
                String Message = "Vous voulez vraiment supprimer le membre : \n" + Membre.get("nom").toUpperCase() + " " + Membre.get("prenom") + " !";
                // Affichage du message de warning
                int choix = JOptionPane.showConfirmDialog(null, Message, "Attention vous êtes sur le point de supprimer un membre", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                // Vérification du choix de l'utilisateur
                if (choix == JOptionPane.YES_OPTION) {
                    boolean result = mem.MembreDel(idInteger);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Le membre à bien été supprimé !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel model = mem.getAllMembres();
                        TableMembre.setModel(model);
                        setupCustomTableColumnMembres();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression ! \n Contactez un administrateur ! ", "Attention", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                }

            }

            @Override
            public void onView(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new View(idInteger, 0).setVisible(true);
            }
        };
        TableMembre.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        TableMembre.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        TableMembre.setRowHeight(50);
    }

    public void setupCustomTableColumnAvions() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new Edit(1, idInteger).setVisible(true);

            }

            @Override
            public void onDelete(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                //Création du message de suppresion
                Integer idInteger = (Integer) id;
                HashMap<String, String> Avion = av.getAvById(idInteger);
                String Message = "Vous voulez vraiment supprimer l'avion  : \n" + Avion.get("type") + " !";
                // Affichage du message de warning
                int choix = JOptionPane.showConfirmDialog(null, Message, "Attention vous êtes sur le point de supprimer l'avion !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                // Vérification du choix de l'utilisateur
                if (choix == JOptionPane.YES_OPTION) {
                    boolean result = av.AvionDel(idInteger);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "L'avion à bien été supprimé !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel model = av.getAllAvions();
                        TableAvion.setModel(model);
                        setupCustomTableColumnAvions();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression ! \n Contactez un administrateur ! ", "Attention", JOptionPane.WARNING_MESSAGE);
                    }

                } else {

                }
            }

            @Override
            public void onView(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new View(idInteger, 1).setVisible(true);
            }
        };
        TableAvion.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        TableAvion.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        TableAvion.setRowHeight(50);
    }

    public void setupCustomTableColumnInstru() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new Edit(2, idInteger).setVisible(true);
            }

            @Override
            public void onDelete(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                //Création du message de suppresion
                Integer idInteger = (Integer) id;
                HashMap<String, String> Instru = instru.getInById(idInteger);
                String Message = "Vous voulez vraiment supprimer le membre : \n" + Instru.get("nom").toUpperCase() + " " + Instru.get("prenom") + " !";
                // Affichage du message de warning
                int choix = JOptionPane.showConfirmDialog(null, Message, "Attention vous êtes sur le point de supprimer l'instructeur !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                // Vérification du choix de l'utilisateur
                if (choix == JOptionPane.YES_OPTION) {
                    boolean result = instru.InstructeurDel(idInteger);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "L'instructeur à bien été supprimé !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel model = instru.getAllInstru();
                        TableInstru.setModel(model);
                        setupCustomTableColumnInstru();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression ! \n Contactez un administrateur ! ", "Attention", JOptionPane.WARNING_MESSAGE);
                    }

                } else {

                }

            }

            @Override
            public void onView(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new View(idInteger, 2).setVisible(true);
            }
        };
        TableInstru.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        TableInstru.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        TableInstru.setRowHeight(50);
    }

    public void setupCustomTableColumnSeqVol() {
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new Edit(3, idInteger).setVisible(true);
            }

            @Override
            public void onDelete(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                System.out.println(row + " et l'id : " + id);
                //Création du message de suppresion
                Integer idInteger = (Integer) id;
                HashMap<String, String> Seq = seq.getSeqById(idInteger);
                String Message = "Vous voulez vraiment supprimer la séquence  : \n" + Seq.get("num_seq") + " !";
                // Affichage du message de warning
                int choix = JOptionPane.showConfirmDialog(null, Message, "Attention vous êtes sur le point de supprimer un membre", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                // Vérification du choix de l'utilisateur
                if (choix == JOptionPane.YES_OPTION) {
                    boolean result = seq.SeqVolDel(idInteger);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "La séquence à bien été supprimé !", "Information", JOptionPane.INFORMATION_MESSAGE);
                        DefaultTableModel model = seq.getAllSeqVols();
                        TableSeqVols.setModel(model);
                        setupCustomTableColumnSeqVol();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur lors de la suppression ! \n Contactez un administrateur ! ", "Attention", JOptionPane.WARNING_MESSAGE);
                    }

                } else {

                }

            }

            @Override
            public void onView(int row, Object id) {
                System.out.println(row + " et l'id : " + id);
                Integer idInteger = (Integer) id;
                new View(idInteger, 3).setVisible(true);
            }
        };
        TableSeqVols.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        TableSeqVols.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        TableSeqVols.setRowHeight(50);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        instructeurs = new javax.swing.JButton();
        avions = new javax.swing.JButton();
        SeqVol = new javax.swing.JButton();
        membres = new javax.swing.JButton();
        Comptes = new javax.swing.JButton();
        ChoiceJtable = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        textmem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMembre = new javax.swing.JTable();
        AddMem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SearchMembre = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        textinstru = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableInstru = new javax.swing.JTable();
        AddInstru = new javax.swing.JButton();
        SearchInstru = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        textavion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableAvion = new javax.swing.JTable();
        AddAv = new javax.swing.JButton();
        SearchAv = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableSeqVols = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        AddSeq = new javax.swing.JButton();
        SearchSeq = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructeurs.setText("Instructeurs");
        instructeurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructeursActionPerformed(evt);
            }
        });

        avions.setText("Avions");
        avions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avionsActionPerformed(evt);
            }
        });

        SeqVol.setText("Seq Vols");
        SeqVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeqVolActionPerformed(evt);
            }
        });

        membres.setText("Membres");
        membres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membresActionPerformed(evt);
            }
        });

        Comptes.setText("Comptes");
        Comptes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComptesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comptes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(instructeurs, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(avions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SeqVol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(membres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(membres)
                .addGap(18, 18, 18)
                .addComponent(instructeurs)
                .addGap(18, 18, 18)
                .addComponent(avions)
                .addGap(18, 18, 18)
                .addComponent(SeqVol)
                .addGap(18, 18, 18)
                .addComponent(Comptes)
                .addContainerGap(263, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 630));

        textmem.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textmem.setText("Table des membres :");

        TableMembre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableMembre);

        AddMem.setText("Ajouter");
        AddMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemActionPerformed(evt);
            }
        });

        jLabel2.setText("Rechercher :");

        SearchMembre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchMembreActionPerformed(evt);
            }
        });
        SearchMembre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchMembreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(textmem)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchMembre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddMem)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textmem)
                        .addComponent(jLabel2)
                        .addComponent(SearchMembre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddMem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ChoiceJtable.addTab("tab1", jPanel6);

        textinstru.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textinstru.setText("Table des instructeurs :");

        TableInstru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableInstru);

        AddInstru.setText("Ajouter");
        AddInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInstruActionPerformed(evt);
            }
        });

        SearchInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchInstruActionPerformed(evt);
            }
        });
        SearchInstru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchInstruKeyReleased(evt);
            }
        });

        jLabel3.setText("Rechercher :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(textinstru)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchInstru, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddInstru)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(SearchInstru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textinstru))
                    .addComponent(AddInstru, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ChoiceJtable.addTab("tab2", jPanel7);

        textavion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        textavion.setText("Table des avions :");

        TableAvion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TableAvion);

        AddAv.setText("Ajouter");
        AddAv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAvActionPerformed(evt);
            }
        });

        SearchAv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAvActionPerformed(evt);
            }
        });
        SearchAv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchAvKeyReleased(evt);
            }
        });

        jLabel4.setText("Rechercher :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(textavion)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchAv, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddAv)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(SearchAv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textavion)
                        .addComponent(AddAv)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ChoiceJtable.addTab("tab3", jPanel8);

        TableSeqVols.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableSeqVols.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(TableSeqVols);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Table des sequences de vols :");

        AddSeq.setText("Ajouter");
        AddSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSeqActionPerformed(evt);
            }
        });

        SearchSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchSeqActionPerformed(evt);
            }
        });
        SearchSeq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchSeqKeyReleased(evt);
            }
        });

        jLabel5.setText("Rechercher :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddSeq)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(SearchSeq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1))
                    .addComponent(AddSeq, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ChoiceJtable.addTab("tab4", jPanel9);

        getContentPane().add(ChoiceJtable, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, -76, 940, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void instructeursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructeursActionPerformed
        // TODO add your handling code here:
        ChoiceJtable.setSelectedIndex(1);
        DefaultTableModel model = instru.getAllInstru();
        TableInstru.setModel(model);
        setupCustomTableColumnInstru();
    }//GEN-LAST:event_instructeursActionPerformed

    private void SeqVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeqVolActionPerformed
        // TODO add your handling code here:
        ChoiceJtable.setSelectedIndex(3);
        DefaultTableModel model = seq.getAllSeqVols();
        TableSeqVols.setModel(model);
        setupCustomTableColumnSeqVol();
    }//GEN-LAST:event_SeqVolActionPerformed

    private void membresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membresActionPerformed
        // TODO add your handling code here:
        ChoiceJtable.setSelectedIndex(0);
        DefaultTableModel model = mem.getAllMembres();
        TableMembre.setModel(model);
        setupCustomTableColumnMembres();
    }//GEN-LAST:event_membresActionPerformed

    private void avionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avionsActionPerformed
        // TODO add your handling code here:
        ChoiceJtable.setSelectedIndex(2);
        DefaultTableModel model = av.getAllAvions();
        TableAvion.setModel(model);
        setupCustomTableColumnAvions();
    }//GEN-LAST:event_avionsActionPerformed

    private void AddInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInstruActionPerformed
        // TODO add your handling code here:
        new Add(2).setVisible(true);
    }//GEN-LAST:event_AddInstruActionPerformed

    private void AddMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemActionPerformed
        // TODO add your handling code here:
        new Add(0).setVisible(true);
    }//GEN-LAST:event_AddMemActionPerformed

    private void AddSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSeqActionPerformed
        // TODO add your handling code here:
        new Add(3).setVisible(true);
    }//GEN-LAST:event_AddSeqActionPerformed

    private void AddAvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAvActionPerformed
        // TODO add your handling code here:
        new Add(1).setVisible(true);
    }//GEN-LAST:event_AddAvActionPerformed

    private void SearchMembreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchMembreActionPerformed

    }//GEN-LAST:event_SearchMembreActionPerformed

    private void SearchInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchInstruActionPerformed

    }//GEN-LAST:event_SearchInstruActionPerformed

    private void SearchAvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchAvActionPerformed

    private void SearchAvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchAvKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableAvion.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        TableAvion.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(SearchAv.getText()));
    }//GEN-LAST:event_SearchAvKeyReleased

    private void SearchInstruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchInstruKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableInstru.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        TableInstru.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(SearchInstru.getText()));
    }//GEN-LAST:event_SearchInstruKeyReleased

    private void SearchMembreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchMembreKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableMembre.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        TableMembre.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(SearchMembre.getText()));
    }//GEN-LAST:event_SearchMembreKeyReleased

    private void SearchSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSeqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchSeqActionPerformed

    private void SearchSeqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchSeqKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) TableSeqVols.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        TableSeqVols.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(SearchSeq.getText()));
    }//GEN-LAST:event_SearchSeqKeyReleased

    private void ComptesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComptesActionPerformed
        // TODO add your handling code here:
        new Compte().setVisible(true);
        
    }//GEN-LAST:event_ComptesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();
        Welcome wel = new Welcome();
        wel.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAv;
    private javax.swing.JButton AddInstru;
    private javax.swing.JButton AddMem;
    private javax.swing.JButton AddSeq;
    private javax.swing.JTabbedPane ChoiceJtable;
    private javax.swing.JButton Comptes;
    private javax.swing.JTextField SearchAv;
    private javax.swing.JTextField SearchInstru;
    private javax.swing.JTextField SearchMembre;
    private javax.swing.JTextField SearchSeq;
    private javax.swing.JButton SeqVol;
    private javax.swing.JTable TableAvion;
    private javax.swing.JTable TableInstru;
    private javax.swing.JTable TableMembre;
    private javax.swing.JTable TableSeqVols;
    private javax.swing.JButton avions;
    private javax.swing.JButton instructeurs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton membres;
    private javax.swing.JLabel textavion;
    private javax.swing.JLabel textinstru;
    private javax.swing.JLabel textmem;
    // End of variables declaration//GEN-END:variables
}
