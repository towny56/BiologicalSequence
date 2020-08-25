package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.instrument.ClassFileTransformer;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main extends Application
{
    public static Information INFORMATION;

    /*
    public static ButtonType confurmationDialog (String information, String title, String header)
    {
        //ButtonType.OK, ButtonType.CANCEL

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(information);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get();
    }
    */

    // DISPLAYS A MASSAGE IF THE INSERTED SOURCE DOES NOT EXIST
    public static void messageDialog (String information, String title, String header)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(information);
        alert.showAndWait();
    }

    // DISPLACE THE INPUT DIALOG WINDOW FOR THE SAMPLE
    public String inputDialog ()
    {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("INPUT");
        textInputDialog.setContentText("Enter sequence ID:");
        textInputDialog.setHeaderText(null);
        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent())
        {
            return result.get();
        }
        else
        {
            return "";
        }
    }

    // READS INFORMATION FROM THE FILE WITCH IS THE SEQUENCE OF THE GENE
    public String inputFromFile (String fileName) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new FileReader(".\\resources\\" + fileName + ".txt"));

        String line = "";
        String result = "";

        while ((line = buffer.readLine()) != null)
        {
            result = result + line;
        }

        return result;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        String sample = inputDialog();

        if (!(new File(".\\resources", sample + ".txt").exists()))
        {
            messageDialog("Source don't exist!", "ERROR", null);
            return;
        }

        String sequence = inputFromFile(sample);

        INFORMATION = new Information(sample, sequence);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GENE");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
