package org.example.designpatterns.structural.facade;

import java.io.File;

public class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: corrigindo áudio...");
        return new File("tmp");
    }
}

