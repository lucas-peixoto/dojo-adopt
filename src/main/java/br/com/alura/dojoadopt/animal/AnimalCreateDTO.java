package br.com.alura.dojoadopt.animal;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AnimalCreateDTO {

    @NotBlank
    @Size(max = 50)
    private String nome;

    @NotNull
    @Min(1000)
    private Long custoMensal;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    private AnimalTipo animalTipo;

    @NotNull
    private AnimalPorte animalPorte;

    @NotNull
    @URL
    private String fotoURL;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(Long custoMensal) {
        this.custoMensal = custoMensal;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public AnimalTipo getAnimalTipo() {
        return animalTipo;
    }

    public void setAnimalTipo(AnimalTipo animalTipo) {
        this.animalTipo = animalTipo;
    }

    public AnimalPorte getAnimalPorte() {
        return animalPorte;
    }

    public void setAnimalPorte(AnimalPorte animalPorte) {
        this.animalPorte = animalPorte;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public Animal toEntity() {
        return new Animal(nome, custoMensal, dataNascimento, animalTipo, animalPorte, fotoURL);
    }
}
