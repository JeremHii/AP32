package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.UtilisateurDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class UtilisateurDAO {

	public static ResultSet getUserByCredentials(String login, String mdp){
		String requete = "SELECT LOGIN FROM Utilisateur WHERE LOGIN = ? AND PASSWORD = ?;";
		Connection conn = DBConnex.getConn();
		ResultSet rs = DBConnex.getRS(conn, requete, List.of(login, mdp));
		return rs;
	}

	public static void createUsers(){
		String requete = "SELECT LOGIN FROM Utilisateur;";
		Connection conn = DBConnex.getConn();
		ResultSet rs = DBConnex.getRS(conn, requete);
		try{
			while(rs.next()){
				new UtilisateurDTO(rs.getString("LOGIN"));
			}
		}catch (Exception e){
		}

		try {
			conn.close();
		}catch (Exception e){
		}
	}
}
