package tn.esprit._5infini1projetdevops.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_FOYER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
<<<<<<< HEAD
    transient Universite universite;
    @OneToMany(mappedBy = "foyer")
    transient List<Bloc> blocs = new ArrayList<>();
=======
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    List<Bloc> blocs= new ArrayList<>();
>>>>>>> university
}