import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

  public List<Content> contentExtractor(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> atributesList = parser.parse(json);

    return atributesList.stream()
    .map(atributes -> new Content(atributes.get("title"), atributes.get("url")))
    .toList();
  }
}
