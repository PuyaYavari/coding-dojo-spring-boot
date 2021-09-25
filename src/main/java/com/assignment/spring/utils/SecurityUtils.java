package com.assignment.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

@Component
public class SecurityUtils {

    private final String appSecret;

    @Autowired
    public SecurityUtils(@Value("${app.secret}") String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * Used to get application Secret
     * @return application secret  key
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * AES decrypts the given string using given SecretKeySpec
     * @param strToDecrypt Encrypted string
     * @param secretKey Key to use for decryption
     * @return AES decrypted string
     */
    public String decryptAES(String strToDecrypt, String secretKey)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, this.getKeySpec(secretKey));
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }

    /**
     * Converts given string into SecretKeySpec
     * @param myKey Input string to convert to SecretKeySpec
     * @return SecretKeySpec of the given string
     * @throws NoSuchAlgorithmException If SHA-1 algorithm not found
     */
    protected SecretKeySpec getKeySpec(String myKey) throws NoSuchAlgorithmException {
        String algorithm = "AES";
        MessageDigest sha;
        byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, algorithm);
    }
}
