import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        var parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);
        
        Map<String, String> movie = moviesList.get(0);
        String imageUrl = movie.get("image");
        String title = movie.get("title");
        InputStream inputStream = new URL(imageUrl).openStream();
        StickersGenerator stickersGenerator = new StickersGenerator();
        stickersGenerator.Create(inputStream, title + ".png", title);

        // for (Map<String, String> movie : moviesList) {
        //     String imageUrl = movie.get("image");
        //     String title = movie.get("title");
        //     InputStream inputStream = new URL(imageUrl).openStream();
        //     StickersGenerator stickersGenerator = new StickersGenerator();
        //     stickersGenerator.Create(inputStream, title + ".png", title);
        // }


    }
}
