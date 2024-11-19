package tn.esprit._5infini1projetdevops.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit._5infini1projetdevops.Entity.Foyer;

import java.util.List;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {

}