package br.com.alura.dojoadopt.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    boolean existsByNomeAndAnimalTipo(String nome, AnimalTipo animalTipo);

    @Query("""
        SELECT animalTipo as tipo, COUNT(id) as quantidade, AVG(custoMensal) as custoMedio
        FROM Animal
        GROUP BY animalTipo
    """)
    List<AnimalGastoPorTipoProjection> animalGastoPorTipo();
}