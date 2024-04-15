/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aeroclub;

import SQL.Avions;
import SQL.Civilite;
import SQL.Instructeurs;
import SQL.Membres;
import SQL.Qualif;
import SQL.SeqVols;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author joseph
 */
public class Edit extends javax.swing.JFrame {

    /**
     * Creates new form Edit
     */
    private static int id;
    private static int Viewer;
    private Membres mem = new Membres();
    private Avions av = new Avions();
    private Instructeurs instru = new Instructeurs();
    private SeqVols seq = new SeqVols();
    private Qualif qualif = new Qualif();
    private Civilite civi = new Civilite();

    public Edit(int Viewer, int id) {
        this.id = id;
        initComponents();
        String[] civilites = civi.getCivil();
        for (String civilite : civilites) {
            ListeQualif.addItem(civilite);
            CiviliteInstru.addItem(civilite);
        }
        String[] avions = av.getAvions();
        String[] instructeurs = instru.getInstrus();
        String[] membres = mem.getMems();
        for (String avion : avions) {
            avT.addItem(avion.trim());
        }
        for (String membre : membres) {
            memT.addItem(membre.trim());
        }
        for (String instructeur : instructeurs) {
            inT.addItem(instructeur.trim());
        }

        switch (Viewer) {
            case 0:
                Affichage.setSelectedIndex(0);
                System.out.println("Membres");
                HashMap<String, String> Membre = mem.getMembreById(id);
                AppendMem(Membre);
                break;
            case 1:
                Affichage.setSelectedIndex(2);
                System.out.println("Avions");
                HashMap<String, String> Avion = av.getAvById(id);
                AppendAvion(Avion);
                break;
            case 2:
                Affichage.setSelectedIndex(3);
                System.out.println("Instructeurs");
                HashMap<String, String> Instru = instru.getInById(id);
                AppendInstructeur(Instru);
                break;
            case 3:
                Affichage.setSelectedIndex(1);
                System.out.println("SeqVols");
                HashMap<String, String> SeqVol = seq.getSeqById(id);
                AppendSeqVol(SeqVol);
                break;
        }
    }

    private void AppendMem(HashMap<String, String> membre) {
        String npm = civi.getCivilByid(Integer.parseInt(membre.get("num_civilite")));
        //Selection du jComboBox de civbilite pour qu'il corresponde aux membres actuel
        for (int i = 0; i < ListeQualif.getItemCount(); i++) {
            if (ListeQualif.getItemAt(i).equals(npm)) {
                ListeQualif.setSelectedIndex(i);
                break;
            }
        }
        prenomt.setText(membre.get("prenom").trim());
        nomt.setText(membre.get("nom").trim());
        cartft.setText(membre.get("cartf").trim());
        badget.setText(membre.get("badge").trim());
        adt.setText(membre.get("adresse").trim());
        telt.setText(membre.get("tel").trim());
        cpt.setText(membre.get("cp").trim());
        villet.setText(membre.get("ville").trim());
        vmt.setText(membre.get("dvm").trim());
        vmvt.setText(membre.get("dvmv").trim());
        sept.setText(membre.get("sep").trim());
        sepvt.setText(membre.get("sepv").trim());
        attestt.setText(membre.get("attest").trim());
        proft.setText(membre.get("prof").trim());
        emailt.setText(membre.get("email").trim());
        commt.setText(membre.get("comm").trim());
        mdpt.setText(membre.get("mdp").trim());
        datent.setText(membre.get("datenaiss").trim());
        Lieut.setText(membre.get("lieu").trim());
        bbmtht.setText(membre.get("date_theorique_bb") != null ? membre.get("date_theorique_bb").trim() : "");
        pplatht.setText(membre.get("date_theorique_ppla") != null ? membre.get("date_theorique_ppla").trim() : "");
        dateBBmt.setText(membre.get("date_bb") != null ? membre.get("date_bb").trim() : "");
        datePPLAmt.setText(membre.get("date_ppla") != null ? membre.get("date_ppla").trim() : "");
        numBBmt.setText(membre.get("numero_bb") != null ? membre.get("numero_bb").trim() : "");
        numPPLAmt.setText(membre.get("numero_ppla") != null ? membre.get("numero_ppla").trim() : "");

    }

    private void AppendSeqVol(HashMap<String, String> seqvols) {
        String instruc = instru.getinsNPbyid(Integer.parseInt(seqvols.get("id_in")));
        //Selection du jComboBox de civbilite pour qu'il corresponde à l'instructeur
        for (int i = 0; i < inT.getItemCount(); i++) {
            if (inT.getItemAt(i).equals(instruc)) {
                inT.setSelectedIndex(i);
                break;
            }
        }
        String memb = mem.getmemNPbyid(Integer.parseInt(seqvols.get("id_mem")));
        //Selection du jComboBox pour qu'il corresponde au membre actuel
        for (int i = 0; i < memT.getItemCount(); i++) {
            if (memT.getItemAt(i).equals(memb)) {
                memT.setSelectedIndex(i);
                break;
            }
        }
        String avion = av.getAvionTypeByid(Integer.parseInt(seqvols.get("id_av")));
        //Selection du jComboBox de civbilite pour qu'il corresponde a l'avion
        for (int i = 0; i < avT.getItemCount(); i++) {
            if (avT.getItemAt(i).equals(avion)) {
                avT.setSelectedIndex(i);
                break;
            }
        }
        datet.setText(seqvols.get("date").trim());
        tempst.setText(seqvols.get("temps").trim());
        hft.setText(seqvols.get("heures_forfait").trim());
        pst.setText(seqvols.get("prix_special").trim());
        tauxt.setText(seqvols.get("taux").trim());
        redst.setText(seqvols.get("reduction_semaine").trim());
        motift.setText(seqvols.get("motif").trim());
        tit.setText(seqvols.get("taux_instructeur").trim());
        System.out.println(seqvols.get("forfait_initiation"));
        if ("t".equals(seqvols.get("forfait_initiation"))) {
            fit.setSelected(true);
        } else {
            fit.setSelected(false);
        }
    }

    private void AppendAvion(HashMap<String, String> avion) {
        typet.setText(avion.get("type").trim());
        txt.setText(avion.get("taux").trim());
        f1t.setText(avion.get("forfait1").trim());
        h1t.setText(avion.get("heures_forfait1").trim());
        f2t.setText(avion.get("forfait2").trim());
        h2t.setText(avion.get("heures_forfait2").trim());
        f3t.setText(avion.get("forfait3").trim());
        h3t.setText(avion.get("heures_forfait3").trim());
        rdst.setText(avion.get("reduction_semaine").trim());
        immt.setText(avion.get("immatriculation").trim());
    }

    private void AppendInstructeur(HashMap<String, String> instru) {
        String npm = civi.getCivilByid(Integer.parseInt(instru.get("num_civilite")));
        //Selection du jComboBox de civilite pour qu'il corresponde a l'instructeur actuel
        for (int i = 0; i < CiviliteInstru.getItemCount(); i++) {
            if (CiviliteInstru.getItemAt(i).equals(npm)) {
                CiviliteInstru.setSelectedIndex(i);
                break;
            }
        }
        prenomit.setText(instru.get("prenom").trim());
        nomit.setText(instru.get("nom").trim());
        adit.setText(instru.get("adresse").trim());
        cpit.setText(instru.get("cp").trim());
        telit.setText(instru.get("tel").trim());
        emailit.setText(instru.get("email").trim());
        badgeit.setText(instru.get("badge").trim());
        villeit.setText(instru.get("ville").trim());
        vmit.setText(instru.get("date_vm").trim());
        vmvit.setText(instru.get("validite_vm").trim());
        sepit.setText(instru.get("date_sep").trim());
        sepvit.setText(instru.get("validite_sep").trim());
        cartfit.setText(instru.get("carte_federale").trim());
        attestit.setText(instru.get("date_attestation").trim());
        faxit.setText(instru.get("fax").trim());
        pplait.setText(instru.get("date_ppla").trim());
        npplait.setText(instru.get("numero_ppla").trim());
        bbit.setText(instru.get("date_bb").trim());
        nbbit.setText(instru.get("numero_bb").trim());
        tiit.setText(instru.get("taux_instructeur").trim());
        commit.setText(instru.get("taux_instructeur").trim());
        mdpit.setText(instru.get("mdp").trim());
    }

    private boolean MemEmpty() {
        //Manque num qualif
        if (nomt.getText().isEmpty() || prenomt.getText().isEmpty()
                || badget.getText().isEmpty() || proft.getText().isEmpty()
                || adt.getText().isEmpty() || cpt.getText().isEmpty()
                || villet.getText().isEmpty() || commt.getText().isEmpty()
                || vmt.getText().isEmpty() || vmvt.getText().isEmpty()
                || sept.getText().isEmpty() || sepvt.getText().isEmpty()
                || mdpt.getText().isEmpty() || cartft.getText().isEmpty()
                || attestt.getText().isEmpty() || datent.getText().isEmpty()
                || Lieut.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean InstruEmpty() {
        //Manque num qualif
        if (nomit.getText().isEmpty() || prenomit.getText().isEmpty()
                || badgeit.getText().isEmpty() || faxit.getText().isEmpty()
                || adit.getText().isEmpty() || cpit.getText().isEmpty()
                || villeit.getText().isEmpty() || emailit.getText().isEmpty()
                || vmit.getText().isEmpty() || vmvit.getText().isEmpty()
                || sepit.getText().isEmpty() || sepvit.getText().isEmpty()
                || mdpit.getText().isEmpty() || cartfit.getText().isEmpty()
                || attestit.getText().isEmpty() || tiit.getText().isEmpty()
                || faxit.getText().isEmpty() || telit.getText().isEmpty()
                || nbbit.getText().isEmpty() || npplait.getText().isEmpty()
                || bbit.getText().isEmpty() || pplait.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean AvionEmpty() {
        //Manque num qualif
        if (typet.getText().isEmpty() || txt.getText().isEmpty()
                || f1t.getText().isEmpty() || h1t.getText().isEmpty()
                || f2t.getText().isEmpty() || h2t.getText().isEmpty()
                || f3t.getText().isEmpty() || h3t.getText().isEmpty()
                || rdst.getText().isEmpty() || immt.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean SeqVolEmpty() {
        //Manque num qualif
        if (datet.getText().isEmpty() || tempst.getText().isEmpty()
                || hft.getText().isEmpty() || pst.getText().isEmpty()
                || tauxt.getText().isEmpty() || redst.getText().isEmpty()
                || motift.getText().isEmpty() || tit.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePPLAthM = new date.DateChooser();
        dateBBM = new date.DateChooser();
        datePPLAM = new date.DateChooser();
        dateBBthM = new date.DateChooser();
        dateNaissanceMembre = new date.DateChooser();
        VmMembre = new date.DateChooser();
        InstruSep = new date.DateChooser();
        InstruVmv = new date.DateChooser();
        InstruVm = new date.DateChooser();
        DateAttestastionMembre = new date.DateChooser();
        SepVMembre = new date.DateChooser();
        SepMembre = new date.DateChooser();
        VmvaliditeMembre = new date.DateChooser();
        InstruSepv = new date.DateChooser();
        InstruBb = new date.DateChooser();
        InstruPpla = new date.DateChooser();
        InstruAttest = new date.DateChooser();
        DateSeq = new date.DateChooser();
        Affichage = new javax.swing.JTabbedPane();
        MembreDet = new javax.swing.JPanel();
        prenoml = new javax.swing.JLabel();
        prenomt = new javax.swing.JTextField();
        noml = new javax.swing.JLabel();
        nomt = new javax.swing.JTextField();
        badgel = new javax.swing.JLabel();
        badget = new javax.swing.JTextField();
        adl = new javax.swing.JLabel();
        adt = new javax.swing.JTextField();
        cpl = new javax.swing.JLabel();
        cpt = new javax.swing.JTextField();
        villel = new javax.swing.JLabel();
        villet = new javax.swing.JTextField();
        emaill = new javax.swing.JLabel();
        emailt = new javax.swing.JTextField();
        tell = new javax.swing.JLabel();
        telt = new javax.swing.JTextField();
        vml = new javax.swing.JLabel();
        vmt = new javax.swing.JTextField();
        vmvl = new javax.swing.JLabel();
        vmvt = new javax.swing.JTextField();
        sepl = new javax.swing.JLabel();
        sept = new javax.swing.JTextField();
        sepvl = new javax.swing.JLabel();
        sepvt = new javax.swing.JTextField();
        cartfl = new javax.swing.JLabel();
        cartft = new javax.swing.JTextField();
        attestl = new javax.swing.JLabel();
        attestt = new javax.swing.JTextField();
        profl = new javax.swing.JLabel();
        proft = new javax.swing.JTextField();
        AddMem = new javax.swing.JButton();
        AnnulerMem = new javax.swing.JButton();
        civilitél = new javax.swing.JLabel();
        ListeQualif = new javax.swing.JComboBox<>();
        comml = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commt = new javax.swing.JTextArea();
        mdpl = new javax.swing.JLabel();
        mdpt = new javax.swing.JPasswordField();
        datenl = new javax.swing.JLabel();
        datent = new javax.swing.JTextField();
        Lieul = new javax.swing.JLabel();
        Lieut = new javax.swing.JTextField();
        bbmthl = new javax.swing.JLabel();
        pplathl = new javax.swing.JLabel();
        bbmtht = new javax.swing.JTextField();
        pplatht = new javax.swing.JTextField();
        dateBBml = new javax.swing.JLabel();
        datePPLAml = new javax.swing.JLabel();
        dateBBmt = new javax.swing.JTextField();
        datePPLAmt = new javax.swing.JTextField();
        numBBml = new javax.swing.JLabel();
        numPPLAml = new javax.swing.JLabel();
        numBBmt = new javax.swing.JTextField();
        numPPLAmt = new javax.swing.JTextField();
        SeqVolsDet = new javax.swing.JPanel();
        inl = new javax.swing.JLabel();
        meml = new javax.swing.JLabel();
        avl = new javax.swing.JLabel();
        datel = new javax.swing.JLabel();
        datet = new javax.swing.JTextField();
        tempsl = new javax.swing.JLabel();
        tempst = new javax.swing.JTextField();
        hfl = new javax.swing.JLabel();
        hft = new javax.swing.JTextField();
        psl = new javax.swing.JLabel();
        pst = new javax.swing.JTextField();
        tauxl = new javax.swing.JLabel();
        tauxt = new javax.swing.JTextField();
        redsl = new javax.swing.JLabel();
        redst = new javax.swing.JTextField();
        motifl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        motift = new javax.swing.JTextArea();
        til = new javax.swing.JLabel();
        tit = new javax.swing.JTextField();
        fil = new javax.swing.JLabel();
        fit = new javax.swing.JCheckBox();
        AnnulerSeq = new javax.swing.JButton();
        AddSeq = new javax.swing.JButton();
        memT = new javax.swing.JComboBox<>();
        avT = new javax.swing.JComboBox<>();
        inT = new javax.swing.JComboBox<>();
        AvionDet = new javax.swing.JPanel();
        typel = new javax.swing.JLabel();
        typet = new javax.swing.JTextField();
        txl = new javax.swing.JLabel();
        txt = new javax.swing.JTextField();
        f1l = new javax.swing.JLabel();
        f1t = new javax.swing.JTextField();
        h1l = new javax.swing.JLabel();
        h1t = new javax.swing.JTextField();
        f2l = new javax.swing.JLabel();
        f2t = new javax.swing.JTextField();
        h2l = new javax.swing.JLabel();
        h2t = new javax.swing.JTextField();
        f3l = new javax.swing.JLabel();
        f3t = new javax.swing.JTextField();
        h3l = new javax.swing.JLabel();
        h3t = new javax.swing.JTextField();
        rdsl = new javax.swing.JLabel();
        rdst = new javax.swing.JTextField();
        imml = new javax.swing.JLabel();
        immt = new javax.swing.JTextField();
        AnnulerAv = new javax.swing.JButton();
        AddAv = new javax.swing.JButton();
        InstructeurDet = new javax.swing.JPanel();
        prenomil = new javax.swing.JLabel();
        prenomit = new javax.swing.JTextField();
        nomil = new javax.swing.JLabel();
        nomit = new javax.swing.JTextField();
        badgeil = new javax.swing.JLabel();
        badgeit = new javax.swing.JTextField();
        adil = new javax.swing.JLabel();
        adit = new javax.swing.JTextField();
        cpil = new javax.swing.JLabel();
        cpit = new javax.swing.JTextField();
        villeil = new javax.swing.JLabel();
        villeit = new javax.swing.JTextField();
        emailil = new javax.swing.JLabel();
        emailit = new javax.swing.JTextField();
        telil = new javax.swing.JLabel();
        telit = new javax.swing.JTextField();
        vmil = new javax.swing.JLabel();
        vmit = new javax.swing.JTextField();
        vmvil = new javax.swing.JLabel();
        vmvit = new javax.swing.JTextField();
        sepil = new javax.swing.JLabel();
        sepit = new javax.swing.JTextField();
        sepvil = new javax.swing.JLabel();
        sepvit = new javax.swing.JTextField();
        cartfil = new javax.swing.JLabel();
        cartfit = new javax.swing.JTextField();
        attestil = new javax.swing.JLabel();
        attestit = new javax.swing.JTextField();
        tiil = new javax.swing.JLabel();
        tiit = new javax.swing.JTextField();
        faxil = new javax.swing.JLabel();
        faxit = new javax.swing.JTextField();
        bbil = new javax.swing.JLabel();
        bbit = new javax.swing.JTextField();
        nbbil = new javax.swing.JLabel();
        nbbit = new javax.swing.JTextField();
        pplal = new javax.swing.JLabel();
        pplait = new javax.swing.JTextField();
        npplail = new javax.swing.JLabel();
        npplait = new javax.swing.JTextField();
        AnnulerInstru = new javax.swing.JButton();
        AddInstru = new javax.swing.JButton();
        mdpit = new javax.swing.JPasswordField();
        mdpil = new javax.swing.JLabel();
        CiviliteInstru = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        commit = new javax.swing.JTextArea();
        commil = new javax.swing.JLabel();

        datePPLAthM.setDateFormat("yyyy-MM-dd");
        datePPLAthM.setTextRefernceWD(pplatht);

        dateBBM.setDateFormat("yyyy-MM-dd");
        dateBBM.setTextRefernceWD(dateBBmt);

        datePPLAM.setDateFormat("yyyy-MM-dd");
        datePPLAM.setTextRefernceWD(datePPLAmt);

        dateBBthM.setDateFormat("yyyy-MM-dd");
        dateBBthM.setTextRefernceWD(bbmtht);

        dateNaissanceMembre.setDateFormat("yyyy-MM-dd");
        dateNaissanceMembre.setTextRefernceWD(datent);

        VmMembre.setDateFormat("yyyy-MM-dd");
        VmMembre.setTextRefernceWD(vmt);

        InstruSep.setDateFormat("yyyy-MM-dd");
        InstruSep.setTextRefernceWD(sepit);

        InstruVmv.setDateFormat("yyyy-MM-dd");
        InstruVmv.setTextRefernceWD(vmvit);

        InstruVm.setDateFormat("yyyy-MM-dd");
        InstruVm.setTextRefernceWD(vmit);

        DateAttestastionMembre.setDateFormat("yyyy-MM-dd");
        DateAttestastionMembre.setTextRefernceWD(attestt);

        SepVMembre.setDateFormat("yyyy-MM-dd");
        SepVMembre.setTextRefernceWD(sepvt);

        SepMembre.setDateFormat("yyyy-MM-dd");
        SepMembre.setTextRefernceWD(sept);

        VmvaliditeMembre.setDateFormat("yyyy-MM-dd");
        VmvaliditeMembre.setTextRefernceWD(vmvt);

        InstruSepv.setDateFormat("yyyy-MM-dd");
        InstruSepv.setTextRefernceWD(sepvit);

        InstruBb.setDateFormat("yyyy-MM-dd");
        InstruBb.setTextRefernceWD(bbit);

        InstruPpla.setDateFormat("yyyy-MM-dd");
        InstruPpla.setTextRefernceWD(pplait);

        InstruAttest.setDateFormat("yyyy-MM-dd");
        InstruAttest.setTextRefernceWD(attestit);

        DateSeq.setDateFormat("yyyy-MM-dd");
        DateSeq.setTextRefernceWD(datet);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prenoml.setText("Prenom :");

        noml.setText("Nom :");

        badgel.setText("Badge :");

        adl.setText("Adresse :");

        cpl.setText("CP :");

        villel.setText("Ville :");

        emaill.setText("Email :");

        tell.setText("Tel :");

        vml.setText("Date VM :");

        vmvl.setText("Validité VM :");

        sepl.setText("Date SEP :");

        sepvl.setText("Validité SEP :");

        cartfl.setText("Carte fédérale :");

        attestl.setText("Date attestation :");

        profl.setText("Profession :");

        AddMem.setText("Modifier");
        AddMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemActionPerformed(evt);
            }
        });

        AnnulerMem.setText("Annuler");
        AnnulerMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerMemActionPerformed(evt);
            }
        });

        civilitél.setText("Civilité :");

        ListeQualif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeQualifActionPerformed(evt);
            }
        });

        comml.setText("Commentaire :");

        commt.setColumns(20);
        commt.setRows(5);
        jScrollPane2.setViewportView(commt);

        mdpl.setText("Mot de passe :");

        datenl.setText("Date de naissance :");

        Lieul.setText("Lieu :");

        bbmthl.setText("Date théorique :");

        pplathl.setText("Date théorique :");

        dateBBml.setText("Date BB :");

        datePPLAml.setText("Date PPLA :");

        numBBml.setText("Numéro BB :");

        numPPLAml.setText("Numéro PPLA :");

        javax.swing.GroupLayout MembreDetLayout = new javax.swing.GroupLayout(MembreDet);
        MembreDet.setLayout(MembreDetLayout);
        MembreDetLayout.setHorizontalGroup(
            MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MembreDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addComponent(adl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(villel))
                            .addComponent(comml, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(villet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(MembreDetLayout.createSequentialGroup()
                            .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                    .addComponent(cartfl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cartft, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(attestl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(attestt))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                    .addComponent(vml)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(vmt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(vmvl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(vmvt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sepl)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sept, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sepvl)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sepvt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MembreDetLayout.createSequentialGroup()
                            .addComponent(AnnulerMem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddMem)))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addComponent(civilitél)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ListeQualif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mdpl))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addComponent(prenoml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prenomt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(noml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(badgel))
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(mdpt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datenl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(badget, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(profl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proft, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(datent, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lieul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Lieut, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(pplathl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pplatht))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(bbmthl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bbmtht, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(dateBBml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateBBmt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numBBml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numBBmt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(datePPLAml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePPLAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numPPLAml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numPPLAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                            .addComponent(emaill)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tell)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(telt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        MembreDetLayout.setVerticalGroup(
            MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MembreDetLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(civilitél)
                    .addComponent(ListeQualif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mdpl)
                    .addComponent(mdpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datenl)
                    .addComponent(datent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lieul)
                    .addComponent(Lieut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenoml)
                    .addComponent(prenomt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noml)
                    .addComponent(nomt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgel)
                    .addComponent(badget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profl)
                    .addComponent(proft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adl)
                    .addComponent(adt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpl)
                    .addComponent(cpt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(villel)
                    .addComponent(villet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emaill)
                    .addComponent(emailt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tell)
                    .addComponent(telt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comml)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vml)
                    .addComponent(vmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vmvl)
                    .addComponent(vmvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sepl)
                    .addComponent(sept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sepvl)
                    .addComponent(sepvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cartfl)
                    .addComponent(cartft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attestl)
                    .addComponent(attestt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbmthl)
                    .addComponent(bbmtht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateBBml)
                    .addComponent(dateBBmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numBBml)
                    .addComponent(numBBmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pplathl)
                    .addComponent(pplatht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePPLAml)
                    .addComponent(datePPLAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numPPLAml)
                    .addComponent(numPPLAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddMem, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AnnulerMem, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Affichage.addTab("tab1", MembreDet);

        inl.setText("Instructeur :");

        meml.setText("Membre :");

        avl.setText("Avion :");

        datel.setText("Date :");

        tempsl.setText("Temps :");

        hfl.setText("Heures Forfait :");

        psl.setText("Prix spécial :");

        tauxl.setText("Taux :");

        tauxt.setEditable(false);

        redsl.setText("Réduc.Semaine :");

        redst.setEditable(false);

        motifl.setText("Motif :");

        motift.setColumns(20);
        motift.setRows(5);
        jScrollPane1.setViewportView(motift);

        til.setText("Taux Instructeur :");

        tit.setEditable(false);

        fil.setText("Forfait initiation :");

        AnnulerSeq.setText("Quiter");
        AnnulerSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerSeqActionPerformed(evt);
            }
        });

        AddSeq.setText("Modifier");
        AddSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSeqActionPerformed(evt);
            }
        });

        avT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avTActionPerformed(evt);
            }
        });

        inT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeqVolsDetLayout = new javax.swing.GroupLayout(SeqVolsDet);
        SeqVolsDet.setLayout(SeqVolsDetLayout);
        SeqVolsDetLayout.setHorizontalGroup(
            SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeqVolsDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SeqVolsDetLayout.createSequentialGroup()
                        .addComponent(AnnulerSeq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddSeq))
                    .addGroup(SeqVolsDetLayout.createSequentialGroup()
                        .addGap(0, 48, Short.MAX_VALUE)
                        .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(inl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(meml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memT, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avT, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(datel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tempsl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tempst, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(hfl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hft, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(psl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pst, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tauxl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tauxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redsl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redst, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(til)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fit))
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(motifl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41))
        );
        SeqVolsDetLayout.setVerticalGroup(
            SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeqVolsDetLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inl)
                    .addComponent(meml)
                    .addComponent(avl)
                    .addComponent(memT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datel)
                    .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tempsl)
                    .addComponent(tempst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hfl)
                    .addComponent(hft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(psl)
                    .addComponent(pst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tauxl)
                    .addComponent(tauxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redsl)
                    .addComponent(redst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(motifl)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(til)
                    .addComponent(tit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fil)
                    .addComponent(fit))
                .addGap(18, 18, 18)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnnulerSeq)
                    .addComponent(AddSeq))
                .addGap(48, 48, 48))
        );

        Affichage.addTab("tab2", SeqVolsDet);

        typel.setText("Type :");

        txl.setText("Taux :");

        f1l.setText("Forfait 1 :");

        h1l.setText("Heures :");

        f2l.setText("Forfait 2 :");

        h2l.setText("Heures :");

        f3l.setText("Forfait 3 :");

        h3l.setText("Heures :");

        rdsl.setText("Réduction semaine :");

        imml.setText("Immatriculation :");

        immt.setEditable(false);

        AnnulerAv.setText("Quitter");
        AnnulerAv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerAvActionPerformed(evt);
            }
        });

        AddAv.setText("Modifier");
        AddAv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AvionDetLayout = new javax.swing.GroupLayout(AvionDet);
        AvionDet.setLayout(AvionDetLayout);
        AvionDetLayout.setHorizontalGroup(
            AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvionDetLayout.createSequentialGroup()
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(AvionDetLayout.createSequentialGroup()
                            .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(f1l, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AvionDetLayout.createSequentialGroup()
                                    .addComponent(f2l)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(f2t, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h2l)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(AvionDetLayout.createSequentialGroup()
                                    .addComponent(h1l)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(h1t))
                                .addGroup(AvionDetLayout.createSequentialGroup()
                                    .addComponent(h2t, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(AvionDetLayout.createSequentialGroup()
                            .addComponent(f3l)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(f3t, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(h3l)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(h3t, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AvionDetLayout.createSequentialGroup()
                            .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(f1t, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AvionDetLayout.createSequentialGroup()
                                    .addComponent(typel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(typet, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txl)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AvionDetLayout.createSequentialGroup()
                        .addComponent(rdsl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdst, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(immt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 369, Short.MAX_VALUE))
            .addGroup(AvionDetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnnulerAv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddAv)
                .addGap(146, 146, 146))
        );
        AvionDetLayout.setVerticalGroup(
            AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AvionDetLayout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typel)
                    .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txl)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(f1l)
                        .addComponent(h1l)
                        .addComponent(h1t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(f1t, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f2l)
                    .addComponent(f2t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h2l)
                    .addComponent(h2t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f3l)
                    .addComponent(f3t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h3l)
                    .addComponent(h3t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdsl)
                    .addComponent(rdst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imml)
                    .addComponent(immt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnnulerAv)
                    .addComponent(AddAv))
                .addGap(138, 138, 138))
        );

        Affichage.addTab("tab3", AvionDet);

        prenomil.setText("Prenom :");

        nomil.setText("Nom :");

        badgeil.setText("Badge :");

        adil.setText("Adresse :");

        cpil.setText("CP :");

        villeil.setText("Ville :");

        emailil.setText("Email :");

        telil.setText("Tel :");

        vmil.setText("Date VM :");

        vmvil.setText("Validité VM :");

        sepil.setText("Date SEP :");

        sepvil.setText("Validité SEP :");

        cartfil.setText("Carte fédérale :");

        attestil.setText("Date attestation :");

        tiil.setText("Taux de l'instructeur :");

        faxil.setText("Fax :");

        bbil.setText("Date BB :");

        nbbil.setText("Numéro BB :");

        pplal.setText("Date PPLA :");

        npplail.setText("Numéro PPLA :");

        AnnulerInstru.setText("Quiter");
        AnnulerInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerInstruActionPerformed(evt);
            }
        });

        AddInstru.setText("Modifier");
        AddInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInstruActionPerformed(evt);
            }
        });

        mdpil.setText("Mot de passe :");

        jLabel1.setText("Civilite :");

        commit.setColumns(20);
        commit.setRows(5);
        jScrollPane3.setViewportView(commit);

        commil.setText("Commentaire : ");

        javax.swing.GroupLayout InstructeurDetLayout = new javax.swing.GroupLayout(InstructeurDet);
        InstructeurDet.setLayout(InstructeurDetLayout);
        InstructeurDetLayout.setHorizontalGroup(
            InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InstructeurDetLayout.createSequentialGroup()
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InstructeurDetLayout.createSequentialGroup()
                                    .addComponent(pplal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pplait, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(npplail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(npplait))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InstructeurDetLayout.createSequentialGroup()
                                    .addComponent(bbil)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(bbit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nbbil)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nbbit, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(InstructeurDetLayout.createSequentialGroup()
                                .addComponent(tiil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(InstructeurDetLayout.createSequentialGroup()
                                    .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(InstructeurDetLayout.createSequentialGroup()
                                            .addComponent(emailil)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(emailit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(telil)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(telit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(94, 94, 94))
                                        .addGroup(InstructeurDetLayout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(mdpil)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mdpit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(commil)
                                            .addGap(18, 18, 18)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(InstructeurDetLayout.createSequentialGroup()
                                    .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(InstructeurDetLayout.createSequentialGroup()
                                            .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InstructeurDetLayout.createSequentialGroup()
                                                    .addComponent(cartfil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cartfit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(attestil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(attestit))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InstructeurDetLayout.createSequentialGroup()
                                                    .addComponent(vmil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(vmit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(vmvil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(vmvit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(sepil))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, InstructeurDetLayout.createSequentialGroup()
                                                    .addComponent(adil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(adit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpil)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cpit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(villeil)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(villeit)
                                                .addComponent(sepit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sepvil))
                                        .addComponent(AnnulerInstru))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AddInstru)
                                        .addComponent(sepvit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InstructeurDetLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(prenomil))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InstructeurDetLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InstructeurDetLayout.createSequentialGroup()
                                .addComponent(prenomit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(badgeil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(badgeit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CiviliteInstru, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        InstructeurDetLayout.setVerticalGroup(
            InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InstructeurDetLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CiviliteInstru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomil)
                    .addComponent(prenomit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomil)
                    .addComponent(nomit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(badgeil)
                    .addComponent(badgeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adil)
                    .addComponent(adit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpil)
                    .addComponent(cpit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(villeil)
                    .addComponent(villeit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailil)
                            .addComponent(emailit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telil)
                            .addComponent(telit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mdpit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mdpil)
                            .addComponent(commil))
                        .addGap(44, 44, 44)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vmil)
                            .addComponent(vmit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vmvil)
                            .addComponent(vmvit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sepil)
                            .addComponent(sepit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sepvil)
                            .addComponent(sepvit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cartfil)
                            .addComponent(cartfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(attestil)
                            .addComponent(attestit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tiil)
                            .addComponent(tiit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(faxil)
                            .addComponent(faxit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bbil)
                            .addComponent(bbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nbbil)
                            .addComponent(nbbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pplal)
                            .addComponent(pplait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(npplail)
                            .addComponent(npplait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnnulerInstru)
                            .addComponent(AddInstru)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        Affichage.addTab("tab1", InstructeurDet);

        getContentPane().add(Affichage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -97, -1, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemActionPerformed
        //Ajout d'un membre
        if (MemEmpty()) {
            System.out.println("J'update mon membre");
            //Appelle la fonction pour créer un membre
            Object selectedObject = ListeQualif.getSelectedItem();
            String selectedString = selectedObject.toString();
            System.out.println(vmt.getText() + " " + vmvt.getText() + " " + sept.getText());
            boolean rep = mem.UpMembre(id, selectedString, nomt.getText(), prenomt.getText(),
                    adt.getText(), cpt.getText(), telt.getText(), emailt.getText(),
                    commt.getText(), badget.getText(), villet.getText(),
                    vmt.getText(), vmvt.getText(), sept.getText(), sepvt.getText(),
                    cartft.getText(), attestt.getText(), mdpt.getText(), proft.getText(), datent.getText(),
                    Lieut.getText(), bbmtht.getText(), pplatht.getText(), dateBBmt.getText(), datePPLAmt.getText(),
                    numBBmt.getText(), numPPLAmt.getText(), true, true);

            if (rep) {
                System.out.println("Update réussi du membre : " + nomt.getText() + " " + prenomt.getText());
                JOptionPane.showMessageDialog(null, "Ajouts réussi du membre : " + nomt.getText() + " " + prenomt.getText(), "Information !", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else if (!rep) {
                System.out.println("Problème d'update");
                JOptionPane.showMessageDialog(null, "Problème d'update vérifier vos informations " + nomt.getText() + " " + prenomt.getText(), "Information !", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            //Afficher dialog remplir tout les champs
            JOptionPane.showMessageDialog(null, "Vous devez remplir tout les champs !", "Alerte !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddMemActionPerformed

    private void AnnulerMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerMemActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerMemActionPerformed

    private void ListeQualifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeQualifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListeQualifActionPerformed

    private void AnnulerSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerSeqActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerSeqActionPerformed

    private void AddSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSeqActionPerformed
        //Ajout d'une sequence de vol
        if (SeqVolEmpty()) {
            System.out.println("J'ajoute ma sequence de vol");
            //Appelle la fonction pour créer une sequence de vol
            //récupération de l'id du membre
            Object selectedObject = memT.getSelectedItem();
            String selectedString = selectedObject.toString();
            String[] membre = selectedString.split(" ");
            String mId = mem.getMemIdByNP(membre[0], membre[1]);
            //récupération de l'id de l'instru
            Object selectedObject2 = inT.getSelectedItem();
            String selectedString2 = selectedObject2.toString();
            String[] instr = selectedString2.split(" ");
            String iId = instru.getInstruIdByNP(instr[0], instr[1]);
            //Récupération de l'id de l'avion
            Object selectedObject3 = avT.getSelectedItem();
            String selectedString3 = selectedObject3.toString();
            String aId = av.getAvIdByType(selectedString3);
            boolean rep = true;
            if (fit.isSelected()) {
                rep = seq.UpSequenceVol(id,iId, mId, aId,
                        datet.getText(), tempst.getText(), hft.getText(),
                        pst.getText(), tauxt.getText(),
                        redst.getText(), motift.getText(),
                        tit.getText(), true);
            } else {
                rep = seq.UpSequenceVol(id,iId, mId, aId,
                        datet.getText(), tempst.getText(), hft.getText(),
                        pst.getText(), tauxt.getText(),
                        redst.getText(), motift.getText(),
                        tit.getText(), false);
            }
            //Ajouter dans les comptes
            if (rep) {
                System.out.println("Update réussi de la sequence de vol : " + typet.getText() + " " + immt.getText());
                JOptionPane.showMessageDialog(null, "Update réussi de la sequence de vol : " + typet.getText() + " " + immt.getText(), "Information !", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else if (!rep) {
                System.out.println("Problème d'ajouts");
            }

        } else {
            //Afficher dialog remplir tout les champs
            JOptionPane.showMessageDialog(null, "Vous devez remplir tout les champs !", "Alerte !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddSeqActionPerformed

    private void avTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avTActionPerformed
        Object selectedObject = avT.getSelectedItem();
        String selectedString = selectedObject.toString();
        String rep = av.getAvionTRByType(selectedString);
        String[] SplitRep = rep.split(" ");
        tauxt.setText(SplitRep[0]);
        redst.setText(SplitRep[1]);
    }//GEN-LAST:event_avTActionPerformed

    private void inTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inTActionPerformed
        // TODO add your handling code here:
        Object selectedObject = inT.getSelectedItem();
        String selectedString = selectedObject.toString();
        String[] np = selectedString.split(" ");
        String taux = instru.getInstruTauxByNP(np[0], np[1]);
        tit.setText(taux);
    }//GEN-LAST:event_inTActionPerformed

    private void AnnulerAvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerAvActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerAvActionPerformed

    private void AddAvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAvActionPerformed
        //Ajout d'un avion
        if (AvionEmpty()) {
            System.out.println("J'update mon avion");
            //Appelle la fonction pour créer un avion
            boolean rep = av.UpAvion(id,typet.getText(),
                    txt.getText(), f1t.getText(),
                    f2t.getText(), f3t.getText(),
                    h1t.getText(), h2t.getText(),
                    h3t.getText(), rdst.getText(),
                    immt.getText());
            if (rep) {
                System.out.println("Update réussi de l'avion : " + typet.getText() + " " + immt.getText());
                JOptionPane.showMessageDialog(null, "Update réussi de l'avion : " + typet.getText() + " " + immt.getText(), "Information !", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else if (!rep) {
                System.out.println("Problème d'ajouts");
            }

        } else {
            //Afficher dialog remplir tout les champs
            JOptionPane.showMessageDialog(null, "Vous devez remplir tout les champs !", "Alerte !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddAvActionPerformed

    private void AnnulerInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerInstruActionPerformed
        this.dispose();
    }//GEN-LAST:event_AnnulerInstruActionPerformed

    private void AddInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInstruActionPerformed
        if (InstruEmpty()) {
            System.out.println("J'update mon Instructeur");
            //Appelle la fonction pour créer un membre
            Object selectedObject = CiviliteInstru.getSelectedItem();
            String selectedString = selectedObject.toString();
            boolean rep = instru.UpInstructeur(id,selectedString, nomit.getText(),
                    prenomit.getText(), adit.getText(), cpit.getText(), telit.getText(),
                    emailit.getText(), commit.getText(), badgeit.getText(),
                    villeit.getText(), vmit.getText(), vmvit.getText(),
                    sepit.getText(), sepvit.getText(), cartfit.getText(),
                    attestit.getText(), mdpit.getText(), tiit.getText(),
                    faxit.getText(), bbit.getText(), pplait.getText(),
                    nbbit.getText(), npplait.getText());

            if (rep) {
                System.out.println("Update réussi de l'instructeur : " + nomit.getText() + " " + prenomit.getText());
                JOptionPane.showMessageDialog(null, "Update réussi de l'instructeur : " + nomit.getText() + " " + prenomit.getText(), "Information !", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else if (!rep) {
                System.out.println("Problème d'ajouts");
            }

        } else {
            //Afficher dialog remplir tout les champs
            JOptionPane.showMessageDialog(null, "Vous devez remplir tout les champs !", "Alerte !", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AddInstruActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit(Viewer, id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAv;
    private javax.swing.JButton AddInstru;
    private javax.swing.JButton AddMem;
    private javax.swing.JButton AddSeq;
    private javax.swing.JTabbedPane Affichage;
    private javax.swing.JButton AnnulerAv;
    private javax.swing.JButton AnnulerInstru;
    private javax.swing.JButton AnnulerMem;
    private javax.swing.JButton AnnulerSeq;
    private javax.swing.JPanel AvionDet;
    private javax.swing.JComboBox<String> CiviliteInstru;
    private date.DateChooser DateAttestastionMembre;
    private date.DateChooser DateSeq;
    private date.DateChooser InstruAttest;
    private date.DateChooser InstruBb;
    private date.DateChooser InstruPpla;
    private date.DateChooser InstruSep;
    private date.DateChooser InstruSepv;
    private date.DateChooser InstruVm;
    private date.DateChooser InstruVmv;
    private javax.swing.JPanel InstructeurDet;
    private javax.swing.JLabel Lieul;
    private javax.swing.JTextField Lieut;
    private javax.swing.JComboBox<String> ListeQualif;
    private javax.swing.JPanel MembreDet;
    private date.DateChooser SepMembre;
    private date.DateChooser SepVMembre;
    private javax.swing.JPanel SeqVolsDet;
    private date.DateChooser VmMembre;
    private date.DateChooser VmvaliditeMembre;
    private javax.swing.JLabel adil;
    private javax.swing.JTextField adit;
    private javax.swing.JLabel adl;
    private javax.swing.JTextField adt;
    private javax.swing.JLabel attestil;
    private javax.swing.JTextField attestit;
    private javax.swing.JLabel attestl;
    private javax.swing.JTextField attestt;
    private javax.swing.JComboBox<String> avT;
    private javax.swing.JLabel avl;
    private javax.swing.JLabel badgeil;
    private javax.swing.JTextField badgeit;
    private javax.swing.JLabel badgel;
    private javax.swing.JTextField badget;
    private javax.swing.JLabel bbil;
    private javax.swing.JTextField bbit;
    private javax.swing.JLabel bbmthl;
    private javax.swing.JTextField bbmtht;
    private javax.swing.JLabel cartfil;
    private javax.swing.JTextField cartfit;
    private javax.swing.JLabel cartfl;
    private javax.swing.JTextField cartft;
    private javax.swing.JLabel civilitél;
    private javax.swing.JLabel commil;
    private javax.swing.JTextArea commit;
    private javax.swing.JLabel comml;
    private javax.swing.JTextArea commt;
    private javax.swing.JLabel cpil;
    private javax.swing.JTextField cpit;
    private javax.swing.JLabel cpl;
    private javax.swing.JTextField cpt;
    private date.DateChooser dateBBM;
    private javax.swing.JLabel dateBBml;
    private javax.swing.JTextField dateBBmt;
    private date.DateChooser dateBBthM;
    private date.DateChooser dateNaissanceMembre;
    private date.DateChooser datePPLAM;
    private javax.swing.JLabel datePPLAml;
    private javax.swing.JTextField datePPLAmt;
    private date.DateChooser datePPLAthM;
    private javax.swing.JLabel datel;
    private javax.swing.JLabel datenl;
    private javax.swing.JTextField datent;
    private javax.swing.JTextField datet;
    private javax.swing.JLabel emailil;
    private javax.swing.JTextField emailit;
    private javax.swing.JLabel emaill;
    private javax.swing.JTextField emailt;
    private javax.swing.JLabel f1l;
    private javax.swing.JTextField f1t;
    private javax.swing.JLabel f2l;
    private javax.swing.JTextField f2t;
    private javax.swing.JLabel f3l;
    private javax.swing.JTextField f3t;
    private javax.swing.JLabel faxil;
    private javax.swing.JTextField faxit;
    private javax.swing.JLabel fil;
    private javax.swing.JCheckBox fit;
    private javax.swing.JLabel h1l;
    private javax.swing.JTextField h1t;
    private javax.swing.JLabel h2l;
    private javax.swing.JTextField h2t;
    private javax.swing.JLabel h3l;
    private javax.swing.JTextField h3t;
    private javax.swing.JLabel hfl;
    private javax.swing.JTextField hft;
    private javax.swing.JLabel imml;
    private javax.swing.JTextField immt;
    private javax.swing.JComboBox<String> inT;
    private javax.swing.JLabel inl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel mdpil;
    private javax.swing.JPasswordField mdpit;
    private javax.swing.JLabel mdpl;
    private javax.swing.JPasswordField mdpt;
    private javax.swing.JComboBox<String> memT;
    private javax.swing.JLabel meml;
    private javax.swing.JLabel motifl;
    private javax.swing.JTextArea motift;
    private javax.swing.JLabel nbbil;
    private javax.swing.JTextField nbbit;
    private javax.swing.JLabel nomil;
    private javax.swing.JTextField nomit;
    private javax.swing.JLabel noml;
    private javax.swing.JTextField nomt;
    private javax.swing.JLabel npplail;
    private javax.swing.JTextField npplait;
    private javax.swing.JLabel numBBml;
    private javax.swing.JTextField numBBmt;
    private javax.swing.JLabel numPPLAml;
    private javax.swing.JTextField numPPLAmt;
    private javax.swing.JTextField pplait;
    private javax.swing.JLabel pplal;
    private javax.swing.JLabel pplathl;
    private javax.swing.JTextField pplatht;
    private javax.swing.JLabel prenomil;
    private javax.swing.JTextField prenomit;
    private javax.swing.JLabel prenoml;
    private javax.swing.JTextField prenomt;
    private javax.swing.JLabel profl;
    private javax.swing.JTextField proft;
    private javax.swing.JLabel psl;
    private javax.swing.JTextField pst;
    private javax.swing.JLabel rdsl;
    private javax.swing.JTextField rdst;
    private javax.swing.JLabel redsl;
    private javax.swing.JTextField redst;
    private javax.swing.JLabel sepil;
    private javax.swing.JTextField sepit;
    private javax.swing.JLabel sepl;
    private javax.swing.JTextField sept;
    private javax.swing.JLabel sepvil;
    private javax.swing.JTextField sepvit;
    private javax.swing.JLabel sepvl;
    private javax.swing.JTextField sepvt;
    private javax.swing.JLabel tauxl;
    private javax.swing.JTextField tauxt;
    private javax.swing.JLabel telil;
    private javax.swing.JTextField telit;
    private javax.swing.JLabel tell;
    private javax.swing.JTextField telt;
    private javax.swing.JLabel tempsl;
    private javax.swing.JTextField tempst;
    private javax.swing.JLabel tiil;
    private javax.swing.JTextField tiit;
    private javax.swing.JLabel til;
    private javax.swing.JTextField tit;
    private javax.swing.JLabel txl;
    private javax.swing.JTextField txt;
    private javax.swing.JLabel typel;
    private javax.swing.JTextField typet;
    private javax.swing.JLabel villeil;
    private javax.swing.JTextField villeit;
    private javax.swing.JLabel villel;
    private javax.swing.JTextField villet;
    private javax.swing.JLabel vmil;
    private javax.swing.JTextField vmit;
    private javax.swing.JLabel vml;
    private javax.swing.JTextField vmt;
    private javax.swing.JLabel vmvil;
    private javax.swing.JTextField vmvit;
    private javax.swing.JLabel vmvl;
    private javax.swing.JTextField vmvt;
    // End of variables declaration//GEN-END:variables
}
