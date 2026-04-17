package hust.soict.globalict.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>(); // Danh sách bài hát [cite: 1070]

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " has been added.");
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " has been removed.");
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("-------------------------");
        for (Track track : tracks) {
            track.play();
        }
    }
}