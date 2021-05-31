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
public class Recepcjonista extends Osoba {
    public Recepcjonista(){   
    }

    public void oddajPokoj(Recepcja r, int nrPokoju){
        r.oddajPokoj(nrPokoju);
    }
}
