package org.example.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Facebook implements SocialNetwork {
    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        // Simula requisição lenta para o Facebook
        simulateNetworkLatency();
        System.out.println("Facebook: Carregando perfil '" + profileEmail + "' pela rede...");
        
        // Retorna perfil existente ou cria um novo
        return profiles.stream()
                .filter(profile -> profile.getEmail().equals(profileEmail))
                .findFirst()
                .orElse(null);
    }

    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        // Simula requisição lenta para o Facebook
        simulateNetworkLatency();
        System.out.println("Facebook: Carregando lista de '" + contactType + "' de '" + profileEmail + "' pela rede...");
        
        Profile profile = requestProfileFromFacebook(profileEmail);
        if (profile != null) {
            return profile.getContacts();
        }
        return new ArrayList<>();
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, profileEmail, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, profileEmail, "coworkers");
    }
}

