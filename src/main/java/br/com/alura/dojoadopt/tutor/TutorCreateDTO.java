package br.com.alura.dojoadopt.tutor;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class TutorCreateDTO {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
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
    private Tutor.Moradia moradia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }

    public Long getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(Long remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Tutor.Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Tutor.Moradia moradia) {
        this.moradia = moradia;
    }

    public Tutor toEntity() {
        return new Tutor(nome, cpf, dataNascimento, fotoURL, remuneracao, moradia);
    }
}
