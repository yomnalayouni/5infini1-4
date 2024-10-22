package tn.esprit._5infini1projetdevops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit._5infini1projetdevops.Entity.Bloc;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {



    //Récuperer les blocs qui ont une capacite inferieur à 50
    List<Bloc> findAllByCapaciteBlocLessThan(long c);
    //Récupérer tous les Blocs qui ont un nom qui commence par "Bl"
    List<Bloc> findAllByNomBlocIsStartingWith(String c);
    //Récupérer tous les blocs qui ont un nom donnée et une capacité donnée
    List<Bloc> findAllByNomBlocIsAndCapaciteBloc (String c , Long b);
    //Récupérer le bloc qui a un nom donnée
    Bloc findBlocByNomBloc(String b );

}
