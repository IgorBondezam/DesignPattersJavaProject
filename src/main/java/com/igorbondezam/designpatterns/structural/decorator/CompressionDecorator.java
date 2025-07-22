package com.igorbondezam.designpatterns.structural.decorator;

import java.io.*;
import java.util.zip.*;
import java.util.Base64;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Aplicando compressão...");
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        System.out.println("Aplicando descompressão...");
        return decompress(super.readData());
    }

    private String compress(String data) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(bos);
            gzip.write(data.getBytes());
            gzip.close();
            return Base64.getEncoder().encodeToString(bos.toByteArray());
        } catch (IOException e) {
            System.out.println("Erro na compressão: " + e.getMessage());
            return data;
        }
    }

    private String decompress(String data) {
        try {
            byte[] compressed = Base64.getDecoder().decode(data);
            ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
            GZIPInputStream gzip = new GZIPInputStream(bis);
            BufferedReader reader = new BufferedReader(new InputStreamReader(gzip));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            return result.toString();
        } catch (Exception e) {
            System.out.println("Erro na descompressão: " + e.getMessage());
            return data;
        }
    }
}

