package packageDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.demo1.Candidats;
import com.example.demo1.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Imple implements Dao {
    Connection connection = Conexion.connect();
    Statement st;
    @Override
    public void AjouterCandidat(String id, String nom, String prenom,String adresse,String mail, String ville, String pays) {
        String query = "INSERT INTO Candidats VALUES (" + id + ", '" + nom + "','" + prenom + "','" + adresse + "', '"+ mail + "','"+ville+"','"+pays+"'";

        try{
            st = connection.createStatement();
            st.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void SupprimerCandidat(String id) {

        String query = "DELETE FROM Candidats WHERE id ="+id;
        try{
            st= connection.createStatement();
            st.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void ModifierCandidat(String id, String nom, String prenom,String adresse,String mail, String ville, String pays) {
        String query = "UPDATE Candidats SET '" + id + "', '" + nom + "','" + prenom + "','" + adresse + "', '"+ mail + "','"+ville+"','"+pays+"'";

        try{
            st= connection.createStatement();
            st.executeUpdate(query);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Candidats> candidatsList() {
        ObservableList<Candidats> List= FXCollections.observableArrayList();
        String query = "SELECT * FROM Candidats";
        ResultSet rs;

        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Candidats candidat;
            while(rs.next()){
                candidat = new Candidats(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adresse"),rs.getString("mail"),rs.getString("ville"),rs.getString("pays"));
                List.add(candidat);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return List;
    }


/*Conexion con;
    public String sql;



    @Override
    public void Ajouter_candidat(Candidats item) {


        try {
            con = new Conexion();

            PreparedStatement ps = con.connect().prepareStatement("Insert candidats Candidats values (?,?,?,?,?,?)");

           ps.setInt(1,item.getId_candidats());
            ps.setString(2, item.getNom());
            ps.setString(3, item.getPrenom());
            ps.setString(4, item.getMail());
            ps.setString(5,item.getAdresse());
            ps.setString(6,item.getVille());
            ps.setString(7,item.getPays());

            ps.execute();

            con.connect().commit();
            ps.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void Supprimer_candidat(Candidats item) {


        try {
            con = new Conexion();

            sql = "DELETE FROM Candidats WHERE Nom = '" +"'";

            PreparedStatement ps = con.connect().prepareStatement(sql);
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }




    @Override
    public void Modifier_candidat(Candidats item) {
        try {
            con = new Conexion();

            sql = "UPDATE Candidats SET Nom = '"+item.getNom() +"',Prenom = '"+item.getPrenom() +"',Mail = '" + item.getMail() + "',"
                    + "Adresse = '"+ item.getAdresse() +"',Ville = '"+ item.getVille() +"',Pays = '"+ item.getPays() +"' "
                    + "WHERE Nom = '" +item.getNom()+  "'";


            PreparedStatement ps = con.connect().prepareStatement(sql);

            ps.execute();

            con.connect().commit();
            ps.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Candidats> getAll() {
        return null;
    }*/
}
