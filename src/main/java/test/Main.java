package test;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What's you name?");
        String name = sc.nextLine();
        System.out.println("Welcome at Astrix " + name);
        System.out.println("How much money do you want to use?");
        double Balance = sc.nextInt();
        User user = new User(Balance);

        StockMenu Menu = new StockMenu(user);
        Menu.menu();
    }
}