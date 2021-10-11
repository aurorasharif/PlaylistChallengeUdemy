package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;
    //private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs=new SongList();
    }

    public boolean addSong(String songTitle, double duration){
        Song found=songs.findSong(songTitle);
        if (found==null){
            songs.addSong(songTitle,duration);
            return true;
        } return false;
    }

    public Song findSong(String songTitle){
        return songs.findSong(songTitle);
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playList){
        if (trackNum>=songs.getNumberOfSongs()){
            System.out.println("Track number does not exists");
            return false;
        }
        Song song=songs.songList.get(trackNum);
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

    private class SongList{
        private List<Song> songList;

        public SongList() {
            this.songList = new ArrayList<Song>();
        }

        private boolean addSong(String songTitle, double duration){
            Song found=findSong(songTitle);
            if (found==null){
                Song songToAdd=new Song(songTitle,duration);
                songList.add(songToAdd);
                return true;
            }
            return false;
        }

        private Song findSong(String songTitle){
            Song song=null;
            for (int i = 0; i< songList.size(); i++){
                if (songList.get(i).getTitle().equals(songTitle)){
                    song= songList.get(i);
                }
            } return song;
        }

        private int getNumberOfSongs(){
           return songList.size();
        }
    }
}
