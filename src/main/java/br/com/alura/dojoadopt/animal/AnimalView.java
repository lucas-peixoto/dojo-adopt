package br.com.alura.dojoadopt.animal;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalView that = (AnimalView) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(custoMensal, that.custoMensal) && Objects.equals(dataNascimento, that.dataNascimento) && animalTipo == that.animalTipo && animalPorte == that.animalPorte && Objects.equals(fotoURL, that.fotoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, custoMensal, dataNascimento, animalTipo, animalPorte, fotoURL);
    }
}
