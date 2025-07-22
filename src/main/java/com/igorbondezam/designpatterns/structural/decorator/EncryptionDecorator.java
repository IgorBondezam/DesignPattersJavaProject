package com.igorbondezam.designpatterns.structural.decorator;

import java.util.Base64;

public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        System.out.println("Aplicando criptografia...");
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        System.out.println("Aplicando descriptografia...");
        return decode(super.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        try {
            byte[] result = Base64.getDecoder().decode(data);
            for (int i = 0; i < result.length; i++) {
                result[i] -= (byte) 1;
            }
            return new String(result);
        } catch (Exception e) {
            return data; // Retorna dados originais se não conseguir descriptografar
        }
    }
}

