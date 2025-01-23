package com.example.dream.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

import static java.security.DrbgParameters.nextBytes;

public class CryptoUtil {

    private static final String ALGORITHM = "AES";

    public byte[] random(int lenth){
        byte[] randombyte = new byte[lenth];
        SecureRandom random = new SecureRandom();
        random.nextBytes(randombyte);
        return randombyte;
    }

    public String encrypt(String data, byte[] key) throws Exception {
        return encrypt(ALGORITHM, data, key);
    }

    // 암호화
    public String encrypt(String algo, String data, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public String decrypt(String encryptedData, byte[] key) throws Exception {
        return decrypt(ALGORITHM, encryptedData, key);
    }

    // 복호화
    public String decrypt(String algo, String encryptedData, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(decodedData);
        return new String(decryptedData);
    }
}
