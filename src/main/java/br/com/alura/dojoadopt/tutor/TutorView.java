package br.com.alura.dojoadopt.tutor;

import br.com.alura.dojoadopt.animal.AnimalView;

import java.util.ArrayList;
import java.util.List;

public class TutorView {
    private Long id;
    private String nome;
    private String cpf;
    private String fotoURL;
    private Long remuneracao;
    private Long gastoMensal;
    private List<AnimalView> animais = new ArrayList<>();

    public TutorView(Tutor tutor) {
        this.id = tutor.getId();
        this.nome = tutor.getNome();
        this.cpf = tutor.getCpf();
        this.fotoURL = tutor.getFotoURL();
        this.remuneracao = tutor.getRemuneracao();
        this.gastoMensal = tutor.getGastoMensal();
        this.animais = tutor.getAnimais().stream().map(AnimalView::new).toList();
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

    public String getFotoURL() {
        return fotoURL;
    }

    public Long getRemuneracao() {
        return remuneracao;
    }

    public Long getGastoMensal() {
        return gastoMensal;
    }

    public List<AnimalView> getAnimais() {
        return animais;
    }
}
