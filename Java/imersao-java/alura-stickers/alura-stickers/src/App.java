import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        buscaTop10();
        //buscaTop100();
        //buscaTop250();
        //buscaRecomendados();
    }

    public static void buscaTop10 () {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            var jasonParser = new JasonParser();
            List<Map<String, String>> listaDeFimes = jasonParser.parse(body);

            System.out.println("Top 10 filmes");
            System.out.println();

            for (Map<String,String> filme : listaDeFimes) {
                    System.out.println("Posição do filme: " + filme.get("rank"));
                    System.out.println("Título do filme: " + filme.get("title"));
                    System.out.println("Imagem do filme: " + filme.get("image"));
                    System.out.println("Avaliação do filme: " + filme.get("imDbRating"));
                    System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void buscaTop100 () {

        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            var jasonParser = new JasonParser();
            List<Map<String, String>> listaDeFimes = jasonParser.parse(body);

            System.out.println("Top 100 filmes");
            System.out.println();

            for (Map<String,String> filme : listaDeFimes) {
                System.out.println("Posição do filme: " + filme.get("rank"));
                System.out.println("Título do filme: " + filme.get("title"));
                System.out.println("Imagem do filme: " + filme.get("image"));
                System.out.println("Avaliação do filme: " + filme.get("imDbRating"));
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void buscaTop250 () {

        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            var jasonParser = new JasonParser();
            List<Map<String, String>> listaDeFimes = jasonParser.parse(body);

            System.out.println("Top 250 filmes");
            System.out.println();

            for (Map<String,String> filme : listaDeFimes) {
                System.out.println("Posição do filme: " + filme.get("rank"));
                System.out.println("Título do filme: " + filme.get("title"));
                System.out.println("Imagem do filme: " + filme.get("image"));
                System.out.println("Avaliação do filme: " + filme.get("imDbRating"));
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void buscaRecomendados () {

        String url = "https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request =  HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String>response;

        try{
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            var jasonParser = new JasonParser();
            List<Map<String, String>> listaDeFimes = jasonParser.parse(body);

            System.out.println("Filmes recomendados");
            System.out.println();

            for (Map<String,String> filme : listaDeFimes) {
                System.out.println("Título do filme: " + filme.get("title"));
                System.out.println("Imagem do filme: " + filme.get("image"));
                System.out.println("Avaliação do filme: " + filme.get("imDbRating"));
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
