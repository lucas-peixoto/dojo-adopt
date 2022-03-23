package br.com.alura.dojoadopt.relatorios;

import br.com.alura.dojoadopt.animal.*;
import br.com.alura.dojoadopt.tutor.TutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RelatorioController {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    public RelatorioController(AnimalRepository animalRepository, TutorRepository tutorRepository) {
        this.animalRepository = animalRepository;
        this.tutorRepository = tutorRepository;
    }

    @GetMapping("/relatorio/animais/tipos")
    public String animaisTipos(Model model) {
        Map<AnimalTipo, List<AnimalView>> animaisPorTipo = animalRepository.findAll().stream()
                .map(AnimalView::new)
                .collect(Collectors.groupingBy(AnimalView::getAnimalTipo));

        model.addAttribute("animaisPorTipo", animaisPorTipo);

        return "relatorio/animaisPorTipo";
    }
}
