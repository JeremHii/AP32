package fr.ap.apjavafx.model.DAO;


import fr.ap.apjavafx.model.DTO.ClientDTO;
import fr.ap.apjavafx.model.DTO.FicheClientDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FicheClientDAO {

    /**
         * Méthode permettant de récupérer les fiches clients
         * @return ResultSet (la liste des fiches Clients)
         */
        public static ResultSet lesFichesClients() {
            String requete = "SELECT * FROM ficheClient";
            return DBConnex.getRS(DBConnex.getConn(), requete);
        }


        /**
         * Méthode permettant de modifier l'état d'une fiche de frais
         * @param unIdFiche
         * @param nouvelEtat (code état)
         * @return Integer
         */
        public static Integer changerEtat(int unIdFiche , String nouvelEtat) {
            String requete = "update ficheFrais set idEtat = '" + nouvelEtat + "' where idFiche = " + unIdFiche ;
            return DBConnex.noQuery(DBConnex.getConn(), requete);
        }

    public static int addFicheClient(ClientDTO unClient){
        String requete = "INSERT INTO Loueur(IDENT, LOGIN, NOM, PRENOM, CONTACTEO_N, TELEPHONECONTACT, MAILCONTACT, TYPEINSCRIPTION) VALUES (?, ?, ?, ?, ?, ?, ?,?);";
        Connection conn = DBConnex.getConn();
        int res = -1;
        try {
            res = DBConnex.noQuery(conn, requete, List.of(unClient.getClientIdEnt(), unClient.getClientLogin(), unClient.getClientNom(), unClient.getClientPrenom(), unClient.getClientcontactO_N(), unClient.getClientTelContact(), unClient.getClientMailContact(),unClient.getClientEtatContact()));
        }
        catch (Exception e){}

        if(res == -1){
            System.out.println("Erreur lors de la requête (addFicheClient).");
        }

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return res;
    }
}
