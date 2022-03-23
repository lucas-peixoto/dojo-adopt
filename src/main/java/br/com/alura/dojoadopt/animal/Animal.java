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
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    private LocalDate adoptionDate;

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

    public double getCustoMensalEmReais() {
        return custoMensal / 100.0;
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

    public void addTutor(Tutor tutor) {
        this.tutor = tutor;
        this.adoptionDate = LocalDate.now();
    }

    public boolean eDoTipo(AnimalTipo animalTipo) {
        return animalTipo.equals(this.animalTipo);
    }

    public boolean temPorte(AnimalPorte animalPorte) {
        return animalPorte.equals(this.animalPorte);
    }

    public boolean podeSerAdotadoPor(Tutor tutor) {
        return !tutor.eDonoDe(this) && tutor.podeCobrirGastosDe(this) && getAnimalTipo().podeSerAdotadoPor(tutor);
    }
}
