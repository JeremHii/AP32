package fr.ap.apjavafx.model.DTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContacterDTO {

    private static List<ContacterDTO> contacts = new ArrayList<>();
    //Login du commercial
    private String login;
    //Date du contact
    private Date date;
    //Identifiant du loueur
    private String ident;

    public ContacterDTO(String login, Date date, String ident){
        contacts.add(this);

        this.login = login;
        this.date = date;
        this.ident = ident;
    }

    public static List<ContacterDTO> getContacts() {
        return contacts;
    }

    /**
     * Récupèrer les années d'activité d'un commercial
     * @param commercial
     * @return
     */
    public static List<Integer> getYearsActivityCommercial(CommercialDTO commercial){
        List<Integer> years = new ArrayList<>();
        for(ContacterDTO contact : getContacts()){
            if(contact.getLogin().equals(commercial.getLogin()) && !years.contains(contact.getDate().getYear()+1900)){
                years.add(contact.getDate().getYear()+1900);
            }
        }
        return years;
    }

    /**
     * Récupèrer les mois d'activité d'un commercial dans une année
     * @param commercial
     * @return
     */
    public static List<Integer> getMonthsActivityCommercial(CommercialDTO commercial, int year){
        List<Integer> months = new ArrayList<>();
        for(ContacterDTO contact : getContacts()){
            if(contact.getLogin().equals(commercial.getLogin()) && (contact.getDate().getYear()+1900) == year && !months.contains(contact.getDate().getMonth())){
                months.add(contact.getDate().getMonth());
            }
        }
        return months;
    }

    public String getLogin() {
        return login;
    }

    public Date getDate() {
        return date;
    }

    public String getIdent() {
        return ident;
    }
}
