package edu.supavenir.spanimals.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.supavenir.spanimals.entites.Refuge;

public interface RefugeRepository extends JpaRepository<Refuge, Integer> {

}