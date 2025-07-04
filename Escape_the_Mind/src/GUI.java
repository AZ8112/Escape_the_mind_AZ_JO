import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTextArea storyArea;
    private JTextField inputField;

    public GUI() {
        setTitle("Definitely Not Zork");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up the text area
        storyArea = new JTextArea();
        storyArea.setEditable(false);
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setBackground(Color.BLACK);
        storyArea.setForeground(new Color(180, 0, 255)); // purple text

        JScrollPane scrollPane = new JScrollPane(storyArea);
        scrollPane.setBorder(null);

        // Set up the input field
        inputField = new JTextField();
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(new Color(180, 0, 255));
        inputField.setCaretColor(new Color(180, 0, 255));
        inputField.setBorder(null);

        inputField.addActionListener(e -> {
            String input = inputField.getText().trim();
            inputField.setText("");
            storyArea.append("> " + input + "\n");
            // Placeholder for future logic
        });

        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);

        inputField.requestFocusInWindow();

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
