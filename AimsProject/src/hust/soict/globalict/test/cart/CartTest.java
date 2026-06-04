package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);
        cart.addMedia(dvd3);

        cart.print();

        System.out.println("Test Search by ID 1");
        cart.searchById(1);

        System.out.println("Test Search by Title: 'Star Wars'");
        cart.searchByTitle("Star Wars");
        
        System.out.println("Test Search by Title: 'Toy Story'");
        cart.searchByTitle("Toy Story");
    }
}