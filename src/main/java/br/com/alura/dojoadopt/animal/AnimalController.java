package br.com.alura.dojoadopt.animal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @InitBinder("animalCreateDTO")
    void animalCreateDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new AnimalCreateValidator(animalRepository));
    }

    @GetMapping("/animal")
    public String list(Model model) {
        List<AnimalView> animais = animalRepository.findAll().stream().map(AnimalView::new).toList();
        model.addAttribute("animals", animais);

        return "animal/list";
    }

    @GetMapping("/animal/create")
    public String createForm(AnimalCreateDTO animalCreateDTO, Model model) {
        model.addAttribute("animalTipo", AnimalTipo.values());
        model.addAttribute("animalPorte", AnimalPorte.values());
        model.addAttribute("animalCreateDTO", animalCreateDTO);

        return "animal/create";
    }

    @PostMapping("/animal/create")
    public String create(@Valid AnimalCreateDTO animalCreateDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createForm(animalCreateDTO, model);
        }

        Animal animal = animalCreateDTO.toEntity();
        animalRepository.save(animal);

        return "redirect:/animal";
    }
}
