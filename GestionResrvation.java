import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionResrvation {


  public void reserver(int iduser, int idevent, int idsalle, int idterrain, String datereserv) {
    String query = "INSERT INTO reservations (id_user, id_event, id_salle, id_terrain, date_reservation) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, iduser);
        stmt.setInt(2, idevent);
        stmt.setInt(3, idsalle);
        stmt.setInt(4, idterrain);
        stmt.setString(5, datereserv);
        stmt.executeUpdate();
        System.out.println("reservation effectuee");
    } catch (SQLException e) {
      System.out.println("Erreur lors de la reservation : " + e.getMessage());
    }
}  

public boolean verifierdisponibilite(int idsalle, int idterrain, String datereserv) {
    String query = "SELECT COUNT(*) FROM reservations WHERE id_salle = ? AND id_terrain = ? AND date_reservation = ?";

    try (Connection conn = Dbcon.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, idsalle);
        stmt.setInt(2, idterrain);
        stmt.setString(3, datereserv);
        try (ResultSet rs = stmt.executeQuery()) {
          if (rs.next()) {
              int total = rs.getInt(1);
              return total == 0;
            }
          }
    } catch (SQLException e) {
      System.out.println("Erreur lors de la verification de la disponibilite : " + e.getMessage());  
    }
     return false;
  }

public List<String> afficherreserv() {
  List<String> reserv = new ArrayList<>();
  String query = "SELECT * FROM reservations";

  try (Connection conn = Dbcon.getConnection();
       PreparedStatement stmt = conn.prepareStatement(query);
       ResultSet rs = stmt.executeQuery()) {

      while (rs.next()) {
        reserv.add("ID: " + rs.getInt("id_reservation")+
          ",Utilisateur: " + rs.getInt("id_user")+
          ",Evenement: " + rs.getInt("id_event")+
          ",Salle: " + rs.getInt("id_salle")+
          ",Terrain: " + rs.getInt("id_terrain")+
          ",Date: " + rs.getString("date_reservation"));
      }
  } catch (SQLException e) {
    System.out.println("Erreur lors de l'affiche de la reservation : " + e.getMessage());
  }
  return reserv;
}


public void supprimerreserv(int idreserv) {
  String query = "DELETE FROM reservations WHERE id_reservation = ?";

  try (Connection conn = Dbcon.getConnection();
       PreparedStatement stmt = conn.prepareStatement(query)) {

      stmt.setInt(1, idreserv);
      stmt.executeUpdate();
      System.out.println("reservation supprimee");
  } catch (SQLException e) {
    System.out.println("Erreur lors de la suppression de la reservation : " + e.getMessage());
  }
}


public void modifierreserv(int idreserv, int newidsal, int newidterrain, String newdatereserv) {
  String query = "UPDATE reservations SET id_salle = ?, id_terrain = ?, date_reservation = ? WHERE id_reservation = ?";

  try (Connection conn = Dbcon.getConnection();
       PreparedStatement stmt = conn.prepareStatement(query)) {

      stmt.setInt(1, newidsal);
      stmt.setInt(2, newidterrain);
      stmt.setString(3, newdatereserv);
      stmt.setInt(4, idreserv);
      
      stmt.executeUpdate();
      System.out.println("reservation modifiee");
  } catch (SQLException e) {
      System.out.println("Erreur lors de la modification de la reservation : " + e.getMessage());
  }
}


}
