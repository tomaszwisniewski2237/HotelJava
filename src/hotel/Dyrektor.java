/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author admin
 */
public class Dyrektor {
    int pozycja;
    String login = "Herbata";
    String haslo = "EarlGrey";
    boolean zalogowano = false;

    public Dyrektor() {
    }

//    public boolean Login(String login, String haslo) {
//        if (login == this.login && haslo == this.haslo) {
//            System.out.println("Zalogowano pomyslnie");
//            zalogowano = true;
//        } else {
//            System.out.println("Nie zalogowano");
//        }
//        return zalogowano;
//    }

    public void dodajPokoj(Recepcja r) {
        r.dodajPokoj();
    }

    public void remont(Recepcja r, int pozycja) {
        //r.wyszukaj(pozycja);
        r.remont(pozycja);
    }

    public void przywrocPokoj(Recepcja r, int pozycja) {
        r.przywrocPokoj(pozycja);
    }
}
