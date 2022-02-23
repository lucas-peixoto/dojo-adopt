package br.com.alura.dojoadopt.animal;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Long custoMensal;
    private LocalDate dataNascimento;
    private AnimalTipo animalTipo;
    private AnimalPorte animalPorte;
    private String fotoURL;

    public Animal() {}

    public Animal(String nome, Long custoMensal, LocalDate dataNascimento, AnimalTipo animalTipo, AnimalPorte animalPorte, String fotoURL) {
        this.nome = nome;
        this.custoMensal = custoMensal;
        this.dataNascimento = dataNascimento;
        this.animalTipo = animalTipo;
        this.animalPorte = animalPorte;
        this.fotoURL = fotoURL;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getCustoMensal() {
        return custoMensal;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public AnimalTipo getAnimalTipo() {
        return animalTipo;
    }

    public AnimalPorte getAnimalPorte() {
        return animalPorte;
    }

    public String getFotoURL() {
        return fotoURL;
    }
}
