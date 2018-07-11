/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.Login;
import java.util.Scanner;
import static main.Game.a;

/**
 *
 * @author RafaelAhmedov
 */
public class LogIn {
    public static Login logIn() {
        Login l = new Login();
        l.setUsername("Rafael");
        l.setPassword("12345");
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("Daxil olun:\nUsername:");
            String getUserName = scan.nextLine();
            System.out.print("Password:");
            String getPassword = scan.nextLine();
            if (l.getUsername().equalsIgnoreCase(getUserName) && l.getPassword().equals(getPassword)) {
                System.out.println("Successfuly login");
                return l;
            } else if (i <= 2) {
                System.out.println("This username or password not available,Try again!");
            } else {
                System.out.println("You banned");
                a = false;
            }
        }
        return l;
    }
}
