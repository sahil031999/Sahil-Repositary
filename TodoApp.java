import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo To-Do App");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel (input + button)
        JPanel topPanel = new JPanel();
        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Add");

        topPanel.add(taskField);
        topPanel.add(addButton);

        // Task list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel (delete button)
        JButton deleteButton = new JButton("Delete Selected");

        // Add task action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        // Delete task action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        // Add components to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}