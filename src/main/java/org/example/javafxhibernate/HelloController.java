package org.example.javafxhibernate;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.javafxhibernate.models.Equipo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Equipo> table;
    @FXML
    private TableColumn<Equipo, Long> cId;
    @FXML
    private TableColumn<Equipo, String> cNombre;
    @FXML
    private TableColumn<Equipo, String> cCategoria;
    @FXML
    private TableColumn<Equipo, Boolean> cDisponible;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        cDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try {
            List<Equipo> equipos = sf.fromSession(session ->
                    session.createQuery("from Equipo", Equipo.class).getResultList());
            table.setItems(FXCollections.observableArrayList(equipos));
        } finally {
            sf.close();
        }
    }
}
