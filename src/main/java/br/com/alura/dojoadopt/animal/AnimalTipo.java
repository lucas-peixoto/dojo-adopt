package br.com.alura.dojoadopt.animal;

import br.com.alura.dojoadopt.tutor.Tutor;

import java.util.List;

import static br.com.alura.dojoadopt.animal.AnimalPorte.GIGANTE;
import static br.com.alura.dojoadopt.animal.AnimalPorte.GRANDE;

public enum AnimalTipo {
    PEIXE {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            return tutor.moraEm(Tutor.Moradia.CASA_COM_PISCINA);
        }
    },
    REPTIL {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            return (!tutor.temAnimalTipo(GATO) && !tutor.temAnimalTipo(CACHORRO)) || tutor.moraEm(Tutor.Moradia.SITIO);
        }
    },
    CACHORRO {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            if (tutor.moraEm(Tutor.Moradia.APARTAMENTO)) {
                return tutor.getAnimaisTipo(CACHORRO).stream().map(Animal::getAnimalPorte).filter(animalPorte -> List.of(GIGANTE, GRANDE).contains(animalPorte)).toList().isEmpty();
            }

            return true;
        }
    },
    GATO {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            return tutor.getAnimaisTipo(CACHORRO).size() < 3;
        }
    },
    PASSARO {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            return !tutor.getNome().startsWith("A") && tutor.getIdade() > 18 && !tutor.moraEm(Tutor.Moradia.APARTAMENTO);
        }
    },
    EXOTICO {
        @Override
        public boolean podeSerAdotadoPor(Tutor tutor) {
            return tutor.getRemuneracao() > 50000 && tutor.moraEm(Tutor.Moradia.SITIO);
        }
    };

    public boolean podeSerAdotadoPor(Tutor tutor) {
        return true;
    }
}
