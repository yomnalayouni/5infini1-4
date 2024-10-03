package tn.esprit._5infini1projetdevops.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_RESERVATION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation implements Serializable {
    @Id
    String idReservation;
    LocalDate anneeUniversitaire;
    boolean estValide;
    @ManyToMany
    @JsonIgnore
    List<Etudiant> etudiants = new ArrayList<>();

}