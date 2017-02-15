package com.planktonleap.rubidium.models;

/**
 * Created by Pongtep Pakakat on 2/15/2017.
 */

public class VideoEntry {
    private final String text;
    private final String videoId;

    public VideoEntry(String text, String videoId) {
        this.text = text;
        this.videoId = videoId;
    }

    public String getText() {
        return text;
    }

    public String getVideoId() {
        return videoId;
    }
}
