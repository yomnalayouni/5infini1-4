package tn.esprit._5infini1projetdevops.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "chambres")
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;
    @Column(unique = true)
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Bloc bloc;
    @OneToMany
    List<Reservation> reservations= new ArrayList<>();
}