package fr.ap.apjavafx.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class ResponsableDTO {
    private static List<ResponsableDTO> responsables = new ArrayList<>();
    private String login;

    public ResponsableDTO(String login)
    {
        responsables.add(this);

        this.login = login;
    }

    public static List<ResponsableDTO> getResponsables(){
        return responsables;
    }

    public static ResponsableDTO getResponsable(String login){
        for (ResponsableDTO responsable : getResponsables()) {
            if(responsable.getLogin().equals(login)){
                return responsable;
            }
        }
        return null;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
