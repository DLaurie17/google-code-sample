package com.google;

import java.util.*;

/**
 * A class used to represent a Playlist
 */
public class VideoPlaylists {

    private final HashMap<String, VideoPlaylist> playlists;

    public VideoPlaylists() {
        this.playlists = new HashMap<>();
    }

    public void createPlaylist(String playlistName) {
        String playlistID = playlistName.toUpperCase();
        if (!playlists.containsKey(playlistID)) {
            playlists.put(playlistID, new VideoPlaylist(playlistName));
            System.out.println("Successfully created new playlist: " + playlistName);
        } else {
            System.out.println("Cannot create playlist: A playlist with the same name already exists");
        }
    }

    public void addVideoToPlaylist(String playlistName, Video video) {

        String playlistID = playlistName.toUpperCase();

        if (!playlists.containsKey(playlistID)) {
            System.out.println("Cannot add video to " + playlistName + ": Playlist does not exist");
        } else if (video == null) {
            System.out.println("Cannot add video to " + playlistName + ": Video does not exist");
        } else {
            VideoPlaylist videoPlaylist = playlists.get(playlistID);
            videoPlaylist.addVideo(playlistName, video);
        }
    }

    public List<String> getPlaylistNames() {
        List<String> playlistNames = new ArrayList<>();
        for (VideoPlaylist videoPlaylist : playlists.values()) {
            playlistNames.add(videoPlaylist.getName());
        }
        return playlistNames;
    }

    public void getPlaylistVideos(String playlistName) {
        String playlistID = playlistName.toUpperCase();
        if (!playlists.containsKey(playlistID)) {
            System.out.println("Cannot show playlist " + playlistName + ": Playlist does not exist");
        } else {
            System.out.println("Showing playlist: " + playlistName);

            VideoPlaylist videoPlaylist = playlists.get(playlistID);
            List<Video> videos = videoPlaylist.getVideos();

            if (videos.isEmpty()) {
                System.out.println("No videos here yet");
            } else {
                for (Video video : videos) {
                    System.out.println(video.getTitle() + " (" + video.getVideoId() + ") [" + video.getStringTags() + "]");
                }
            }
        }
    }

    public void removeVideoFromPlaylist(String playlistName, Video video) {
        String playlistID = playlistName.toUpperCase();
        if (!playlists.containsKey(playlistID)) {
            System.out.println("Cannot remove video from " + playlistName + ": Playlist does not exist");
        } else if (video == null) {
            System.out.println("Cannot remove video from " + playlistName + ": Video does not exist");
        } else {
            VideoPlaylist videoPlaylist = playlists.get(playlistID);
            if ((videoPlaylist.getVideos() == null) || !(videoPlaylist.getVideos().contains(video))) {
                System.out.println("Cannot remove video from " + playlistName + ": Video is not in playlist");
            } else {
                videoPlaylist.removeVideo(video);
                System.out.println("Removed video from " + playlistName + ": " + video.getTitle());
            }
        }
    }

    public void clearPlaylist(String playlistName){
        String playlistID = playlistName.toUpperCase();
        if (!playlists.containsKey(playlistID)) {
            System.out.println("Cannot clear playlist " + playlistName + ": Playlist does not exist");
        } else {
            VideoPlaylist videoPlaylist = playlists.get(playlistID);
            videoPlaylist.removeAllVideos();
            System.out.println("Successfully removed all videos from " + playlistName);
        }
    }

    public void deletePlaylist(String playlistName) {
        String playlistID = playlistName.toUpperCase();
        if (!playlists.containsKey(playlistID)) {
            System.out.println("Cannot delete playlist " + playlistName + ": Playlist does not exist");
        } else {
            playlists.remove(playlistID);
            System.out.println("Deleted playlist: " + playlistName);
        }
    }
}
