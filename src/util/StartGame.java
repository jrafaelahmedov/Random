/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import beans.CompatitorsList;
import beans.Login;
import beans.Person;

import java.util.Random;
import java.util.Scanner;
import static main.Game.a;
import static util.ChoiceMenu.choice;
import static util.ChoiceMenu.members;

/**
 *
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
                Login l= new Login();
                System.out.println("Congratulations you won!");
                a = false;
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


    public static void pointSystem(){

    }
}
