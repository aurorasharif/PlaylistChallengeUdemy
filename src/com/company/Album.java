package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs=new ArrayList<Song>();
    }

    public boolean addSong(String songTitle, double duration){
        Song found=findSong(songTitle);
        if (found==null){
            Song songToAdd=new Song(songTitle,duration);
            songs.add(songToAdd);
            return true;
        } return false;
    }

    public Song findSong(String songTitle){
        Song song=null;
        for (int i=0; i<songs.size(); i++){
            if (songs.get(i).getTitle().equals(songTitle)){
                song=songs.get(i);
            }
        } return song;
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playList){
        if (trackNum>=songs.size()){
            System.out.println("Track number does not exists");
            return false;
        }
        Song song=songs.get(trackNum);
        if (song!=null){
            return playList.add(song);
        } return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playList){
        Song song=findSong(songTitle);
        if (song!=null){
            return playList.add(song);
        } return false;
    }
}
