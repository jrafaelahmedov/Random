/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.List;

/**
 * @author RafaelAhmedov
 */
public class Login extends Person {

    private String username = "Rafael";
    private String password = "12345";
    private int xal = 0;

    public int getXal() {
        return xal;
    }

    public void setXal(int xal) {
        this.xal = xal;
    }

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
