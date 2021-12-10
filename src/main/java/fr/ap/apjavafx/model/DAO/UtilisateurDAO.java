package fr.ap.apjavafx.model.DAO;

import fr.ap.apjavafx.model.DTO.CommercialDTO;
import fr.ap.apjavafx.model.DTO.UtilisateurDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public static int addUser(UtilisateurDTO user, String password){
		String requete = "INSERT INTO Utilisateur(LOGIN, PASSWORD) VALUES (?, ?);";
		Connection conn = DBConnex.getConn();
		int res = -1;
		try{
			 res = DBConnex.noQuery(conn, requete, List.of(user.getLogin(), password));
		}
		catch (Exception e){}

		if(res == -1){
			System.out.println("Erreur lors de la requête (addUser).");
		}

		try {
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return res;
	}

	public static int deleteUser(UtilisateurDTO user){
		String requete = "DELETE FROM Utilisateur WHERE LOGIN = ?;";
		Connection conn = DBConnex.getConn();
		int res = -1;
		try {
			res = DBConnex.noQuery(conn, requete, List.of(user.getLogin()));
		}
		catch (Exception e){}

		if(res == -1){
			System.out.println("Erreur lors de la requête (deleteUser).");
		}

		try {
			conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return res;
	}
}
