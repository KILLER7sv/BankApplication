import java.util.UUID;

public class HDFC implements BankAppMethods{
    private String name;
    private String accountNo;
    private double balance;
    private String password;

    final double RateOfInterest = 6.1;

    public HDFC(){

    }

    public HDFC(String name, double balance, String password) {
        this.name = name;
        this.accountNo = String.valueOf(UUID.randomUUID());
        this.balance = balance;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String FetchBalance(String password) {
        if(password.equals(this.password)){
            return "Your Balance is " + this.balance;
        }
        return "Invalid Password";
    }

    @Override
    public double AddMoney(double amount) {
        this.balance += amount;
        return this.balance;
    }

    @Override
    public String WithdrawMoney(String password, double amount) {
        if(password.equals(this.password)){
            if(this.balance >= amount){
                this.balance -= amount;
                return "Money has been Withdrawn. The remaining balance is " + this.balance;
            }else{
                return "Insufficient Balance";
            }
        }
        return "Invalid Password";
    }

    @Override
    public String ChangePassword(String oldpassword, String newpassword) {
        if(oldpassword.equals(this.password)){
            this.password = newpassword;
            return "Password Changed Successfully";
        }
        return "Invalid Password";
    }

    @Override
    public double CalculateInterest(int years) {
        return (this.balance * RateOfInterest * years)/100;
    }
}
