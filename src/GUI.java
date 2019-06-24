import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {


    new JPanel panel1;
    new JTextField searchNameField;
    new JTextField searchAuthorField;
    new JTextField searchmd5Field;
    new JButton searchButton;
    new JLabel bookOutput;


    public GUI() {initializeGui();}

    private void initializeGui() {

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.setPreferredSize(new Dimension(600, 400));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(panel2);
        final JLabel label1 = new JLabel();
        label1.setText("Book Finder");


        panel2.add(label1);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel3.setPreferredSize(new Dimension(600, 200));
        panel1.add(panel3);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel4.setPreferredSize(new Dimension(300, 47));
        panel3.add(panel4);
        final JLabel label2 = new JLabel();
        label2.setHorizontalAlignment(2);
        label2.setText("Title:");
        panel4.add(label2);

        searchNameField = new JTextField();
        searchNameField.setPreferredSize(new Dimension(300,37));
        searchAuthorField.setText("Handbook of Clinical Drug Data");
        panel4.add(searchNameField);


        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel5.setPreferredSize(new Dimension(600, 200));
        panel4.add(panel5);
        final JLabel label3 = new JLabel();
        label3.setHorizontalAlignment(2);
        label3.setText("Author");

        searchAuthorField = new JTextField();
        searchAuthorField.setPreferredSize(new Dimension(300,37));
        searchAuthorField.setText("Philip Anderson");

        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel6.setPreferredSize(new Dimension(600, 200));
        panel5.add(panel6);
        final JLabel label4 = new JLabel();
        label3.setHorizontalAlignment(2);
        label3.setText("md5");

        searchmd5Field = new JTextField();
        searchmd5Field.setPreferredSize(new Dimension(300,37));
        searchmd5Field.setText("7b2a4d53fde834e801c26a2bab7e0240");

        final JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel3.add(panel7);
        bookOutput = new JLabel();
        bookOutput.setPreferredSize(new Dimension(300, 47));
        bookOutput.setText("The book you are looking for: ");

        panel7.add(bookOutput);
        searchButton = new JButton();
        searchButton.setLabel("Search");
        searchButton.setText("Search");
        panel1.add(searchButton);




        add(panel1);



        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = new Connection(
                        searchNameField.getText(),
                        searchAuthorField.getText(),
                        searchmd5Field.getText()
                );

                String jsonData = connection.request();


               BookResult bookresult = Parser.parse(jsonData);

                bookOutput.setText("The book you are looking for is " +bookresult.results.title);
            }
        });

    }





}
