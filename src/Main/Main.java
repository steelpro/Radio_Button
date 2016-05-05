package Main;

/*
Zachary Betters
CIS 150
3/24/16
Button Assignment
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    // sets text
    Text text = new Text("Click on the Buttons and Boxes");

    @Override
    public void start(Stage primaryStage) throws Exception {
        // sets a font and size for the text
        text.setFont(Font.font("Times", 20));

        // sets three different circles
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbGreen = new RadioButton("Green");
        RadioButton rbBlue = new RadioButton("Blue");

        //if circle "red" is clicked, set text color to red
        rbRed.setOnAction(e -> {
            if (rbRed.isSelected()) {
                text.setFill(Color.RED);
            }
        });

        rbGreen.setOnAction(e -> {
            if (rbGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        rbBlue.setOnAction(e -> {
            if (rbBlue.isSelected()) {
                text.setFill(Color.BLUE);
            }
        });

        // sets group so only one can be clicked
        ToggleGroup tg1 = new ToggleGroup();
        rbRed.setToggleGroup(tg1);
        rbGreen.setToggleGroup(tg1);
        rbBlue.setToggleGroup(tg1);

        // sets check boxes
        CheckBox cbxBold = new CheckBox("Bold");
        CheckBox cbxItalic = new CheckBox("Italic");

        // sets fonts to be used later
        Font fontBoldItalic = Font.font("Times",
                FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Times",
                FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Times",
                FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Times",
                FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);

        EventHandler<ActionEvent> handler = e -> {
            // if both check boxes are selected
            if (cbxBold.isSelected() && cbxItalic.isSelected()) {
                // set text font to bold and italic
                text.setFont(fontBoldItalic);
            } else if (cbxBold.isSelected()) {
                text.setFont(fontBold);
            } else if (cbxItalic.isSelected()) {
                text.setFont(fontItalic);
            } else {
                text.setFont(fontNormal);
            }
        };

        cbxBold.setOnAction(handler);
        cbxItalic.setOnAction(handler);

        VBox pane1 = new VBox(10);
        pane1.setAlignment(Pos.CENTER_LEFT);
        pane1.setPadding(new Insets(10, 10, 10, 10));
        pane1.getChildren().addAll(rbRed, rbGreen, rbBlue);

        VBox pane3 = new VBox(10);
        pane3.setAlignment(Pos.CENTER_LEFT);
        pane3.setPadding(new Insets(10, 10, 10, 10));
        pane3.getChildren().addAll(cbxBold, cbxItalic);

        StackPane pane2 = new StackPane();
        pane2.getChildren().add(text);

        BorderPane pane = new BorderPane();
        pane.setLeft(pane1);
        pane.setCenter(pane2);
        pane.setRight(pane3);

        Scene scene = new Scene(pane, 500, 250);

        primaryStage.setTitle("Radio Buttons and Check Boxes");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void stop() {
        // when program is closed
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Close Event");
        alert.setHeaderText(null);
        //display message
        alert.setContentText("So long and thanks for all the fish");
        alert.showAndWait();
    }
}