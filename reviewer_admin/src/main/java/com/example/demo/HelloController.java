package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;

public class HelloController {
    @FXML
    private Button buttonRole;
    @FXML
    private Button buttonBlock;
    @FXML
    private Button buttonRefresh;
    @FXML
    private TextField ind;

    @FXML
    private TableColumn<User, String> password;
    @FXML
    private TableColumn<User, String> name;
    @FXML
    private TableColumn<User, Boolean> role;
    @FXML
    private TableColumn<User, Boolean> isBlocked;
    @FXML
    private TableColumn<User, Boolean> isRequested;
    @FXML
    private TableView<User> table1;

    ObservableList<User> list = FXCollections.observableArrayList();
    DBFunctions db = new DBFunctions();
    Connection conn = db.connect_to_db("kursach", "postgres", "postgres");

    @FXML
    private void initialize() {

        initData();

        name.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        //password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        role.setCellValueFactory(new PropertyValueFactory<User, Boolean>("Role"));
        isRequested.setCellValueFactory(new PropertyValueFactory<User, Boolean>("IsRequested"));
        isBlocked.setCellValueFactory(new PropertyValueFactory<User, Boolean>("IsBlocked"));

        table1.setItems(list);

        buttonRole.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(ind.getText() != null){
                    if( Integer.parseInt(ind.getText()) >= 0 && Integer.parseInt(ind.getText()) < list.size()) {
                        updateRole(list.get(Integer.parseInt(ind.getText()) - 1).getName(),
                                !list.get(Integer.parseInt(ind.getText()) - 1).getRole(),
                                !list.get(Integer.parseInt(ind.getText()) - 1).getIsRequested());
                    }
                }
            }
        });
        buttonBlock.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(ind.getText() != null){
                    if( Integer.parseInt(ind.getText()) >= 0 && Integer.parseInt(ind.getText()) < list.size()){
                        updateBlock(list.get(Integer.parseInt(ind.getText()) - 1).getName(),
                                !list.get(Integer.parseInt(ind.getText()) - 1).getIsBlocked());
                    }
                }
            }
        });
        buttonRefresh.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                initData();
            }
        });
    }
    private void initData() {
        list = FXCollections.observableList( db.read_data(conn, "users"));
        System.out.println(list);
        table1.setItems(list);
        table1.refresh();
    }
    private void updateRole(String name, boolean role, boolean req){
        db.updateRole(conn, "users",  name , Boolean.toString(role));
        initData();
    }
    private void updateBlock(String name, boolean block){
        db.updateBlock(conn, "users",  name , Boolean.toString(block));
        initData();
    }
}
