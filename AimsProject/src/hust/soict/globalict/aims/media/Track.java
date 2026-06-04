package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable { 
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { 
        return title; 
    }

    public int getLength() { 
        return length; 
    }

    public void play() throws PlayerException{
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else {
            System.err.println("Error: DVD length is non-positive");
            throw new PlayerException("Error: DVD length is non-positive");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (obj instanceof Track) {
            Track track = (Track) obj;
            return this.getTitle().equals(track.getTitle()) && this.getLength() == track.getLength();
        }
        return false;
    }
}