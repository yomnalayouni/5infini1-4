package tn.esprit._5infini1projetdevops.Entity;
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
    Foyer foyer;

<<<<<<< HEAD

    public void setId(Long idUniversite) {
=======
    public void setId(Long idUniversite) {
        this.idUniversite = idUniversite; // Assign the provided ID to the field
>>>>>>> university
    }
}
