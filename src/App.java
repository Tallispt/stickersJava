import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        ApiUrls apiUrl = ApiUrls.IMDB_SERIES;

        String url = apiUrl.getUrl();
        ContentExtractor extractor = apiUrl.getExtractor();

        var http = new Client();
        String jsonBody = http.dataSearch(url);
        
        List<Content> list = extractor.contentExtractor(jsonBody);
        StickersGenerator stickersGenerator = new StickersGenerator();

        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            String title = content.getTitle();
            stickersGenerator.Create(inputStream, title + ".png", title);
        }
    }
}
