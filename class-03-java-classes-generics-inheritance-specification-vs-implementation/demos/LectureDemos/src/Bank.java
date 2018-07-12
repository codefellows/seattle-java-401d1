public class Bank {
    public static void main(String[] args) {
        SafetyDepositBox account = new SafetyDepositBox("12345", "idea: vape sandwiches?");
        System.out.println(account.unlock("password"));
        System.out.println(account.unlock("12345"));
    }
}
