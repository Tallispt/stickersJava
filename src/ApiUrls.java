public enum ApiUrls {

  IMDB_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ImdbContentExtractor()),
  IMDB_SERIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json", new ImdbContentExtractor()),
  NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14", new NasaContentExtractor());

  private String url;
  private ContentExtractor extractor;
  
  private ApiUrls(String url, ContentExtractor extractor) {
    this.url = url;
    this.extractor = extractor;
  }
  public String getUrl() {
    return url;
  }
  public ContentExtractor getExtractor() {
    return extractor;
  }

  
}
