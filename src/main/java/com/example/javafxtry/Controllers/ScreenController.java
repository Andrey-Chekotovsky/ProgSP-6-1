package com.example.javafxtry.Controllers;

import com.example.javafxtry.Models.FullName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;
import java.util.function.BiFunction;

public class ScreenController implements Initializable {
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField patronymicField;
    @FXML
    private Button enterButton;
    @FXML
    private ListView<String> firstNameList;
    @FXML
    private ListView<String> secondNameList;
    @FXML
    private ListView<String> patronymicList;
    @FXML
    private CheckBox lastNameCheck;
    @FXML
    private CheckBox firstNameCheck;
    @FXML
    private CheckBox patronymicCheck;

    private List<FullName> fullNames = new ArrayList<>(Arrays.asList(
        new FullName("Б", "Б", "В"),
        new FullName("Б", "Aб", "В"),
        new FullName("Аб", "Aб", "Ю"),
            new FullName("Аб", "Aб", "А")
    ));
    public void enter(ActionEvent event) {
        if (secondNameField.getText().isEmpty() || firstNameField.getText().isEmpty() ||
                patronymicField.getText().isEmpty()){
            return;
        }
        FullName fullName = new FullName(firstNameField.getText(),
                secondNameField.getText(), patronymicField.getText());
        fullNames.add(fullName);
        resetLists();
        secondNameField.clear();
        firstNameField.clear();
        patronymicField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resetLists();
    }

    public void changeFilter(ActionEvent event){
        BiFunction<FullName, FullName, Integer> comporator =
                new FullNameComporator(firstNameCheck.isSelected(),
                        lastNameCheck.isSelected(),
                        patronymicCheck.isSelected())
                        .getComporator();
        Collections.sort(fullNames, (a, b) -> comporator.apply(a, b));
        resetLists();
    }

    private void resetLists() {
        firstNameList.getItems().clear();
        secondNameList.getItems().clear();
        patronymicList.getItems().clear();
        firstNameList.getItems().addAll(getFirstNameList(fullNames));
        secondNameList.getItems().addAll(getLastNameList(fullNames));
        patronymicList.getItems().addAll(getPatronymicList(fullNames));
    }

    private List<String> getFirstNameList(List<FullName> fullNames){
        List<String> list = new ArrayList<>();
        for (FullName f:
             fullNames) {
            list.add(f.getFirstName());
        }
        return list;
    }
    private List<String> getLastNameList(List<FullName> fullNames){
        List<String> list = new ArrayList<>();
        for (FullName f:
                fullNames) {
            list.add(f.getLastName());
        }
        return list;
    }
    private List<String> getPatronymicList(List<FullName> fullNames){
        List<String> list = new ArrayList<>();
        for (FullName f:
                fullNames) {
            list.add(f.getPatronymic());
        }
        return list;
    }

}
