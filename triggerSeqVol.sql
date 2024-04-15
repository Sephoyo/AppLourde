--Trigger lors de la suppression d'une sequences de vol

CREATE OR REPLACE FUNCTION add_to_historique_seqvol()
RETURNS TRIGGER AS $$
BEGIN
    -- Insérer les données supprimées de seq-vol dans historique_seqvol
    INSERT INTO historique_seqvol (ID_IN, ID_MEM, ID_AV, DATE, TEMPS, HEURES_FORFAIT, PRIX_SPECIAL, TAUX, REDUCTION_SEMAINE, MOTIF, TAUX_INSTRUCTEUR, FORFAIT_INITIATION)
    VALUES (OLD.ID_IN, OLD.ID_MEM, OLD.ID_AV, OLD.DATE, OLD.TEMPS, OLD.HEURES_FORFAIT, OLD.PRIX_SPECIAL, OLD.TAUX, OLD.REDUCTION_SEMAINE, OLD.MOTIF, OLD.TAUX_INSTRUCTEUR, OLD.FORFAIT_INITIATION);
    
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- Créer le déclencheur
CREATE TRIGGER seqvol_delete_trigger
AFTER DELETE ON seq_vol
FOR EACH ROW
EXECUTE FUNCTION add_to_historique_seqvol();


--Trigger lors de l'ajoute d'un membre pour créer une ligne dans la table compte

CREATE OR REPLACE FUNCTION create_compte_after_insert()
RETURNS TRIGGER AS $$
BEGIN
    -- Insérer un nouveau compte associé à l'ID du membre nouvellement inséré
    INSERT INTO COMPTES (ID) VALUES (NEW.ID);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Associer le déclencheur à la table membres
CREATE TRIGGER create_compte_trigger
AFTER INSERT ON membres
FOR EACH ROW
EXECUTE FUNCTION create_compte_after_insert();