package com.igorbondezam.designpatterns.structural.proxy;

import java.util.HashMap;

public class YouTubeDownloader {
    private ThirdPartyYouTubeLib api;

    public YouTubeDownloader(ThirdPartyYouTubeLib api) {
        this.api = api;
    }

    public void renderVideoPage(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n-------------------------------");
        System.out.println("Página do vídeo (ID: " + videoId + ")");
        System.out.println("Título: " + video.title);
        System.out.println("Vídeo: " + video.data);
        System.out.println("-------------------------------\n");
    }

    public void renderPopularVideos() {
        HashMap<String, Video> list = api.popularVideos();
        System.out.println("\n-------------------------------");
        System.out.println("Vídeos mais populares");
        for (Video video : list.values()) {
            System.out.println("ID: " + video.id + " / Título: " + video.title);
        }
        System.out.println("-------------------------------\n");
    }
}

