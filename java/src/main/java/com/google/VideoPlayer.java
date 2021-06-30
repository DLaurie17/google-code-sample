package com.google;

import java.util.*;

public class VideoPlayer {

    private final VideoLibrary videoLibrary;
    private final VideoPlaylists videoPlaylists;
    private Video playingVideo = null;
    private boolean isPaused = false;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();
        this.videoPlaylists = new VideoPlaylists();
    }

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {

        List<Video> videos = videoLibrary.getVideos();
        //sorting with lambda
        //videos.sort((video1, video2) -> video1.getTitle().compareTo(video2.getTitle()));
        //or with Comparator
        //videos.sort(Comparator.comparing(Video::getTitle));

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
        if (playingVideo != null) {
            if (!isPaused) {
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

        if (playingVideo != null) {
            String message = "Currently playing: " + playingVideo.getTitle() + " (" + playingVideo.getVideoId() + ") [" + playingVideo.getStringTags() + "]";
            if (!isPaused) {
                System.out.println(message);
            } else {
                System.out.println(message + " - PAUSED");
            }
        } else {
            System.out.println("No video is currently playing");
        }
    }

    public void createPlaylist(String playlistName) {
        videoPlaylists.createPlaylist(playlistName);
    }

    public void addVideoToPlaylist(String playlistName, String videoId) {
        Video video = videoLibrary.getVideo(videoId);
        videoPlaylists.addVideoToPlaylist(playlistName, video);
    }

    public void showAllPlaylists() {
        List<String> playlistNames = videoPlaylists.getPlaylistNames();
        if (!playlistNames.isEmpty()) {
            System.out.println("Showing all playlists:");
            Collections.sort(playlistNames);
            for (String playlistName : playlistNames) {
                System.out.println(playlistName);
            }
        } else {
            System.out.println("No playlists exist yet");
        }
    }

    public void showPlaylist(String playlistName) {
        videoPlaylists.getPlaylistVideos(playlistName);
    }

    public void removeFromPlaylist(String playlistName, String videoId) {
        Video video = videoLibrary.getVideo(videoId);
        videoPlaylists.removeVideoFromPlaylist(playlistName, video);
    }

    public void clearPlaylist(String playlistName) {
        videoPlaylists.clearPlaylist(playlistName);
    }

    public void deletePlaylist(String playlistName) {
        videoPlaylists.deletePlaylist(playlistName);
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