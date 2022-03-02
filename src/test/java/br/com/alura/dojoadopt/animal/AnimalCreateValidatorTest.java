package br.com.alura.dojoadopt.animal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class AnimalCreateValidatorTest {

    private AnimalCreateValidator animalCreateValidator;
    private AnimalRepository animalRepository;
    private Errors errors;

    @BeforeEach
    void setUp() {
        animalRepository = mock(AnimalRepository.class);
        errors = mock(Errors.class);

        animalCreateValidator = new AnimalCreateValidator(animalRepository);
    }

    @Test
    void validate__should_reject_for_existing_code() {
        AnimalCreateDTO animalCreateDTO = new AnimalCreateDTO();
        when(animalRepository.existsByNomeAndAnimalTipo(any(), any())).thenReturn(true);

        animalCreateValidator.validate(animalCreateDTO, errors);

        verify(errors).rejectValue("nome", "animal.already.exists", "Um animal com esse nome e tipo já existe");
    }

    @Test
    void validate__should_not_reject_for_non_existing_code() {
        AnimalCreateDTO animalCreateDTO = new AnimalCreateDTO();
        when(animalRepository.existsByNomeAndAnimalTipo(any(), any())).thenReturn(false);

        animalCreateValidator.validate(animalCreateDTO, errors);

        verify(errors, never()).rejectValue(any(), any(), any());
    }
}