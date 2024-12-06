import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionSalleTerrain {
    

    public void ajoutersal(String nomsal, int capacite) {
    String query = "INSERT INTO salles (nom_salle, capacite) VALUES (?, ?)";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, nomsal);
        stmt.setInt(2, capacite);
        stmt.executeUpdate();
        System.out.println("salle ajoutee");
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout du salle : " + e.getMessage());
    }
}


public List<String> affichersal() {
    List<String> sal = new ArrayList<>();
    String query = "SELECT * FROM salles";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            sal.add("Id: " + rs.getInt("id_salle")+
            ",Nom: " + rs.getString("nom_salle")+
            ",Capacite: " + rs.getInt("capacite"));
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'affiche du salle : " + e.getMessage());
    }
    return sal;
}

public void supprimersal(int idsal) {
    String query = "DELETE FROM salles WHERE id_salle = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idsal);
        stmt.executeUpdate();
        System.out.println("salle supprimee");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression du salle : " + e.getMessage());
    }
}

public void ajouterterrain(String nomterrain, String type) {
    String query = "INSERT INTO terrains (nom_terrain, type) VALUES (?, ?)";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, nomterrain);
        stmt.setString(2, type);
        stmt.executeUpdate();
        System.out.println("terrain ajoute");
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout du terrain : " + e.getMessage());
    }
}
public List<String> afficherterrain() {
    List<String> terrains = new ArrayList<>();
    String query = "SELECT * FROM terrains";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            terrains.add("Id: " + rs.getInt("id_terrain")+
            ",Nom: " + rs.getString("nom_terrain")+
            ",Type: " + rs.getString("type"));
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'affiche du terrain : " + e.getMessage());
    }
    return terrains;
}

public void supprimerTerrain(int idterrain) {
    String query = "DELETE FROM terrains WHERE id_terrain = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idterrain);
        stmt.executeUpdate();
        System.out.println("terrain supprime");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression du terrain : " + e.getMessage());
    }
}

}
