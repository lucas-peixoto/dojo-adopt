package br.com.alura.dojoadopt.adoption;

import br.com.alura.dojoadopt.animal.*;
import br.com.alura.dojoadopt.exceptions.NotFoundException;
import br.com.alura.dojoadopt.tutor.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdoptionController {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    public AdoptionController(AnimalRepository animalRepository, TutorRepository tutorRepository) {
        this.animalRepository = animalRepository;
        this.tutorRepository = tutorRepository;
    }

    @GetMapping("/adocao/{tutorId}")
    public String adoptionForm(@PathVariable Long tutorId, Model model) {
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(NotFoundException::new);
        TutorView tutorView = new TutorView(tutor);

        List<AnimalView> animaisDisponiveis = animalRepository.findAll().stream()
                .filter(animal -> animal.podeSerAdotadoPor(tutor))
                .map(AnimalView::new)
                .toList();

        model.addAttribute("tutor", tutorView);
        model.addAttribute("animaisDisponiveis", animaisDisponiveis);

        return "adoption/adoption";
    }

    @PostMapping("/adocao/tutor/{tutorId}/animal/{animalId}")
    public String adoption(@PathVariable Long tutorId, @PathVariable Long animalId, Model model) {
        Tutor tutor = tutorRepository.findById(tutorId).orElseThrow(NotFoundException::new);
        Animal animal = animalRepository.findById(animalId).orElseThrow(NotFoundException::new);

        if (!animal.podeSerAdotadoPor(tutor)) {
            return "redirect:/adocao/%d".formatted(tutor.getId());
        }

        tutor.adopt(animal);
        tutorRepository.save(tutor);

        return "redirect:/tutor/perfil";
    }
}
