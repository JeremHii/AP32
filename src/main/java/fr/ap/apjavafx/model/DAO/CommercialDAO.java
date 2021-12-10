package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.AdminDTO;
import fr.ap.apjavafx.model.DTO.ResponsableDTO;

import java.sql.Connection;
import java.sql.ResultSet;

public class ResponsableDAO {

	public static void createResponsables(){
		String requete = "SELECT * FROM Responsable;";
		Connection conn = DBConnex.getConn();
		ResultSet rs = DBConnex.getRS(conn, requete);
		try{
			while(rs.next()){
				new ResponsableDTO(rs.getString("LOGIN"));
			}
		}catch (Exception e){
		}

		try {
			conn.close();
		}catch (Exception e){
		}
	}
}
