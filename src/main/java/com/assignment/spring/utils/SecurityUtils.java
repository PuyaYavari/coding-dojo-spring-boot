package com.assignment.spring.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;

@Component
public class SecurityUtils {
    public static String getAppSecret() {
        return "ExampleSecretKey";
    }

    /**
     * Converts given string into SecretKeySpec
     * @param myKey Input string to convert to SecretKeySpec
     * @return SecretKeySpec of the given string
     * @throws NoSuchAlgorithmException
     */
    public static SecretKeySpec getKeySpec(String myKey) throws NoSuchAlgorithmException {
        String algorithm = "AES";
        MessageDigest sha;
        byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, algorithm);
    }

    /**
     * AES encrypts the given string using given SecretKeySpec
     * @param strToEncrypt Raw string to encrypt
     * @param secretKey SecretKeySpec to use for encryption
     * @return AES encrypted string
     */
    public static String encryptAES(String strToEncrypt, SecretKeySpec secretKey)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    /**
     * AES decrypts the given string using given SecretKeySpec
     * @param strToDecrypt Encrypted string
     * @param secretKey Key to use for decryption
     * @return AES decrypted string
     */
    public static String decryptAES(String strToDecrypt, SecretKeySpec secretKey)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }
}
