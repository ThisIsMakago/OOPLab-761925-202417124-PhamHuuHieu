package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, director, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }
    
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}