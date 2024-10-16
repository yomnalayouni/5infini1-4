package tn.esprit._5infini1projetdevops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit._5infini1projetdevops.Entity.Chambre;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {
}
