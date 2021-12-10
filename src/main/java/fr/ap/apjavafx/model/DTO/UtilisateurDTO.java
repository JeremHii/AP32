package fr.ap.apjavafx.model.DTO;


import fr.ap.apjavafx.model.DAO.UtilisateurDAO;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class UtilisateurDTO {

    private static List<UtilisateurDTO> utilisateurs = new ArrayList<>();
	private String login;

    public UtilisateurDTO(String login)
    {
        utilisateurs.add(this);

        this.login = login;
    }

    public static List<UtilisateurDTO> getUtilisateurs(){
        return utilisateurs;
    }

    public static UtilisateurDTO getUtilisateur(String login){
        for (UtilisateurDTO utilisateur : getUtilisateurs()) {
            if(utilisateur.getLogin().equals(login)){
                return utilisateur;
            }
        }
        return null;
    }

    public String getFonction(){
        if(CommercialDTO.getCommercial(this.login) != null){
            return "COMMERCIAL";
        }
        if(AdminDTO.getAdmin(this.login) != null){
            return "ADMIN";
        }
        if(ResponsableDTO.getResponsable(this.login) != null){
            return "RESPONSABLE";
        }

        return "UNKNOWN";
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void delete(){
        UtilisateurDAO.deleteUser(this);
        utilisateurs.remove(this);
    }
}
	

