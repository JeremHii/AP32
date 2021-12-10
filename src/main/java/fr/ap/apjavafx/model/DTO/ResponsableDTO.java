package fr.ap.apjavafx.model.DTO;

import java.util.ArrayList;
import java.util.List;

public class AdminDTO {
    private static List<AdminDTO> admins = new ArrayList<>();
    private String login;

    public AdminDTO(String login)
    {
        admins.add(this);

        this.login = login;
    }

    public static List<AdminDTO> getAdmins(){
        return admins;
    }

    public static AdminDTO getAdmin(String login){
        for (AdminDTO admin : getAdmins()) {
            if(admin.getLogin().equals(login)){
                return admin;
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
