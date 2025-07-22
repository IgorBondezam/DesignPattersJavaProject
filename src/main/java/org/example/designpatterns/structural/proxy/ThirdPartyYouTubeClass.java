package org.example.designpatterns.structural.proxy;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Métodos auxiliares que simulam requisições de rede

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Conectando ao " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Conectado!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.print("Baixando vídeos populares... ");
        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Gatos engraçados"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Cachorros bonitinhos"));
        hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Vídeos de dança"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Vídeos de culinária"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Vídeos de viagem"));
        System.out.print("Concluído!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Baixando vídeo... ");
        experienceNetworkLatency();
        Video video = new Video(videoId, "Algum título de vídeo");
        System.out.print("Concluído!" + "\n");
        return video;
    }
}

