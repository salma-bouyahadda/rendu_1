
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateur{

public void ajouterutilis(String nom,String prenom,String email,String type){
    String query = "INSERT INTO utilisateurs (nom,prenom,email,type) VALUES (?,?,?,?)";
    try(Connection conn=Dbcon.getConnection();
    PreparedStatement stmt=conn.prepareStatement(query)){
      stmt.setString(1, nom);
      stmt.setString(2, prenom);
      stmt.setString(3, email);
      stmt.setString(4, type);
      stmt.executeUpdate();
      System.out.println("utilisateur ajoute");
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout d'utilisateur : " + e.getMessage());
    }
}


public List<String> afficherutilis() {
    List<String> utilis = new ArrayList<>();
    String query = "SELECT * FROM utilisateurs";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            utilis.add("ID: " + rs.getInt("id_user")+
            ",Nom: " + rs.getString("nom")+
            ",Prenom: " + rs.getString("prenom")+
            ",Email: " + rs.getString("email")+
            ",Type: " + rs.getString("type"));
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'affichage d'utilisateur : " + e.getMessage());
    }
    return utilis;
}


public void supprimerutilis(int id) {
    String query = "DELETE FROM utilisateurs WHERE id_user = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("utilisateur supprime");
    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
    }
}

}