public interface BankAppMethods {

    String FetchBalance(String password);

    double AddMoney(double amount);

    String WithdrawMoney(String password , double amount);

    String ChangePassword(String oldpassword , String newpassword);

    double CalculateInterest(int years);
}
