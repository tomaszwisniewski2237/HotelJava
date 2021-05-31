/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and ope n the template in the editor.
 */
package hotel;

/**
 *
 * @author admin
 */
enum Status {

    wolny, zarezerwowany, naprawa, zajety, sprzataj
}

public class Pokoj {

    public int nrPokoju; //nr pokoju
    public Status stan = Status.wolny;
    public String uzytkownik = ""; // użytkownik pokoju

    public Pokoj(int nrPokoju) {
        this.nrPokoju = nrPokoju;
    }

    public void setRezerwant(String nazwisko) {
        this.uzytkownik = nazwisko;
    }

    public int getNrPokoju() {
        return nrPokoju;
    }

    public Status getStan() {
        return stan;
    }

    public void setStan(Status stan) {
        this.stan = stan;
    }

    public String getUzytkownik() {
        return uzytkownik;
    }

    public void rezerwuj(int nrPokoju, String nazwisko) {
        stan = Status.zarezerwowany;
        uzytkownik = nazwisko;
    }

    public void rezerwuj2(String nazwisko) {
        stan = Status.zarezerwowany;
        uzytkownik = nazwisko;
    }
    //else {
//            throw new RuntimeException("Pokoj niedostepny");

    public void anulujRezerwacje(int nrPokoju) {
        if (stan == Status.zarezerwowany) {
            setRezerwant("");
            stan = Status.wolny;
        }
    }

    public void anulujRezerwacje2(String nazwisko) {
        if (stan == Status.zarezerwowany && nazwisko.equals(uzytkownik)) {
            uzytkownik="";
            stan = Status.wolny;
        }
    }

    public void zajmij(String nazwisko) {
        if ((stan == Status.wolny) || (stan == Status.zarezerwowany)) {

            if (stan == Status.wolny) {
                setRezerwant(nazwisko);
                stan = Status.zajety;

            } else if ((stan == Status.zarezerwowany)
                    && (uzytkownik.equals(nazwisko))) {

                stan = Status.zajety;
            }
//            else {
//                throw new RuntimeException("Zarezerwowany na inne nazw.");
//            }
        } else {
            throw new RuntimeException("Pokoj niedostepy");
        }
    }

    public void oddajPokoj() {
        if (stan == Status.zajety) {
            stan = Status.sprzataj;
            uzytkownik = "";
        }
    }

    public void remont() {
        stan = Status.naprawa;
    }

    public void sprzataj() {
        stan = Status.sprzataj;
    }

    public void posprzatano() {
        stan = Status.wolny;
    }

    @Override
    public String toString() {
        String string = "Pokoj nr " + nrPokoju + " jest";
        if (stan == Status.wolny) {
            string += " wolny";
        } else if (stan == Status.zarezerwowany) {
            string += " zarezerwowany na nazwisko " + uzytkownik;
        } else if (stan == Status.naprawa) {
            string += " naprawa";
        } else if (stan == Status.zajety) {
            string += " zajety na nazwisko " + uzytkownik;
        } else if (stan == Status.sprzataj) {
            string += " do sprzatania";
        }
        return string;
    }
}
