package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.ResponsableDTO;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CommercialDAO {

	public static void createCommerciaux(){
		String requete = "SELECT * FROM Commercial;";
		Connection conn = DBConnex.getConn();
		ResultSet rs = DBConnex.getRS(conn, requete);
		try{
			while(rs.next()){
				new CommercialDTO(
						rs.getString("LOGIN"),
						rs.getString("NOM"),
						rs.getString("PRENOM"),
						rs.getString("ADRESSE"),
						rs.getString("TELEPHONE"),
						rs.getString("MAIL"),
						rs.getString("POURCENTINTERESSEMENT")
				);
			}
		}catch (Exception e){
		}

		try {
			conn.close();
		}catch (Exception e){
		}
	}

	public static int addCommercial(CommercialDTO commercial){
		String requete = "INSERT INTO Commercial(LOGIN, NOM, PRENOM, ADRESSE, TELEPHONE, MAIL, POURCENTINTERESSEMENT) VALUES (?, ?, ?, ?, ?, ?, ?);";
		Connection conn = DBConnex.getConn();
		int res = -1;
		try {
			res = DBConnex.noQuery(conn, requete, List.of(commercial.getLogin(), commercial.getNom(), commercial.getPrenom(), commercial.getAdresse(), commercial.getTelephone(), commercial.getMail(), commercial.getPourcentinteressement()));
		}
		catch (Exception e){}

		if(res == -1){
			System.out.println("Erreur lors de la requête (addCommercial).");
		}

		try {
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return res;
	}
}
