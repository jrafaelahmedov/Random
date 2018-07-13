/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import WriteToObjectIO.WriteToObjectCompatitors;
import beans.CompatitorsList;
import beans.Person;

import java.util.Scanner;

import static util.ChoiceMenu.members;

/**
 * @author RafaelAhmedov
 */
public class FillInPerson {

    public static Person personFilliIn(Person person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Yarishmada nece shexs ishdirak edecek?");
        members = sc.nextInt();
        Person member[] = new Person[members];
        CompatitorsList comp = new CompatitorsList();
        for (int i = 0; i < members; i++) {
            member[i] = personInformation();
        }
        comp.setPerson(member);
        WriteToObjectCompatitors.writeToObjectCompatitorsUsingFileWriter(comp, "Ishtirakcilar");
        return person;
    }

    public static Person personInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ishtirakcinin adi:");
        String name = sc.nextLine();
        System.out.println("Ishtirakcinin soy adi:");
        String surname = sc.nextLine();
        System.out.println("Ishtirakcinin yashi:");
        int age = sc.nextInt();
        Person person = new Person(name, surname, age);
        return person;
    }
}
