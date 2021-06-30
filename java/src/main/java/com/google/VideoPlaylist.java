package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VideoPlaylist {
    private final String name;
    private List<Video> videos;

    VideoPlaylist(String name) {
        this.name = name;
        this.videos = new ArrayList<>();
    }

    /** Returns the name of the playlist. */
    public String getName() {
        return name;
    }

    /** Returns the list of videos in the playlist. */
    public List<Video> getVideos() {
        return videos;
    }

    public void addVideo(String inputName, Video video){
        if(videos.contains(video)) {
            System.out.println("Cannot add video to " + inputName + ": Video already added");
            return;
        } else {
            videos.add(video);
        }
        System.out.println("Added video to " + inputName + ": " + video.getTitle());
        //videos.sort(Comparator.comparing(Video::getTitle));
    }

    public void removeVideo(Video video){
        videos.remove(video);
    }

    public void removeAllVideos(){
        videos.clear();
    }

}
