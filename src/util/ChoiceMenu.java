/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import ReadToObject.ReadToObjectCompatitors;
import beans.CompatitorsList;
import beans.Login;
import beans.Person;

import java.util.Scanner;

import static main.Game.a;
import static main.Game.b;

/**
 * @author RafaelAhmedov
 */
public class ChoiceMenu {
    public static int members;

    public static void choice(CompatitorsList person) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Növbəti əməliyyatı seçin:\n"
                + "1.   Yarishmacilari register et\n"
                + "2.	Yarışmaya başla\n"
                + "3.	Logout\n"
                + "4.	Exit\n"
                + "5. Ishdirakcilarin Siyahisina Bax");
        int selected = scan.nextInt();
        if (selected == 1) {
            if (members != 0) {
                System.out.println("Yarishmacilar artiq registr olunub!!");
                choice(person);
            }
            b = true;
        } else if (selected == 2) {
            if (members == 0) {
                System.out.println("Zehmet olmasa Ishtirakcilari registr edin!!");
                b = false;
                choice(person);
            } else {
                util.StartGame.startmatch(person);
            }
        } else if (selected == 3) {
            b = false;
            a = true;
            members = 0;
        } else if (selected == 4) {
            System.out.println("Siz sistemden cixdiniz!!");
            main.Game.a = false;
            main.Game.b = false;
        } else if (selected == 5) {

           CompatitorsList comp=(CompatitorsList)ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            for (int i = 0; i <comp.getPerson().length; i++) {

                System.out.println("read to choice "+comp.getPerson()[i].getName());
            }
            choice(person);
        } else {
            System.out.println("Yalnish secim etdiniz!!!");
            choice(person);
        }
    }
}
