package tn.esprit._5infini1projetdevops.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_ETUDIANT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idEtudiant;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole;
    LocalDate dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
<<<<<<< HEAD
    private List<Reservation> reservations = new ArrayList<>();



}
=======
    List<Reservation> reservations= new ArrayList<>();


}
>>>>>>> university
