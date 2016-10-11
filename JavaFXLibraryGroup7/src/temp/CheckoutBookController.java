/*package temp;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.mpp.library.controller.CheckoutBookController;
import com.mpp.library.entity.Address;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.entity.Person;
import com.mpp.library.ui.model.CheckoutEntryModel;
import com.mpp.library.ui.model.adapter.CheckoutEntryAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class CheckoutBookController {

	private CheckoutBookController checkoutController = CheckoutBookController.getInstance();

	@FXML
	private TextField txtMemberID;
	@FXML
	private Text txtName;
	@FXML
	private Text txtAddress;
	@FXML
	private Text txtCheckoutDate;
	@FXML
	private TextField txtISBN;

	@FXML
	private TableColumn titleColumn;

	@FXML
	private TableView<CheckoutEntryModel> checkoutEntryTable;

	private ObservableList<CheckoutEntryModel> values = FXCollections.observableArrayList();

	public CheckoutBookController() {
	}

	@FXML
	private void initialize() {
		titleColumn.prefWidthProperty().bind(checkoutEntryTable.widthProperty().subtract(310));
		values.addAll(CheckoutEntryAdapter.toCheckoutEntryModels(new CheckoutRecord().getRecordEntries()));
		checkoutEntryTable.setItems(values);
	}

	@FXML
	private void checkoutBook(ActionEvent event) {
//		System.out.println("checkoutBooks");
		CheckoutRecord checkoutRecord;
		try {
			checkoutRecord = checkoutController.checkoutBooks(txtMemberID.getText(), txtISBN.getText());
			Person member = checkoutRecord.getMember();
			if (member != null){
				// check the user
				if (!member.getLastName().equals(txtName.getText())){
					txtName.setText(member.getLastName());
					Address address = member.getAddress();
					if (address != null){					
						txtAddress.setText(address.toString());
					}
				}
			}

			values.clear();
			values.addAll(CheckoutEntryAdapter.toCheckoutEntryModels(checkoutRecord.getRecordEntries()));
		} catch (Exception ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Exception Dialog");
			alert.setHeaderText(null);
			alert.setContentText(ex.toString());

			// Create expandable Exception.
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			String exceptionText = sw.toString();

			Label label = new Label("The exception stacktrace was:");

			TextArea textArea = new TextArea(exceptionText);
			textArea.setEditable(false);
			textArea.setWrapText(true);

			textArea.setMaxWidth(Double.MAX_VALUE);
			textArea.setMaxHeight(Double.MAX_VALUE);
			GridPane.setVgrow(textArea, Priority.ALWAYS);
			GridPane.setHgrow(textArea, Priority.ALWAYS);

			GridPane expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(textArea, 0, 1);

			// Set expandable Exception into the dialog pane.
			alert.getDialogPane().setExpandableContent(expContent);

			alert.showAndWait();
		}

	}
}
*/