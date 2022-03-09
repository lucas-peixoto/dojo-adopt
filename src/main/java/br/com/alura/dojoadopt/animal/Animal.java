package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.tutor.Tutor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "nome", "animalTipo" }) })
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String nome;

    @ManyToOne
    private Tutor tutor;

    @NotNull
    @Min(1000)
    private Long custoMensal;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AnimalTipo animalTipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AnimalPorte animalPorte;

    @URL
    @NotNull
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
