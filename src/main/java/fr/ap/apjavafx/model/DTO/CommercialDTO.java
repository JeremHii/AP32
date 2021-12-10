package fr.ap.apjavafx.model.DTO;

import fr.ap.apjavafx.model.DAO.CommercialDAO;
import fr.ap.apjavafx.model.DAO.UtilisateurDAO;

import java.util.ArrayList;
import java.util.List;

public class CommercialDTO {

    private static List<CommercialDTO> commerciaux = new ArrayList<>();
    private String login;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String mail;
    private String pourcentinteressement;

    public CommercialDTO(String login, String nom, String prenom, String adresse, String telephone, String mail, String pourcentinteressement) {
        commerciaux.add(this);

        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
        this.pourcentinteressement = pourcentinteressement;
    }

    public static List<CommercialDTO> getCommerciaux(){
        return commerciaux;
    }

    public static CommercialDTO getCommercial(String login){
        for (CommercialDTO commercial : getCommerciaux()) {
            if(commercial.getLogin().equals(login)){
                return commercial;
            }
        }
        return null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPourcentinteressement() {
        return pourcentinteressement;
    }

    public void setPourcentinteressement(String pourcentinteressement) {
        this.pourcentinteressement = pourcentinteressement;
    }

    public String getLogin() {
        return login;
    }

    public void delete(){
        UtilisateurDTO.getUtilisateur(this.getLogin()).delete();
        commerciaux.remove(this);
    }
}
