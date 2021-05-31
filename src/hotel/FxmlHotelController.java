package hotel;

import java.awt.BorderLayout;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class FxmlHotelController implements Initializable {

    @FXML
    private VBox v;
    @FXML
    private FlowPane Checkboxy;
    @FXML
    private CheckBox CheckBoxDyrektor;

    @FXML
    private CheckBox CheckBoxGosc;
    @FXML
    private CheckBox CheckBoxRecepcjonista;
    @FXML
    private CheckBox CheckBoxSprzatacz;
    @FXML
    private FlowPane Buttony;
    @FXML
    private Button button_Dodaj_Pokoj;
    @FXML
    private Button button_Rezerwuj;
    @FXML
    private Button button_Zajmij;
    @FXML
    private Button button_Anuluj_Rezerwacje;
    @FXML
    private FlowPane Texts;
    @FXML
    private Label Label_NrPokoju;
    @FXML
    private TextField TextField_NrPokoju;

    public int dajNrPokoju() {
        return Integer.parseInt(TextField_NrPokoju.getText());
    }
    @FXML
    private Label Label_Nazwisko;
    @FXML
    private TextField TextField_Nazwisko;
    @FXML
    private Button button_Oddaj_Pokoj;
    @FXML
    private Button button_Remont;
    @FXML
    private Button button_Przywroc_Pokoj;
    @FXML
    private Button button_Sprzataj;
    @FXML
    private FlowPane Tabela;
    @FXML
    private TableView<Pokoj> TableView_Pokoje;

    @FXML
    private TableColumn<Pokoj, Integer> ColNrPokoju;

    @FXML
    private TableColumn<Pokoj, String> ColUzytkownik;

    @FXML
    private TableColumn<Pokoj, Status> ColStan;

    public void clear() {
        TextField_Nazwisko.clear();
        TextField_NrPokoju.clear();
    }

    public void clearDisable(Boolean b) {
        clear();
        TextField_Nazwisko.setDisable(b);
        TextField_NrPokoju.setDisable(b);
    }

    public void checkDyr(boolean alfa) {
        button_Dodaj_Pokoj.setDisable(!alfa);
        button_Remont.setDisable(!alfa);
        button_Przywroc_Pokoj.setDisable(!alfa);
    }

    public void checkGosc(boolean alfa) {
        button_Zajmij.setDisable(!alfa);
        button_Rezerwuj.setDisable(!alfa);
        button_Anuluj_Rezerwacje.setDisable(!alfa);
    }

    public void checkRec(boolean alfa) {
        button_Oddaj_Pokoj.setDisable(!alfa);
    }

    public void checkSprz(boolean alfa) {
        button_Sprzataj.setDisable(!alfa);
    }
    EventHandler CbDyr = new EventHandler() {
        @Override
        public void handle(Event event) {

            CheckBox cb = (CheckBox) event.getSource();
            if (cb.isSelected() == true) {
                System.out.println("Hello " + cb.getText());
                checkDyr(true);
                checkSprz(false);
                checkGosc(false);
                checkRec(false);
                CheckBoxGosc.setSelected(false);
                CheckBoxRecepcjonista.setSelected(false);
                CheckBoxSprzatacz.setSelected(false);
                clear();
                TextField_NrPokoju.setDisable(false);
                TextField_Nazwisko.setDisable(true);
            } else if (cb.isSelected() == false) {
                checkDyr(false);
                clearDisable(true);
            }

        }
    };

//----------GoscCb-----------
    EventHandler CbGosc = new EventHandler() {
        @Override
        public void handle(Event event) {
            CheckBox cb = (CheckBox) event.getSource();
            if (cb.isSelected() == true) {
                System.out.println("Hello " + cb.getText());
                CheckBoxDyrektor.setSelected(false);
                CheckBoxRecepcjonista.setSelected(false);
                CheckBoxSprzatacz.setSelected(false);
                checkDyr(false);
                checkSprz(false);
                checkGosc(true);
                checkRec(false);
                clear();
                TextField_NrPokoju.setDisable(true);
                TextField_Nazwisko.setDisable(false);
            } else {
                checkGosc(false);
                clearDisable(true);
            }
        }
    };
    //------------CbRec----------//
    EventHandler CbRec = new EventHandler() {
        @Override
        public void handle(Event event) {
            CheckBox cb = (CheckBox) event.getSource();
            if (cb.isSelected() == true) {
                System.out.println("He " + cb.getText());
                checkDyr(false);
                checkGosc(true);
                checkRec(true);
                checkSprz(false);
                CheckBoxDyrektor.setSelected(false);
                CheckBoxGosc.setSelected(false);
                CheckBoxSprzatacz.setSelected(false);
                clearDisable(false);
            } else {
                checkGosc(false);
                checkRec(false);
                clearDisable(true);
            }
        }
    };
    //------------CbSprzataj--------//
    EventHandler CbSprz = new EventHandler() {
        @Override
        public void handle(Event event) {
            CheckBox cb = (CheckBox) event.getSource();
            if (cb.isSelected() == true) {
                System.out.println("Hello " + cb.getText());
                checkDyr(false);
                checkGosc(false);
                checkRec(false);
                checkSprz(true);
                CheckBoxDyrektor.setSelected(false);
                CheckBoxGosc.setSelected(false);
                CheckBoxRecepcjonista.setSelected(false);
                TextField_Nazwisko.setDisable(true);
                TextField_NrPokoju.setDisable(true);
                clear();
            } else {
                checkSprz(false);
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //CheckBoxRecepcjonista.setOnAction(eh);
        Recepcja r = new Recepcja();
        Dyrektor dyr = new Dyrektor();
        //  Gosc g = new Gosc();
        Sprzatacze sprzatacz = new Sprzatacze();
        Recepcjonista rec = new Recepcjonista();
        ObservableList<Pokoj> oPokoje = FXCollections.observableArrayList(r.pokoje);
        ColNrPokoju.setCellValueFactory(new PropertyValueFactory<>("NrPokoju"));
        ColUzytkownik.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().uzytkownik));
        ColStan.setCellValueFactory(new PropertyValueFactory<>("Stan"));
        TableView_Pokoje.setItems(oPokoje);

        CheckBoxDyrektor.setOnAction(CbDyr);
        CheckBoxRecepcjonista.setOnAction(CbRec);
        CheckBoxGosc.setOnAction(CbGosc);
        CheckBoxSprzatacz.setOnAction(CbSprz);

        button_Dodaj_Pokoj.setOnAction(e -> {
            dyr.dodajPokoj(r);
            oPokoje.add(new Pokoj(r.pokoje.get(r.getSize() - 1).getNrPokoju()));
            oPokoje.set(r.getSize() - 1, new Pokoj(r.getSize()));
        });

        button_Anuluj_Rezerwacje.setOnAction(e -> {
            int i = 0;
            boolean zarezerwowano = false;
            if (TextField_Nazwisko.getText().isEmpty()) {
                System.out.println("Podaj Nazwisko!");
            }else{
                rec.anulujRezerwacje2(r, TextField_Nazwisko.getText());
                while (i < oPokoje.size() && zarezerwowano == false) {
                    if (oPokoje.get(i).uzytkownik.equals(TextField_Nazwisko.getText()) && oPokoje.get(i).stan == Status.zarezerwowany) {
                        oPokoje.set(i, new Pokoj(i + 1));
                        oPokoje.get(i).anulujRezerwacje2(TextField_Nazwisko.getText());
                        zarezerwowano = true;
                    } else {
                        i++;
                    }
                }
            }
        });

        button_Oddaj_Pokoj.setOnAction(e -> { //dziala?
            if (TextField_NrPokoju.getText().isEmpty()) {
                System.out.println("Podaj nrPokoju");
            } else {
                if (TextField_NrPokoju.getText().matches("[0-9]+")) {
                    rec.oddajPokoj(r, Integer.parseInt(TextField_NrPokoju.getText()));
                    if (dajNrPokoju() >= 1 && dajNrPokoju() <= oPokoje.size()) {
                        if (oPokoje.get(dajNrPokoju() - 1).stan == Status.zajety) {
                            oPokoje.set(dajNrPokoju() - 1, new Pokoj(dajNrPokoju()));
                            oPokoje.get(dajNrPokoju() - 1).sprzataj();
                        }
                    }
                } else {
                    System.out.println("Nr pokoju nie może zawierać liter!");
                }
            }
        });

        button_Przywroc_Pokoj.setOnAction(e -> { //dziala
            if (TextField_NrPokoju.getText().isEmpty()) {
                System.out.println("Podaj nrPokoju");
            } else {
                if (TextField_NrPokoju.getText().matches("[0-9]+")) {
                    dyr.przywrocPokoj(r, Integer.parseInt(TextField_NrPokoju.getText()));
                    if (dajNrPokoju() >= 1 && dajNrPokoju() <= oPokoje.size()) {
                        if (oPokoje.get(dajNrPokoju() - 1).stan == Status.naprawa) {
                            oPokoje.set(dajNrPokoju() - 1, new Pokoj(dajNrPokoju()));
                            oPokoje.get(dajNrPokoju() - 1).sprzataj();
                        }
                    }
                } else {
                    System.out.println("Nr pokoju nie może zawierać liter!");
                }
            }
        });

        button_Remont.setOnAction(e -> { //dziala
            if (TextField_NrPokoju.getText().isEmpty()) {
                System.out.println("Podaj nrPokoju");
            } else {
                if (TextField_NrPokoju.getText().matches("[0-9]+")) {
                    dyr.remont(r, Integer.parseInt(TextField_NrPokoju.getText()));
                    if (dajNrPokoju() >= 1 && dajNrPokoju() <= oPokoje.size()) {
                        if (oPokoje.get(dajNrPokoju() - 1).stan == Status.wolny) {
                            oPokoje.set(dajNrPokoju() - 1, new Pokoj(dajNrPokoju()));
                            oPokoje.get(dajNrPokoju() - 1).remont();
                        }
                    }
                } else {
                    System.out.println("Nr pokoju nie może zawierać liter!");
                }
            }

        });

        button_Rezerwuj.setOnAction(e -> { //??
            if (TextField_Nazwisko.getText().isEmpty()) {
                System.out.println("Podaj Nazwisko!");
            } else {
                int i = 0;
                boolean zarezerwowano = false;
                rec.rezerwuj2(r, TextField_Nazwisko.getText());
                while (i < oPokoje.size() && zarezerwowano == false) {
                    if (oPokoje.get(i).stan == Status.wolny) {

                        oPokoje.set(i, new Pokoj(i + 1));
                        oPokoje.get(i).rezerwuj2(TextField_Nazwisko.getText());
                        zarezerwowano = true;
                    } else {
                        i++;
                    }
                }
            }
        });

        button_Sprzataj.setOnAction(e -> {
            sprzatacz.wyszukajBrudny(r);
            int i = 0;
            boolean posprzatano = false;
            while (i < oPokoje.size() && posprzatano == false) {
                if (oPokoje.get(i).stan == Status.sprzataj) {
                    oPokoje.set(i, new Pokoj(i + 1));
                    oPokoje.get(i).posprzatano();
                    //oPokoje.get(i).setStan(Status.wolny);
                    posprzatano = true;
                } else {
                    i++;
                }
            }
        });
        button_Zajmij.setOnAction(e -> { //not wokr
            if (TextField_Nazwisko.getText().isEmpty()) {
                System.out.println("Podaj Nazwisko!");
            } else {

                int i = 0;
                boolean zajmij = false;
                rec.zajmijPokoj(r, TextField_Nazwisko.getText());
                while (i < oPokoje.size() && zajmij == false) {
                    if (oPokoje.get(i).uzytkownik.equals(TextField_Nazwisko.getText()) && oPokoje.get(i).stan == Status.zarezerwowany) {
                        //rec.zajmijPokoj(r, TextField_Nazwisko.getText());
                        oPokoje.set(i, new Pokoj(i + 1));
                        oPokoje.get(i).zajmij(TextField_Nazwisko.getText());
                        zajmij = true;
                    } else {
                        i++;
                    }
                }
                i = 0;
                while (i < oPokoje.size() && zajmij == false) {
                    if (oPokoje.get(i).stan == Status.wolny) {
                        //rec.zajmijPokoj(r, TextField_Nazwisko.getText());
                        oPokoje.set(i, new Pokoj(i + 1));
                        oPokoje.get(i).zajmij(TextField_Nazwisko.getText());
                        zajmij = true;
                    } else {
                        i++;
                    }

                }
                // rec.zajmijPokoj(r, TextField_Nazwisko.getText());
            }
        });

    }
}
