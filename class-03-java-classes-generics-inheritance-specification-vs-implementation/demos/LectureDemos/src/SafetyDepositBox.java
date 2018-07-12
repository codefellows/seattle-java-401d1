public class SafetyDepositBox {
    private String password;
    private String contents;

    public SafetyDepositBox(String password, String contents) {
        this.password = password;
        this.contents = contents;
    }

    public String unlock(String passwordAttempt) {
        if (passwordAttempt.equals(this.password)) {
            return this.contents;
        }
        return "Access denied!";
    }
}