import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();

                BookResult bookresult = Parser.parse(Parser.testingJson);
                System.out.println(bookresult.results.title);
            }
        });
    }
}
