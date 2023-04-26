package com.myp.core.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class CustomPasswordEncoder {

    public CustomPasswordEncoder() {}

    public String encode(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            return bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean matches(String request, String password) {
        String rawPassword = encode(request);
        if(password != rawPassword) return false;
        return true;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) {
                stringBuffer.append('0');
            }
            stringBuffer.append(hex);
        }
        return stringBuffer.toString();

    }
}
