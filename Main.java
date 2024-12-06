import java.util.List;

public class Main {
    public static void main(String[] args) {

        GestionUtilisateur gestUtil = new GestionUtilisateur();

        gestUtil.ajouterutilis("salma", "bouya", "salma@gmail.com", "etudiant");
        gestUtil.ajouterutilis("hassna", "hada", "hassna@gmail.com", "etudiant");
        gestUtil.ajouterutilis("mounir", "bayan", "mounir@gmail.com", "professeur");

        System.out.println("liste des utilisateurs :");
        List<String> utilisateurs = gestUtil.afficherutilis();
        for (String utilisateur : utilisateurs) {
            System.out.println(utilisateur);
        }

        gestUtil.supprimerutilis(2);

        System.out.println("liste des utilisateurs apres supperssion :");
        utilisateurs = gestUtil.afficherutilis();
        for (String utilisateur : utilisateurs) {
            System.out.println(utilisateur);
        }

        GestionSalleTerrain gestSalTerrain = new GestionSalleTerrain();

        gestSalTerrain.ajoutersal("salle A", 50);
        gestSalTerrain.ajoutersal("salle B", 30);
        gestSalTerrain.ajoutersal("salle C", 50);

        gestSalTerrain.ajouterterrain("terrain 1", "football");
        gestSalTerrain.ajouterterrain("terrain 2", "fasketball");
        gestSalTerrain.ajouterterrain("terrain 3", "volleyball");

        System.out.println("\nliste des salles :");
        List<String> salles = gestSalTerrain.affichersal();
        for (String salle : salles) {
            System.out.println(salle);
        }

        System.out.println("\nliste des terrains :");
        List<String> terrains = gestSalTerrain.afficherterrain();
        for (String terrain : terrains) {
            System.out.println(terrain);
        }

        gestSalTerrain.supprimersal(3);
        gestSalTerrain.supprimerTerrain(3);

        System.out.println("\nliste des salles apres suppresission :");
        salles = gestSalTerrain.affichersal();
        for (String salle : salles) {
            System.out.println(salle);
        }
        System.out.println("\nliste des terrains apres suppression :");
        terrains = gestSalTerrain.afficherterrain();
        for (String terrain : terrains) {
            System.out.println(terrain);
        }
        

        GestionEvenement gestEven = new GestionEvenement();

        gestEven.ajoutereven("football tournament", "2024-12-15", " match", 1);
        gestEven.ajoutereven("DAMA", "2024-12-20", "jeux", 3);
        gestEven.ajoutereven("volley tournament", "2024-12-19", " match", 1);

        System.out.println("\nliste des evenements :");
        List<String> evenements = gestEven.affichereven();
        for (String evenement : evenements) {
            System.out.println(evenement);
        }

        gestEven.modifiereven(1, "basketball", "2024-12-18", "new match");

        System.out.println("\nliste des evenements apres modification :");
         evenements = gestEven.affichereven();
        for (String evenement : evenements) {
            System.out.println(evenement);
        }

        gestEven.supprimereven(2);

        System.out.println("\nliste des evenements apres suppression :");
         evenements = gestEven.affichereven();
        for (String evenement : evenements) {
            System.out.println(evenement);
        }

        GestionResrvation gestResrv = new GestionResrvation();

        gestResrv.reserver(1, 1, 1, 1, "2024-12-15");  // Salle 1, Terrain 1, Utilisateur 1
        gestResrv.reserver(3, 3, 2, 2, "2024-12-20");  // Salle 2, Terrain 2, Utilisateur 2

        System.out.println("\nliste des reservations :");
        List<String> reservations = gestResrv.afficherreserv();
        for (String reservation : reservations) {
            System.out.println(reservation);
        }

        boolean disponibleSalle1 = gestResrv.verifierdisponibilite(1, 1, "2024-12-15");
        boolean disponibleSalle2 = gestResrv.verifierdisponibilite(2, 2, "2024-12-20");
        boolean disponibleSalle3 = gestResrv.verifierdisponibilite(1, 1, "2024-12-18");

        System.out.println("\ndisponibilite des salles :");
        System.out.println("Salle 1 (2024-12-15): " + (disponibleSalle1 ? "Disponible" : "Indisponible"));
        System.out.println("Salle 2 (2024-12-20): " + (disponibleSalle2 ? "Disponible" : "Indisponible"));
        System.out.println("Salle 1 (2024-12-18): " + (disponibleSalle3 ? "Disponible" : "Indisponible"));

        gestResrv.modifierreserv(1, 2, 2, "2024-12-22");

        System.out.println("\nliste des reservations apres modification :");
        reservations = gestResrv.afficherreserv();
        for (String reservation : reservations) {
            System.out.println(reservation);
        }
        gestResrv.supprimerreserv(1);
        System.out.println("\nliste des reservations apres suppression :");
        reservations = gestResrv.afficherreserv();
        for (String reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
