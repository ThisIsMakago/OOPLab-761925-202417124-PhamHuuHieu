package hust.soict.globalict.aims.screen.manager;
 
import javax.swing.*;
import java.awt.*;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
 
public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;
 
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }
 
    @Override
    JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(6, 2, 5, 5));
        center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        tfTitle = new JTextField();
        tfCategory = new JTextField();
        tfDirector = new JTextField();
        tfLength = new JTextField();
        tfCost = new JTextField();
 
        center.add(new JLabel("Title:"));
        center.add(tfTitle);
        center.add(new JLabel("Category:"));
        center.add(tfCategory);
        center.add(new JLabel("Director:"));
        center.add(tfDirector);
        center.add(new JLabel("Length:"));
        center.add(tfLength);
        center.add(new JLabel("Cost:"));
        center.add(tfCost);
 
        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText().isEmpty() ? "0" : tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText().isEmpty() ? "0" : tfCost.getText());
 
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
        });
 
        center.add(new JLabel());
        center.add(btnAdd);
 
        return center;
    }
}