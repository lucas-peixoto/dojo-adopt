package br.com.alura.dojoadopt.animal;

public interface AnimalGastoPorTipoProjection {
    AnimalTipo getTipo();
    int getQuantidade();
    Long getCustoMedio();

    default double getCustoMedioEmReais() {
        return getCustoMedio() / 100.0;
    }
}
