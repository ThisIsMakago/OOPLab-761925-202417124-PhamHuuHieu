package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfCost;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(4, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfCost = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost = Float.parseFloat(tfCost.getText().isEmpty() ? "0" : tfCost.getText());

            Book book = new Book();
            book.setTitle(title);
            book.setCategory(category);
            book.setCost(cost);
            
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}