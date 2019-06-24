import java.awt.print.Book;

public class Parser {

    public static String testingJson;

    public static BookResult parse(String jsonText) {
        Gson gson = new Gson();
       BookResult sunrise = gson.fromJson(jsonText, BookResult.class);
        return bookresult;
    }
}
