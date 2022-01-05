package fr.ap.apjavafx.model.DTO;

public class ClientDTO {
    private String idEnt;
    private String login;
    private String nom;
    private String prenom;
    private String contactO_N;
    private String telContact;
    private String mailContact;
    private String etatContact;
    private UtilisateurDTO utilisateur;

    public ClientDTO(String pidEnt, String plogin, String pnom, String pprenom, String pcontactO_N, String ptelContact, String pmailContact, String petatContact) {
        this.idEnt = pidEnt;
        this.login = plogin;
        this.nom = pnom;
        this.prenom = pprenom;
        this.contactO_N = pcontactO_N;
        this.telContact = ptelContact;
        this.mailContact = pmailContact;
        this.etatContact = petatContact;
    }

    public String getClientIdEnt() {
        return idEnt;
    }

    public String getClientLogin() {
        return login;
    }

    public String getClientNom(){ return nom;}

    public String getClientcontactO_N(){ return contactO_N;}

    public String getClientPrenom(){ return prenom;}

    public String getClientTelContact(){ return telContact;}

    public String getClientMailContact(){ return mailContact;}

    public String getClientEtatContact(){ return etatContact;}
}
