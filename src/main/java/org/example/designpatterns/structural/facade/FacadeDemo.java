package org.example.designpatterns.structural.facade;

import org.example.utils.CmdVisualUtils;

import java.io.File;

public class FacadeDemo {
    
    public static void demonstrate() {
        System.out.println("=== FACADE PATTERN ===");
        System.out.println("Problema: Simplificar interface para um subsistema complexo");
        System.out.println("Solução: Fornecer uma interface unificada para um conjunto de interfaces em um subsistema\n");
        
        System.out.println("Exemplo: Sistema de conversão de vídeo");
        System.out.println("Sem Facade, o cliente precisaria:");
        System.out.println("1. Criar VideoFile");
        System.out.println("2. Extrair codec com CodecFactory");
        System.out.println("3. Ler arquivo com BitrateReader");
        System.out.println("4. Converter com BitrateReader");
        System.out.println("5. Corrigir áudio com AudioMixer");
        System.out.println();
        
        System.out.println("Com Facade, o cliente faz apenas:");
        VideoConversionFacade converter = new VideoConversionFacade();
        
        System.out.println("\nTeste 1: Convertendo video.ogg para MP4");
        File mp4Video = converter.convertVideo("video.ogg", "mp4");
        System.out.println("Resultado: " + mp4Video.getName());

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Teste 2: Convertendo presentation.mp4 para OGG");
        File oggVideo = converter.convertVideo("presentation.mp4", "ogg");
        System.out.println("Resultado: " + oggVideo.getName());

        CmdVisualUtils.separetorCmd(50);

        System.out.println("Demonstração sem Facade (processo manual):");
        System.out.println("Cliente precisa conhecer todos os detalhes internos:");
        
        // Processo manual que o cliente teria que fazer sem facade
        VideoFile file = new VideoFile("manual_video.mp4");
        System.out.println("1. Criando VideoFile: " + file.getName());
        
        Codec sourceCodec = CodecFactory.extract(file);
        System.out.println("2. Extraindo codec...");
        
        Codec destinationCodec = new OggCompressionCodec();
        System.out.println("3. Definindo codec de destino...");
        
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        System.out.println("4. Lendo arquivo...");
        
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        System.out.println("5. Convertendo...");
        
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("6. Corrigindo áudio...");
        System.out.println("Processo manual concluído: " + result.getName());
        
        System.out.println("\nVantagens:");
        System.out.println("- Isola clientes da complexidade do subsistema");
        System.out.println("- Promove acoplamento fraco entre subsistema e clientes");
        System.out.println("- Não impede acesso direto ao subsistema quando necessário");
        System.out.println("- Simplifica a interface para casos de uso comuns");
        System.out.println("- Facilita manutenção e evolução do subsistema");
    }
}

