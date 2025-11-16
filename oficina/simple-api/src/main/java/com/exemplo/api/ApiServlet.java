package main.java.com.exemplo.api;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Um único Servlet para lidar com todos os endpoints da API.
 * A anotação @WebServlet mapeia todas as URLs solicitadas para este servlet.
 */
@WebServlet(urlPatterns = {
        "/areas",
        "/cursos",
        "/campus",
        "/modalidades"
})
public class ApiServlet extends HttpServlet {

    // Instância do Gson para converter objetos Java para JSON
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obter o caminho que foi solicitado (ex: "/areas")
        String path = req.getServletPath();

        // Objeto para armazenar os dados de resposta
        Object data;

        // Roteamento: decide quais dados retornar com base no 'path'
        switch (path) {
            case "/areas":
                data = getAreas();
                break;
            case "/cursos":
                data = getCursos();
                break;
            case "/campus":
                data = getCampus();
                break;
            case "/modalidades":
                data = getModalidades();
                break;
            default:
                // Se algo der errado (não deve acontecer devido ao @WebServlet)
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Endpoint não encontrado");
                return;
        }

        // --- Preparar e Enviar a Resposta JSON ---

        // 1. Converter os dados (a Lista) para uma string JSON
        String jsonResponse = gson.toJson(data);

        // 2. Definir o tipo de conteúdo da resposta como JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // 3. Escrever o JSON na resposta
        PrintWriter out = resp.getWriter();
        out.print(jsonResponse);
        out.flush();
    }

    // --- Métodos Privados para buscar os dados ---

    private List<String> getAreas() {
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

    private List<String> getCursos() {
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

    private List<String> getCampus() {
        return Arrays.asList(
                "augusta",
                "mooca"
        );
    }

    private List<String> getModalidades() {
        return Arrays.asList(
                "presencial",
                "ead"
        );
    }
}
