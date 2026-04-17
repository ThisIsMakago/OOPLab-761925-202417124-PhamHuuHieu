package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc() {
        super();
    }

    public Disc(String title) {
        super();
        this.setTitle(title);
    }

    public Disc(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.setCost(cost);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.director = director;
        this.length = length;
        this.setCost(cost);
    }
}