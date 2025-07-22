package org.example.designpatterns.structural.facade;

public class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extraindo codec MPEG4...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extraindo codec OGG...");
            return new OggCompressionCodec();
        }
    }
}

