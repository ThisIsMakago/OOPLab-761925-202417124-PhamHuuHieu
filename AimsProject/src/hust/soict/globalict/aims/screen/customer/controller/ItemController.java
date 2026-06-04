package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    void btnAddToCartPressed(ActionEvent event) {
        cart.addMedia(media);
        System.out.println("Added " + media.getTitle() + " to cart!");
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        try {
            ((Playable) media).play();
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Playing");
            alert.setHeaderText("You are playing:");
            alert.setContentText(media.getTitle() + " - " + media.getCost() + " $");
            alert.showAndWait();
        } catch (PlayerException e) {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setHeaderText("Error Playing Media");
            alert.setTitle("Illegal Media Length");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } 
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
}