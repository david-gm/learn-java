package com.collections;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class JukeBox {

    private final String fileName = "songs.txt";
    ArrayList<Song> songs = new ArrayList<Song>();

    public void run() {
        readFile();
        
        System.out.println("Songs as ArrayList (needs Songs to implement Compareable and method compareTo()");
        System.out.println(songs);

        System.out.println("Songs as HashSet (needs Compareable interface and methods equals() and hashCode()");
        HashSet<Song> songsSet = new HashSet<Song>();
        songsSet.addAll(songs);
        System.out.println(songsSet);
    }

    private void readFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = null;
            while((line = bufferedReader.readLine()) !=  null)
                addSong(line);


            Collections.sort(songs);

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addSong(String line) 
    {
        String[] splitLine = line.split("/");
        songs.add(new Song(splitLine[0], splitLine[1], splitLine[2], splitLine[3]));
    }

}

class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String length;

    Song(String title, String artist, String rating, String length) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.length = length;
    }

    public String toString() {
        return title;
    }

    public String getTitle() {
        return title;
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    public boolean equals(Object song) {
        Song s = (Song) song;
        return s.getTitle().equals(title);
    }

    public int hashCode() {
        return title.hashCode();
    }
}