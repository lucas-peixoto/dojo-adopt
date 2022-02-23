package br.com.alura.dojoadopt.animal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    boolean existsByNomeAndAnimalTipo(String nome, AnimalTipo animalTipo);
}