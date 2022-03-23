package br.com.alura.dojoadopt.animal;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class AnimalView {

    private Long id;
    private String nome;
    private Long custoMensal;
    private LocalDate dataNascimento;
    private AnimalTipo animalTipo;
    private AnimalPorte animalPorte;
    private String fotoURL;

    public AnimalView(Animal animal) {
        this.id = animal.getId();
        this.nome = animal.getNome();
        this.custoMensal = animal.getCustoMensal();
        this.dataNascimento = animal.getDataNascimento();
        this.animalTipo = animal.getAnimalTipo();
        this.animalPorte = animal.getAnimalPorte();
        this.fotoURL = animal.getFotoURL();
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

    public double getCustoMensalEmReais() {
        return custoMensal / 100.0;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getIdade() {
        return YEARS.between(dataNascimento, LocalDate.now());
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
