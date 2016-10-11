package com.library.controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.CheckoutRecord;
import com.library.entity.CheckoutRecordEntry;
import com.library.entity.LibraryMember;
import com.library.model.DataAccess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class CheckoutRecordController {
	
	DataAccess dataAccess  = SystemController.getDataAccessInstance();
	
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
    void addCheckoutRecord(ActionEvent event) {
    	
    	String id = txtMemberID.getText();
    	String isbn = txtISBN.getText();
 
    	boolean bookCopyFound = true;
    	boolean libraryMemberFound = true;
    	
    	Book book = null;
    	BookCopy bookCopy = null;
    	LibraryMember libraryMember = null;
    	
    	bookCopy = dataAccess.getAvailableBookCopy(isbn);
    	if(bookCopy != null){
    		bookCopyFound = true;
    	}
    	
    	libraryMember = dataAccess.getLibraryMemberById(id);
    	if(libraryMember != null){
    		libraryMemberFound = true;
    	}
 
    	if(!bookCopyFound){
    		JOptionPane.showMessageDialog(null, "Please input correct bookCopy", "Group7:Error", 1);
    	}else if (!libraryMemberFound) {
    		JOptionPane.showMessageDialog(null, "Please input correct library member", "Group7:Error", 1);
		}else if(bookCopyFound && libraryMemberFound){
    		CheckoutRecord checkoutRecord = libraryMember.getCheckoutRecord();
        	if( checkoutRecord == null){
        		checkoutRecord = new CheckoutRecord();
        	}
        	
        	List<CheckoutRecordEntry> entries = checkoutRecord.getRecordEntries();
        	CheckoutRecordEntry entry = new CheckoutRecordEntry(bookCopy, LocalDate.now(), LocalDate.now().plusDays(21));
        	entries.add(entry);
        	
        	
        	dataAccess.setBookCopyAsNotAvailable(isbn, bookCopy.getCopyNum());
        	
        	
        	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Information Dialog");
	    	alert.setHeaderText("Success");
	    	alert.setContentText(" Book Checkout successful !");
	    	alert.showAndWait();
        	
    	}

    }
}
