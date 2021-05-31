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

public class Osoba {

    String nazwisko;
    
    public int wyszukajWolny(Recepcja r){
        int wynik = r.wyszukajStan(Status.wolny);
        return wynik ;
    }
//    public void rezerwuj(Recepcja r, int nrPokoju, String nazwisko){
//        r.rezerwuj(nrPokoju,nazwisko);
//        //return "Zarezerwowano na nazwisko: " + nazwisko;
//    }
    
    public void rezerwuj2(Recepcja r, String nazwisko){
        r.rezerwuj2(nazwisko);
    }
//    public void anulujRezerwacje(Recepcja r, int nrPokoju){
//        r.anulujRezerwacje(nrPokoju);
//    }
    public void anulujRezerwacje2(Recepcja r, String nazwisko){
        r.anulujRezerwacje2(nazwisko);
    }
    public void zajmijPokoj(Recepcja r, String nazwisko){
        r.zajmijPokoj(nazwisko);
        
    }
    
}
