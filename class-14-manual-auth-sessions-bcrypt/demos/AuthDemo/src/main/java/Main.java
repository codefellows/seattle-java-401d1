import org.mindrot.jbcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {
        String hash1 = BCrypt.hashpw("password123", BCrypt.gensalt(12));
        String hash2 = BCrypt.hashpw("password123", BCrypt.gensalt(12));
        System.out.println(hash1);
        System.out.println(hash2);

        String attempt1 = "hotdog";
        String attempt2 = "password123";

        boolean isCorrect1 = BCrypt.checkpw(attempt1, hash1);
        boolean isCorrect2 = BCrypt.checkpw(attempt2, hash1);
        boolean isCorrect3 = BCrypt.checkpw(attempt2, hash2);

        System.out.println(isCorrect1);
        System.out.println(isCorrect2);
        System.out.println(isCorrect3);
    }
}
