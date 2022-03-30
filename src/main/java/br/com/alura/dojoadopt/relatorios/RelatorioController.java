package br.com.alura.dojoadopt.relatorios;

import br.com.alura.dojoadopt.animal.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class RelatorioController {

    private final FabricaDeRelatorio fabricaDeRelatorio;

    public RelatorioController(FabricaDeRelatorio fabricaDeRelatorio) {
        this.fabricaDeRelatorio = fabricaDeRelatorio;
    }

    @GetMapping("/relatorio/animais/tipos")
    public String animaisTipos(Model model) {
        Map<AnimalTipo, List<AnimalView>> animaisPorTipo = fabricaDeRelatorio.animaisPorTipo();

        model.addAttribute("animaisPorTipo", animaisPorTipo);

        return "relatorio/animaisPorTipo";
    }

    @GetMapping("/relatorio/animais/gasto")
    public String animaisGastoPorTipo(Model model) {
        List<AnimalGastoPorTipoProjection> animaisGastoPorTipo = fabricaDeRelatorio.animalGastoPorTipo();

        model.addAttribute("animaisGastoPorTipo", animaisGastoPorTipo);

        return "relatorio/animaisGastoPorTipo";
    }
}
