package blockchain.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class StringUtil {

    private static final int NUMBER = 0xff;

    /**
     * Applies Sha256 to a string and returns the result.
     *
     * @param input value to be converted
     * @return hexadecimal into a String
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte aHash : hash) {
                String hex = Integer.toHexString(NUMBER & aHash);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
