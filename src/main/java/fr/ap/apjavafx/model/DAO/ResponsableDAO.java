package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.AdminDTO;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class AdminDAO {

	public static void createAdmins(){
		String requete = "SELECT * FROM Admin;";
		Connection conn = DBConnex.getConn();
		ResultSet rs = DBConnex.getRS(conn, requete);
		try{
			while(rs.next()){
				new AdminDTO(rs.getString("LOGIN"));
			}
		}catch (Exception e){
		}

		try {
			conn.close();
		}catch (Exception e){
		}
	}
}
