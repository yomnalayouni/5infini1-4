package tn.esprit._5infini1projetdevops.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Table(name = "bloc")
    public class Bloc {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long idBloc;
        String nomBloc;
        long capaciteBloc;

        @ManyToOne
        Foyer foyer;
        @OneToMany (mappedBy = "bloc" , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        List<Chambre> chambres= new ArrayList<>();

        public void addChambre(Chambre chambre) {
            chambres.add(chambre);
            chambre.setBloc(this);
        }
    }

