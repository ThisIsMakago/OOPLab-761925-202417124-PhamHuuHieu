package hust.soict.globalict.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfArtist, tfCost;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfArtist = new JTextField();
        tfCost = new JTextField();

        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Director:"));
        center.add(tfDirector);
        center.add(new JLabel("Artist:"));
        center.add(tfArtist);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            String artist = tfArtist.getText();
            float cost = Float.parseFloat(tfCost.getText().isEmpty() ? "0" : tfCost.getText());

            CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
        });

        center.add(new JLabel());
        center.add(btnAdd);

        return center;
    }
}