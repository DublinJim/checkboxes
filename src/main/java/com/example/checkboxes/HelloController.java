package com.example.checkboxes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public CheckBox choices = new CheckBox("Click here");
    public VBox vBox;
    public Text txt1 = new Text();
    public Text txt2 = new Text();
    private SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty();
    private SimpleBooleanProperty setprop = new SimpleBooleanProperty(true);
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txt1.setText("Off");
        choices.setSelected(false);
        choices.setPadding(new Insets(10));
        choices.setOnAction(actionEvent -> {
            boolean toggle =choices.isSelected();
            txt1.setText(String.valueOf(choices.isSelected()));

            setThisAsOn();
        });
        vBox.getChildren().addAll(choices, txt1,txt2);
        simpleBooleanProperty.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (choices.isSelected()) {
                    simpleBooleanProperty.setValue(aBoolean);
                    txt1.setText(simpleBooleanProperty.toString());
                }
            }
        });


    }

    private void setThisAsOn() {
      boolean  isSet = choices.isSelected();
        txt2.setText("Now is Set "+isSet);
    }
}