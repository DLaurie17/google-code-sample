package com.google;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchVideoLibrary {

    final private VideoLibrary videoLibrary;

    public SearchVideoLibrary(VideoLibrary videoLibrary) {
        this.videoLibrary = videoLibrary;
    }

    public Video SearchVideoWithName(String searchTerm) {
        String upperCaseSearchTerm = searchTerm.toUpperCase();
        List<Video> videos = videoLibrary.getVideos();
        List<Video> results = videos.stream()
                .filter(video -> video.getTitle().toUpperCase().contains(upperCaseSearchTerm))
                .sorted(Comparator.comparing(Video::getTitle))
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("No search results for blah");
            return null;
        } else {
            System.out.println("Here are the results for " + searchTerm + ":");
            int options = results.size();
            for (int i = 0; i < options; i++) {
                Video result = results.get(i);
                System.out.println((i + 1) + ") " + result.getTitle() + " (" + result.getVideoId() + ") ["
                        + result.getStringTags() + "]");
            }
            int option = SearchResponse();
            if (!(option > 0) || !(option <= options)) {
                return null;
            } else {
                return results.get(option - 1);
            }
        }
    }

    public void SearchVideoWithTag(String tag) {

    }

    public int SearchResponse() {
        System.out.println("Would you like to play any of the above? If yes, specify the number of the video.\n" +
                "If your answer is not a valid number, we will assume it's a no.");
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
        }
        return intInput;
    }
}
