package br.com.alura.dojoadopt.tutor;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    boolean existsByCpf(@NotBlank String cpf);
}