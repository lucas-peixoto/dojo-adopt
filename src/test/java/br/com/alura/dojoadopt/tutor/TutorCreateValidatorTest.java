package br.com.alura.dojoadopt.tutor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TutorCreateValidatorTest {

    private TutorCreateValidator tutorCreateValidator;
    private TutorRepository tutorRepository;
    private Errors errors;

    @BeforeEach
    void setUp() {
        tutorRepository = mock(TutorRepository.class);
        errors = mock(Errors.class);

        tutorCreateValidator = new TutorCreateValidator(tutorRepository);
    }

    @Test
    void validate__should_reject_for_existing_cpf() {
        TutorCreateDTO tutorCreateDTO = new TutorCreateDTO();
        when(tutorRepository.existsByCpf(any())).thenReturn(true);

        tutorCreateValidator.validate(tutorCreateDTO, errors);

        verify(errors).rejectValue("cpf", "tutor.already.exists", "Um tutor com esse cpf já existe");
    }

    @Test
    void validate__should_not_reject_for_non_existing_code() {
        TutorCreateDTO tutorCreateDTO = new TutorCreateDTO();
        when(tutorRepository.existsByCpf(any())).thenReturn(false);

        tutorCreateValidator.validate(tutorCreateDTO, errors);

        verify(errors, never()).rejectValue(any(), any(), any());
    }

}