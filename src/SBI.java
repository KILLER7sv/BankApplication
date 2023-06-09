import java.util.UUID;

public class SBI implements BankAppMethods{
    private String name;
    private String password;
    private double balance;
    private String accountN0;

    private double RateOfInterest = 7.0;

    public SBI(){

    }

    public SBI(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountN0 = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountN0() {
        return accountN0;
    }

    public void setAccountN0(String accountN0) {
        this.accountN0 = accountN0;
    }


    @Override
    public String FetchBalance(String password) {
        if(password.equals(this.password)){
            return "Your Balance is : " + this.balance;
        }
        return "Incorrect Password";
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
                return "Money has been withdrawn, New Balance : " + this.balance;
            }else{
                return "Low Balance";
            }
        }

        return "Incorrect Password";
    }

    @Override
    public String ChangePassword(String oldpassword, String newpassword) {
        if(oldpassword.equals(this.password)){
            this.password = newpassword;
            return "Password changed Successfully";
        }
        return "Incorrect Password";
    }

    @Override
    public double CalculateInterest(int years) {
        if(years < 2){
            return (this.balance * years * RateOfInterest)/100;
        }else if(years <= 4){
            RateOfInterest += 0.6;
            return (this.balance * years * RateOfInterest)/100;
        }else{
            RateOfInterest += 1.2;
            return (this.balance * years * RateOfInterest)/100;
        }
    }
}
