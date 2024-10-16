package tn.esprit._5infini1projetdevops.services;

import tn.esprit._5infini1projetdevops.Entity.Bloc;

import java.util.List;

public interface IBlocService {

    public Bloc addBloc(Bloc bloc);
    public void deleteBloc(Long idBloc);
    public Bloc updateBloc(Bloc bloc);
    public List<Bloc> getAllblocs();
    public Bloc getbloc(Long idBloc);
    public List<Bloc> trouverBlocsParNomEtCap (String c , Long b);

}
