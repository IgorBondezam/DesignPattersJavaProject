package com.igorbondezam.designpatterns.structural.proxy;

import com.igorbondezam.utils.CmdVisualUtils;

public class ProxyDemo {
    
    public static void demonstrate() {
        System.out.println("=== PROXY PATTERN ===");
        System.out.println("Problema: Controlar acesso a um objeto fornecendo um substituto ou placeholder");
        System.out.println("Solução: Criar um proxy que controla acesso ao objeto real\n");
        
        System.out.println("Teste 1: Acesso direto (sem proxy)");
        test(new YouTubeDownloader(new ThirdPartyYouTubeClass()));

        CmdVisualUtils.separetorCmd(60);

        System.out.println("Teste 2: Acesso através de proxy com cache");
        test(new YouTubeDownloader(new YouTubeCacheProxy()));
        
        System.out.println("\nVantagens:");
        System.out.println("- Controla acesso ao objeto de serviço");
        System.out.println("- Gerencia ciclo de vida do objeto de serviço");
        System.out.println("- Funciona mesmo quando objeto de serviço não está pronto");
        System.out.println("- Segue o princípio Open/Closed");
        System.out.println("- Pode implementar lazy initialization, cache, logging, etc.");
    }
    
    public static void test(YouTubeDownloader downloader) {
        // Primeira chamada - dados serão buscados
        long startTime = System.currentTimeMillis();
        downloader.renderPopularVideos();
        System.out.println("Tempo da primeira busca: " + (System.currentTimeMillis() - startTime) + "ms");
        
        // Segunda chamada - dados podem vir do cache (se usando proxy)
        startTime = System.currentTimeMillis();
        downloader.renderPopularVideos();
        System.out.println("Tempo da segunda busca: " + (System.currentTimeMillis() - startTime) + "ms");
        
        // Buscar vídeo específico
        startTime = System.currentTimeMillis();
        downloader.renderVideoPage("catzzzzzzzzz");
        System.out.println("Tempo da busca do vídeo: " + (System.currentTimeMillis() - startTime) + "ms");
        
        // Buscar o mesmo vídeo novamente
        startTime = System.currentTimeMillis();
        downloader.renderVideoPage("catzzzzzzzzz");
        System.out.println("Tempo da segunda busca do vídeo: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}

