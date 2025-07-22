package com.igorbondezam.designpatterns.structural.proxy;

public class Video {
    public String id;
    public String title;
    public String data;

    Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Dados do vídeo " + title;
    }
}

