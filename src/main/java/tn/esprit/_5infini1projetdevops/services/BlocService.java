package tn.esprit._5infini1projetdevops.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.Repository.BlocRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class BlocService {

    private BlocRepository blocRepository;


    public Bloc addBloc(Bloc bloc)
    {
        return blocRepository.save(bloc);
    }


    public void deleteBloc(Long idBloc)
    {
        blocRepository.deleteById(idBloc);
    }


   
   public Bloc updateBloc(Bloc bloc) {
       // Récupérer le bloc existant depuis la base de données
       Bloc existingBloc = blocRepository.findById(bloc.getIdBloc())
               .orElseThrow(() -> new IllegalArgumentException("Bloc not found"));

       // Mettre à jour les champs nécessaires
       existingBloc.setNomBloc(bloc.getNomBloc());
       existingBloc.setCapaciteBloc(bloc.getCapaciteBloc());

       // Enregistrer le bloc mis à jour
       return blocRepository.save(existingBloc);
   }



    @Scheduled(fixedDelay = 15000)

    public List<Bloc> getAllblocs() {
        List<Bloc> listB = blocRepository.findAll();
        log.info("taille totale : "+listB.size());
        for (Bloc b : listB){
            log.info("bloc:" +b);
        }
        return listB;

    }


    public Bloc getbloc(Long idBloc) {
    return blocRepository.findById(idBloc).orElseThrow(() -> new IllegalArgumentException("Bloc with ID " + idBloc + " not found"));
}

    


    public List<Bloc> trouverBlocsParNomEtCap(String c, Long b) {

        return blocRepository.findAllByNomBlocIsAndCapaciteBloc(c, b);
    }

}
