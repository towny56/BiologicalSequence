package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller
{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLoadSequence;

    @FXML
    private Button btnFormatSequence;

    @FXML
    private Button btnComputeSequence;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnClearSequence;

    @FXML
    private TextField txtSequence;

    @FXML
    private TextArea txtComputeSequence;

    @FXML
    void btnClearSequenceClicked(ActionEvent event)
    {
        txtSequence.setText("");
        txtComputeSequence.setText("");
    }

    @FXML
    void btnComputeSequenceClicked(ActionEvent event)
    {
        txtComputeSequence.setText(Function.computeString());
    }

    @FXML
    void btnFormatSequenceClicked(ActionEvent event)
    {
        txtSequence.setText(Function.formatString());
    }

    @FXML
    void btnLoadSequenceClicked(ActionEvent event)
    {
        txtSequence.setText(Main.INFORMATION.getSequence());
    }

    @FXML
    void btnQuitClicked(ActionEvent event)
    {
        Platform.exit();
    }

    @FXML
    void initialize()
    {
        assert btnLoadSequence != null : "fx:id=\"btnLoadSequence\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnFormatSequence != null : "fx:id=\"btnFormatSequence\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnComputeSequence != null : "fx:id=\"btnComputeSequence\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnClearSequence != null : "fx:id=\"btnClearSequence\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtSequence != null : "fx:id=\"txtSequence\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtComputeSequence != null : "fx:id=\"txtComputeSequence\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
