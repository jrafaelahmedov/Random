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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static main.Game.a;
import static main.Game.b;

/**
 * @author RafaelAhmedov
 */
public class ChoiceMenu {
    public static int members;

    public static void choice(Person person) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Növbəti əməliyyatı seçin:\n"
                + "1.   Yarishmacilari register et\n"
                + "2.	Yarışmaya başla\n"
                + "3.	Logout\n"
                + "4.	Exit\n"
                + "5. Ishdirakcilarin Siyahisina Bax\n"
                + "6.  Ishdirakcilarin Sayini artirin\n"
                + "7. Butun Isdirakcilari Sil\n"
                + "8. Topladigim Xallarimi Gosder \n");
        int selected = scan.nextInt();

        if (selected == 1) {
            CompatitorsList comp = (CompatitorsList) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            if (comp.getPerson() != null) {
                members = comp.getPerson().length;
                if (members != 0) {
                    System.out.println("Yarishmacilar artiq registr olunub!!");
                    choice(person);
                }
            }
            b = true;

        } else if (selected == 2) {
            CompatitorsList comp = (CompatitorsList) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            if (members == 0) {
                System.out.println("Zehmet olmasa Ishtirakcilari registr edin!!");
                b = false;
                choice(person);
            } else {
                members = comp.getPerson().length;
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
            CompatitorsList comp = (CompatitorsList) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            if (comp.getPerson() == null) {
                System.out.println("Zehmet olmasa ishdirakcilari elave edin!!");
                choice(person);
            } else {
                System.out.println("String  " + comp.toString());
                choice(person);
            }

        } else if (selected == 6) {
            System.out.println("Elave Etmek isdediyiniz ishdirakcilarin sayini qeyd edin");
            int addCompatitor = scan.nextInt();
            Person member[] = new Person[addCompatitor];
            CompatitorsList comp = new CompatitorsList();
            for (int i = members; i < addCompatitor; i++) {
                member[i] = FillInPerson.personInformation();
            }
            Person[] birlesme = (Person[]) concatenate(member, comp.getPerson());
            comp.setPerson(birlesme);
            System.out.println(comp.toString());
            WriteToObjectCompatitors.writeToObjectCompatitorsUsingFileWriter(comp, "Ishtirakcilar");
            CompatitorsList compa = (CompatitorsList) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            members = comp.getPerson().length + addCompatitor;

            if (members != 0) {
                choice(person);
            }

        } else if (selected == 7) {
            CompatitorsList comp = (CompatitorsList) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
            members = 0;
            comp.setPerson(null);
            System.out.println("Butun Isdirakcilar silinmisdir!!");
            WriteToObjectCompatitors.writeToObjectCompatitorsUsingFileWriter(comp, "Ishtirakcilar");
            choice(person);

        } else if (selected == 8) {
            Login login = (Login) ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Xallarim");
            System.out.println("Sizin " + login.getXal() + " Xaliniz var");
            choice(person);
        } else {
            System.out.println("Yalnish secim etdiniz!!!");
            choice(person);
        }
    }

    private static Object[] concatenate(Object[] a, Object[] b) {
        Collection<Object> result = new ArrayList<Object>(a.length + b.length);
        for (Object val : a) {
            result.add(val);
        }
        for (Object val : b) {
            result.add(val);
        }
        return result.toArray();
    }
}
