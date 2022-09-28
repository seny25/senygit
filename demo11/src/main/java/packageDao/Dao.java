package packageDao;

import javafx.collections.ObservableList;
import com.example.demo1.Candidats;

public interface Dao
{
   public void AjouterCandidat(String id , String nom , String prenom ,String adresse,String mail,String ville , String pays);

   public void SupprimerCandidat(String id);

   public void ModifierCandidat(String id, String nom, String prenom,String adresse,String mail, String ville, String pays);

   public ObservableList<Candidats> candidatsList();



}
