package com.library.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.CheckoutRecord;
import com.library.entity.CheckoutRecordEntry;
import com.library.entity.LibraryMember;
import com.library.model.DataAccess;
import com.library.utility.Utility;
import com.sun.prism.impl.Disposer.Record;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Callback;


public class CheckoutRecordController implements Initializable{
	
	DataAccess dataAccess  = SystemController.getDataAccessInstance();
	
	ObservableList<CheckoutRecordEntry> memberCheckoutRecords;
	
	@FXML
    private TableView<CheckoutRecordEntry> checkoutEntryTable;
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
	private TableColumn<CheckoutRecordEntry, String> isbnColumn;
	
	@FXML
	private TableColumn<CheckoutRecordEntry, String> titleColumn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberCheckoutRecords = FXCollections.observableArrayList();
		checkoutEntryTable.setItems(memberCheckoutRecords);
	}
	
    @FXML
    void addCheckoutRecord(ActionEvent event) {
    	
    	String id = txtMemberID.getText();
    	String isbn = txtISBN.getText();
 
    	boolean bookCopyFound = false;
    	boolean libraryMemberFound = false;
    	
    	Book book = dataAccess.getBook().get(isbn);
    	BookCopy bookCopy = null;
    	LibraryMember libraryMember = null;
    	
    	bookCopy = dataAccess.getAvailableBookCopy(isbn);
    	if(bookCopy != null){
    		bookCopyFound = true;
    	}
    	
    	libraryMember = dataAccess.getLibraryMemberById(id);
    	if(libraryMember != null){
    		libraryMemberFound = true;
    		txtName.setText(libraryMember.getFullName());
    		txtAddress.setText(libraryMember.getAddress().getStringAddress());
    	}
 
    	if(!bookCopyFound){
    		Utility.showAlerMessage("Information Dialog", "Checkout Error", "This book is not available!!", AlertType.ERROR);
    	}else if (!libraryMemberFound) {
    		Utility.showAlerMessage("Information Dialog", "Checkout Error", "Please input correct member Id!", AlertType.ERROR);	
		}else if(bookCopyFound && libraryMemberFound){
			// Update checked out book and related information
			dataAccess.setBookCopyAsNotAvailable(isbn, bookCopy.getCopyNum());
    		CheckoutRecord checkoutRecord = libraryMember.getCheckoutRecord();
        	if( checkoutRecord == null){
        		checkoutRecord = new CheckoutRecord();
        	}
        	
        	List<CheckoutRecordEntry> entries = checkoutRecord.getRecordEntries();
        	CheckoutRecordEntry entry = new CheckoutRecordEntry(bookCopy, LocalDate.now(), LocalDate.now().plusDays(21));
        	entries.add(entry);
        	libraryMember.setCheckoutRecord(checkoutRecord);
        	dataAccess.addLibraryMember(libraryMember);
        	memberCheckoutRecords.addAll(entries);
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
        	Utility.showAlerMessage("Information Dialog", "Checkout Success", " Book Checkout successful !", AlertType.INFORMATION);
    	}
    }
    
}
