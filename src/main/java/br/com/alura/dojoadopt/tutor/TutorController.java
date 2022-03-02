package br.com.alura.dojoadopt.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TutorController {

    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @InitBinder("tutorCreateDTO")
    void animalCreateDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(new TutorCreateValidator(tutorRepository));
    }

    @GetMapping("/tutor")
    public String list(Model model) {
        List<TutorView> tutores = tutorRepository.findAll().stream().map(TutorView::new).toList();
        model.addAttribute("tutores", tutores);

        return "tutor/list";
    }

    @GetMapping("/tutor/create")
    public String createForm(TutorCreateDTO tutorCreateDTO, Model model) {
        model.addAttribute("moradias", Tutor.Moradia.values());
        model.addAttribute("tutorCreateDTO", tutorCreateDTO);

        return "tutor/create";
    }

    @PostMapping("/tutor/create")
    public String create(@Valid TutorCreateDTO tutorCreateDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createForm(tutorCreateDTO, model);
        }

        Tutor tutor = tutorCreateDTO.toEntity();
        tutorRepository.save(tutor);

        return "redirect:/tutor";
    }
}
