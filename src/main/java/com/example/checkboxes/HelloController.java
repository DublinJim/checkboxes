package com.example.checkboxes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public CheckBox checkBox = new CheckBox("Click here");
    public VBox vBox;
    public Text txt1 = new Text();
    public Text txt2 = new Text();
    public Text txt3 = new Text();
    private SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty();
    private SimpleBooleanProperty setprop = new SimpleBooleanProperty(true);
    private ChoiceBox<Double> volumeChoiceBox = new ChoiceBox<>();
    private Double[] volChoices = {1.0, 2.0, 3.0};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txt1.setText("Off");
        volumeChoiceBox.getItems().addAll(volChoices);
        volumeChoiceBox.setOnAction(this::getVolValue);
        checkBox.setSelected(false);
        checkBox.setPadding(new Insets(10));
        checkBox.setOnAction(actionEvent -> {
            boolean toggle = checkBox.isSelected();
            txt1.setText(String.valueOf(checkBox.isSelected()));
            setThisAsOn();
        });

        vBox.getChildren().addAll(checkBox, txt1, txt2, volumeChoiceBox, txt3);

        //add a listener
        simpleBooleanProperty.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (checkBox.isSelected()) {
                    simpleBooleanProperty.setValue(aBoolean);
                    txt1.setText(simpleBooleanProperty.toString());
                }
            }
        });


    }//end of function

    private void getVolValue(ActionEvent actionEvent) {
        double choice = volumeChoiceBox.getValue();
        txt3.setText(String.valueOf(choice));
        setThingUp(choice);
    }

    private void setThingUp(double choice) {
        double thingToSet = choice;
        txt3.setText("Setting is now at " + thingToSet);
    }

    private void setThisAsOn() {
        boolean isSet = checkBox.isSelected();
        txt2.setText("Now is Set " + isSet);
    }


}//end of class