package br.com.alura.dojoadopt.tutor;

public class TutorView {
    private Long id;
    private String nome;
    private String cpf;
    private String fotoURL;

    public TutorView(Tutor tutor) {
        this.id = tutor.getId();
        this.nome = tutor.getNome();
        this.cpf = tutor.getCpf();
        this.fotoURL = tutor.getFotoURL();
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
}
