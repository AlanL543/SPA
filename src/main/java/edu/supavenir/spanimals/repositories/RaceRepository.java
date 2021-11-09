package edu.supavenir.spanimals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.spanimals.entites.Race;

<<<<<<< HEAD
public interface RaceRepository extends JpaRepository<Race, Integer>{

=======
public interface RaceRepository extends JpaRepository<Race, Integer> {
	public Race findByLibelle(String libelle);
>>>>>>> 9eb69e92ffdc4d69a330c85ca2099dd557a388d0
}
