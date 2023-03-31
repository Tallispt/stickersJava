import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
  private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
  private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");
  
  public List<Map<String, String>> parse(String json) {
    
    Matcher matcher = REGEX_ITEMS.matcher(json);
    if (!matcher.find()) {

        throw new IllegalArgumentException("No itens found");
    }

    String[] items = matcher.group(1).split("\\},\\{");

    List<Map<String, String>> data = new ArrayList<>();

    for (String item : items) {

        Map<String, String> itemAtributes = new HashMap<>();

        Matcher matcherJsonAtributes = REGEX_ATRIBUTOS_JSON.matcher(item);
        while (matcherJsonAtributes.find()) {
            String atribute = matcherJsonAtributes.group(1);
            String value = matcherJsonAtributes.group(2);
            itemAtributes.put(atribute, value);
        }

        data.add(itemAtributes);
    }

    return data;
  }
}
