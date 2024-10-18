package tn.esprit._5infini1projetdevops.Controllers;

import org.springframework.web.bind.annotation.*;
import tn.esprit._5infini1projetdevops.Entity.Bloc;
import tn.esprit._5infini1projetdevops.services.BlocService;

import java.util.List;

public class BlocRestControllor {
    public BlocService blocService ;
    @PostMapping(path = "/add-bloc")
    public Bloc addBloc (@RequestBody Bloc bloc)
    {
        return blocService.addBloc(bloc);
    }

    @GetMapping("/show-bloc")
    public List<Bloc> getAllblocs() {
        List<Bloc> listBlocs = blocService.getAllblocs();
        return listBlocs;
    }

    @GetMapping("/show-blocid/{id}")
    public List<Bloc> gelBloc(@PathVariable("id") Long idBloc)
    {
        return (List<Bloc>) blocService.getbloc(idBloc);
    }


    @DeleteMapping(path = "/delete-bloc/{id}")
    public void deleteBloc (@PathVariable ("id") Long idBloc)
    {
        blocService.deleteBloc(idBloc);
    }


    @PutMapping(path = "/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc b)
    {

        Bloc bloc = blocService.updateBloc(b);
        return bloc ;
    }

    @GetMapping("/show-blocandcapacite/{c}/{b}")
    public void recuperBlocsParNomEtCap(@PathVariable ("c") String c,
                                        @PathVariable("b")Long b)
    {
        blocService.trouverBlocsParNomEtCap(c, b);
    }

}
