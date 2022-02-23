package br.com.alura.dojoadopt.animal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AnimalCreateValidator implements Validator {

    private final AnimalRepository animalRepository;

    public AnimalCreateValidator(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return AnimalCreateDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AnimalCreateDTO animalCreateDTO = (AnimalCreateDTO) target;

        if (animalRepository.existsByNomeAndAnimalTipo(animalCreateDTO.getNome(), animalCreateDTO.getAnimalTipo())) {
            errors.rejectValue("nome", "animal.already.exists", "Um animal com esse nome e tipo já existe");
        }
    }
}
