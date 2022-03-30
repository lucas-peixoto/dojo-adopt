package br.com.alura.dojoadopt.relatorios;

import br.com.alura.dojoadopt.animal.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FabricaDeRelatorio {

    private final AnimalRepository animalRepository;

    public FabricaDeRelatorio(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public Map<AnimalTipo, List<AnimalView>> animaisPorTipo() {
        return animalRepository.findAll().stream()
                .map(AnimalView::new)
                .collect(Collectors.groupingBy(AnimalView::getAnimalTipo));
    }

    public List<AnimalGastoPorTipoProjection> animalGastoPorTipo() {
        return animalRepository.animalGastoPorTipo();
    }
}
