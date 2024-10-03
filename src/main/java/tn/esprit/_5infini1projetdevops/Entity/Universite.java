package tn.esprit._5infini1projetdevops.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "universite")
public class Universite {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idUniversite;
    String nomUniversite;
    String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    tn.esprit._5infini1projetdevops.entity.Foyer foyer;


    public void setId(Long idUniversite) {
    }
}
