package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VideoPlayer {

    private final VideoLibrary videoLibrary;
    private Video playingVideo = null;
    private boolean isPaused = false;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();
    }

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {
        List<Video> videos = videoLibrary.getVideos();
        String[] messages = new String[videos.size()];
        int counter = 0;
        for (Video video : videos) {
            messages[counter] = video.getTitle() + " (" + video.getVideoId() + ") [" + video.getStringTags() + "]";
            counter++;
        }
        Arrays.sort(messages);
        System.out.println("Here's a list of all available videos:");
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void playVideo(String videoId) {
        Video video = videoLibrary.getVideo(videoId);
        if (video != null) {
            if (playingVideo != null) {
                stopVideo();
            }
            playingVideo = video;
            System.out.println("Playing video: " + video.getTitle());
        } else {
            System.out.println("Cannot play video: Video does not exist");
        }
    }

    public void stopVideo() {
        if (playingVideo != null) {
            System.out.println("Stopping video: " + playingVideo.getTitle());
            playingVideo = null;
            isPaused = false;
        } else {
            System.out.println("Cannot stop video: No video is currently playing");
        }
    }

    public void playRandomVideo() {
        List<Video> videos = videoLibrary.getVideos();

        //select a random video from the video list
        Random random = new Random();
        Video video = videos.get(random.nextInt(videos.size() - 1));

        playVideo(video.getVideoId());
    }

    public void pauseVideo() {
        if (playingVideo != null) {
            if (!isPaused) {
                isPaused = true;
                System.out.println("Pausing video: " + playingVideo.getTitle());
            } else {
                System.out.println("Video already paused: " + playingVideo.getTitle());
            }
        } else {
            System.out.println("Cannot pause video: No video is currently playing");
        }
    }

    public void continueVideo() {
        if(playingVideo != null){
            if(!isPaused){
                System.out.println("Cannot continue video: Video is not paused");
            } else {
                isPaused = false;
                System.out.println("Continuing video: " + playingVideo.getTitle());
            }
        } else {
            System.out.println("Cannot continue video: No video is currently playing");
        }
    }

    public void showPlaying() {

        if(playingVideo != null){
            String message = "Currently playing: " + playingVideo.getTitle() + " (" + playingVideo.getVideoId() + ") [" + playingVideo.getStringTags() + "]";
            if(!isPaused){
                System.out.println(message);
            } else {
                System.out.println(message + " - PAUSED");
            }
        } else {
            System.out.println("No video is currently playing");
        }
    }

    public void createPlaylist(String playlistName) {
        System.out.println("createPlaylist needs implementation");
    }

    public void addVideoToPlaylist(String playlistName, String videoId) {
        System.out.println("addVideoToPlaylist needs implementation");
    }

    public void showAllPlaylists() {
        System.out.println("showAllPlaylists needs implementation");
    }

    public void showPlaylist(String playlistName) {
        System.out.println("showPlaylist needs implementation");
    }

    public void removeFromPlaylist(String playlistName, String videoId) {
        System.out.println("removeFromPlaylist needs implementation");
    }

    public void clearPlaylist(String playlistName) {
        System.out.println("clearPlaylist needs implementation");
    }

    public void deletePlaylist(String playlistName) {
        System.out.println("deletePlaylist needs implementation");
    }

    public void searchVideos(String searchTerm) {
        System.out.println("searchVideos needs implementation");
    }

    public void searchVideosWithTag(String videoTag) {
        System.out.println("searchVideosWithTag needs implementation");
    }

    public void flagVideo(String videoId) {
        System.out.println("flagVideo needs implementation");
    }

    public void flagVideo(String videoId, String reason) {
        System.out.println("flagVideo needs implementation");
    }

    public void allowVideo(String videoId) {
        System.out.println("allowVideo needs implementation");
    }
}