package org.example.designpatterns.structural.proxy;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            System.out.println("Cache vazio. Buscando vídeos populares...");
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retornando vídeos populares do cache...");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            System.out.println("Vídeo não encontrado no cache. Buscando...");
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retornando vídeo do cache: " + video.title);
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
        System.out.println("Cache limpo.");
    }
}

