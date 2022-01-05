package fr.ap.apjavafx.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DBConnex {
	/**
	 * M�thode de connexion � la base de donn�es
	 * @return  Statement
	 */

	public static Connection getConn(){
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/ap_meetingsbooker","root","");
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Méthode permettant l'envoi de requetes "select" à la base de données
	 * @param conn
	 * @param requete
	 * @return ResultSet
	 */
	public static ResultSet getRS(Connection conn, String requete){
		return getRS(conn, requete, null);
	}

	/**
	 * Méthode permettant l'envoi de requetes "select" à la base de données
	 * @param conn
	 * @param requete
	 * @param elements Remplacer les "?" dans la requête
	 * @return ResultSet
	 */
	public static ResultSet getRS(Connection conn, String requete, List<Object> elements ){
		ResultSet rs = null;
		try{
			PreparedStatement ps = conn.prepareStatement(requete);

			if(elements != null){
				int i = 0;
				for(Object elem : elements){
					i++;
					if(elem instanceof Integer){
						ps.setInt(i, (Integer) elem);
					}
					else{
						ps.setString(i, (String) elem);
					}
				}
			}

			rs = ps.executeQuery();
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return rs;
	}
	
	/**
	  * M�thode permettant l'envoi de requ�tes "update, insert, delete" � la base de donn�es
	 * @param conn
	 * @param requete
	 * @return Integer
	 */
	public static Integer noQuery(Connection conn, String requete){
		return noQuery(conn, requete, null);
	}

	/**
	 * M�thode permettant l'envoi de requ�tes "update, insert, delete" � la base de donn�es
	 * @param conn
	 * @param requete
	 * @param elements Remplacer les "?" dans la requête
	 * @return Integer
	 */
	public static Integer noQuery(Connection conn, String requete, List<Object> elements ){
		int res = -1;
		try{
			PreparedStatement ps = conn.prepareStatement(requete);

			if(elements != null){
				int i = 0;
				for(Object elem : elements){
					i++;
					if(elem instanceof Integer){
						ps.setInt(i, (Integer) elem);
					}
					else{
						ps.setString(i, (String) elem);
					}
				}
			}

			res = ps.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		return res;
	}


}
