package tn.esprit._5infini1projetdevops.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "chambres")
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idChambre;
    @Column(unique = true)
    long numeroChambre;
    @Enumerated(EnumType.STRING)
    TypeChambre typeC;

    @ManyToOne(cascade = CascadeType.ALL)
    Bloc bloc;

    @OneToMany
    List<Reservation> reservations= new ArrayList<>();
}