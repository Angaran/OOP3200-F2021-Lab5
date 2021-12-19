//File Name: OOP3200-F2021-JavaLab5
//Student #1:Angaran Yogeswaran
//Student #1 ID: 100754161
//Student #2: Taylor Bazouzi
//Student #2: 100579090
//Date: December 18th 2021

package ca.durhamcollege.oop3200f2021javalab5;
//importing necessary files
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;



public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Java Lab 5");




        //Step 1 Create a control
        // Creating Controls for the Labels that tell the user what to enter
        Label MyHeightLabel = new Label("My Height in Inches");
        Label MyWeightLabel = new Label("My Weight in Pounds");

        // Creating Controls for the Textfields that let the user enter values
        TextField HeightInput = new TextField();
        TextField Weightnput = new TextField();

        // Creating Controls for the BMI TextField and Calculate Button
        TextField BMIDisplay = new TextField();
        Button calculateButton = new Button("Calculate BMI");

        Label BMIScale = new Label("BMI SCALE");
        Label Result = new Label("Result");
        Label Underweight = new Label("UnderWeight");
        Label Underweight2 = new Label("Less than 18.5");
        Label Normal = new Label("Normal");
        Label Normal2 = new Label("Between 18.5 and 24.9");
        Label Overweight = new Label("OverWeight");
        Label Overweight2 = new Label("Between 25 and 29.9");
        Label Obese = new Label("Obese");
        Label Obese2 = new Label("30 or Greater");
        //// Creating Controls for the Label for BMI Field
        Label BMILabel = new Label("My BMI");

        //Creating Controls to output code
        Label BMIScaleTitle = new Label("BMI Scale Result");
        TextField BMIScaleResult = new TextField();
        BMIScaleResult.setPrefWidth(300);


        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                String Weight =Weightnput.getText();
                String Height =HeightInput.getText();
                int weight = Integer.parseInt(String.valueOf(Weight));
                int height = Integer.parseInt(String.valueOf(Height));
                String BMIString;
                BMIString = BMIDisplay.getText();
                int BMI = (int) ((weight * 703)/Math.pow(height,2));

               BMIDisplay.setText(String.valueOf(BMI));
               System.out.println(height);
               System.out.println(weight);
               System.out.println((weight * 703)/Math.pow(height,2));
               System.out.println(BMIString);

                if (BMI < 18.5)
                {
                    BMIScaleResult.setText("Your BMI is underweight");
                }
                else if(BMI >18.5 && BMI <24.9)
                {
                    BMIScaleResult.setText("Your BMI is Normal");
                }
                else if (BMI > 25 && BMI < 29.9)
                {
                    BMIScaleResult.setText("Your BMI is overweight");
                }
                else
                {
                    BMIScaleResult.setText("Your BMI is Obese");
                }
            }
        }
        calculateButton.setOnAction(new ButtonClickHandler());



        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");

        gridPane.add(MyHeightLabel,0,0);
        gridPane.add(MyWeightLabel,0,1);
        gridPane.add(HeightInput,1,0);
        gridPane.add(Weightnput,1,1);
        gridPane.add(BMILabel,0,2);
        gridPane.add(BMIDisplay,1,2);
        gridPane.add(calculateButton,2,2);

        gridPane.add(BMIScale,0,3);
        gridPane.add(Underweight,0,4);
        gridPane.add(Normal,0,5);
        gridPane.add(Overweight,0,6);
        gridPane.add(Obese,0,7);

        gridPane.add(Result,1,3);
        gridPane.add(Underweight2,1,4);
        gridPane.add(Normal2,1,5);
        gridPane.add(Overweight2,1,6);
        gridPane.add(Obese2,1,7);

        gridPane.add(BMIScaleTitle,2,0);
        gridPane.add(BMIScaleResult,2,1);

        Scene primaryscene = new Scene(gridPane);


        stage.setScene(primaryscene);
        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}