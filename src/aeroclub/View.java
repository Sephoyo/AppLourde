/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeroclub;

import SQL.Membres;
import SQL.SeqVols;
import SQL.Instructeurs;
import SQL.Avions;
import java.util.HashMap;

/**
 *
 * @author joseph.baert
 */
public class View extends javax.swing.JFrame {

    private static int id;
    private static int Viewer;
    private Membres mem = new Membres();
    private Avions av = new Avions();
    private Instructeurs instru = new Instructeurs();
    private SeqVols seq = new SeqVols();

    public View(int id, int Viewer) {
        initComponents();
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
                HashMap<String,String> Avion = av.getAvById(id);
                AppendAvion(Avion);
                break;
            case 2:
                Affichage.setSelectedIndex(3);
                System.out.println("Instructeurs");
                HashMap<String,String> Instru= instru.getInById(id);
                AppendInstructeur(Instru);
                break;
            case 3:
                Affichage.setSelectedIndex(1);
                System.out.println("SeqVols");
                HashMap<String,String> SeqVol = seq.getSeqById(id);
                System.out.println("Table récupérer dans le view : "+SeqVol);
                AppendSeqVol(SeqVol);
                break;
        }
    }

    private void AppendMem(HashMap<String, String> membre) {
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
    }

    private void AppendSeqVol(HashMap<String, String> seqvols) {
        seqt.setText(seqvols.get("num_seq").trim());
        inT.setText(seqvols.get("id_in").trim());
        memt.setText(seqvols.get("id_mem").trim());
        aviont.setText(seqvols.get("id_av").trim());
        datet.setText(seqvols.get("date").trim());
        tempst.setText(seqvols.get("temps").trim());
        hft.setText(seqvols.get("heures_forfait").trim());
        pst.setText(seqvols.get("prix_special").trim());
        tauxt.setText(seqvols.get("taux").trim());
        redst.setText(seqvols.get("reduction_semaine").trim());
        motift.setText(seqvols.get("motif").trim());
        tit.setText(seqvols.get("taux_instructeur").trim());
        System.out.println(seqvols.get("forfait_initiation"));
        if("t".equals(seqvols.get("forfait_initiation"))){
            fit.setSelected(true);
        }else{
            fit.setSelected(false);
        }
    }
    
    private void AppendAvion(HashMap<String,String>avion){
        numt.setText(avion.get("num_avion").trim());
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
    
    private void AppendInstructeur(HashMap<String,String> instru){
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
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        CloseMem = new javax.swing.JButton();
        comml = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        commt = new javax.swing.JTextArea();
        SeqVolsDet = new javax.swing.JPanel();
        seql = new javax.swing.JLabel();
        seqt = new javax.swing.JTextField();
        inl = new javax.swing.JLabel();
        inT = new javax.swing.JTextField();
        meml = new javax.swing.JLabel();
        memt = new javax.swing.JTextField();
        avl = new javax.swing.JLabel();
        aviont = new javax.swing.JTextField();
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
        QuitterSeq = new javax.swing.JButton();
        AvionDet = new javax.swing.JPanel();
        numl = new javax.swing.JLabel();
        numt = new javax.swing.JTextField();
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
        QuiiterAv = new javax.swing.JButton();
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
        QuiiterInstru = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        commit = new javax.swing.JTextArea();
        commil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prenoml.setText("Prenom :");

        prenomt.setEditable(false);

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

        CloseMem.setText("Quitter");
        CloseMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseMemActionPerformed(evt);
            }
        });

        comml.setText("Commentaire :");

        commt.setEditable(false);
        commt.setColumns(20);
        commt.setRows(5);
        jScrollPane2.setViewportView(commt);

        javax.swing.GroupLayout MembreDetLayout = new javax.swing.GroupLayout(MembreDet);
        MembreDet.setLayout(MembreDetLayout);
        MembreDetLayout.setHorizontalGroup(
            MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MembreDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addComponent(adl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(villel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(villet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addComponent(cartfl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MembreDetLayout.createSequentialGroup()
                                .addComponent(cartft, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attestl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(attestt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MembreDetLayout.createSequentialGroup()
                                .addComponent(vmt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vmvl)
                                .addGap(18, 18, 18)
                                .addComponent(vmvt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sepl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sept, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sepvl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CloseMem)
                                    .addComponent(sepvt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(171, 171, 171))))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addComponent(prenoml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prenomt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(noml)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nomt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(badgel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(badget, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proft, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addComponent(emaill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MembreDetLayout.createSequentialGroup()
                        .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vml)
                            .addComponent(comml))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MembreDetLayout.setVerticalGroup(
            MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MembreDetLayout.createSequentialGroup()
                .addContainerGap(211, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vml)
                    .addComponent(vmvl)
                    .addComponent(vmvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sepl)
                    .addComponent(sepvl)
                    .addComponent(sepvt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(MembreDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cartfl)
                    .addComponent(cartft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attestl)
                    .addComponent(attestt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(CloseMem)
                .addGap(58, 58, 58))
        );

        Affichage.addTab("tab1", MembreDet);

        seql.setText("Num Sequence :");

        inl.setText("Instructeur :");

        meml.setText("Membre :");

        avl.setText("Avion :");

        datel.setText("Date :");

        tempsl.setText("Temps :");

        hfl.setText("Heures Forfait :");

        psl.setText("Prix spécial :");

        tauxl.setText("Taux :");

        redsl.setText("Réduc.Semaine :");

        motifl.setText("Motif :");

        motift.setColumns(20);
        motift.setRows(5);
        jScrollPane1.setViewportView(motift);

        til.setText("Taux Instructeur :");

        fil.setText("Forfait initiation :");

        QuitterSeq.setText("Quiiter");
        QuitterSeq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterSeqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SeqVolsDetLayout = new javax.swing.GroupLayout(SeqVolsDet);
        SeqVolsDet.setLayout(SeqVolsDetLayout);
        SeqVolsDetLayout.setHorizontalGroup(
            SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeqVolsDetLayout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SeqVolsDetLayout.createSequentialGroup()
                        .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(seql)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(seqt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SeqVolsDetLayout.createSequentialGroup()
                                .addComponent(inl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(meml)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(memt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(avl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aviont, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeqVolsDetLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(QuitterSeq)))
                .addContainerGap())
        );
        SeqVolsDetLayout.setVerticalGroup(
            SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SeqVolsDetLayout.createSequentialGroup()
                .addContainerGap(264, Short.MAX_VALUE)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seql)
                    .addComponent(seqt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SeqVolsDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inl)
                    .addComponent(inT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meml)
                    .addComponent(memt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avl)
                    .addComponent(aviont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(QuitterSeq)
                .addGap(48, 48, 48))
        );

        Affichage.addTab("tab2", SeqVolsDet);

        numl.setText("Numéro Avion : ");

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

        QuiiterAv.setText("Quitter");
        QuiiterAv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuiiterAvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AvionDetLayout = new javax.swing.GroupLayout(AvionDet);
        AvionDet.setLayout(AvionDetLayout);
        AvionDetLayout.setHorizontalGroup(
            AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AvionDetLayout.createSequentialGroup()
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AvionDetLayout.createSequentialGroup()
                                                    .addComponent(typel)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(typet))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AvionDetLayout.createSequentialGroup()
                                                    .addComponent(numl)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(numt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AvionDetLayout.createSequentialGroup()
                        .addContainerGap(607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(QuiiterAv)))
                .addGap(0, 272, Short.MAX_VALUE))
        );
        AvionDetLayout.setVerticalGroup(
            AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AvionDetLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(AvionDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numl)
                    .addComponent(numt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addComponent(QuiiterAv)
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

        QuiiterInstru.setText("Quiiter");
        QuiiterInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuiiterInstruActionPerformed(evt);
            }
        });

        commit.setEditable(false);
        commit.setColumns(20);
        commit.setRows(5);
        jScrollPane3.setViewportView(commit);

        commil.setText("Commentaire :");

        javax.swing.GroupLayout InstructeurDetLayout = new javax.swing.GroupLayout(InstructeurDet);
        InstructeurDet.setLayout(InstructeurDetLayout);
        InstructeurDetLayout.setHorizontalGroup(
            InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InstructeurDetLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QuiiterInstru))
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InstructeurDetLayout.createSequentialGroup()
                                .addComponent(prenomil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prenomit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(badgeil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(badgeit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(sepvil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sepvit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(InstructeurDetLayout.createSequentialGroup()
                                .addComponent(tiil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tiit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(faxit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 283, Short.MAX_VALUE))
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addComponent(emailil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailit, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(InstructeurDetLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commil)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InstructeurDetLayout.setVerticalGroup(
            InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InstructeurDetLayout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailil)
                    .addComponent(emailit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telil)
                    .addComponent(telit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(InstructeurDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InstructeurDetLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(commil)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(npplait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuiiterInstru))
                .addGap(72, 72, 72))
        );

        Affichage.addTab("tab1", InstructeurDet);

        getContentPane().add(Affichage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -97, -1, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseMemActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_CloseMemActionPerformed

    private void QuitterSeqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterSeqActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_QuitterSeqActionPerformed

    private void QuiiterAvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuiiterAvActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_QuiiterAvActionPerformed

    private void QuiiterInstruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuiiterInstruActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_QuiiterInstruActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View(id, Viewer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Affichage;
    private javax.swing.JPanel AvionDet;
    private javax.swing.JButton CloseMem;
    private javax.swing.JPanel InstructeurDet;
    private javax.swing.JPanel MembreDet;
    private javax.swing.JButton QuiiterAv;
    private javax.swing.JButton QuiiterInstru;
    private javax.swing.JButton QuitterSeq;
    private javax.swing.JPanel SeqVolsDet;
    private javax.swing.JLabel adil;
    private javax.swing.JTextField adit;
    private javax.swing.JLabel adl;
    private javax.swing.JTextField adt;
    private javax.swing.JLabel attestil;
    private javax.swing.JTextField attestit;
    private javax.swing.JLabel attestl;
    private javax.swing.JTextField attestt;
    private javax.swing.JTextField aviont;
    private javax.swing.JLabel avl;
    private javax.swing.JLabel badgeil;
    private javax.swing.JTextField badgeit;
    private javax.swing.JLabel badgel;
    private javax.swing.JTextField badget;
    private javax.swing.JLabel bbil;
    private javax.swing.JTextField bbit;
    private javax.swing.JLabel cartfil;
    private javax.swing.JTextField cartfit;
    private javax.swing.JLabel cartfl;
    private javax.swing.JTextField cartft;
    private javax.swing.JLabel commil;
    private javax.swing.JTextArea commit;
    private javax.swing.JLabel comml;
    private javax.swing.JTextArea commt;
    private javax.swing.JLabel cpil;
    private javax.swing.JTextField cpit;
    private javax.swing.JLabel cpl;
    private javax.swing.JTextField cpt;
    private javax.swing.JLabel datel;
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
    private javax.swing.JTextField inT;
    private javax.swing.JLabel inl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel meml;
    private javax.swing.JTextField memt;
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
    private javax.swing.JLabel numl;
    private javax.swing.JTextField numt;
    private javax.swing.JTextField pplait;
    private javax.swing.JLabel pplal;
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
    private javax.swing.JLabel seql;
    private javax.swing.JTextField seqt;
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
