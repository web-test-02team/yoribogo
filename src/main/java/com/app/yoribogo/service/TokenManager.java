package com.app.yoribogo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenManager {

    private static final Map<String, String> tokenToEmailMap = new HashMap<>();
    //토큰을 생성
    public static String generateToken(String email) {
        String token = UUID.randomUUID().toString();
        tokenToEmailMap.put(token, email);
        return token;
    }

    public static String getEmailFromToken(String token) {
        return tokenToEmailMap.get(token);
    }
}
