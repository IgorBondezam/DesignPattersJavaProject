package com.igorbondezam.designpatterns.structural.facade;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: lendo arquivo " + file.getName());
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: escrevendo arquivo...");
        return buffer;
    }
}

