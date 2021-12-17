package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.ContacterDTO;

import java.sql.Connection;
import java.sql.ResultSet;

public class ContacterDAO {
    public static void createContacts(){
        String requete = "SELECT * FROM Contacter;";
        Connection conn = DBConnex.getConn();
        ResultSet rs = DBConnex.getRS(conn, requete);
        try{
            while(rs.next()){
                new ContacterDTO(
                        rs.getString("LOGIN"),
                        rs.getDate("DATE"),
                        rs.getString("IDENT")
                );
            }
        }catch (Exception e){
        }

        try {
            conn.close();
        }catch (Exception e){
        }
    }
}
