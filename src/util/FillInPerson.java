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

import java.util.Scanner;
import static util.ChoiceMenu.members;

/**
 *
 * @author RafaelAhmedov
 */
public class FillInPerson {

    public static Person personFilliIn(CompatitorsList person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Yarishmada nece shexs ishdirak edecek?");
        members = sc.nextInt();
        Person member[] = new Person[members];

        for (int i = 0; i < members; i++) {
            member[i] = personInformation();
            person.setPerson(member);
        }

//        CompatitorsList c =  new CompatitorsList();
//        c.setPerson(member);
        WriteToObjectCompatitors.writeToObjectCompatitorsUsingFileWriter(person,"Ishtirakcilar");
        System.out.println("write"+person.toString());
        ReadToObjectCompatitors.readToObjectCompatitorsUsingOutputStream("Ishtirakcilar");
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
