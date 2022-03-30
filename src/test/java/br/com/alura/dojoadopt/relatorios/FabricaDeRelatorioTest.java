package br.com.alura.dojoadopt.relatorios;

import br.com.alura.dojoadopt.animal.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

class FabricaDeRelatorioTest {

    private FabricaDeRelatorio fabricaDeRelatorio;

    private Animal cachorro;
    private Animal cachorro2;
    private Animal gato;
    private AnimalView cachorroView;
    private AnimalView cachorro2View;
    private AnimalView gatoView;
    private AnimalRepository animalRepository;

    @BeforeEach
    void setUp() {
        cachorro = AnimalBuilder.anAnimal().withNome("cachorro 1").withAnimalTipo(AnimalTipo.CACHORRO).withAnimalPorte(AnimalPorte.MINI).withCustoMensal(100L).withDataNascimento(LocalDate.now()).withFotoURL("https://foto.legl.com").build();
        cachorro2 = AnimalBuilder.anAnimal().withNome("cachorro 2").withAnimalTipo(AnimalTipo.CACHORRO).withAnimalPorte(AnimalPorte.GIGANTE).withCustoMensal(100L).withDataNascimento(LocalDate.now()).withFotoURL("https://foto.legl.com").build();
        gato = AnimalBuilder.anAnimal().withNome("gato").withAnimalTipo(AnimalTipo.GATO).withAnimalPorte(AnimalPorte.MINI).withCustoMensal(100L).withDataNascimento(LocalDate.now()).withFotoURL("https://foto.legl.com").build();

        cachorroView = new AnimalView(cachorro);
        cachorro2View = new AnimalView(cachorro2);
        gatoView = new AnimalView(gato);

        animalRepository = Mockito.mock(AnimalRepository.class);

        fabricaDeRelatorio = new FabricaDeRelatorio(animalRepository);
    }

    @Test
    void animaisPorTipo__deve_retornar_um_mapa_dos_animais_agrupados_por_tipo() {
        Mockito.when(animalRepository.findAll()).thenReturn(List.of(cachorro, cachorro2, gato));

        assertThat(fabricaDeRelatorio.animaisPorTipo())
                .containsExactlyInAnyOrderEntriesOf(
                        Map.ofEntries(entry(AnimalTipo.CACHORRO, List.of(cachorroView, cachorro2View)), entry(AnimalTipo.GATO, List.of(gatoView)))
                );
    }
}