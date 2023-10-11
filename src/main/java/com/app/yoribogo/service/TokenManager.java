package com.app.yoribogo.service;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenManager {

    private static final Map<String, TokenInfo> tokenStore = new HashMap<>();

    public static String generateToken(String email) {
        String token = UUID.randomUUID().toString();

        // 토큰과 유효 기간 설정 (예: 현재 시간부터 1시간 후)
        TokenInfo tokenInfo = new TokenInfo(email, token);
        tokenStore.put(token, tokenInfo);

        return token;
    }

    public static String getEmailFromToken(String token) {
        TokenInfo tokenInfo = tokenStore.get(token);

        // 토큰이 존재하고 유효한 경우에만 이메일 반환
        if (tokenInfo != null && tokenInfo.isValid()) {
            return tokenInfo.getEmail();
        }

        return null;
    }

    private static class TokenInfo {
        @Getter
        private final String email;
        private final String token;
        private final long expirationTime; // 토큰의 만료 시간 (예: 현재 시간부터 1시간 후)

        public TokenInfo(String email, String token) {
            this.email = email;
            this.token = token;
            this.expirationTime = System.currentTimeMillis() + (60 * 60 * 1000); // 1시간 후
        }

        public boolean isValid() {
            return System.currentTimeMillis() <= expirationTime;
        }
    }
}
