package SB;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TextField nameInput, priceInput;
    @FXML
    private TextArea mainArea;
    @FXML
    private Button editBtn, exitBtn, okBtn;
    @FXML
    private Spinner<Integer> quantityInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    ShoppingBasket sb = new ShoppingBasket();


    @FXML
    public void add(){
        sb.addProduct(nameInput.getText(), Double.parseDouble(priceInput.getText()), quantityInput.getValue());
        mainArea.setText(sb.toString());
    }

    @FXML
    public void remove()throws Exception{
        sb.removeProduct(nameInput.getText(), quantityInput.getValue());
        mainArea.setText(sb.toString());
    }

    @FXML
    public void clear(){
        sb.clearBasket();
        mainArea.setText(sb.toString());
    }

    @FXML
    public void handleEdit(ActionEvent event)throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == editBtn) {
            stage= new Stage();
            root = FXMLLoader.load(getClass().getResource("edit.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(editBtn.getScene().getWindow());
            stage.showAndWait();
        }else{
            stage = (Stage)okBtn.getScene().getWindow();
            stage.close();

        }
       

    }

    @FXML
    public void exit(){
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void writeToFile() throws IOException{
        sb.saveBasket("Receipt");
    }
}