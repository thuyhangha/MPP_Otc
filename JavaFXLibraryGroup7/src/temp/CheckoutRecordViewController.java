/*package temp;

import java.io.IOException;

import com.library.controller.SystemController;
import com.library.model.DataAccess;
import com.library.recourse.Resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckoutRecordViewController {
	
	DataAccess dataAccessFacade  = SystemController.getDataAccessFacadeInstance();

    @FXML
    private TextField memberId;

    @FXML
    private Button btnViewCheckoutRecord;

    @FXML
    private Button btngoBack;

    @FXML
    void displayCheckoutRecord(ActionEvent event) throws IOException {
    	int id = Integer.parseInt(memberId.getText());
    	dataAccessFacade.setMemberId(id);    	
    	Stage stage = (Stage) btnViewCheckoutRecord.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource(Resource.CHECKOUTRECORDHISTORY));
		Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btngoBack.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource(Resource.LIBRARIAN));
		Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

}*/