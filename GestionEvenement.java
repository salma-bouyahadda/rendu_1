import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionEvenement {
    
    public void ajoutereven(String nomevent, String dateevent, String descrip, int iduser) {
    String query = "INSERT INTO evenements (nom_event, date_event, description, id_user) VALUES (?, ?, ?, ?)";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, nomevent);
        stmt.setString(2, dateevent);
        stmt.setString(3, descrip);
        stmt.setInt(4, iduser);
        stmt.executeUpdate();
        System.out.println("evenement ajoute");
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout d'evenement : " + e.getMessage());
    }
}


public  List<String> affichereven() {
    List<String> even = new ArrayList<>();
    String query = "SELECT * FROM evenements";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            even.add("ID: " + rs.getInt("id_event")+
            ",Nom: " + rs.getString("nom_event")+
            ",Date: " + rs.getString("date_event")+
            ",Description: " + rs.getString("description")+
            ",Id utilisateur: " + rs.getInt("id_user"));
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'affiche d'evenement : " + e.getMessage());
    }
    return even;
}

public void modifiereven(int idevent, String newNom, String newDate, String newDescrip) {
    String query = "UPDATE evenements SET nom_event = ?, date_event = ?, description = ? WHERE id_event = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, newNom);
        stmt.setString(2, newDate);
        stmt.setString(3, newDescrip);
        stmt.setInt(4, idevent);
        stmt.executeUpdate();
        System.out.println("evenement modifie");
    } catch (SQLException e) {
        System.out.println("Erreur lors de modification d'evenement : " + e.getMessage());    }
}


public void supprimereven(int idevent) {
    String query = "DELETE FROM evenements WHERE id_event = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idevent);
        stmt.executeUpdate();
        System.out.println("evenement supprime");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression d'evenement : " + e.getMessage());    }
    }
}



