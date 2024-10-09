package tn.esprit._5infini1projetdevops.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit._5infini1projetdevops.Entity.Universite;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "foyer")
public class Foyer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idFoyer;
    String nomFoyer;
    Long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    Universite universite;




    public void setId(Long idFoyer) {
    }
}