import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HDFC p1 = new HDFC("Sarthak" , 1000 , "abc123");
        System.out.println("Congrats ! " + p1.getName() +
                "your Account has been created, Your account Number is : "
                + p1.getAccountNo());

        HDFC p2 = new HDFC("kamal" , 2000 , "kamal123");
        System.out.println("Congrats ! " + p2.getName() +
                "your Account has been created, Your account Number is : "
                + p2.getAccountNo());

        // Add Money
        System.out.println("Congrats "+p1.getName()+ "Money has been added, New balance is : "
                + p1.AddMoney(50000));
        System.out.println("Congrats "+p2.getName()+ "Money has been added, New balance is : "
                + p2.AddMoney(50000));

        // Withdraw Money Wrong Password
        System.out.println(p1.WithdrawMoney("ac123" , 10000));
        System.out.println(p2.WithdrawMoney("ac123" , 10000));

        // Withdraw Money Right Password
        System.out.println(p1.WithdrawMoney("abc123" , 10000));
        System.out.println(p2.WithdrawMoney("kamal123" , 15000));

        // Fetch Balance
        System.out.println(p1.FetchBalance("abc123"));
        System.out.println(p2.FetchBalance("kamal123"));

        // Change Password
        System.out.println(p1.ChangePassword("123" , "password"));
        System.out.println(p1.ChangePassword("abc123" , "password"));

        // RateofInterest
        System.out.println("Enter the years to calculate Rate Of Interest :");
        int x = sc.nextInt();
        System.out.println(p1.CalculateInterest(x));
        System.out.println(p2.CalculateInterest(x));

    }
}
