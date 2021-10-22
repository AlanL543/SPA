
package edu.supavenir.spanimals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.spanimals.entites.Animal;
import edu.supavenir.spanimals.entites.Espece;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    public List<Animal> findBySos(boolean sos);

    public List<Animal> findByAdopte(boolean adopte);

    public List<Animal> findByEspece(Espece espece);
}
