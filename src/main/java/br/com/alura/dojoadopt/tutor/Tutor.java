package br.com.alura.dojoadopt.tutor;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public Long getRemuneracao() {
        return remuneracao;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public enum Moradia {
        CASA, APARTAMENTO, CASA_COM_QUINTAL, CASA_COM_PISCINA, SITIO;
    }
}
