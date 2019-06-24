public class Connection {

    String BASE_URL = "http://gen.lib.rus.ec/json.php";
    public final String composedUrl;

    public Connection{String title, String author, String md5}{
        composedUrl = BASE_URL + "tile" + title + author + "author" +
    }


}
