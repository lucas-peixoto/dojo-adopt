package br.com.alura.dojoadopt.tutor;

import br.com.alura.dojoadopt.animal.Animal;
import br.com.alura.dojoadopt.animal.AnimalTipo;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @OneToMany(mappedBy = "tutor")
    private List<Animal> animais = new ArrayList<>();

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @URL
    @NotNull
    private String fotoURL;

    @NotNull
    private Long remuneracao;

    @NotNull
    private Moradia moradia;

    public Tutor() {}

    public Tutor(String nome, String cpf, LocalDate dataNascimento, String fotoURL, Long remuneracao, Moradia moradia) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.fotoURL = fotoURL;
        this.remuneracao = remuneracao;
        this.moradia = moradia;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public Long getRemuneracao() {
        return remuneracao;
    }

    public double getRemuneracaoEmReais() {
        return remuneracao / 100.0;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public Long getIdade() {
        return YEARS.between(dataNascimento, LocalDate.now());
    }

    public Long getGastoMensal() {
        return animais.stream().mapToLong(Animal::getCustoMensal).sum();
    }

    public boolean podeCobrirGastosDe(Animal animal) {
        return (getGastoMensal() + animal.getCustoMensal()) > 0;
    }

    public void adopt(Animal animal) {
        animais.add(animal);
        animal.addTutor(this);
    }

    public boolean temAnimalTipo(AnimalTipo animalTipo) {
        return animais.stream().anyMatch(animal -> animal.eDoTipo(animalTipo));
    }

    public boolean temAnimalTipoGato() {
        return animais.stream().anyMatch(animal -> animal.eDoTipo(AnimalTipo.GATO));
    }

    public boolean temAnimalTipoCachorro() {
        return animais.stream().anyMatch(animal -> animal.eDoTipo(AnimalTipo.CACHORRO));
    }

    public List<Animal> getAnimaisTipo(AnimalTipo animalTipo) {
        return animais.stream().filter(animal -> animal.eDoTipo(animalTipo)).toList();
    }

    public boolean moraEm(Moradia moradia) {
        return moradia.equals(this.moradia);
    }

    public enum Moradia {
        CASA, APARTAMENTO, CASA_COM_QUINTAL, CASA_COM_PISCINA, SITIO;
    }
}
