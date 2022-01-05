package fr.ap.apjavafx.model.DTO;

import java.util.ArrayList;
import java.util.Date;

public class FicheClientDTO {
    private String nomEntreprise;
    private String adresseEntreprise;
    private String villePays;
    private String telEntreprise;
    private String nomPrenomContact;
    private String etatContact;
    private String mailContact;
    private String emailEntreprise;
    private String telContact;
    private UtilisateurDTO utilisateur;

    public FicheClientDTO(String pnomEntreprise, String padresseEntreprise, String pvillePays, String ptelEntreprise, String pmailEntreprise, String pnomPrenomContact  , String petatContact, String pmailContact, String pnumTelContact) {
        this.nomEntreprise = pnomEntreprise;
        this.adresseEntreprise = padresseEntreprise;
        this.villePays = pvillePays;
        this.telEntreprise = ptelEntreprise;
        this.emailEntreprise = pmailEntreprise;
        this.nomPrenomContact = pnomPrenomContact;
        this.etatContact = petatContact;
        this.mailContact = pmailContact;
        this.telContact = pnumTelContact;

    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }


    public String getAdresseExacte() {
        return adresseEntreprise;
    }

    public String getVillePays() {
        return villePays;
    }

    public String getNumTelephone() {
        return telEntreprise;
    }

    public String getNomPrenomContact() {
        return nomPrenomContact;
    }

    public String getMailContact() {
        return mailContact;
    }

    public String getEtatContact() {
        return etatContact;
    }

    public String getNumTelContact() {
        return telContact;
    }

    public String getMailEntreprise() {
        return emailEntreprise;
    }


    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public void setAdresseExacte(String adresseExacte) {
        this.adresseEntreprise = adresseExacte;
    }

    public void setVillePays(String villePays) {
        this.villePays = villePays;
    }

    public void setNumTelephone(String numTelephone) {
        this.telEntreprise = numTelephone;
    }

    public void setNomPrenomContact(String nomPrenomContact) {
        this.nomPrenomContact = nomPrenomContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    public void setNumTelContact(String numTelContact) {
        this.telContact = numTelContact;
    }

    public void setEtatContact(String petatContact) {
        this.etatContact = petatContact;
    }

    public void setMailEntreprise(String pMailEntreprise) {
        this.emailEntreprise = pMailEntreprise;
    }
}
