package Game;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class GUI extends JFrame {
    private final JTextArea storyArea;
    private final JTextField inputField;
    private Consumer<String> inputHandler;
    private Consumer<Integer> transitionHandler; // new

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
            appendText("> " + input);
            if (inputHandler != null) {
                try {
                    inputHandler.accept(input);
                } catch (RoomTransitionException rte) {
                    if (transitionHandler != null) {
                        transitionHandler.accept(rte.nextRoom);
                    } else {
                        printText("💥 Transition handler not set.");
                    }
                } catch (Exception ex) {
                    printText("💥 Error: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
        inputField.requestFocusInWindow();
        setVisible(true);
    }

    public void printText(String text) {
        SwingUtilities.invokeLater(() -> appendText(text));
    }

    public void printBookText(String text) {
        SwingUtilities.invokeLater(() -> {
            Color previous = storyArea.getForeground();
            storyArea.setForeground(Color.CYAN);
            appendText(text);
            storyArea.setForeground(previous); // restore previous
        });
    }

    private void appendText(String text) {
        storyArea.append(text + "\n");
        storyArea.setCaretPosition(storyArea.getDocument().getLength());
    }

    public void setInputHandler(Consumer<String> handler) {
        this.inputHandler = handler;
    }

    public void setRoomTransitionHandler(Consumer<Integer> handler) {
        this.transitionHandler = handler;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
