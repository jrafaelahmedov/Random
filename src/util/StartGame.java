/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ReadToObject.ReadToObjectCompatitors;
import WriteToObjectIO.WriteToObjectCompatitors;
import beans.CompatitorsList;
import beans.Login;
import beans.Person;

import java.util.Random;
import java.util.Scanner;

import static main.Game.a;
import static main.Game.b;
import static util.ChoiceMenu.choice;
import static util.ChoiceMenu.members;

/**
 * @author RafaelAhmedov
 */
public class StartGame {
    public static void startmatch(Person person) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Sizce secilen ishtirakci kimdir?");
        a = true;
        int min = 1;
        int selectedMember = random.nextInt(members);
        while (a == true) {
            int customerSelectedNumber = scan.nextInt();
            if (((selectedMember - min) + 1) + min == customerSelectedNumber) {
                Login l = new Login();
                Login login1 = (Login) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Xallarim");
                int cem = login1.getXal()+10;
                login1.setXal(cem);
                WriteToObjectCompatitors.writeToObjectCompatitorsUsingFileWriter(login1, "Xallarim");
                Login login2 = (Login) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Xallarim");
                System.out.println("Congratulations you won! you have " + login2.getXal() + " point");
                a = false;
                b = false;
                return;
            } else if (customerSelectedNumber > members || customerSelectedNumber == 0) {
                System.out.println("Secdiyiniz reqem ishdirakci sayi ile duz gelmir!!Zehmet olmasa duzgun secim edin!!");
            } else {
                System.out.println("You failed");
                a = false;
                choice(person);
                return;
            }
        }
    }


    public static void pointSystem() {

    }
}
