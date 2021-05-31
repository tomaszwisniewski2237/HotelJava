package hotel;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Recepcja {

    public ArrayList<Pokoj> pokoje = new ArrayList<Pokoj>();
    // public ObservableList<Pokoj> pokoje = new FXCollections.observableArrayList();

    public Pokoj getPokoj(int pozycja) {
        return pokoje.get(pozycja);
    }

    public int wyszukaj(int nrPokoju) {
        for (int i = 0; i < pokoje.size(); i++) {
            if ((pokoje.get(i).getNrPokoju() == nrPokoju)) {
                return i;
            }
        }
        return -1;
    }

    public int wyszukajStan(Status stan) { // -- do sprzatacza
        for (int i = 0; i < pokoje.size(); i++) {
            if ((pokoje.get(i).getStan() == stan)) {
                return i;
            }
        }
        return -1;
    }

    public int wyszukajUzytkownik(String uzytkownik) { // -- do sprzatacza
        for (int i = 0; i < pokoje.size(); i++) {
//            System.out.println(pokoje.get(i).getUzytkownik());
//            System.out.println(uzytkownik);
            if ((pokoje.get(i).getUzytkownik().equals(uzytkownik))) {
                return i;
            }
        }
        return -1;
    }

    public void dodajPokoj() {
        int nrPokoju = pokoje.size() + 1;
        pokoje.add(new Pokoj(nrPokoju));
        System.out.println("Dodano pokoj nr " + nrPokoju + ".");
    }

//    public void rezerwuj(int nrPokoju, String nazwisko) {
//        int pozycja = wyszukaj(nrPokoju);
//        if (getPokoj(pozycja).getStan() == Status.wolny) {
//            getPokoj(pozycja).rezerwuj(nrPokoju, nazwisko);
//        } else {
//            System.out.println("Brak wolnych pokoi");
//        }
//
//    }
    public void rezerwuj2(String nazwisko) {
        Status stan = Status.wolny;
        int pozycja = wyszukajStan(stan);

        if (pozycja == -1) {
            System.out.println("Brak wolnych pokoi.");
        } else {
            getPokoj(pozycja).rezerwuj2(nazwisko);
            System.out.println("Zarezerwowano pokoj nr: " + pokoje.get(pozycja).getNrPokoju()+ " na nazwisko "+ pokoje.get(pozycja).getUzytkownik() +".");
        }
    }

//    public void anulujRezerwacje(int nrPokoju) {
//
//        int pozycja = wyszukaj(nrPokoju);
//        if (pozycja == -1) {
//            System.out.println("Nie ma takiego numer pokoju");
//        } else {
//            System.out.println("Anulowano rezerwacja na nr pokoju : ");
//            getPokoj(pozycja).anulujRezerwacje(nrPokoju);
//        }
//    }
    public void anulujRezerwacje2(String nazwisko) {
        int pozycja = wyszukajUzytkownik(nazwisko);
        if (pozycja == -1) {
            System.out.println("Nie ma rezerwacji na takie nazwisko.");
        } else {
            getPokoj(pozycja).anulujRezerwacje2(nazwisko);
            System.out.println("Anulowano rezerwacje pokoju nr "+ getPokoj(pozycja).getNrPokoju() + " na nazwisko " + nazwisko+".");
        }
    }

    public void zajmijPokoj(String uzytkownik) {
        int pozycja = wyszukajStan(Status.zarezerwowany);
        if (pozycja == -1) {
            pozycja = wyszukajStan(Status.wolny);
            if (pozycja == -1) {
                System.out.println("Pokoje zajete.");
            } else if (getPokoj(pozycja).getStan() == Status.wolny) {
                getPokoj(pozycja).zajmij(uzytkownik);
                System.out.println("Zajeto pokoj nr "+ getPokoj(pozycja).getNrPokoju() + " na nazwisko: " + uzytkownik + ".");
            } else {
                System.out.println("Brak wolnych pokoi.");
            }
        } else if (getPokoj(pozycja).getStan() == Status.zarezerwowany) {
            getPokoj(pozycja).zajmij(uzytkownik);
            System.out.println("Zajeto pokoj nr " + getPokoj(pozycja).getNrPokoju() + " na nazwisko: " + uzytkownik + ".");
        } else {
            System.out.println("Brak rezerwacji.");
        }
    }

    public void oddajPokoj(int nrPokoju) {
        int pozycja = wyszukaj(nrPokoju);
        if (pozycja == -1) {
            System.out.println("Nie ma takiego numeru pokoju.");
        } else if (getPokoj(pozycja).getStan() == Status.zajety) {
            getPokoj(pozycja).oddajPokoj();
            System.out.println("Oddano pokoj o numerze: " + nrPokoju+".");
        } else {
            System.out.println("Ten pokoj nie jest zajety.");
        }
    }

    public void remont(int nrPokoju) {
        int pozycja = wyszukaj(nrPokoju);
        if (pozycja == -1) {
            System.out.println("Nie ma takiego numeru pokoju.");
        } else if (pokoje.get(pozycja).getStan() == Status.wolny) {
            pokoje.get(pozycja).remont();
            System.out.println("Pokoj nr " + pokoje.get(pozycja).getNrPokoju() + " wyslany do remontu."); // + nr pokoju
        } else {
            System.out.println("Tego pokoju nie można remontować.");
        }
    }

    public void przywrocPokoj(int nrPokoju) {
        int pozycja = wyszukaj(nrPokoju);
        if (pozycja == -1) {
            System.out.println("Nie ma takiego numeru pokoju.");
        } else if (pokoje.get(pozycja).getStan() == Status.naprawa) {
            pokoje.get(pozycja).sprzataj();
            System.out.println("Pokoj nr " + pokoje.get(pozycja).getNrPokoju() + " wyremontowano, nalezy go posprzatac!");
        } else {
            System.out.println("Pokoj nie jest w remoncie.");
        }
    }

    public void sprzataj() {
        int pozycja = wyszukajStan(Status.sprzataj);
        if (pozycja == -1) {
            System.out.println("Brak brudnych pokoi.");
        } else if (pokoje.get(pozycja).getStan() == Status.sprzataj) {
            pokoje.get(pozycja).posprzatano();
            System.out.println("Posprzątano pokoj nr: " + pokoje.get(pozycja).getNrPokoju()+".");
        }
    }
//    public void setUzytkownik(String nazwisko){
//        int pozycja = wyszukajUzytkownik(nazwisko);
//        pokoje.get(pozycja).setRezerwant(nazwisko);
//    }

    public int getSize() {
        return pokoje.size();
    }
}
