package com.library.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.library.entity.Book;
import com.library.entity.CheckoutRecord;
import com.library.entity.CheckoutRecordEntry;
import com.library.entity.LibraryMember;
import com.library.model.DataAccess;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;


public class OverDueBooksController implements Initializable{
	
	DataAccess dataAccess  = SystemController.getDataAccessInstance();
	
	ObservableList<CheckoutRecordEntry> memberCheckoutRecords;
	
	@FXML
    private TableView<CheckoutRecordEntry> checkoutEntryTable;
	@FXML
	private TextField txtISBN;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> isbnColumn;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, String> titleColumn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberCheckoutRecords = FXCollections.observableArrayList();
		checkoutEntryTable.setItems(memberCheckoutRecords);
	}
	
    @FXML
    void getOverDueBook(ActionEvent event) {   	
    	String isbn = txtISBN.getText();
    	HashMap<String, Book> bookMap = dataAccess.getBook();
    	Book book = bookMap.get(isbn);
    	boolean bookFound = book != null? true : false;
 
    	if (!bookFound) {
    		showAlerMessage("Information Dialog", "Print Checkout Error", "Please input correct member Id!", AlertType.ERROR);	
		}else {
			// Update checked out book and related information
			List<CheckoutRecordEntry> allOverDueEntries = new ArrayList<CheckoutRecordEntry>();
			HashMap<String, LibraryMember> allLibraryMember = dataAccess.getLibraryMember();
			for (String key : allLibraryMember.keySet()) {
				LibraryMember libraryMember = allLibraryMember.get(key);
				CheckoutRecord checkoutRecord = libraryMember.getCheckoutRecord();
				if (checkoutRecord != null) {
					List<CheckoutRecordEntry> overDueEntries = checkoutRecord.getOverDueRecordEntry();
					if (overDueEntries != null && overDueEntries.isEmpty() == false) {
						allOverDueEntries.addAll(overDueEntries);
					}
				}
			}
			memberCheckoutRecords.addAll(allOverDueEntries);
        	isbnColumn.setCellValueFactory(new Callback<CellDataFeatures<CheckoutRecordEntry, String>, ObservableValue<String>>() {
			     public ObservableValue<String> call(CellDataFeatures<CheckoutRecordEntry, String> p) {
			         String isbnString = p.getValue().getBookCopy().getBook().getISBN(); 
			         return new SimpleStringProperty(isbnString);
			     }
			});
        	titleColumn.setCellValueFactory(new Callback<CellDataFeatures<CheckoutRecordEntry, String>, ObservableValue<String>>() {
			     public ObservableValue<String> call(CellDataFeatures<CheckoutRecordEntry, String> p) {
			         String titleString = p.getValue().getBookCopy().getBook().getTitle(); 
			         return new SimpleStringProperty(titleString);
			     }
			});
    	}
    }
    
    private void showAlerMessage(String title, String header, String message, AlertType alertType) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(header);
    	alert.setContentText(message);
    	alert.showAndWait();
    }
}
