package com.example.spring_boot_camel_jdbc_client.user;

import java.security.SecureRandom;

public class CustomIdGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateCustomId() {
        StringBuilder id = new StringBuilder(10);

        // First character is always 'a'
        id.append('a');

        // Next 2 characters are uppercase letters
        for (int i = 0; i < 2; i++) {
            id.append(CHARACTERS.charAt(RANDOM.nextInt(26)));
        }

        // Next 13 characters are a mix of uppercase letters and digits
        for (int i = 0; i < 13; i++) {
            id.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }

        // Last 2 characters are uppercase letters
        for (int i = 0; i < 2; i++) {
            id.append(CHARACTERS.charAt(RANDOM.nextInt(26)));
        }

        return id.toString();
    }
}
