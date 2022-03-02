package br.com.alura.dojoadopt.tutor;

import br.com.alura.dojoadopt.animal.AnimalCreateDTO;
import br.com.alura.dojoadopt.animal.AnimalRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TutorCreateValidator implements Validator {

    private final TutorRepository tutorRepository;

    public TutorCreateValidator(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return TutorCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        TutorCreateDTO tutorCreateDTO = (TutorCreateDTO) target;

        if (tutorRepository.existsByCpf(tutorCreateDTO.getCpf())) {
            errors.rejectValue("cpf", "tutor.already.exists", "Um tutor com esse cpf já existe");
        }
    }
}
