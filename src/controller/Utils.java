package controller;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;


public class Utils {
    private final static String keyString = "THEKEYTORULETHEMALL";
    private final static SecretKey key = generateKey(keyString);


    public static String convertToHashedVersion(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return convertBytesToHexString(encodedHash);
    }
    private static String convertBytesToHexString(byte[] password){
        StringBuilder hexString = new StringBuilder(2 * password.length);
        for (int i = 0; i < password.length; i++) {
            String hex = Integer.toHexString(0xff & password[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    private static SecretKey generateKey(String keyString) {
        try{
            byte[] bytes = keyString.getBytes();
            DESKeySpec keySpec = new DESKeySpec(bytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            return key;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String text){
        try{

            Cipher encCipher = Cipher.getInstance("DES");
            encCipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] utf8 = text.getBytes("UTF8");
            byte[] enc = encCipher.doFinal(utf8);
            return (Base64.getEncoder().encodeToString(enc));

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String text){
        try{

            Cipher decCipher = Cipher.getInstance("DES");
            decCipher.init(Cipher.DECRYPT_MODE,key);
            byte[] dec = Base64.getDecoder().decode(text.getBytes());
            byte[] utf8 = decCipher.doFinal(dec);
            return new String(utf8, "UTF8");

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void writeOutputFile(String text,String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filePath,true));
        writer.println(text);
        writer.close();
    }

    public static List<String> readInputFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        LinkedList<String > listToDecrypt = new LinkedList<>();
        while (line != null) {
            listToDecrypt.add(line);
            line = reader.readLine();
        }
        return  listToDecrypt;
    }
}
