/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import ReadToObject.ReadToObjectCompatitors;
import beans.CompatitorsList;
import beans.Login;
import beans.Person;

import java.util.ArrayList;

/**
 *
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
            CompatitorsList comp = new CompatitorsList();
            if (a) {
                util.ChoiceMenu.choice(comp);
                if (b) {
                    util.FillInPerson.personFilliIn(comp);
                    System.out.println("Yarishmacilar ugurla qeydiyyatdan kecdi!");
                    util.StartGame.startmatch(comp);
                }
            }
        }
    }
}
