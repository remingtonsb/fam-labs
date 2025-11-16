package com.exemplo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @RestController = Diz ao Spring que esta classe é um controlador de API
 * e que as respostas dos métodos devem ser convertidas para JSON
 * automaticamente (sem precisar do Gson!).
 */
@RestController
public class ApiController {

    /**
     * @GetMapping = Mapeia requisições HTTP GET para esta URL.
     * Chega de "switch (path)"!
     */
    @GetMapping("/areas")
    public List<String> getAreas() {
        return Arrays.asList(
                "arquitetura_e_design",
                "ciencias_agrarias",
                "comunicacao",
                "direito",
                "educacao",
                "engenharias",
                "gastronomia_turismo_hotelaria_eventos",
                "gestao_negocios",
                "medicina",
                "medicina_veteriaria",
                "saude",
                "tecnologia_da_informacao"
        );
    }

    @GetMapping("/cursos")
    public List<String> getCursos() {
        // O Spring Boot converte esta "List<String>" em JSON automaticamente
        return Arrays.asList(
                "administracao",
                "agronomia",
                "analise_desenvolvimento_sistemas",
                "arquitetura_e_urbanismo",
                "banco_de_dados",
                "biomedicina",
                "ciencia_de_dados",
                "ciencia_biologicas",
                "ciencias_contabeis",
                "ciencias_da_computacao",
                "ciencias_economicas",
                "cinema_e_audiovisual"
        );
    }

    @GetMapping("/campus")
    public List<String> getCampus() {
        return Arrays.asList(
                "augusta",
                "mooca"
        );
    }

    @GetMapping("/modalidades")
    public List<String> getModalidades() {
        return Arrays.asList(
                "presencial",
                "ead"
        );
    }
}
