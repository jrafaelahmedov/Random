/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ReadToObject.ReadToObjectCompatitors;
import WriteToObjectIO.WriteToObjectCompatitors;
import beans.CompatitorsList;
import beans.Login;
import beans.Person;

import java.util.ArrayList;

/**
 * @author RafaelAhmedov
 */
public class Game {

    /**
     *
     */
    public static boolean a = true;
    public static boolean b = true;

    public static void main(String[] args) {
        while (a) {
            Login login = util.LogIn.logIn();
            Person p = new Person();
            CompatitorsList comp= new CompatitorsList();
            if (a) {
                util.ChoiceMenu.choice(p);
                if (b) {
                    util.FillInPerson.personFilliIn(p);
                    System.out.println("Yarishmacilar ugurla qeydiyyatdan kecdi!");
                    util.StartGame.startmatch(p);
                }
            }
        }
    }
}
