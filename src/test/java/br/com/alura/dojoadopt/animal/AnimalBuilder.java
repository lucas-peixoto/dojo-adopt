package br.com.alura.dojoadopt.animal;

import java.time.LocalDate;

public final class AnimalBuilder {
    private String nome;
    private Long custoMensal;
    private LocalDate dataNascimento;
    private AnimalTipo animalTipo;
    private AnimalPorte animalPorte;
    private String fotoURL;

    private AnimalBuilder() {
    }

    public static AnimalBuilder anAnimal() {
        return new AnimalBuilder();
    }

    public AnimalBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public AnimalBuilder withCustoMensal(Long custoMensal) {
        this.custoMensal = custoMensal;
        return this;
    }

    public AnimalBuilder withDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public AnimalBuilder withAnimalTipo(AnimalTipo animalTipo) {
        this.animalTipo = animalTipo;
        return this;
    }

    public AnimalBuilder withAnimalPorte(AnimalPorte animalPorte) {
        this.animalPorte = animalPorte;
        return this;
    }

    public AnimalBuilder withFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
        return this;
    }

    public Animal build() {
        return new Animal(nome, custoMensal, dataNascimento, animalTipo, animalPorte, fotoURL);
    }
}
