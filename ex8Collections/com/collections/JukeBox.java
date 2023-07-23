package com.collections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JukeBox {

    private final String fileName = "songs.txt";
    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<Song> songsComperator = new ArrayList<Song>();
    ArrayList<Song> songsComperatorLam = new ArrayList<Song>();

    public void run() {
        readFile();

        System.out.println("\nSongs as ArrayList (needs Songs to implement Compareable and method compareTo()");
        for(Song s : songs)
            System.out.println(s);

        System.out.println("\nArrayList using Comperators");
        for(Song s : songsComperator)
            System.out.println(s);

        System.out.println("\nArrayList using Comperators (Lambda)");
        for(Song s : songsComperatorLam)
            System.out.println(s);

        System.out.println("Songs as HashSet methods equals() and hashCode() to get uniques");
        HashSet<Song> songsSet = new HashSet<Song>();
        songsSet.addAll(songs);
        for(Song s : songsSet)
            System.out.println(s);
    }

    private void readFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = null;
            while((line = bufferedReader.readLine()) !=  null)
                addSong(line);

            // Collections.sort(songs);
            // Collections.sort(songsComperator, Song.Comperators.ARTIST);
            // Collections.sort(songsComperatorLam, Song.ComparatorsLambda.TITLE);

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSong(String line) {
        String[] splitLine = line.split("/");
        Song s = new Song(splitLine[0], splitLine[1], splitLine[2], splitLine[3]);
        songs.add(new Song(s));
        songsComperator.add(new Song(s));
        songsComperatorLam.add(new Song(s));
    }

}

class Song /**implements Comparable<Song>**/ {
    private String title;
    private String artist;
    private String rating;
    private String length;

    Song(String title, String artist, String rating, String length) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.length = length;
    }

    Song(Song other) {
        this.title = other.title;
        this.artist = other.artist;
        this.rating = other.rating;
        this.length = other.length;
    }

    public String toString() {
        return String.format("artist: %s, title: %s", artist, title);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    // public int compareTo(Song s) {
    //     return title.compareTo(s.getTitle());
    // }

    // public static class Comperators {
    //     public static final Comparator<Song> TITLE = new Comparator<Song>() {
    //         @Override
    //         public int compare(Song o1, Song o2) {
    //             return o1.title.compareTo(o2.title);
    //         }
    //     };

    //     public static final Comparator<Song> ARTIST = new Comparator<Song>() {
    //         @Override
    //         public int compare(Song o1, Song o2) {
    //             return o1.artist.compareTo(o2.artist);
    //         }
    //     };
    // }

    // using Comparator inner classes and lambdas (Java 8)
    public static class ComparatorsLambda {
        public static final Comparator<Song> TITLE = (Song o1, Song o2) -> o1.title.compareTo(o2.title);
        public static final Comparator<Song> ARTIST = (Song o1, Song o2) -> o1.artist.compareTo(o2.artist);
    }

    public boolean equals(Object song) {
        Song s = (Song) song;
        return s.getTitle().equals(title);
    }

    public int hashCode() {
        return title.hashCode();
    }
}