import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SimpleLinkShortener {
    public static void main(String[] args) {
        String longUrl = "https://www.example.com";
        String shortUrl = shortenUrl(longUrl);

        System.out.println("Original URL: " + longUrl);
        System.out.println("Shortened URL: " + shortUrl);
    }

    private static String shortenUrl(String longUrl) {
        try {
            // Create a hash of the long URL using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(longUrl.getBytes());

            // Encode the hash using Base64 to get a short string
            String base64Encoded = Base64.getEncoder().encodeToString(digest);

            // Use the first 8 characters as the short URL
            return base64Encoded.substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
